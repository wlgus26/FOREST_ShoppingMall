package com.hm.forest.admin.model.vo;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Program {
	
	private int no;
	
	private String title;
	
	private String thumb;
	
	private int price;
	
	private String category;
	
	private String content;
	
	private String address;
	
	private int applications;
	
	private int maximum;
	
	private String status;
	
	private Date startDate;
	
	private Date expireDate;
	
}
