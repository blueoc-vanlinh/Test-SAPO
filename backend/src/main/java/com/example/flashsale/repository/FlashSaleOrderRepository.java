package com.example.flashsale.repository;

import com.example.flashsale.entity.FlashSaleOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface FlashSaleOrderRepository extends JpaRepository<FlashSaleOrder, Long> {

    @Query("SELECT COALESCE(SUM(o.quantity), 0) FROM FlashSaleOrder o WHERE o.userId = :userId AND o.productId = :productId")
    Integer getTotalPurchasedByUser(@Param("userId") Long userId, @Param("productId") Long productId);
}