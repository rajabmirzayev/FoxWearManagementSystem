package com.library.foxwearmanagement.repository.enums;

import com.library.foxwearmanagement.entity.enums.WearSize;
import lombok.NonNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WearSizeRepository extends JpaRepository<@NonNull WearSize, @NonNull Long> {
}
