package com.hm.forest.product.model.vo;

import lombok.AllArgsConstructor;
<<<<<<< HEAD
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
=======
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Data
@Builder
@ToString
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
>>>>>>> main
public class Product {
	private int no;
	
	private String name;
	
	private int price;
	
	private String content;
	
	private String color;
<<<<<<< HEAD
	 
	private int amount;
	
	private String size_sml;
=======
	
	private int amount;
	
	private String sizeSml;
>>>>>>> main
	
	private int stock;
	
	private String company;
	
	private int discountrate;
	
	private String status;
	
	private String image;
	
	private int wish;
<<<<<<< HEAD
=======
	
	
>>>>>>> main
}
