package com.hm.forest.admin.model.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductDetail {
	private int no;
	
	private String color;
	
	private String sizeSml;
	
	private int stock;
}
