package com.example.Do_An_Java.viewmodels;

import com.example.Do_An_Java.entities.Product;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
@Builder
public record ProductGetVm(Long id, String name, String image, Double
        price, String category) {
    public static ProductGetVm from(@NotNull Product product) {
        return ProductGetVm.builder()
                .id(product.getId())
                .name(product.getName())
                .image(product.getImage())
                .price(product.getPrice())
                .category(product.getCategory().getName())
                .build();
    }
}
