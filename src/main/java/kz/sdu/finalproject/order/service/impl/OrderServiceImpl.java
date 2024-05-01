package kz.sdu.finalproject.order.service.impl;

import kz.sdu.finalproject.core.exceptions.BadRequestException;
import kz.sdu.finalproject.order.dto.OrderCreateRequest;
import kz.sdu.finalproject.order.entity.OrderEntity;
import kz.sdu.finalproject.order.repository.OrderRepository;
import kz.sdu.finalproject.order.service.OrderService;
import kz.sdu.finalproject.products.service.ProductService;
import kz.sdu.finalproject.user.service.UserService;
import kz.sdu.finalproject.user.util.GetUsername;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;

    private final ProductService productService;

    private final UserService userService;

    private final GetUsername getUsername;

    @Transactional
    @Override
    public boolean addOrder(String token, OrderCreateRequest request) {
        if(request.getProductIds().stream().anyMatch(productId -> !productService.productExists(productId)))
            throw new BadRequestException("Product not exists");


        OrderEntity entity = OrderEntity.builder()
                .user(userService.getUserByName(getUsername.getUsername(token)))
                .createdAt(LocalDateTime.now())
                .build();

        for (Long productId : request.getProductIds())
            entity.addProduct(productService.getProductById(productId));

        orderRepository.save(entity);

        return true;
    }

    @Transactional(readOnly = true)
    @Override
    public List<OrderEntity> getOrders(String token) {
        return orderRepository.findOrderEntitiesByUser(userService.getUserByName(getUsername.getUsername(token)));
    }


}
