package com.example.flashsale;

import com.example.flashsale.entity.FlashSaleProduct;
import com.example.flashsale.repository.FlashSaleProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class FlashSaleApplication {

    public static void main(String[] args) {
        SpringApplication.run(FlashSaleApplication.class, args);
    }

    @Bean
    CommandLineRunner initData(FlashSaleProductRepository productRepository) {
        return args -> {
            productRepository.save(new FlashSaleProduct(null, "Áo thun basic", 500000.0, 250000.0, 20));
            productRepository.save(new FlashSaleProduct(null, "Giày sneaker", 500000.0, 250000.0, 10));
            productRepository.save(new FlashSaleProduct(null, "Balo thời trang", 500000.0, 250000.0, 5));
            productRepository.save(new FlashSaleProduct(null, "Áo polo", 500000.0, 250000.0, 1));
        };
    }
}