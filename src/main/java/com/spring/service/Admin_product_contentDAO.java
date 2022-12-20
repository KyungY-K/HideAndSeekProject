package com.spring.service;

import java.util.List;

import com.spring.model.Product_contentDTO;
import com.spring.model.admin_product_contentDTO;

public interface Admin_product_contentDAO {
	List<Product_contentDTO> getProductContList();
	
	admin_product_contentDTO getProductOne(int product_no);
	
	
	int insertProductContent(int product_no);
	
	int deleteProductCont(int product_no);
	
	void productContUpdateSeq(int product_no);
	
	
	
	//ù��° ���ϸ� ������ ��
	int UpdatePCFile1(admin_product_contentDTO dto);
	
	//�ι�° ���ϸ� ������ ��
	int UpdatePCFile2(admin_product_contentDTO dto);

	//����° ���ϸ� ������ ��
	int UpdatePCFile3(admin_product_contentDTO dto);
	
	//ù��°�� �ȵ����� ��
	int updateWithoutFile1(admin_product_contentDTO dto);

	//�ι�°�� �ȵ����� ��
	int updateWithoutFile2(admin_product_contentDTO dto);

	//����°�� �ȵ����� ��
	int updateWithoutFile3(admin_product_contentDTO dto);
	
	//�� ������ ��
	int productContentUpdate(admin_product_contentDTO dto);
	
	//������ �ϳ��� �������� �ʾ��� ��
	int updateWithoutFile(admin_product_contentDTO dto);
	


}
