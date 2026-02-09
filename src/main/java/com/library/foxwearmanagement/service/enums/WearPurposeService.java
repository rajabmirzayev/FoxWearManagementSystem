package com.library.foxwearmanagement.service.enums;

import com.library.foxwearmanagement.entity.enums.WearPurpose;
import com.library.foxwearmanagement.repository.enums.WearPurposeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class WearPurposeService {
    private final WearPurposeRepository wearPurposeRepository;

    public List<String> getWearPurposes() {
        return wearPurposeRepository.findAll()
                .stream()
                .map(WearPurpose::getName)
                .toList();
    }
}
