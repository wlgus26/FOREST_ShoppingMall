package com.hm.forest.admin.model.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Product {
	
	private int no;
	
	private String name;
	
	private int price;
	
	private String content;
	
	private String color;
	
	private int amount;
	
	private String sizeSml;
	
	private int stock;
	
	private String company;
	
	private int discountrate;
	
	private String image;
	
	private int wish;
	
	
}
