package com.library.foxwearmanagement.entity;

import com.library.foxwearmanagement.util.enums.WearSize;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
@Table(name = "product_color_option", schema = "products")
public class ColorOption {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String colorName;
    Integer stockQuantity;

    @Enumerated(EnumType.STRING)
    WearSize size;
    Double price;
    Double discountedPrice; // ? endirim tətbiq olunandan sonrakı qiymət
    String imageUrl;

    @ManyToOne
    @JoinColumn(name = "product_id")
    Product product;
}
