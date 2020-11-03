package io.practice.productsPackaging.config;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConstructorBinding;

@Data
@AllArgsConstructor
@ConstructorBinding
@ConfigurationProperties(prefix = "prod-packaging-service")
public class ProdPackagingConfig {
    private String productsServiceUrl;
    private String productsServiceUsername;
    private String productsServicePassword;
}
