package com.spring.model;

import java.util.Date;

import lombok.Data;

@Data
public class ProductDTO {
	private int product_no; // ��ǰ��ȣ
	private String product_name; // ��ǰ�̸�
	private String product_category; // ��ǰ ī�װ�
	private String product_company; // ��ǰ ������
	
	private int product_alcohol; // ����
	private String product_flavor; // �� .. �Ÿ�, �ܸ�
	private int product_soda; // ź�� .. ��(1),��(2),��(3)
	private String product_material; // ���� .. ��, �, ��ä, ����, ��Ÿ
	
	private int product_price; // ��ǰ �ǸŰ�
	private int product_stock; // ��ǰ ������
	private int product_point; // ��ǰ ����Ʈ
	private String product_thumbnail; // ��ǰ �����
	private String product_status; // ��ǰ ���� �⺻��:�Ǹ� .. ǰ��, ����
	private Date product_date; // ��ǰ �����
	
}
