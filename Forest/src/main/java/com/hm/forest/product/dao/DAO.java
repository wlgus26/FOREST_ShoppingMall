package com.hm.forest.product.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.hm.forest.admin.model.vo.Product;
import com.hm.forest.product.model.vo.Products;

@Repository
public class DAO {

	
	  @Autowired
	    private JdbcTemplate jdbcTemplate;

	  public List<Product> getAllProducts() {
	        // 데이터베이스 쿼리 실행 및 결과를 List<Product> 형태로 반환
	        List<Product> products = new ArrayList<>(); // 적절한 방법으로 데이터를 조회하여 products에 할당
	        return products;
	    }

	    public Product getProductByNo(int productNo) {
	        // 데이터베이스 쿼리 실행 및 결과를 Product 형태로 반환
	        Product product = new Product(); // 적절한 방법으로 데이터를 조회하여 product에 할당
	        return product;
	    }
}
