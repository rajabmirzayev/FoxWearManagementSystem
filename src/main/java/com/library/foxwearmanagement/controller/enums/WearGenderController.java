package com.library.foxwearmanagement.controller.enums;

import com.library.foxwearmanagement.dto.ApiResponse;
import com.library.foxwearmanagement.service.enums.WearGenderService;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/enums/wear-gender")
@RequiredArgsConstructor
public class WearGenderController {
    private final WearGenderService wearGenderService;

    @GetMapping
    public ResponseEntity<@NonNull ApiResponse<List<String>>> getWearGenders() {
        var response = wearGenderService.getWearGenders();

        return ResponseEntity.ok(ApiResponse.success(response));
    }
}
