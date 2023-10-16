package com.hm.forest.payment.model.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.hm.forest.payment.model.vo.Delivery;
import com.hm.forest.payment.model.vo.Order;
import com.hm.forest.payment.model.vo.Payment;

public interface PaymentService {

	// 결제하기 클릭 시 입력되는 정보들
	// 1. 결제 정보 설정(입력)
	int save(Payment payment);

	// 2. 해당 결제에 관련된 주문정보 등록 
	int insertOrderLists(@Param("paymentNo") int paymentNo, List<Order> orderLists);

	// 3. 해당 결제에 관련된 배송정보 등록 
	int save(@Param("paymentNo") int paymentNo, Delivery delivery);

	// 결제 성공 시 
	// 1. 재고 수량 감소_ 주문수량 확인
	List<Order> getOrderQuantityByNo(int no);

	
}
