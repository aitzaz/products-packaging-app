package io.practice.productsPackaging.exceptions;

public class ProductNotFoundException extends RuntimeException {

    public ProductNotFoundException(String id) {
        super("Product not found exception:" + id);
    }
}
