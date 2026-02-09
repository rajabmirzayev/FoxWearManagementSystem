package com.library.foxwearmanagement.dto.response;

import com.library.foxwearmanagement.entity.ColorOption;
import com.library.foxwearmanagement.util.enums.WearGender;
import com.library.foxwearmanagement.util.enums.WearPurpose;
import com.library.foxwearmanagement.util.enums.WearSeason;
import com.library.foxwearmanagement.util.enums.WearType;
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

    @Enumerated(EnumType.STRING)
    WearGender gender;

    @Enumerated(EnumType.STRING)
    WearPurpose purpose;

    @Enumerated(EnumType.STRING)
    WearSeason season;

    @Enumerated(EnumType.STRING)
    WearType wearType;

    String description;

    List<ColorOption> colorOptions;
}
