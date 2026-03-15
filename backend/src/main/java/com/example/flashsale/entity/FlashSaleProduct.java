package com.example.flashsale.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "flash_sale_products")
public class FlashSaleProduct {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private Double originalPrice;
    private Double salePrice;
    private Integer stock;

    public FlashSaleProduct() {
    }

    public FlashSaleProduct(Long id, String name, Double originalPrice, Double salePrice, Integer stock) {
        this.id = id;
        this.name = name;
        this.originalPrice = originalPrice;
        this.salePrice = salePrice;
        this.stock = stock;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Double getOriginalPrice() {
        return originalPrice;
    }

    public Double getSalePrice() {
        return salePrice;
    }

    public Integer getStock() {
        return stock;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setOriginalPrice(Double originalPrice) {
        this.originalPrice = originalPrice;
    }

    public void setSalePrice(Double salePrice) {
        this.salePrice = salePrice;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }
}