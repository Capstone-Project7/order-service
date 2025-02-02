package com.demo.order_service.dao.entity;

import java.sql.Date;
import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data

@Entity
@Table(name="orders")
public class OrderEntity {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="order_id")
	private int orderId;
	
	@Column(name="order_date")
	// private Date orderDate;
	private LocalDate orderDate;

	
	@Column(name="delivery_date")
	// private Date deliveryDate;
	private LocalDate deliveryDate;

	
	@Column(name="order_amount")
	// private Date deliveryDate;
	private double orderAmount;

	
	@Column(name="customer_id")
	private int customerId;	

}
