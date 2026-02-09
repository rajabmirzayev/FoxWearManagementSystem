package com.library.foxwearmanagement.controller.enums;

import com.library.foxwearmanagement.dto.ApiResponse;
import com.library.foxwearmanagement.service.enums.WearSeasonService;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/enums/wear-season")
@RequiredArgsConstructor
public class WearSeasonController {
    private final WearSeasonService wearSeasonService;

    @GetMapping
    public ResponseEntity<@NonNull ApiResponse<List<String>>> getWearSeasons() {
        var response = wearSeasonService.getWearSeasons();
        return ResponseEntity.ok(ApiResponse.success(response));
    }
}
