package com.library.foxwearmanagement.service.enums;

import com.library.foxwearmanagement.entity.enums.WearSize;
import com.library.foxwearmanagement.repository.enums.WearSizeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class WearSizeService {
    private final WearSizeRepository wearSizeRepository;

    public List<String> getWearSizes() {
        return wearSizeRepository.findAll()
                .stream()
                .map(WearSize::getName)
                .toList();
    }
}
