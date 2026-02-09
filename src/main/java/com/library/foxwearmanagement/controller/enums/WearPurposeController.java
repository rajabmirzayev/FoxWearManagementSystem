package com.library.foxwearmanagement.controller.enums;

import com.library.foxwearmanagement.dto.ApiResponse;
import com.library.foxwearmanagement.service.enums.WearPurposeService;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/enums/wear-purpose")
@RequiredArgsConstructor
public class WearPurposeController {
    private final WearPurposeService wearPurposeService;

    @GetMapping
    public ResponseEntity<@NonNull ApiResponse<List<String>>> getWearTypes() {
        var response = wearPurposeService.getWearPurposes();

        return ResponseEntity.ok(ApiResponse.success(response));
    }
}
