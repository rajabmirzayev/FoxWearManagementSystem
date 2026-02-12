package com.library.foxwearmanagement.dto.response;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class GetColorOptionResponse {
    Long id;
    Double price;
    Double discountedPrice; // ? endirim tətbiq olunandan sonrakı qiymət
    Boolean active = true;
    String imageUrl;
}
