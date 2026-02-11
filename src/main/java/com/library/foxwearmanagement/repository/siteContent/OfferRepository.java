package com.library.foxwearmanagement.repository.siteContent;

import com.library.foxwearmanagement.entity.siteContent.Offer;
import lombok.NonNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OfferRepository extends JpaRepository<@NonNull Offer,@NonNull Long> {
}
