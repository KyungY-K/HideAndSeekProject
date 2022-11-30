package com.spring.model;

import java.util.Date;

import lombok.Data;

@Data
public class UserDTO {
	private String user_id;
	private String user_pwd;
	private String user_email;
	private String user_name;
	private int user_jumin; //�ֹε�Ϲ�ȣ ���ڸ�
	private int user_zipcode; //�����ȣ
	private String user_addr;
	private String user_phone;
	private int user_point;
	private Date user_date; //ȸ��������
	private int user_leave; //ȸ��Ż�𿩺� �⺻��:1 Ż���:2
}
