package com.spring.model;

import org.springframework.web.multipart.MultipartFile;

import lombok.Data;

@Data
public class admin_product_contentDTO {
	
	private int product_no; // ��ǰ ��ȣ FK
	private MultipartFile product_file1; // ��ǰ ����
	private MultipartFile product_file2;
	private MultipartFile product_file3;
	private MultipartFile product_file4;
	private MultipartFile product_file5;
	private String product_cont1; // ��ǰ ����
	private String product_cont2;
	private String product_cont3;
	private String product_cont4;
	private String product_cont5;
}
