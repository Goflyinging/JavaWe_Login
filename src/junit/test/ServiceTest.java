package junit.test;

import java.util.Date;

import org.junit.Test;

import cn.xing.domain.User;
import cn.xing.exception.UserExistException;
import cn.xing.service.impl.BusinessServiceImpl;

public class ServiceTest {
	
	@Test
	public void testRegister(){
		
		User user = new User();
		user.setBirthday(new Date());
		user.setEmail("bb@sina.com");
		user.setId("232533");
		user.setNickname("����");
		user.setPassword("123");
		user.setUsername("bbc");
		BusinessServiceImpl service = new BusinessServiceImpl();
		try {
			service.register(user);
			System.out.println("ע��ɹ�����");
		} catch (UserExistException e) {
			System.out.println("�û��Ѿ����ڣ���");
		}
		
	}
	
	@Test
	public void testLogin(){
		BusinessServiceImpl service = new BusinessServiceImpl();
		User user = service.login("bbc", "123");
		System.out.println(user);
	}

}
