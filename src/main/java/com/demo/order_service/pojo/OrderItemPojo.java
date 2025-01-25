package com.demo.order_service.pojo;

import java.sql.Date;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data

public class OrderItemPojo {

    private int orderId;
	private Date orderDate;
	private Date deliveryDate;
	private int customerId;	
    private List<ItemPojo> items;
}
