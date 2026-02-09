package com.library.foxwearmanagement.repository.enums;

import com.library.foxwearmanagement.entity.enums.WearType;
import lombok.NonNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WearTypeRepository extends JpaRepository<@NonNull WearType, @NonNull Long> {
}
