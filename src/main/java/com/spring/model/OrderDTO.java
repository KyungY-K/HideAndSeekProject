package com.spring.model;

import java.util.Date;

import lombok.Data;

@Data
public class OrderDTO {
	private int order_no; // �ֹ� ��ȣ
	private String order_status; //�ֹ����� �⺻��:�ֹ��Ϸ�
	private Date order_date; // �ֹ� ��¥
	private String user_id; // ���� ���̵� FK
	private int product_no; // ��ǰ ��ȣ FK
}
