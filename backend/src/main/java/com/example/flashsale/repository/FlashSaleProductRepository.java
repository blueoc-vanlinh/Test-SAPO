package com.example.flashsale.repository;

import com.example.flashsale.entity.FlashSaleProduct;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FlashSaleProductRepository extends JpaRepository<FlashSaleProduct, Long> {
}