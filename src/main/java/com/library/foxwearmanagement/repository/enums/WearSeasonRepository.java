package com.library.foxwearmanagement.repository.enums;

import com.library.foxwearmanagement.entity.enums.WearSeason;
import lombok.NonNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WearSeasonRepository extends JpaRepository<@NonNull WearSeason, @NonNull Long> {
}
