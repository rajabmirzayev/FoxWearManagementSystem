package com.library.foxwearmanagement.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
@Table(name = "product_review", schema = "products")
public class ProductReview {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    String customerName;
    Integer rating;
    String comment;

    @JsonFormat(pattern = "dd-MM-yyyy HH:mm:ss")
    LocalDateTime reviewDate;

    @ManyToOne
    @JoinColumn(name = "product_id")
    Product product;
}
