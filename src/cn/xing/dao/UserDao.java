package cn.xing.dao;

import cn.xing.domain.User;

public interface UserDao {

	// �����ݿ����������
	void add(User user);

	// ��¼ʱ�û��ж�
	User find(String username, String password);

	// ����ע����û��Ƿ������ݿ��д���
	boolean find(String username);

}