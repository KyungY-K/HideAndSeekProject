package com.spring.model;

import java.util.Date;

import lombok.Data;

@Data
public class DipsDTO {
	private int dibs_no; // �� ��ȣ
	private Date dibs_date; // �� ��¥
	private String user_id;  // ���� ���̵� FK
	private int product_no; // ��ǰ ��ȣ FK
}
