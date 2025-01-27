package com.demo.order_service.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data

public class ItemPojo {

    private int itemId;
	private int orderId;
	private int catalogueId;
	private int tailorId;
	private String itemStatus;
    
}
