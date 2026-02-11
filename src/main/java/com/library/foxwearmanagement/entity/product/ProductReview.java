package com.library.foxwearmanagement.entity.product;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.library.foxwearmanagement.entity.User;
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
    Integer rating;
    String comment;

    @JsonFormat(pattern = "dd-MM-yyyy HH:mm:ss")
    LocalDateTime reviewDate;

    @JsonFormat(pattern = "dd-MM-yyyy HH:mm:ss")
    LocalDateTime lastUpdated;

    @ManyToOne
    @JoinColumn(name = "product_id")
    Product product;

    @ManyToOne
    @JoinColumn(name = "user_id")
    User user;

    @PrePersist
    public void prePersist() {
        reviewDate = LocalDateTime.now();
        lastUpdated = LocalDateTime.now();
    }

    @PreUpdate
    public void preUpdate() {
        lastUpdated = LocalDateTime.now();
    }
}
