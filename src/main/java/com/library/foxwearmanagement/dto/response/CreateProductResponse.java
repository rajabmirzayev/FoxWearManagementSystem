package com.library.foxwearmanagement.dto.response;

import com.library.foxwearmanagement.entity.product.ColorOption;
import com.library.foxwearmanagement.entity.enums.WearGender;
import com.library.foxwearmanagement.entity.enums.WearPurpose;
import com.library.foxwearmanagement.entity.enums.WearSeason;
import com.library.foxwearmanagement.entity.enums.WearType;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CreateProductResponse {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String name;
    Integer discount;
    LocalDate releaseDate; // ? satışa çıxarılma tarixi
    WearGender gender;
    WearPurpose purpose;
    WearSeason season;
    WearType wearType;
    String description;

    List<ColorOption> colorOptions;
}
