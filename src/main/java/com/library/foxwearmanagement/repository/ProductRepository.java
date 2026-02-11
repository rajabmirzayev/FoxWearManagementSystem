package com.library.foxwearmanagement.repository;

import com.library.foxwearmanagement.entity.product.Product;
import lombok.NonNull;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<@NonNull Product, @NonNull Long> {
}
