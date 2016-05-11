package cn.xing.web.fornbean;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.beanutils.locale.converters.DateLocaleConverter;

public class RegisterForm {

	private String username;
	private String password;
	private String password2;
	private String email;
	private String birthday;
	private String nickname;
	private Map errors = new HashMap();

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPassword2() {
		return password2;
	}

	public void setPassword2(String password2) {
		this.password2 = password2;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public Map getErrors() {
		return errors;
	}

	public void setErrors(Map errors) {
		this.errors = errors;
	}

	// �û�������Ϊ�գ�������Ҫ3-8Ϊ��ĸ
	// ���벻��Ϊ�գ�������3-8λ����
	// ȷ�����벻��Ϊ�գ�����Ҫ��һ��һ��
	// ���䲻��Ϊ�գ�����Ҫһ����ʽ�Ϸ���
	// ���տ���Ϊ�գ���Ϊ��ʱ��������һ������
	// �ǳƲ�����Ϊ�գ�
	public boolean validate() {
		boolean isOk = true;
		if (username == null || username.trim().equals("")) {
			isOk = false;
			errors.put("username", "�û�������Ϊ��");
		} else {
			if (!username.matches("[A-Za-z]{3,8}")) {
				isOk = false;
				errors.put("username", "�û���3-8λ��ĸ");
			}
		}
		if (password == null || password.trim().equals("")) {
			isOk = false;
			errors.put("password", "���벻��Ϊ��");
		} else {
			if (!password.matches("\\d{3,8}")) {
				isOk = false;
				errors.put("password", "����3-8λ����");
			}
		}
		if (password2 == null || password2.trim().equals("")) {
			isOk = false;
			errors.put("password2", "ȷ�����벻��Ϊ��");
		} else {
			if (!password.equals(password2)) {
				isOk = false;
				errors.put("password2", "�����������벻һ��");
			}
		}
		if (email == null || email.trim().equals("")) {
			isOk = false;
			errors.put("email", "���䲻��Ϊ��");
		} else {// aa@sina.com aa@sina.com.cn
			if (!email.matches("\\w+@\\w+(\\.\\w+)+")) {
				isOk = false;
				errors.put("email", "�����ʽ���Ϸ�");
			}
		}
		if (birthday != null && !birthday.trim().equals("")) {
			DateLocaleConverter dlc = new DateLocaleConverter(); //У�����ڸ�ʽ�Ƿ�Ϸ�
			try {
				dlc.convert(birthday, "yyyy-MM-dd");
			} catch (Exception e) {
				isOk = false;
				errors.put("birthday", "���ڸ�ʽ����");
			}
			// SimpleDateFormat df=new SimpleDateFormat("yyyy-MM-dd");
		}
		if (nickname == null || nickname.trim().equals("")) {
			isOk = false;
			errors.put("nickname", "�ǳƲ���Ϊ��");
		} else {// �������� \u4e00-\u9fa5
			if (!nickname.matches("[\u4e00-\u9fa5]+")) {
				//^([\u4e00-\u9fa5]+)$
				isOk = false;
				errors.put("nickname", "�ǳƱ���Ϊ����");
			}
		}

		return isOk;
	}

	

}
