package com.library.foxwearmanagement.dto.request;

import com.library.foxwearmanagement.entity.Product;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CreateColorOptionRequest {
    @NotBlank(message = "Color name is required")
    @Size(min = 1, max = 20, message = "Color name must be between 1 and 20 characters")
    @Pattern(regexp = "^[a-zA-Z\\s]+$", message = "Color name must only contain letters and spaces")
    String colorName;

    @NotNull(message = "Stock quantity is required")
    @Min(value = 0, message = "Stock quantity cannot be less than 0")
    @Max(value = 10000, message = "Stock quantity cannot exceed 10,000")
    Integer stockQuantity;

    @NotNull(message = "Price is required")
    @Min(value = 0, message = "Price cannot be less than 0")
    @DecimalMin(value = "0.01", message = "Price must be greater than 0")
    @Digits(integer = 10, fraction = 2, message = "Price must have at most 2 decimal places and be a valid number")
    Double price;

    @NotNull(message = "Wear size is required")
    Long size;

    @ManyToOne
    @JoinColumn(name = "product_id")
    @NotNull(message = "Product is required")
    Product product;

    String imageUrl;
}
