package com.spring.model;

import java.util.Date;

import lombok.Data;

@Data
public class Subscribe_userDTO {
	private int sub_no; // ���� ��ȣ
	private Date sub_start; // ���� ������
	private Date sub_end; // ���� ������
	private String sub_status; // ���� ���� �⺻��:���� .. �޽�,����,����
	private String user_id; // ���� ���̵� FK
}