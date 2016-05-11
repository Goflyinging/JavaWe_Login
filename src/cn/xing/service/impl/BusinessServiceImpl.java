package cn.xing.service.impl;

import cn.xing.dao.UserDao;
import cn.xing.dao.impl.UserDaoImpl;
import cn.xing.domain.User;
import cn.xing.exception.UserExistException;
import cn.xing.utils.ServiceUtils;

//��web���ṩ���е�ҵ�����
public class BusinessServiceImpl {

	private UserDao dao = new UserDaoImpl();  //����ģʽ  spring
	//��web���ṩע�����
	public void register(User user) throws UserExistException {
		//�жϵ�ǰҪע����û�ʦ������
		boolean b=dao.find(user.getUsername());
		if(b){
			throw new UserExistException("�û��Ѿ�����!");
			//�û����ڣ���web���׳�����ʱ�쳣
		}else{
			user.setPassword(ServiceUtils.md5(user.getPassword()));
			dao.add(user);
		}
 
		
	}
	//��web���ṩ��½����
	public User login(String username,String password){
		 password = ServiceUtils.md5(password);
		 return dao.find(username, password);
	}
}
