package com.spring.model;

import lombok.Data;

@Data
public class DeliveryDTO {
	private String deli_zipcode; // ���� ��ȣ
	private String deli_addr1; // �⺻ �ּ�
	private String deli_addr2; // �� �ּ�
	private String user_id; // ���� ���̵� FK
}
