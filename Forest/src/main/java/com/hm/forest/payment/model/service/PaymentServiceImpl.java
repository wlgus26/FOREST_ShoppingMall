package com.hm.forest.payment.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hm.forest.payment.model.mapper.PaymentMapper;
import com.hm.forest.payment.model.vo.Delivery;
import com.hm.forest.payment.model.vo.Order;
import com.hm.forest.payment.model.vo.Payment;

@Service
public class PaymentServiceImpl implements PaymentService {

	@Autowired
	private PaymentMapper paymentMapper;

	// 결제하기 클릭 시 입력되는 정보들
	// 1. 결제 정보 설정(입력)
	@Override
	@Transactional
	public int save(Payment payment) {
		int result = 0;
		
		if (payment.getNo() > 0) {
			// update
		//	result = paymentMapper.updatePayment(payment);
		} else {
			// insert
			result = paymentMapper.insertPayment(payment);
		}	
		return result;
	}

	// 2. 해당 결제에 관련된 주문정보 등록
	@Override
	public int insertOrderLists(int paymentNo, List<Order> orderLists) {
		return paymentMapper.insertOrdersByPaymentNo(paymentNo, orderLists);
	}

	// 3. 해당 결제에 관련된 배송정보 등록 
	@Override
	public int save(int paymentNo, Delivery delivery) {
		int result = 0;
		
		if (delivery.getNo() > 0) {
			// update
		//	result = paymentMapper.updatePayment(payment);
		} else {
			// insert
			result = paymentMapper.insertDeliveryByPaymentNo(paymentNo, delivery);
		}	
		return result;
	}

	// 결제 성공 시 
	// 1. 재고 수량 감소_ 주문수량 확인
	@Override
	public List<Order> getOrderQuantityByNo(int no) {
		return paymentMapper.getOrderQuantityByNo(no);
	}

}
