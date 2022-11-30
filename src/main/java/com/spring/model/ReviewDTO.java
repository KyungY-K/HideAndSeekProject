package com.spring.model;

import java.util.Date;

import lombok.Data;

@Data
public class ReviewDTO {
	private int review_no; // ���� ��ȣ
	private String review_title; // ���� ����
	private String review_cont; // ���� ����
	private String review_file; // ���� ����
	private int review_star; // ���� ���� // 1~5����
	private Date review_date; // ���� ��¥
	
	private String user_id; // ���� ���̵� FK
	private int product_no; // ��ǰ ��ȣ

}
