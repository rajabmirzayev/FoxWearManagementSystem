package com.library.foxwearmanagement.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.library.foxwearmanagement.util.enums.UserRole;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "user", schema = "users")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    String firstName;
    String lastName;
    String email;
    String password;

    @Enumerated(EnumType.STRING)
    UserRole role;

    String phoneNumber;
    String profileImageUrl;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    List<ProductReview> reviews;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    LocalDateTime createdAt;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    LocalDateTime updatedAt;

//    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
//    List<Order> orders;

    Boolean active = true;

    @PrePersist
    public void prePersist() {
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
        this.role = UserRole.USER;

//        Optional.ofNullable(this.password)
//                .ifPresent(password -> this.password = PasswordUtil.encryptPassword(password));
    }

    @PreUpdate
    public void preUpdate() {
        this.updatedAt = LocalDateTime.now();

//        Optional.ofNullable(this.password)
//                .ifPresent(password -> this.password = PasswordUtil.encryptPassword(password));
    }
}
