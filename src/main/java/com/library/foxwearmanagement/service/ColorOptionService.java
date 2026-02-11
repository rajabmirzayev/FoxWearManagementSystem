package com.library.foxwearmanagement.service;

import com.library.foxwearmanagement.dto.request.CreateColorOptionRequest;
import com.library.foxwearmanagement.dto.response.CreateColorOptionResponse;
import com.library.foxwearmanagement.entity.product.ColorOption;
import com.library.foxwearmanagement.entity.enums.WearSize;
import com.library.foxwearmanagement.exception.ColorAlreadyExistException;
import com.library.foxwearmanagement.exception.NotFoundException;
import com.library.foxwearmanagement.repository.ColorOptionRepository;
import com.library.foxwearmanagement.repository.enums.WearSizeRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ColorOptionService {
    private final ColorOptionRepository colorOptionRepository;
    private final WearSizeRepository wearSizeRepository;
    private final ModelMapper modelMapper;

    public CreateColorOptionResponse createColorOption(CreateColorOptionRequest request) {
        WearSize size = wearSizeRepository.findById(request.getSize())
                .orElseThrow(() -> new NotFoundException("size with id " + request.getSize() + " not found"));

        if (colorOptionRepository.existsByColorNameAndSizeAndProduct(
                request.getColorName(),
                size,
                request.getProduct().getId()
        )) {
            throw new ColorAlreadyExistException("Color with name " + request.getColorName() +
                    ", size " + request.getSize() +
                    " already exists");
        }

        ColorOption colorOption = modelMapper.map(request, ColorOption.class);

        colorOption.setSize(size);

        colorOptionRepository.save(colorOption);

        return modelMapper.map(colorOption, CreateColorOptionResponse.class);
    }
}
