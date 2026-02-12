package com.library.foxwearmanagement.service.siteContent;

import com.library.foxwearmanagement.entity.siteContent.ContactInfo;
import com.library.foxwearmanagement.repository.siteContent.ContactInfoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ContactInfoService {
    private final ContactInfoRepository contactInfoRepository;

    public ContactInfo getContactInfoById(Long contactId) {
        return contactInfoRepository.findById(contactId).orElse(null);
    }
}
