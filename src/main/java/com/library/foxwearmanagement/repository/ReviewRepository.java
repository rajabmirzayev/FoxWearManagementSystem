package com.library.foxwearmanagement.repository;

import com.library.foxwearmanagement.entity.Review;
import lombok.NonNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReviewRepository extends JpaRepository<@NonNull Review, @NonNull Long> {
}
