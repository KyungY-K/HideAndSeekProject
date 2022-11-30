package com.spring.service;

import com.spring.model.CartDTO;


public interface CartDAO {
	// ��ٱ��� ������ DB �� �ִ� �޼���
    void insertCart(CartDTO dto);

    // ��ٱ��� DB �� ������ �޾ƿ��� �޼���
    CartDTO getCartCont(int cart_no);

    // ��ٱ����� ������ �����ϴ� �޼���
    void updateCart(CartDTO dto);

    // ��ٱ����� ������ �����ϴ� �޼���
    void deleteCart(int cart_no);

}
