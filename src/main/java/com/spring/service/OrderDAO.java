package com.spring.service;

import java.util.List;

import com.spring.model.CartDTO;
import com.spring.model.OrderDTO;
import com.spring.model.Product_categoryDTO;

public interface OrderDAO {
	
	//�ֱ� �ֹ� ����Ʈ�� �ҷ����� �޼���
	List<OrderDTO> getNewOrderList();
	
	//�ֹ� ����Ʈ�� �ҷ����� �޼���
	List<OrderDTO> getOrderList();
	
	//ī�װ� ����Ʈ�� �ҷ����� �޼���
	List<Product_categoryDTO> getCategoryList();
	
	//��ü �ֹ��� �ҷ����� �޼���
	int getOrderCount();
	
	// �ֹ� ������ DB �� �ִ� �޼���
    void insertOrder(OrderDTO dto);

    // �ֹ� DB �� ������ �޾ƿ��� �޼���
    CartDTO getOrderCont(int order_no);

    // �ֹ� ������ �����ϴ� �޼���
    void updateOrder(OrderDTO dto);

    // �ֹ� ������ �����ϴ� �޼���
    void deleteOrder(int order_no);

}
