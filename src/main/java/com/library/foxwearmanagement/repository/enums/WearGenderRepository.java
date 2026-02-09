package com.library.foxwearmanagement.repository.enums;

import com.library.foxwearmanagement.entity.enums.WearGender;
import lombok.NonNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WearGenderRepository extends JpaRepository<@NonNull WearGender, @NonNull Long> {
}
