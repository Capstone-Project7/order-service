package com.demo.order_service.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.demo.order_service.dao.entity.OrderEntity;

@Repository
public interface OrderRepository extends JpaRepository<OrderEntity,Integer>{
//	getOrderByCustomerId()
	 List<OrderEntity> findByCustomerId(int customerId);
}
