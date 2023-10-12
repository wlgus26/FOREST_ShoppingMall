package com.hm.forest.member.model.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Cart {
	private int no;
	
	private int memberNo;
	
	private int productNo;
	
	private int quantity;

	private String color;
	
	private String size;

	private int price;
	
	private String image;

	private String category;	

	private String name;
	
	private int discountrate;
	
	private String status;

}