package com.hm.forest.product.model.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.hm.forest.product.model.vo.Products;
import com.hm.forest.admin.model.vo.Product;
import com.hm.forest.common.util.PageInfo;

@Service
public interface ProductService {


	List<Products> getProducts();
	

//	Products getProductsById(int no);
	
	List<Products> getProductList(PageInfo pageInfo);
//	
//	Products getProductByNo(int no);

	List<Products> datailProduct(int no);

	Products selectProductByNo(int no);
	
	
	

	
	
	
	List<Product> getAllProducts();


	static Products getProductByNo(int no) {
		// TODO Auto-generated method stub
		return null;
	}


	Products getProductByNo1(int no);

//	int productdetail(int no);

}
