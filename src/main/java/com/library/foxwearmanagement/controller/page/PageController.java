package com.library.foxwearmanagement.controller.page;

import com.library.foxwearmanagement.entity.siteContent.ContactInfo;
import com.library.foxwearmanagement.entity.siteContent.HomepageHeroSection;
import com.library.foxwearmanagement.entity.siteContent.Offer;
import com.library.foxwearmanagement.service.siteContent.ContactInfoService;
import com.library.foxwearmanagement.service.siteContent.HomepageHeroSectionService;
import com.library.foxwearmanagement.service.siteContent.OfferService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class PageController {
    private final OfferService offerService;
    private final ContactInfoService contactInfoService;
    private final HomepageHeroSectionService homepageHeroSectionService;

    @GetMapping("/")
    public String index(Model model) {
        Offer offer = offerService.getOfferById(1L);
        ContactInfo phone = contactInfoService.getContactInfoById(1L);
        ContactInfo email = contactInfoService.getContactInfoById(2L);
        HomepageHeroSection homepageHeroSection = homepageHeroSectionService.getHomepageHeroSectionById(1L);

        model.addAttribute("offer", offer);
        model.addAttribute("phone", phone);
        model.addAttribute("email", email);
        model.addAttribute("heroSection", homepageHeroSection);

        return "index";
    }
}
