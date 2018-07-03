package cn.kgc.ui.impl;

import java.util.Scanner;

import cn.kgc.model.DataTransmission;
import cn.kgc.service.impl.LoginServiceImpl;
import cn.kgc.service.intf.Service;
import cn.kgc.ui.intf.MainUI;
import cn.kgc.util.Prompt;

public class LoginMainUIImpl implements MainUI,Prompt {
	Scanner input = new Scanner(System.in);
	Service service = new LoginServiceImpl();
	private String username;	//��ǰ���û���
	private String password;	//��ǰ���û�����
	
	/**
	 * ��½�߼�
	 */
	@Override
	public DataTransmission start(DataTransmission data) {
		String command = data.getCommand();
		System.out.print(LOGIN_USERNAME_PROMPT);
		username = input.next();
		System.out.print(LOGIN_PASSWORD_PROMPT);
		password = input.next();
		return service.start(username,password,command);
		
	}
	/**
	 * ������ݺ���߼�
	 */
	@Override
	public DataTransmission after(DataTransmission data) {
		try {
			data = service.after(data);
			System.out.println(LOGIN_SUCCUSS);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return data;
	}
	
}
