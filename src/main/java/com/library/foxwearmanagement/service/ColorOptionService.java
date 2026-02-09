package com.library.foxwearmanagement.service;

import com.library.foxwearmanagement.dto.request.CreateColorOptionRequest;
import com.library.foxwearmanagement.dto.response.CreateColorOptionResponse;
import com.library.foxwearmanagement.entity.ColorOption;
import com.library.foxwearmanagement.exception.ColorAlreadyExistException;
import com.library.foxwearmanagement.repository.ColorOptionRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ColorOptionService {
    private final ColorOptionRepository colorOptionRepository;
    private final ModelMapper modelMapper;

    public CreateColorOptionResponse createColorOption(CreateColorOptionRequest request) {
        if (colorOptionRepository.existsByColorNameAndSizeAndProduct(
                request.getColorName(),
                request.getSize(),
                request.getProduct().getId()
        )) {
            throw new ColorAlreadyExistException("Color with name " + request.getColorName() +
                    ", size " + request.getSize() +
                    " already exists");
        }

        ColorOption colorOption = modelMapper.map(request, ColorOption.class);

        colorOptionRepository.save(colorOption);

        return modelMapper.map(colorOption, CreateColorOptionResponse.class);
    }
}
