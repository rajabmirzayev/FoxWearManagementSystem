package com.library.foxwearmanagement.repository;

import com.library.foxwearmanagement.entity.ColorOption;
import com.library.foxwearmanagement.util.enums.WearSize;
import lombok.NonNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ColorOptionRepository extends JpaRepository<@NonNull ColorOption, @NonNull Long> {
    @Query("SELECT COUNT(co) > 0 FROM ColorOption co WHERE co.colorName = ?1 AND co.size = ?2 AND co.product.id = ?3")
    boolean existsByColorNameAndSizeAndProduct(String colorName, WearSize size, Long productId);
}
