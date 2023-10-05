package com.hm.forest.admin.model.service;

import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hm.forest.admin.model.mapper.AdminMapper;
import com.hm.forest.admin.model.vo.Product;
import com.hm.forest.admin.model.vo.Program;
import com.hm.forest.common.util.PageInfo;

@Service
public class AdminServiceImpl implements AdminService {
	@Autowired
	private AdminMapper adminMapper;
	

	@Override
	@Transactional
	public int save(Product product) {
		int result = 0;
		
		if (product.getNo() > 0) {
			// update
			result = adminMapper.updateProduct(product);
		} else {
			// insert
			result = adminMapper.insertProduct(product);
		}

		return result;
	}


	@Override
	public int getProductBoardCount() {
		
		
		return adminMapper.selectProductBoardCount();
	}

	@Override
	public List<Product> getProductBoardList(PageInfo pageInfo) {
		int limit = pageInfo.getListLimit();
		int offset = (pageInfo.getCurrentPage() - 1) * limit;
		RowBounds rowBounds = new RowBounds(offset, limit);
		
		return adminMapper.selectAll(rowBounds);
	}

	@Override
	public Product getProductBoardByNo(int no) {
		
		return adminMapper.selectProductBoardByNo(no);
	}


	@Override
	public int delete(int no) {
		
		return adminMapper.updateProductStatus(no, "N");
	}


<<<<<<< HEAD
	




//	@Override
//	public Product imgInsert(Product product) throws Exception {
//		
//		String imgSrc = getImgScr(product.getContent());
//		
//		if(imgSrc != "") {
//			product.setImage(imgSrc);
//			
//		}
//		
//
//		return adminMapper.productImg(product.getImage(),imgSrc);
//	}

	
=======
	@Override
	public int save(Program program) {

		return 0;
	}


>>>>>>> f2e2bdfdaedb200b88b920184079d6a448badcfd
}
