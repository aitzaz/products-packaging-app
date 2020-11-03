package io.practice.productsPackaging.exceptions;

public class PackageNotFoundException extends RuntimeException {

    public PackageNotFoundException(long id) {
        super("Could not find Package for id: " + id);
    }
}
