package io.practice.productsPackaging.service;

import io.practice.productsPackaging.exceptions.PackageNotFoundException;
import io.practice.productsPackaging.exceptions.ProductNotFoundException;
import io.practice.productsPackaging.model.ProdPackage;
import io.practice.productsPackaging.model.Product;
import io.practice.productsPackaging.repo.ProdPackageRepository;
import io.practice.productsPackaging.utils.ProductServiceClient;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Log4j2
@RequiredArgsConstructor
@Service
public class ProdPackagingService {

    private final ProductServiceClient productServiceClient;

    private final ProdPackageRepository prodPackageRepository;

    /**
     * Returns all existing packages from the database and updating latest prices
     * from products service endpoint.
     */
    public List<ProdPackage> getAllPackages() {
        List<ProdPackage> prodPackages = prodPackageRepository.findAll();
        if (prodPackages.isEmpty()) {
            return Collections.emptyList();
        }

        Map<String, Product> productMap = productServiceClient.getProductsMap();
        prodPackages.forEach(prodPackage -> {
            prodPackage.setProductsPrices(productMap);
        });

        return prodPackages;
    }

    /**
     * Returns package for the provided ID.
     * @param id
     * @return
     */
    public Optional<ProdPackage> getPackage(long id) {
        Optional<ProdPackage> prodPackage = prodPackageRepository.findById(id);
        if (prodPackage.isPresent()) {
            Map<String, Product> productMap = productServiceClient.getProductsMap();
            prodPackage.ifPresent(pkg -> {
                pkg.setProductsPrices(productMap);
            });
        }

        return prodPackage;
    }

    /**
     * Saves a Package to the DB along with its products mapping.
     * Returns an updated Package object.
     * @param prodPackage
     * @return
     */
    @Transactional
    public ProdPackage addPackage(ProdPackage prodPackage) {
        Map<String, Product> productsMap = productServiceClient.getProductsMap();

        fillProductInfo(prodPackage, productsMap);
        prodPackage = prodPackageRepository.save(prodPackage);
        return prodPackage;
    }

    private void fillProductInfo(ProdPackage prodPackage, Map<String, Product> productsMap) {
        prodPackage.getProducts().forEach(product -> {
            Product p = productsMap.get(product.getId());
            if (p == null) {
                throw new ProductNotFoundException(product.getId());
            }
            product.setName(p.getName());
            product.setUsdPrice(p.getUsdPrice());
        });
    }

    @Transactional
    public ProdPackage updatePackage(ProdPackage updatedPkg, long id) {
        Optional<ProdPackage> existingPkg = prodPackageRepository.findById(id);
        existingPkg.ifPresent(pkg -> {
            // TODO: Update only different properties
            pkg.setName(updatedPkg.getName());
            pkg.setDescription(updatedPkg.getDescription());

            Map<String, Product> productsMap = productServiceClient.getProductsMap();
            pkg.setProducts(updatedPkg.getProducts());
            fillProductInfo(pkg, productsMap);
        });

        if (existingPkg.isPresent()) {
            return prodPackageRepository.save(existingPkg.get());
        }
        else {
            throw new PackageNotFoundException(id);
        }
    }
}
