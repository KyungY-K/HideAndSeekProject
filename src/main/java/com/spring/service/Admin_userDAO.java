package com.spring.service;

import java.util.List;
import java.util.Map;

import com.spring.model.PageDTO;
import com.spring.model.UserDTO;

public interface Admin_userDAO {
	
	//��ü ���� ���� �޾ƿ��� �޼���
	int getUserCount();
	
	//��ü ���� ����Ʈ�� �ҷ����� �޼���
	List<UserDTO> getUserList(PageDTO dto);
	
	
	//���� ������ �ҷ����� �޼���
	UserDTO getUserCont(int user_no);
	
	
	//�˻��� ������ ���� �޾ƿ��� �޼���
	int getSearchUserCount(String keyword);
	
	//���� �˻��ϴ� �޼���
	List<UserDTO> searchUserList(Map<String, Object> map);
	
	
	//���� �߰��ϴ� �޼���
	int insertUser(UserDTO dto);
	
	//���� �����ϴ� �޼���
	int updateUser(UserDTO dto);
	
	//���� �����ϴ� �޼���
	int deleteUser(int user_no);
	
	//���� ���� �� ��ȣ������
	void userUpdateSeq(int user_no);

	//���� ���� ���� �ϴ� �޼���(ȸ�� -> Ż��)
	int updateUserStatus(int user_no);
	
	//Ż�� ȸ�� ���� ���� ȸ���� ���� �޼���
	int getIngUserCount();
	
	//Ż�� ȸ�� ���� ���� ȸ�� ����Ʈ
	List<UserDTO> getIngUserList(PageDTO dto);
	
	//Ż�� ȸ�� �� ���� �޼���
	int getDelUserCount();
	
	//Ż�� ȸ�� ����Ʈ
	List<UserDTO> getDelUserList(PageDTO dto);
	
	
}
