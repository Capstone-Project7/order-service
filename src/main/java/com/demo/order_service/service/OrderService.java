package com.demo.order_service.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.demo.order_service.dao.entity.*;

import com.demo.order_service.dao.OrderRepository;

@Service
public class OrderService {
	
	@Autowired
	OrderRepository orderRepo;
	
	public List<OrderEntity> getAllOrders(){
		return orderRepo.findAll();
	}
	
	public Optional<OrderEntity> getOrderById(int orderId){
		return orderRepo.findById(orderId);
	}
	
	public OrderEntity createOrder(OrderEntity newOrder) {
		newOrder.setOrderDate(LocalDate.now());
		newOrder.setOrderAmount(0);
		return orderRepo.saveAndFlush(newOrder);
	}

	public OrderEntity updateAmountOrder(OrderEntity newOrder) {
		OrderEntity orderEntity = orderRepo.findById(newOrder.getOrderId()).orElse(null);
		if(orderEntity != null) {
			orderEntity.setOrderAmount(newOrder.getOrderAmount() + orderEntity.getOrderAmount());
            return orderRepo.save(orderEntity);
		}
		return null;
	}
	
	public List<OrderEntity> getOrderByCustomerId(int customerId) {
		return orderRepo.findByCustomerId(customerId);
	}
	
	
	
//	public Order
}
