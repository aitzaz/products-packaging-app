package io.practice.productsPackaging.utils;

import io.practice.productsPackaging.model.ProdPackage;
import io.practice.productsPackaging.model.Product;
import io.practice.productsPackaging.service.ProdPackagingService;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Map;

@Log4j2
@AllArgsConstructor
@Component
public class LoadDatabase implements CommandLineRunner {

    private ApplicationContext ctx;

    @Override
    public void run(String... args) throws Exception {
        log.info("Adding SEED data");
        ProdPackagingService packagingService = ctx.getBean(ProdPackagingService.class);
        ProductServiceClient client = ctx.getBean(ProductServiceClient.class);

        Map<String, Product> productMap = client.getProductsMap();
        Product p1 = productMap.get("VqKb4tyj9V6i"); // Shield
        Product p2 = productMap.get("7dgX6XzU3Wds"); // Sword
        Product p3 = productMap.get("500R5EHvNlNB"); // Gold Coin
        Product p1Copy = p1.clone();
        Product p2Copy = p2.clone();

        ProdPackage prodPackage1 = new ProdPackage();
        prodPackage1.setName("Package 1 - Shield");
        prodPackage1.setDescription("Test Package 1");
        prodPackage1.setProducts(Collections.singleton(p1));

        ProdPackage prodPackage2 = new ProdPackage();
        prodPackage2.setName("Package 2 - Sword");
        prodPackage2.setDescription("Test Package 2");
        prodPackage2.setProducts(Collections.singleton(p2));

        ProdPackage prodPackage3 = new ProdPackage();
        prodPackage3.setName("Package 3 - Gold Coin");
        prodPackage3.setDescription("Test Package 3");
        prodPackage3.setProducts(Collections.singleton(p3));

        ProdPackage prodPackage4 = new ProdPackage();
        prodPackage4.setName("Package 4 - Shield & Sword");
        prodPackage4.setDescription("Test Package 4");
        prodPackage4.setProducts(new HashSet<>(Arrays.asList(p1Copy, p2Copy)));

        packagingService.addPackage(prodPackage1);
        packagingService.addPackage(prodPackage2);
        packagingService.addPackage(prodPackage3);
        packagingService.addPackage(prodPackage4);
    }
}
