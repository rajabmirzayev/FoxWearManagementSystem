package com.library.foxwearmanagement.dto.response;

import com.library.foxwearmanagement.entity.User;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class GetReviewResponse {
    Long id;
    User user;
    String comment;
    Integer rating;
    LocalDateTime createdAt;
    LocalDateTime updatedAt;
    Boolean status;
}
