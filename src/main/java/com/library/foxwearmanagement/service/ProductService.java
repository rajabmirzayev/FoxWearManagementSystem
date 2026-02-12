package com.library.foxwearmanagement.service;

import com.library.foxwearmanagement.dto.request.CreateProductRequest;
import com.library.foxwearmanagement.dto.response.CreateProductResponse;
import com.library.foxwearmanagement.dto.response.GetAllProductResponse;
import com.library.foxwearmanagement.dto.response.GetColorOptionResponse;
import com.library.foxwearmanagement.entity.product.Product;
import com.library.foxwearmanagement.entity.enums.WearGender;
import com.library.foxwearmanagement.entity.enums.WearPurpose;
import com.library.foxwearmanagement.entity.enums.WearSeason;
import com.library.foxwearmanagement.entity.enums.WearType;
import com.library.foxwearmanagement.exception.NotFoundException;
import com.library.foxwearmanagement.repository.ProductRepository;
import com.library.foxwearmanagement.repository.enums.WearGenderRepository;
import com.library.foxwearmanagement.repository.enums.WearPurposeRepository;
import com.library.foxwearmanagement.repository.enums.WearSeasonRepository;
import com.library.foxwearmanagement.repository.enums.WearTypeRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;
    private final WearGenderRepository wearGenderRepository;
    private final WearPurposeRepository wearPurposeRepository;
    private final WearSeasonRepository wearSeasonRepository;
    private final WearTypeRepository wearTypeRepository;
    private final ModelMapper modelMapper;

    public CreateProductResponse createProduct(CreateProductRequest request) {
        WearGender gender = wearGenderRepository.findById(request.getGender())
                .orElseThrow(() -> new NotFoundException("gender with id " + request.getGender() +  " not found"));

        WearPurpose purpose = wearPurposeRepository.findById(request.getPurpose())
                .orElseThrow(() -> new NotFoundException("purpose with id " + request.getPurpose() +  " not found"));

        WearSeason season = wearSeasonRepository.findById(request.getSeason())
                .orElseThrow(() -> new NotFoundException("season with id " + request.getSeason() +  " not found"));

        WearType wearType = wearTypeRepository.findById(request.getWearType())
                .orElseThrow(() -> new NotFoundException("wearType with id " + request.getWearType() +  " not found"));

        Product product = modelMapper.map(request, Product.class);

        product.setGender(gender);
        product.setPurpose(purpose);
        product.setSeason(season);
        product.setWearType(wearType);

        product = productRepository.save(product);

        return modelMapper.map(product, CreateProductResponse.class);
    }

    public List<GetAllProductResponse> getMostLikedProducts() {
        return productRepository.findTop10ByLikes().stream()
                .map(product -> {
                    var map = modelMapper.map(product, GetAllProductResponse.class);
                    var colorOptionList = product.getColorOptions().stream()
                            .map(colorOption -> modelMapper.map(colorOption, GetColorOptionResponse.class))
                            .toList();
                    map.setColors(colorOptionList);
                    return map;
                })
                .toList();
    }
}
