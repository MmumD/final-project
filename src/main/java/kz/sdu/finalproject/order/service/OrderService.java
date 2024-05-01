package kz.sdu.finalproject.order.service;

import kz.sdu.finalproject.order.dto.OrderCreateRequest;
import kz.sdu.finalproject.order.entity.OrderEntity;

import java.util.List;

public interface OrderService {

    boolean addOrder(String token, OrderCreateRequest request);

    List<OrderEntity> getOrders(String token);

}
