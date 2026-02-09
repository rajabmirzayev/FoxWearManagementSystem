package com.library.foxwearmanagement.controller.enums;

import com.library.foxwearmanagement.dto.ApiResponse;
import com.library.foxwearmanagement.service.enums.WearTypeService;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/enums/wear-type")
@RequiredArgsConstructor
public class WearTypeController {
    private final WearTypeService wearTypeService;

    @GetMapping
    public ResponseEntity<@NonNull ApiResponse<List<String>>> getWearTypes() {
        var response = wearTypeService.getWearTypes();

        return ResponseEntity.ok(ApiResponse.success(response));
    }

}
