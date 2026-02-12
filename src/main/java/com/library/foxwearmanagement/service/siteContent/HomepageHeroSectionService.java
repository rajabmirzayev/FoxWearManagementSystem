package com.library.foxwearmanagement.service.siteContent;

import com.library.foxwearmanagement.entity.siteContent.HomepageHeroSection;
import com.library.foxwearmanagement.repository.siteContent.HomepageHeroSectionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class HomepageHeroSectionService {
    private final HomepageHeroSectionRepository homepageHeroSectionRepository;

    public HomepageHeroSection getHomepageHeroSectionById(Long id) {
        return homepageHeroSectionRepository.findById(id).orElse(null);
    }
}
