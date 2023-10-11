package com.hm.forest.admin.model.vo;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product {
	
	private int no;
	
	private String category;
	
	private String name;
	
	private int price;
	
	private String content;
	
	private String company;
	
	private int discountrate;
	
	private String selling;
	
	private String status;
	
	private String image;
	
	private int wish;
	
	
	// 다른 속성들
    private String color;
    
    
    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
    
  
    private String sizeSml;
    
    
    public String getSizeSml() {
        return sizeSml;
    }

    public void setSizeSml(String sizeSml) {
        this.sizeSml = sizeSml;
    }
    
   
    private int stock;

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }
    
    

}
