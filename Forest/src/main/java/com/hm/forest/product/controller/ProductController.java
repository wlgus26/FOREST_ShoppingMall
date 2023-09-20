package com.hm.forest.product.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.hm.forest.board.service.BoardService;
import com.hm.forest.product.model.service.ProductService;
import com.hm.forest.product.model.vo.Product;

@Controller
@RequestMapping("/product")
public class ProductController {
	
	@Autowired
	private ProductService productService;
	
	// 제품 등록하기
    @RequestMapping(value = "/admin/productInsert", method = RequestMethod.POST)
	public ResponseEntity<Map<String, Object>> enroll(Product product) {
	int result = 0;
	Map<String, Object> map = new HashMap<>();
					
	result = productService.save(product);
			
	map.put("resultCode", result);
	map.put("product", product);
			
	return ResponseEntity.ok(map);
		}

}
