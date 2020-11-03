package io.practice.productsPackaging;

import io.practice.productsPackaging.config.ProdPackagingConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableConfigurationProperties(ProdPackagingConfig.class)
@EnableCaching
public class ProductsPackagingApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProductsPackagingApplication.class, args);
    }

}

