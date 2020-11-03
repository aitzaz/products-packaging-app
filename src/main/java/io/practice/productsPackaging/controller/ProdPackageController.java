package io.practice.productsPackaging.controller;

import io.practice.productsPackaging.exceptions.PackageNotFoundException;
import io.practice.productsPackaging.model.ProdPackage;
import io.practice.productsPackaging.repo.ProdPackageRepository;
import io.practice.productsPackaging.service.ProdPackagingService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@Log4j2
@RequiredArgsConstructor
@RestController
public class ProdPackageController {

    private final ProdPackageRepository prodPackageRepository;

    private final ProdPackagingService prodPackagingService;

    @GetMapping("/packages")
    public List<ProdPackage> getPackages() {
        log.debug("Get All Packages request");
        return prodPackagingService.getAllPackages();
    }

    @GetMapping("/packages/{id}")
    public ProdPackage getPackageDetails(@PathVariable long id) {
        log.debug("Get a Package details request for id: " + id);
        return prodPackagingService.getPackage(id)
                .orElseThrow(() -> new PackageNotFoundException(id));
    }

    @PostMapping("/packages")
    public ProdPackage newPackage(@RequestBody @Valid ProdPackage newProdPkg) {
        log.debug("Create a new Package request");
        return prodPackagingService.addPackage(newProdPkg);
    }

    @PutMapping("/packages/{id}")
    public ProdPackage replacePackage(@RequestBody @Valid ProdPackage newProdPkg, @PathVariable Long id) {
        log.debug("Update Package request for id: " + id);
        return prodPackagingService.updatePackage(newProdPkg, id);
    }

    @DeleteMapping("/packages/{id}")
    public ResponseEntity<String> deleteEmployee(@PathVariable Long id) {
        log.info("Deleting Package with id: " + id);
        prodPackageRepository.deleteById(id);
        return ResponseEntity.ok("Deleted successfully");
    }
}
