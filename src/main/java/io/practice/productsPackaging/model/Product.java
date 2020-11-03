package io.practice.productsPackaging.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tbl_products")
public class Product implements Serializable, Cloneable {
    /**
     * Surrogate key.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long productId;

    /**
     * Id received from the products service.
     */
    private String id;

    private String name;

    @Transient private int usdPrice;

    @Override
    public Product clone() throws CloneNotSupportedException {
        return (Product)super.clone();
    }
}
