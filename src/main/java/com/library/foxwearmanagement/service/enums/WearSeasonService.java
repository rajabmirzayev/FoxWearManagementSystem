package com.library.foxwearmanagement.service.enums;

import com.library.foxwearmanagement.entity.enums.WearSeason;
import com.library.foxwearmanagement.repository.enums.WearSeasonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class WearSeasonService {
    private final WearSeasonRepository wearSeasonRepository;

    public List<String> getWearSeasons() {
        return wearSeasonRepository.findAll()
                .stream()
                .map(WearSeason::getName)
                .toList();
    }
}
