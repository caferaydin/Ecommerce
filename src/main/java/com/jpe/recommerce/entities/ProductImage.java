package com.jpe.recommerce.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "productImages")
public class ProductImage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;
    @Column(name = "showCase")
    private String showCase;
    @Column(name = "image_one")
    private String imageOne;
    @Column(name = "image_two")
    private String imageTwo;
    @Column(name = "image_three")
    private String imageThree;
    @Column(name = "image_four")
    private String imageFour;
    @Column(name = "image_five")
    private String imageFive;
    @Column(name = "image_six")
    private String imageSix;
    @Column(name = "image_seven")
    private String imageSeven;
    @Column(name = "image_eight")
    private String imageEight;
    @Column(name = "image_nine")
    private String imageNine;
    
    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;
}
