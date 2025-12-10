package com.ecom.productcatalog.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Set;

@Entity
@Data
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @OneToMany(mappedBy = "category",
                cascade = CascadeType.ALL,
                 fetch = FetchType.LAZY)
    @JsonIgnoreProperties({"category"})
    private Set<Product> products;
}
