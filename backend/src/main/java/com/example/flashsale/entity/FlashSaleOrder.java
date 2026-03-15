package com.example.flashsale.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "flash_sale_orders")
public class FlashSaleOrder {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long productId;
    private Long userId;
    private Integer quantity;

    public FlashSaleOrder() {
    }

    public FlashSaleOrder(Long id, Long productId, Long userId, Integer quantity) {
        this.id = id;
        this.productId = productId;
        this.userId = userId;
        this.quantity = quantity;
    }

    public Long getId() {
        return id;
    }

    public Long getProductId() {
        return productId;
    }

    public Long getUserId() {
        return userId;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}