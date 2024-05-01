package kz.sdu.finalproject.products.controller;

import kz.sdu.finalproject.products.dto.ProductCreateRequest;
import kz.sdu.finalproject.products.dto.ProductUpdateRequest;
import kz.sdu.finalproject.products.entity.ProductEntity;
import kz.sdu.finalproject.products.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService service;

    @GetMapping("/get/by/id")
    public ResponseEntity<ProductEntity> getProductById(@RequestParam (value = "id") Long id) {
        return ResponseEntity.ok(service.getProductById(id));
    }

    @GetMapping("/get/all")
    public ResponseEntity<List<ProductEntity>> getProducts(){
        return ResponseEntity.ok(service.getProducts());
    }


    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PostMapping("/add")
    public ResponseEntity<Boolean> addProduct(@RequestBody ProductCreateRequest request){
        return ResponseEntity.ok(service.addProduct(request));
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PutMapping("/update")
    public ResponseEntity<Boolean> updateProduct(@RequestParam (value = "id") Long id, @RequestBody ProductUpdateRequest request){
        return ResponseEntity.ok(service.updateProduct(id, request));
    }


}
