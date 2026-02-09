package com.library.foxwearmanagement.controller.enums;

import com.library.foxwearmanagement.dto.ApiResponse;
import com.library.foxwearmanagement.service.enums.WearSizeService;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/enums/wear-size")
@RequiredArgsConstructor
public class WearSizeController {
    private final WearSizeService wearSizeService;

    @GetMapping
    public ResponseEntity<@NonNull ApiResponse<List<String>>> getWearPurposes() {
        var response = wearSizeService.getWearSizes();

        return ResponseEntity.ok(ApiResponse.success(response));
    }
}
