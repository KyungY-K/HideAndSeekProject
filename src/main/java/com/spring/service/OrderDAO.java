package com.spring.service;

import java.util.List;

import com.spring.model.CartDTO;
import com.spring.model.OrderDTO;
import com.spring.model.PageDTO;
import com.spring.model.ProductDTO;

public interface OrderDAO {
	
	//�ֹ� ����Ʈ�� �ҷ����� �޼���
	List<OrderDTO> getOrderList();
	
	// �ֹ� ������ DB �� �ִ� �޼���
    void insertOrder(OrderDTO dto);

    // �ֹ� DB �� ������ �޾ƿ��� �޼���
    CartDTO getOrderCont(int order_no);

    // �ֹ� ������ �����ϴ� �޼���
    void updateOrder(OrderDTO dto);

    // �ֹ� ������ �����ϴ� �޼���
    void deleteOrder(int order_no);

}
