package com.library.foxwearmanagement.service;

import com.library.foxwearmanagement.dto.request.CreateUserRequest;
import com.library.foxwearmanagement.dto.response.CreateUserResponse;
import com.library.foxwearmanagement.entity.User;
import com.library.foxwearmanagement.exception.EmailAlreadyExistException;
import com.library.foxwearmanagement.exception.PhoneNumberAlreadyExistException;
import com.library.foxwearmanagement.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
@RequiredArgsConstructor
public class UserService {
    private final ModelMapper modelMapper;
    private final UserRepository userRepository;

    public CreateUserResponse createUser(CreateUserRequest createUserRequest) {
        if (userRepository.existsByEmail(createUserRequest.getEmail())) {
            throw new EmailAlreadyExistException("Email " + createUserRequest.getEmail() + " already exists");
        }

        if (userRepository.existsByPhoneNumber(createUserRequest.getPhoneNumber())) {
            throw new PhoneNumberAlreadyExistException("Phone number " + createUserRequest.getPhoneNumber() + " already exists");
        }

        User user = modelMapper.map(createUserRequest, User.class);

        userRepository.save(user);

        return modelMapper.map(user, CreateUserResponse.class);
    }
}
