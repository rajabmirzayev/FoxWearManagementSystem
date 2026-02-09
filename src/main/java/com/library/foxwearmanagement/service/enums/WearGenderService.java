package com.library.foxwearmanagement.service.enums;

import com.library.foxwearmanagement.entity.enums.WearGender;
import com.library.foxwearmanagement.repository.enums.WearGenderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class WearGenderService {
    private final WearGenderRepository wearGenderRepository;

    public List<WearGender> getWearGenders() {
        return wearGenderRepository.findAll();
    }
}
