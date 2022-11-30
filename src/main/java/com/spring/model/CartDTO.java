package com.spring.model;

import java.util.Date;

import lombok.Data;

@Data
public class CartDTO {
	
	private int cart_no; // ��ٱ��� ��ȣ
	private int cart_amount; // ��ٱ��� ����
	private int cart_price; // ��ٱ��� ����
	private Date cart_date; // ��ٱ��� ��¥
	private String user_id; // �������̵� FK
	private int product_no; // ��ǰ ��ȣ FK

}
