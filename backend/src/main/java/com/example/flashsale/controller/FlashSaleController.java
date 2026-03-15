package com.example.flashsale.controller;

import com.example.flashsale.dto.FlashSaleOrderRequest;
import com.example.flashsale.entity.FlashSaleProduct;
import com.example.flashsale.service.FlashSaleService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/flash-sale")
@CrossOrigin(origins = "*")
public class FlashSaleController {

    private final FlashSaleService flashSaleService;

    public FlashSaleController(FlashSaleService flashSaleService) {
        this.flashSaleService = flashSaleService;
    }

    @GetMapping("/products")
    public ResponseEntity<List<FlashSaleProduct>> getProducts() {
        return ResponseEntity.ok(flashSaleService.getAllProducts());
    }

    @PostMapping("/order")
    public ResponseEntity<String> order(@RequestBody FlashSaleOrderRequest request) {
        String result = flashSaleService.createOrder(request);

        if ("Đặt hàng thành công".equals(result)) {
            return ResponseEntity.ok(result);
        }

        return ResponseEntity.badRequest().body(result);
    }
}