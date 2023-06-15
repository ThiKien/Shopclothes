package com.example.Do_An_Java.viewmodels;

import com.example.Do_An_Java.entities.Product;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;

@Builder
public record ProductPostVm(String name, String image, Double price, Long categoryId) {
    public static ProductPostVm from(@NotNull Product product) {
        return new ProductPostVm(product.getName(), product.getImage(), product.getPrice(), product.getCategory().getId());
    }
}