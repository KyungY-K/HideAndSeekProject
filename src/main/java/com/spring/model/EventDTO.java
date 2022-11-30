package com.spring.model;

import java.util.Date;

import lombok.Data;


@Data
public class EventDTO {
	
	private int event_no; // �̺�Ʈ ��ȣ
	private String event_thumbnail; // �����
	private String event_file1; // �̺�Ʈ ����1
	private String event_file2;
	private String event_file3;

	private String event_cont1;// �̺�Ʈ ����1
	private String event_cont2;
	private String event_cont3;
	
	private Date event_date; // �̺�Ʈ �����
	private Date event_start; // �̺�Ʈ ������
	private Date event_end; // �̺�Ʈ ������
	
	private String event_status; // �̺�Ʈ ����

}
