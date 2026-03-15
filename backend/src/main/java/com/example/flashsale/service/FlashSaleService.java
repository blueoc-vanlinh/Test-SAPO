package com.example.flashsale.service;

import com.example.flashsale.dto.FlashSaleOrderRequest;
import com.example.flashsale.entity.FlashSaleOrder;
import com.example.flashsale.entity.FlashSaleProduct;
import com.example.flashsale.repository.FlashSaleOrderRepository;
import com.example.flashsale.repository.FlashSaleProductRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class FlashSaleService {

    private final FlashSaleProductRepository productRepository;
    private final FlashSaleOrderRepository orderRepository;

    public FlashSaleService(FlashSaleProductRepository productRepository,
                            FlashSaleOrderRepository orderRepository) {
        this.productRepository = productRepository;
        this.orderRepository = orderRepository;
    }

    public List<FlashSaleProduct> getAllProducts() {
        return productRepository.findAll();
    }

    @Transactional
    public String createOrder(FlashSaleOrderRequest request) {
        if (request.getProductId() == null || request.getUserId() == null || request.getQuantity() == null) {
            return "Thiếu thông tin đặt hàng";
        }

        if (request.getQuantity() <= 0) {
            return "Số lượng mua không hợp lệ";
        }

        FlashSaleProduct product = productRepository.findById(request.getProductId()).orElse(null);
        if (product == null) {
            return "Sản phẩm không tồn tại";
        }

        Integer purchased = orderRepository.getTotalPurchasedByUser(request.getUserId(), request.getProductId());
        if (purchased + request.getQuantity() > 2) {
            return "Vượt quá giới hạn mua tối đa 2 sản phẩm";
        }

        if (product.getStock() < request.getQuantity()) {
            return "Sản phẩm đã hết hàng hoặc không đủ số lượng";
        }

        product.setStock(product.getStock() - request.getQuantity());
        productRepository.save(product);

        FlashSaleOrder order = new FlashSaleOrder();
        order.setProductId(request.getProductId());
        order.setUserId(request.getUserId());
        order.setQuantity(request.getQuantity());
        orderRepository.save(order);

        return "Đặt hàng thành công";
    }
}