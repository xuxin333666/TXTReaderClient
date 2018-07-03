package cn.kgc.ui.impl;

import java.util.Scanner;

import cn.kgc.model.DataTransmission;
import cn.kgc.service.impl.RegisterServiceImpl;
import cn.kgc.service.intf.Service;
import cn.kgc.ui.intf.MainUI;
import cn.kgc.util.Prompt;

public class RegisterMainUIImpl implements MainUI,Prompt {
	Scanner input = new Scanner(System.in);
	Service service = new RegisterServiceImpl();
	private String username;	//��ǰע����û���
	private String password;	//��ǰע����û�����
	
	
	/**
	 * ע���û�������ע��ҵ���
	 */
	@Override
	public DataTransmission start(DataTransmission data) {
		String command = data.getCommand();
		getUsername();
		getPassword();	
		return service.start(username,password,command);
	}
	
	/**
	 * ��ȡ�û���
	 */
	private void getUsername() {
		System.out.print(REGISTER_USERNAME_PROMPT);
		username = input.next();
	}
	/**
	 * ��ȡ����
	 */
	private void getPassword() {
		System.out.print(REGISTER_PASSWORD_PROMPT);
		password = input.next();
		System.out.print(REGISTER_PASSWORD2_PROMPT);
		String newPassword = input.next();
		if(!newPassword.equals(password)) {
			System.out.println(REGISTER_PASSWORD2_ERORR);
			getPassword();
		}
	}
	/**
	 * ��ȡ���ݺ�ת��ҵ��㴦��
	 * @throws Exception 
	 */
	@Override
	public DataTransmission after(DataTransmission data) {
		try {
			data = service.after(data);
			System.out.println(REGISTER_SUCCUSS);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return data;
	}

}
