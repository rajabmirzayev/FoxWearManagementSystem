package com.library.foxwearmanagement.service;

import com.library.foxwearmanagement.dto.request.CreateProductRequest;
import com.library.foxwearmanagement.dto.response.CreateProductResponse;
import com.library.foxwearmanagement.entity.Product;
import com.library.foxwearmanagement.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;
    private final ModelMapper modelMapper;

    public CreateProductResponse createProduct(CreateProductRequest request) {
        Product product = modelMapper.map(request, Product.class);

        product = productRepository.save(product);

        return modelMapper.map(product, CreateProductResponse.class);
    }
}
