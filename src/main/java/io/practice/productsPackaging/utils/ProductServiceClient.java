package io.practice.productsPackaging.utils;

import io.practice.productsPackaging.config.ProdPackagingConfig;
import io.practice.productsPackaging.model.Product;
import lombok.extern.log4j.Log4j2;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

@Log4j2
@Component
public class ProductServiceClient {

    private final ProdPackagingConfig prodPackagingConfig;

    private final RestTemplate restTemplate;

    public ProductServiceClient(ProdPackagingConfig prodPackagingConfig, RestTemplateBuilder restTemplateBuilder) {
        this.prodPackagingConfig = prodPackagingConfig;
        this.restTemplate = restTemplateBuilder
                .basicAuthentication(prodPackagingConfig.getProductsServiceUsername(),
                        prodPackagingConfig.getProductsServicePassword())
                .build();
    }

    /**
     * Gets and returns all products from the Products Service endpoint.
     */
    public List<Product> getProducts() {
        log.debug("Sending request to get all products from the products service");
        List<Product> products = new ArrayList<>();
        ResponseEntity<Product[]> resp = restTemplate.getForEntity(
                prodPackagingConfig.getProductsServiceUrl(), Product[].class);
        if (resp.getStatusCode() == HttpStatus.OK && resp.getBody() != null) {
            products = Arrays.asList(resp.getBody());
        }
        return products;
    }

    /**
     * Returns all products as a map.
     */
    public Map<String, Product> getProductsMap() {
        List<Product> products = this.getProducts();
        log.debug("Returning products as a Map");

        return products.stream().collect(
                Collectors.toMap(Product::getId, Function.identity()));
    }

    /**
     * Returns a single Product object as Optional.
     */
    // TODO: Add Caching with proper evict/refresh policy
//    @Cacheable(value = "products", key = "#id", condition = "#result.present")
    public Optional<Product> getProduct(String id) {
        log.info("Sending request to fetch product with id: " + id);
        ResponseEntity<Product> resp = restTemplate.getForEntity(
                prodPackagingConfig.getProductsServiceUrl() + "/" + id, Product.class);
        Product product = resp.getBody();
        log.info("Received product response: " + product);
        return Optional.ofNullable(product);
    }
}
