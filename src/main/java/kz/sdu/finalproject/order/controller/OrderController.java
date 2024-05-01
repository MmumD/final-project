package kz.sdu.finalproject.order.controller;


import kz.sdu.finalproject.order.dto.OrderCreateRequest;
import kz.sdu.finalproject.order.entity.OrderEntity;
import kz.sdu.finalproject.order.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/order")
@RequiredArgsConstructor
public class OrderController {

    private final OrderService service;

    @PostMapping("/add")
    public ResponseEntity<Boolean> makeOrder(@RequestHeader("Authorization") String token, @RequestBody OrderCreateRequest request){
        return ResponseEntity.ok(service.addOrder(token, request));
    }

    @GetMapping("/get")
    public ResponseEntity<List<OrderEntity>> getOrders(@RequestHeader("Authorization") String token){
        return ResponseEntity.ok(service.getOrders(token));
    }

}
