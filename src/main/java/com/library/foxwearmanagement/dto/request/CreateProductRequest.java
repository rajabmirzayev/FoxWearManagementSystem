package com.library.foxwearmanagement.dto.request;

import com.library.foxwearmanagement.util.enums.WearGender;
import com.library.foxwearmanagement.util.enums.WearPurpose;
import com.library.foxwearmanagement.util.enums.WearSeason;
import com.library.foxwearmanagement.util.enums.WearType;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CreateProductRequest {
    @NotBlank(message = "Product name is required")
    @Size(min = 3, max = 50, message = "Product name must be between 3 and 50 characters")
    @Pattern(regexp = "^[a-zA-Z\\- ]+$", message = "Product name must contain only letters, spaces and '-' symbol")
    String name;

    @Min(0)
    @Max(100)
    Integer discount;

    @NotNull(message = "Gender is required")
    @Enumerated(EnumType.STRING)
    WearGender gender;

    @NotNull(message = "Purpose is required")
    @Enumerated(EnumType.STRING)
    WearPurpose purpose;

    @NotNull(message = "Season is required")
    @Enumerated(EnumType.STRING)
    WearSeason season;

    @NotNull(message = "Wear type is required")
    @Enumerated(EnumType.STRING)
    WearType wearType;

    @Size(min = 10, max = 1000, message = "Description must be between 10 and 1000 characters")
    String description;
}
