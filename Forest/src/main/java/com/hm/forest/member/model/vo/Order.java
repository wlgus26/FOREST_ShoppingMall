package com.hm.forest.member.model.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Order {
	private int no;

	private int cartNo;
	
	private int memberNo;
	
	private int productNo;
	
	private int detailNo;
	
	private int quantity;
	
	private String status;

}
