package io.practice.productsPackaging.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.UniqueElements;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.Map;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tbl_packages")
public class ProdPackage {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @NotEmpty
    private String name;

    private String description;

    // Assuming that products' prices will not change
    @Transient private int price;
    // TODO: add currency support

    @Size(min = 1, message = "At least one product is required to create a package")
    @UniqueElements
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<Product> products;

    public int getPrice() {
        this.setPrice(this.getProducts().stream().mapToInt(Product::getUsdPrice).sum());
        return this.price;
    }

    public void setProductsPrices(Map<String, Product> productMap) {
        this.getProducts().forEach(product -> {
            product.setUsdPrice(productMap.get(product.getId()).getUsdPrice());
        });
    }
}
