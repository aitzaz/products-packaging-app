package io.practice.productsPackaging.repo;

import io.practice.productsPackaging.model.ProdPackage;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdPackageRepository extends JpaRepository<ProdPackage, Long> {

}
