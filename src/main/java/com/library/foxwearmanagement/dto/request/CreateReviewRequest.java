package com.library.foxwearmanagement.dto.request;

import jakarta.validation.constraints.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CreateReviewRequest {
    @NotNull(message = "User ID is required")
    Long userId;

    @Size(max = 200, message = "Comment must be maximum 200 characters")
    String comment;

    @Min(1)
    @Max(5)
    @NotNull(message = "Rating is required")
    Integer rating;
}
