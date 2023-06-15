package com.example.Do_An_Java.services;


import com.example.Do_An_Java.entities.Product;
import com.example.Do_An_Java.repostories.IProductRepository;

import lombok.RequiredArgsConstructor;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
@Service
@RequiredArgsConstructor
@Transactional(isolation = Isolation.SERIALIZABLE,
        rollbackFor = {Exception.class, Throwable.class})
public class ProductService {
    private final IProductRepository productRepository;
    public List<Product> getAllProducts(Integer pageNo,
                                     Integer pageSize,
                                     String sortBy) {

        return productRepository.findAllProducts(pageNo, pageSize, sortBy);
    }
    public Optional<Product> getProductById(Long id) {
        return productRepository.findById(id);
    }
    public void addProduct(Product product) {
        productRepository.save(product);
    }


    public void deleteProductById(Long id) {
        productRepository.deleteById(id);
    }

    public long countProduct(){
        return productRepository.count();
    }
    public void updateProduct(@NotNull Product product) {
        Product existingProduct = productRepository.findById(product.getId())
                .orElse(null);
        Objects.requireNonNull(existingProduct).setName(product.getName());
        existingProduct.setImage(product.getImage());
        existingProduct.setPrice(product.getPrice());
        existingProduct.setCategory(product.getCategory());
        productRepository.save(existingProduct);
    }
    public List<Product> searchProduct(String keyword) {
        return productRepository.searchProduct(keyword);
    }

}
