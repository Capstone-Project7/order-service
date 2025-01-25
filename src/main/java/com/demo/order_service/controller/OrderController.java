package com.demo.order_service.controller;

import com.demo.order_service.service.OrderService;
import com.demo.order_service.dao.entity.OrderEntity;
import com.demo.order_service.pojo.ItemPojo;
import com.demo.order_service.pojo.OrderItemPojo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestClient;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    private OrderService orderService;

    // Get all orders
    @GetMapping
    public ResponseEntity<List<OrderEntity>> getAllOrders() {
        List<OrderEntity> orders = orderService.getAllOrders();
        return new ResponseEntity<>(orders, HttpStatus.OK);
    }

    // Get order by ID
    @GetMapping("/{orderId}")
    public ResponseEntity<OrderItemPojo> getOrderById(@PathVariable int orderId) {
        Optional<OrderEntity> order = orderService.getOrderById(orderId);
        if (order.isPresent()) {
            RestClient restClient = RestClient.create();
            List<ItemPojo> allItems = restClient
                    .get()
                    .uri("http://localhost:8082/api/order/" + order.get().getOrderId())
                    .retrieve()
                    .body(List.class);

            OrderItemPojo orderItemPojo = new OrderItemPojo(
                    order.get().getOrderId(),
                    order.get().getOrderDate(),
                    order.get().getDeliveryDate(),
                    order.get().getCustomerId(),
                    allItems);
                    return ResponseEntity.status(HttpStatus.OK).body(orderItemPojo);
                } else { 
                    return new ResponseEntity<>(HttpStatus.NOT_FOUND);
                }
    }

    // Get orders by customer ID
    @GetMapping("/customer/{customerId}")
    public ResponseEntity<List<OrderEntity>> getOrdersByCustomerId(@PathVariable int customerId) {
        List<OrderEntity> orders = orderService.getOrderByCustomerId(customerId);
        return new ResponseEntity<>(orders, HttpStatus.OK);
    }

    // Create a new order
    @PostMapping
    public ResponseEntity<OrderEntity> createOrder(@RequestBody OrderEntity newOrder) {
        OrderEntity createdOrder = orderService.createOrder(newOrder);
        return new ResponseEntity<>(createdOrder, HttpStatus.OK);
    }
}
