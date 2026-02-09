package com.library.foxwearmanagement.service.enums;

import com.library.foxwearmanagement.entity.enums.WearType;
import com.library.foxwearmanagement.repository.enums.WearTypeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class WearTypeService {
    private final WearTypeRepository wearTypeRepository;

    public List<WearType> getWearTypes() {
        return wearTypeRepository.findAll();
    }
}
