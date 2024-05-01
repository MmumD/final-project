package kz.sdu.finalproject.products.service;

import kz.sdu.finalproject.products.dto.ProductCreateRequest;
import kz.sdu.finalproject.products.dto.ProductUpdateRequest;
import kz.sdu.finalproject.products.entity.ProductEntity;

import java.util.List;

public interface ProductService {

    boolean addProduct(ProductCreateRequest request);

    boolean updateProduct(Long id, ProductUpdateRequest request);

    List<ProductEntity> getProducts();

    ProductEntity getProductById(Long id);

}
