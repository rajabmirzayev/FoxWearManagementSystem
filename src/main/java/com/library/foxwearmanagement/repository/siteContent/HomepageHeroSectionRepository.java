package com.library.foxwearmanagement.repository.siteContent;

import com.library.foxwearmanagement.entity.siteContent.HomepageHeroSection;
import lombok.NonNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HomepageHeroSectionRepository extends JpaRepository<@NonNull HomepageHeroSection, @NonNull Long> {
}
