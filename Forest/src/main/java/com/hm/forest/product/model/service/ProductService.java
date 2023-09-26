package com.hm.forest.product.model.service;

import java.util.List;

import com.hm.forest.product.model.vo.Products;
import com.hm.forest.common.util.PageInfo;

public interface ProductService {


	List<Products> getProducts();
	

//	Products getProductsById(int no);
	
	List<Products> getProductList(PageInfo pageInfo);
	
	Products getProductByNo(int no);

//	List<Products> datailProduct();


//	int productdetail(int no);

}
