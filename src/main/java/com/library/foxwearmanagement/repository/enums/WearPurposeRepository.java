package com.library.foxwearmanagement.repository.enums;

import com.library.foxwearmanagement.entity.enums.WearPurpose;
import lombok.NonNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WearPurposeRepository extends JpaRepository<@NonNull WearPurpose,@NonNull Long> {
}
