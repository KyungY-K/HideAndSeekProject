package com.spring.model;

import java.util.Date;

import lombok.Data;

@Data
public class SubscribeDTO {
	private int sub_no; // ���� ��ȣ
	private String sub_package; // ���� ��Ű����
	private Date sub_date; // �Ǹ� �Ⱓ
	private int product_no; // ��ǰ ��ȣ

}
