package com.library.foxwearmanagement.service.siteContent;

import com.library.foxwearmanagement.entity.siteContent.Offer;
import com.library.foxwearmanagement.repository.siteContent.OfferRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OfferService {
    private final OfferRepository offerRepository;

    public Offer getOfferById(Long id) {
        return offerRepository.findById(id).orElse(null);
    }
}
