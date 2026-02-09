package com.library.foxwearmanagement.dto;

import com.library.foxwearmanagement.util.enums.*;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class GetWearProductCartResponse {
    String name;
    Double price;
    Double discount;
    Integer stock;
    Integer likes;

    @Enumerated(EnumType.STRING)
    WearColor color;

    @Enumerated(EnumType.STRING)
    WearGender gender;

    @Enumerated(EnumType.STRING)
    WearPurpose purpose;

    @Enumerated(EnumType.STRING)
    WearSeason season;

    @Enumerated(EnumType.STRING)
    WearType type;

    @Enumerated(EnumType.STRING)
    WearSize size;

    LocalDateTime creationDate;
    String image;
}
