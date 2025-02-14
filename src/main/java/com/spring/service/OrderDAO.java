package com.spring.service;

import java.util.List;
import java.util.Map;

import com.spring.model.CartDTO;
import com.spring.model.OrderDTO;
import com.spring.model.PageDTO;
import com.spring.model.ProductDTO;
import com.spring.model.Product_categoryDTO;

public interface OrderDAO {
	
	//占쌍깍옙 占쌍뱄옙 占쏙옙占쏙옙트占쏙옙 占쌀뤄옙占쏙옙占쏙옙 占쌨쇽옙占쏙옙
	List<OrderDTO> getNewOrderList();
	
	//占쌍뱄옙 占쏙옙占쏙옙트占쏙옙 占쌀뤄옙占쏙옙占쏙옙 占쌨쇽옙占쏙옙
	List<OrderDTO> getOrderList();
	
	//카占쌓곤옙 占쏙옙占쏙옙트占쏙옙 占쌀뤄옙占쏙옙占쏙옙 占쌨쇽옙占쏙옙
	List<Product_categoryDTO> getCategoryList();
	
	//占쏙옙체 占쌍뱄옙占쏙옙 占쌀뤄옙占쏙옙占쏙옙 占쌨쇽옙占쏙옙
	int getOrderCount();
	
	// 占쌍뱄옙 占쏙옙占쏙옙占쏙옙 DB 占쏙옙 占쌍댐옙 占쌨쇽옙占쏙옙
    void insertOrder(OrderDTO dto);

    // 占쌍뱄옙 DB 占쏙옙 占쏙옙占쏙옙占쏙옙 占쌨아울옙占쏙옙 占쌨쇽옙占쏙옙
    CartDTO getOrderCont(int order_no);

    // 占쌍뱄옙 占쏙옙占쏙옙占쏙옙 占쏙옙占쏙옙占싹댐옙 占쌨쇽옙占쏙옙
    void updateOrder(OrderDTO dto);

    // 占쌍뱄옙 占쏙옙占쏙옙占쏙옙 占쏙옙占쏙옙占싹댐옙 占쌨쇽옙占쏙옙
    void deleteOrder(int order_no);
    
    // DB ���� ��泥� 二쇰Ц 紐⑸� ��瑜� 諛����ㅻ�� 硫�����
    int getOrderListCount();
    
    // �ㅻ�����대��� 由ъ�ㅽ�몃�� 諛����ㅻ�� 硫�����
    List<OrderDTO> getOrderList(PageDTO dto);
    
    // �ㅻ��由ъ�ㅽ�몄�� ����踰��몄�� �대�뱁���� ���� ��蹂대�� 諛����ㅻ�� 硫�����
    List<ProductDTO> getOrderProductList(int product_no);
    
    // 二쇰Ц踰��몄�� �대�뱁���� 二쇰Ц�댁���� 二쇰Ц����瑜� 蹂�寃쏀���� 硫�����
    int orderStatusChange(Map<String, Object> map);
    
    // �ㅻ�����대��� 寃��� 由ъ�ㅽ�몄�� ��瑜� 諛����ㅻ�� 硫�����
    int getOrderSearchListCount(String keyword);
    
    // �ㅻ�����대��� 寃��� 由ъ�ㅽ�몃�� 諛����ㅻ�� 硫�����
    List<OrderDTO> getOrderSearchList(Map<String, Object> map);
    
    // DB ���� ��泥� 二쇰Ц 紐⑸� ��瑜� 諛����ㅻ�� 硫�����
    int getOrderDelListCount();
    
    // �ㅻ�����대��� 二쇰Ц�� 痍⑥���� 由ъ�ㅽ�몃�� 諛����ㅻ�� 硫�����
    List<OrderDTO> getOrderDelList(PageDTO dto);
    
    // �ㅻ�����대��� 寃��� 由ъ�ㅽ�몄�� ��瑜� 諛����ㅻ�� 硫�����
    int getOrderDelSearchListCount(String keyword);
    
    // �ㅻ�����대��� 寃��� 由ъ�ㅽ�몃�� 諛����ㅻ�� 硫�����
    List<OrderDTO> getOrderDelSearchList(Map<String, Object> map);
    
    List<OrderDTO> getSamePakageOrderList(int order_pakage);
    
    // 오더 테이블에 맥스 패키지 값을 받아오는 메서드
 	int getOrderMaxPackageNo();
 	
 	// 오더 테이블에 맥스 오더 넘버를 받아오는 메서드
 	int getOrderMaxNo();
 	
 	// 오더 테이블에 주문 정보를 넣는 메서드
 	void insertorder(Map<String, Object> map);
 	
 	// 주문 완료시 해당하는 상품의 재고 수량을 낮추는 메서드
 	void updateProductStock(Map<String, Object> map);
 	
	// 주문 완료시 해당하는 유저가 사용한 포인트를 차감해주는 메서드
   	void updateMinusPoint(Map<String, Object> map);
 	
 	// 주문 완료시 해당하는 유저의 정보에 포인트를 적립해주는 메서드
  	void updateSavePoint(Map<String, Object> map);
  	
  	// 주문 후 해당 상품의 재고가 0이면 판매상태를 품절로 바꿔주는 메서드
   	void updateProductStatus(Map<String, Object> map);
   	
   	// 유저 이름에 해당하는 주문 내역을 출력하는 메서드(5개만)
   	List<OrderDTO> getOrderList(String userId);
   	
   	// 유저 이름에 해당하는 주문 전체 내역을 출력하는 메서드
   	List<OrderDTO> getorderListall(String userId);
   	
   	
  	
}
