package com.example.Do_An_Java.repostories;

import com.example.Do_An_Java.entities.Product;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IProductRepository extends PagingAndSortingRepository<Product, Long>, JpaRepository<Product, Long> {
    @Query("""
SELECT b FROM Product b
WHERE b.name LIKE %?1%
OR b.image LIKE %?1%
OR b.category.name LIKE %?1%
""")
    List<Product> searchProduct(String keyword);
    default List<Product> findAllProducts(Integer pageNo,
                                          Integer pageSize,
                                          String sortBy) {
        return findAll(PageRequest.of(pageNo,
                pageSize,
                Sort.by(sortBy)))
                .getContent();
    }


}