package kz.sdu.finalproject.products.service.impl;

import kz.sdu.finalproject.core.exceptions.ProductNotFoundException;
import kz.sdu.finalproject.products.dto.ProductCreateRequest;
import kz.sdu.finalproject.products.dto.ProductUpdateRequest;
import kz.sdu.finalproject.products.entity.ProductEntity;
import kz.sdu.finalproject.products.mapper.ProductMapper;
import kz.sdu.finalproject.products.repository.ProductRepository;
import kz.sdu.finalproject.products.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository repository;

    @Transactional
    @Override
    public boolean addProduct(ProductCreateRequest request) {
        ProductEntity entity = ProductMapper.INSTANCE.toEntity(request);

        repository.save(entity);

        return true;
    }

    @Transactional
    @Override
    public boolean updateProduct(Long id, ProductUpdateRequest request) {
        ProductEntity entity = repository.findById(id)
                .orElseThrow(() -> new ProductNotFoundException("Product not found"));

        entity = ProductMapper.INSTANCE.toEntity(entity, request);

        repository.save(entity);

        return true;
    }

    @Transactional(readOnly = true)
    @Override
    public List<ProductEntity> getProducts() {
        return repository.findAll();
    }

    @Transactional(readOnly = true)
    @Override
    public ProductEntity getProductById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ProductNotFoundException("Product not found"));
    }

    @Transactional(readOnly = true)
    @Override
    public boolean productExists(Long id) {
        return repository.existsById(id);
    }
}
