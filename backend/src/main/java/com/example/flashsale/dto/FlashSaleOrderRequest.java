package com.example.flashsale.dto;

public class FlashSaleOrderRequest {
    private Long productId;
    private Long userId;
    private Integer quantity;

    public Long getProductId() {
        return productId;
    }

    public Long getUserId() {
        return userId;
    }

    public Integer getQuantity() {
        return quantity;
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