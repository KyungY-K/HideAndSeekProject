package com.spring.service;

import com.spring.model.CartDTO;
import com.spring.model.OrderDTO;
import com.spring.model.ProductDTO;

public interface OrderDAO {
	
	// �ֹ� ������ DB �� �ִ� �޼���
    void insertOrder(OrderDTO dto);

    // �ֹ� DB �� ������ �޾ƿ��� �޼���
    CartDTO getOrderCont(int order_no);

    // �ֹ� ������ �����ϴ� �޼���
    void updateOrder(OrderDTO dto);

    // �ֹ� ������ �����ϴ� �޼���
    void deleteOrder(int order_no);

}
