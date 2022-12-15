package com.spring.service;

import java.util.List;

import com.spring.model.CartDTO;
import com.spring.model.ProductDTO;


public interface CartDAO {

	// 유저 ID 에 해당하는 장바구니 수를 받아오는 메서드
	int getCartCount(String userId);
	
	// 유저 ID 에 해당하는 장바구니 정보를 받아오는 메서드
	List<CartDTO> getCartList(String userId);
	
	// 장바구니 번호 에 해당하는 장바구니 정보를 받아오는 메서드
	List<CartDTO> getCartDTO(int cart_no);
	
	// 상품 번호에 해당하는 상품 정보를 받아오는 메서드
	List<ProductDTO> getCartProductList(int product_no);
	
	// 장바구니 번호에 해당하는 장바구니 정보를 삭제하는 메서드
	void deleteCartList(int cart_no);
	
	// 장바구니 번호에 해당하는 장바구니 수량을 다운시키는 메서드
	void minusCartAmonut(int cart_no);
	
	// 장바구니 번호에 해당하는 장바구니 수량을 업시키는 메서드
	void plusCartAmonut(int cart_no);
	
	// 장바구니 번호에 해당하는 장바구니 수량을 가져오는 메서드
	String getCartAmount(int cart_no);
	
	// 삭제한 장바구니 번호보다 높은 장바구니의 번호를 받아오는 메서드
	List<CartDTO> getCartMaxNo(int cart_no);
	
}
