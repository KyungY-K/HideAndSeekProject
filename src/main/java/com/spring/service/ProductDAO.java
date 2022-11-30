package com.spring.service;

import java.util.List;
import com.spring.model.ProductDTO;

public interface ProductDAO {
	// DB ���� ��ü ��ǰ ���� �޾ƿ��� �޼���
    int getListCount();

    // ��ǰ���̺��� ����Ʈ�� �޾ƿ��� �޼���
    List<ProductDTO> getProductList();

    // ��ǰ�� �������� �޾ƿ��� �޼���
    ProductDTO getProductCont(int product_no);

}
