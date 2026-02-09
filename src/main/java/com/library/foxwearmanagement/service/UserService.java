package com.library.foxwearmanagement.service;

import com.library.foxwearmanagement.dto.request.CreateUserRequest;
import com.library.foxwearmanagement.dto.response.CreateUserResponse;
import com.library.foxwearmanagement.entity.User;
import com.library.foxwearmanagement.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
    private final ModelMapper modelMapper;
    private final UserRepository userRepository;

    public CreateUserResponse createUser(CreateUserRequest createUserRequest) {
        User user = modelMapper.map(createUserRequest, User.class);

        userRepository.save(user);

        return modelMapper.map(user, CreateUserResponse.class);
    }
}
