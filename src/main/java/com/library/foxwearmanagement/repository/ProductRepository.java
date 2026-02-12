package com.library.foxwearmanagement.repository;

import com.library.foxwearmanagement.entity.product.Product;
import lombok.NonNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductRepository extends JpaRepository<@NonNull Product, @NonNull Long> {
    @Query("SELECT p FROM Product p ORDER BY p.likes DESC LIMIT 10")
    List<Product> findTop10ByLikes();
}
