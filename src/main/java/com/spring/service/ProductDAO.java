package com.spring.service;

import java.util.List;
import java.util.Map;

import com.spring.model.PageDTO;
import com.spring.model.ProductDTO;
import com.spring.model.ReviewDTO;

public interface ProductDAO {
	
	// 가장 많이 팔린 상품 수를 받아오는 메서드
	List<ProductDTO> getBestList();
	
	// 리뷰가 많이 달린 상품 수를 받아오는 메서드
	List<ProductDTO> getReviewList();
	
	// 사진이 포함된 최신 리뷰를 받아오는 메서드
	List<ReviewDTO> getPhotoReviewList();
	
	// DB 상의 전체 상품 수를 받아오는 메서드
    int getListCount();
    
    // DB 상의 해당 카테고리 상품 수를 받아오는 메서드
    int getListCategoryCount(String category);
    
    // 태그가 포함된 DB 상의 상품 수를 받아오는 메서드
    int getListTagCount(Map<String, Object> map);
    
    // 상품번호에 해당하는 리뷰 총 개수를 받아오는 메서드
    int getReviewCount(int product_no);
    
    // 상품번호에 해당하는 별점 받아오는 메서드
    double getReviewStar(int product_no);

    // 상품테이블의 정렬된 리스트를 받아오는 메서드
    List<ProductDTO> getProductList(Map<String, Object> map, String sort);
    
    // 상품테이블의 리스트를 받아오는 메서드
    List<ProductDTO> getProductList(PageDTO dto);
    
	// 태그가 포함된 상품테이블의 리스트를 받아오는 메서드
    List<ProductDTO> getProductTagList(Map<String, Object> map, String sort);

    // 상품의 상세정보를 받아오는 메서드
    ProductDTO getProductCont(int product_no);
    
  //상품 검색하는 메서드
    List<ProductDTO> searchProductList(Map<String, Object> map);
    
    // 검색된 상품의 수를 받아오는 메서드
    int getSearchListCount(String keyword);
    
    //상품 추가하는 메서드
    int insertProduct(ProductDTO dto);
    
    //상품의 판매상태를 변경하는 메서드
    int productStatusChange(int product_no);
    //상품의 판매상태를 변경하는 메서드
    int productStatusChange2(int product_no);

}
