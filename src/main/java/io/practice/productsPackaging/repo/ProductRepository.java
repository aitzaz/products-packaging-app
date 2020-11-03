package io.practice.productsPackaging.repo;

import io.practice.productsPackaging.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
