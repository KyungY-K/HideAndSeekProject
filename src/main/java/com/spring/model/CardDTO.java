package com.spring.model;

import lombok.Data;

@Data
public class CardDTO {
	private int card_num; // ī�� ������ȣ
	private int card_no1; // ī�� ��ȣ1
	private int card_no2; // ī�� ��ȣ2
	private int card_no3; // ī�� ��ȣ3
	private int card_no4; // ī�� ��ȣ4
	private int card_cvc; // CVC ��ȣ // DB��ȣȭ
	private int card_pwd; // ī�� ��й�ȣ // DB��ȣȭ

	private String user_id; // ���� ���̵� FK
}
