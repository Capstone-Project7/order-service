package com.demo.order_service.service;

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
		return orderRepo.saveAndFlush(newOrder);
	}
	
	public List<OrderEntity> getOrderByCustomerId(int customerId) {
		return orderRepo.findByCustomerId(customerId);
	}
	
	
	
//	public Order
}
