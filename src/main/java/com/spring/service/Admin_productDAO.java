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
    int productUpdate(admin_productDTO adto);

	int insertGoods(admin_productDTO adto);
	
	//��ǰ�� �����ϴ� �޼���
	int deleteProduct(int product_no);
	
	//������ ��ȣ������
	void productUpdateSeq(int product_no);
	
	//�Ǹ� ���� ��ǰ ����Ʈ ��ȸ
	List<admin_productDTO> stopProductList(PageDTO dto);
	
	//�Ǹ� ���� ��ǰ ���� ��ȸ
	int getStopProductCount();
	
	//�Ǹ����� ��ǰ ����Ʈ ��ȸ
	List<admin_productDTO> IngProductList(PageDTO dto);
	
	//�Ǹ����� ��ǰ ���� ��ȸ
	int getIngProductCount();
	
	//�Ǹ����� ��ǰ �˻� ��� ����
	int getSearchIngProductCount(String keyword);
	
	//�Ǹ����� ��ǰ �˻��ϴ� �޼���
    List<admin_productDTO> searchIngProductList(Map<String, Object> map);
    
    //����� �������� ���� ��ǰ����
    int productUpdateWithoutThumbnail(admin_productDTO adto);
    
    //ī�װ� �� ��ǰ ��ü ���
    List<admin_productDTO> getProductCateSortTakjuList();
    List<admin_productDTO> getProductCateSortChungjuList();
    List<admin_productDTO> getProductCateSortWineList();
    List<admin_productDTO> getProductCateSortSojuList();
    
    //ī�װ��� ��ǰ ���
    List<ProductDTO> getCateProductList(String category);
	

}
