package com.library.foxwearmanagement.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.library.foxwearmanagement.util.enums.*;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "product", schema = "products")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String name;

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
    List<ColorOption> colorOptions;
    Integer likes;

    Integer discount;

    @JsonFormat(pattern = "dd-MM-yyyy")
    LocalDate releaseDate;  // ? satışa çıxarılma tarixi

    @JsonFormat(pattern = "dd-MM-yyyy HH:mm:ss")
    LocalDateTime lastUpdated;

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
    List<ProductReview> reviews;

    @Enumerated(EnumType.STRING)
    WearGender gender;

    @Enumerated(EnumType.STRING)
    WearPurpose purpose;

    @Enumerated(EnumType.STRING)
    WearSeason season;

    @Enumerated(EnumType.STRING)
    WearType wearType;

    String description;

    @PrePersist
    public void prePersist() {
        releaseDate = LocalDate.now();
        lastUpdated = LocalDateTime.now();
        likes = likes == null ? 0 : likes;
        discount = discount == null ? 0 : discount;
    }

    @PreUpdate
    public void preUpdate() {
        lastUpdated = LocalDateTime.now();
    }
}
