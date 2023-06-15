package com.example.Do_An_Java.controllers;

import com.example.Do_An_Java.services.CartService;
import com.example.Do_An_Java.services.CategoryService;
import com.example.Do_An_Java.services.ProductService;
import com.example.Do_An_Java.viewmodels.ProductGetVm;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController
@RequestMapping("/api/v1")
@CrossOrigin(origins = "*")
@RequiredArgsConstructor
public class ApiController {
    private final ProductService productService;
    private final CategoryService categoryService;
    private final CartService cartService;
    @GetMapping("/products")
    public ResponseEntity<List<ProductGetVm>> getAllProducts(Integer pageNo,
                                                          Integer pageSize, String sortBy) {
        return ResponseEntity.ok(productService.getAllProducts(
                pageNo == null ? 0 : pageNo,pageSize == null ? 20 : pageSize,
                        sortBy == null ? "id" : sortBy)
                .stream()
                .map(ProductGetVm::from)
                .toList());
    }
    @GetMapping("/products/id/{id}")
    public ResponseEntity<ProductGetVm> getProductById(@PathVariable Long id)
    {
        return ResponseEntity.ok(productService.getProductById(id)
                .map(ProductGetVm::from)
                .orElse(null));
    }
    @DeleteMapping("/products/{id}")
    public ResponseEntity<Void> deleteProductById(@PathVariable Long id) {
        productService.deleteProductById(id);
        return ResponseEntity.ok().build();
    }
    @GetMapping("/products/search")
    public ResponseEntity<List<ProductGetVm>> searchProducts(String keyword)
    {
        return ResponseEntity.ok(productService.searchProduct(keyword)
                .stream()
                .map(ProductGetVm::from)
                .toList());
    }
}
