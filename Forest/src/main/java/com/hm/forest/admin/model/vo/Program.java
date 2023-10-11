package com.hm.forest.admin.model.vo;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Program {
	
	private int no;
	
	private String title;
	
	private int price;
	
	private String category;
	
	private String content;
	
	private String address;
	
	private int applications;
	
	private int maximum;
	
	private String status;
	
	private String originalFilename;
	
	private String renamedFilename;
	
	private Date startDate;
	
	private Date expireDate; 

}
