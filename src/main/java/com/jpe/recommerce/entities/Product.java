package com.jpe.recommerce.entities;



import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    
    @ManyToOne
    @JoinColumn(name = "subcategoryId")
    private SubCategory subCategory;

    @Column(name = "product_name")
    private String productName;
    
    @Column(name = "description")
    private String description;
    
    @Column(name = "price")
    private double price;

    @Column(name = "status")
    private boolean status;

    @ManyToOne
    @JoinColumn(name = "categoryId")
    private Category category;
  
    @OneToOne(mappedBy = "product") // (mappedBy = "user", cascade = CascadeType.ALL)
    private Stock stocks;

    @OneToMany(mappedBy ="product")
    private List<ProductImage> productImages;

}
