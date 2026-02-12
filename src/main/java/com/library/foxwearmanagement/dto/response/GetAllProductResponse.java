package com.library.foxwearmanagement.dto.response;

import com.library.foxwearmanagement.entity.enums.WearGender;
import com.library.foxwearmanagement.entity.enums.WearPurpose;
import com.library.foxwearmanagement.entity.enums.WearSeason;
import com.library.foxwearmanagement.entity.enums.WearType;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class GetAllProductResponse {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String name;
    Integer likes;
    Integer discount;
    WearGender gender;
    WearPurpose purpose;
    WearSeason season;
    WearType wearType;
    List<GetColorOptionResponse> colors;
}
