package com.spring.service;

import java.util.List;
import java.util.Map;

import com.spring.model.PageDTO;
import com.spring.model.ProductDTO;
import com.spring.model.admin_productDTO;

public interface Admin_productDAO {
	
	// DB ���� ��ü ��ǰ ���� �޾ƿ��� �޼���
    int getListCount();
    
    // �±װ� ���Ե� DB ���� ��ǰ ���� �޾ƿ��� �޼���
    int getListTagCount(Map<String, Object> map);

    // ��ǰ���̺��� ���ĵ� ����Ʈ�� �޾ƿ��� �޼���
    List<ProductDTO> getProductList(PageDTO dto, String sort);
    
    // ��ǰ���̺��� ����Ʈ�� �޾ƿ��� �޼���
    List<admin_productDTO> getProductList(PageDTO dto);
    
	// �±װ� ���Ե� ��ǰ���̺��� ����Ʈ�� �޾ƿ��� �޼���
    List<ProductDTO> getProductTagList(Map<String, Object> map, String sort);

    // ��ǰ�� �������� �޾ƿ��� �޼���
    admin_productDTO getProductCont(int product_no);
    
  //��ǰ �˻��ϴ� �޼���
    List<admin_productDTO> searchProductList(Map<String, Object> map);
    
    // �˻��� ��ǰ�� ���� �޾ƿ��� �޼���
    int getSearchListCount(String keyword);
    
    //��ǰ �߰��ϴ� �޼���
    int insertProduct(admin_productDTO adto);
    
    //��ǰ�� �ǸŻ��¸� �����ϴ� �޼���
    int productStatusChange(int product_no);
    //��ǰ�� �ǸŻ��¸� �����ϴ� �޼���
    int productStatusChange2(int product_no);
    
    //��ǰ�� �����ϴ� �޼���
    int productUpdate(ProductDTO dto);


}
