package com.spring.model;

import java.util.Date;

import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@JsonFormat(pattern = "yyyy-MM-dd")
@Data
public class admin_productDTO {
	
	private int product_no; // ��ǰ ��ȣ
	private String product_name; // ��ǰ �̸�
	private String product_category; // ��ǰ ī�װ�
	private String product_introduce1;	// ��ǰ ����1
	private String product_introduce2;	// ��ǰ ����2
	private String product_company; // ��ǰ ������
	
	private int product_alcohol; // ����
	private String product_dosu; // �±װ˻� ����
	
	private String product_sweet; // �ܸ�
	private String product_acidity; // �Ÿ�
	
	private String product_soda; // ź��
	private String product_material; // ���� .. ��, �, ��ä, ����, ��Ÿ
	
	private int product_price; // ��ǰ �ǸŰ�
	private int product_stock; // ��ǰ ������
	private int product_point; // ��ǰ ����Ʈ
	private MultipartFile product_thumbnail; // ��ǰ �����
	private String product_status; // ��ǰ ���� �⺻��:�Ǹ� .. ǰ��, ����
	

	private Date product_date; // ��ǰ �����

}
