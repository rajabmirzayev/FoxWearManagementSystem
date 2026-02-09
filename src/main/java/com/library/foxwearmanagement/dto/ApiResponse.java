package com.library.foxwearmanagement.dto;

import lombok.*;
import lombok.experimental.FieldDefaults;

import static com.library.foxwearmanagement.util.constant.Constant.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ApiResponse<T> {
    boolean success;
    String message;
    String errorCode;
    T data;

    public static <T> ApiResponse<T> success(T data) {
        return ApiResponse.<T>builder()
                .success(true)
                .message(SUCCESS_MSG)
                .errorCode(null)
                .data(data)
                .build();
    }

    public static <T> ApiResponse<T> validationError(T data) {
        return ApiResponse.<T>builder()
                .success(false)
                .message(VALIDATION_ERROR_MSG)
                .errorCode(VALIDATION_ERROR_CODE)
                .data(data)
                .build();
    }
}
