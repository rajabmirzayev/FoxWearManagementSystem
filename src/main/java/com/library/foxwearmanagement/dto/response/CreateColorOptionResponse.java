package com.library.foxwearmanagement.dto.response;

import com.library.foxwearmanagement.util.enums.WearSize;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CreateColorOptionResponse {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String colorName;
    Integer stockQuantity;
    WearSize size;
    Double price;
    Double discountedPrice; // ? endirim tətbiq olunandan sonrakı qiymət
    Boolean active;
    String imageUrl;
}
