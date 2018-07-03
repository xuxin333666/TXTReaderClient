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
	private String username;	//当前注册的用户名
	private String password;	//当前注册的用户密码
	
	
	/**
	 * 注册用户，调用注册业务层
	 */
	@Override
	public DataTransmission start(DataTransmission data) {
		String command = data.getCommand();
		getUsername();
		getPassword();	
		return service.start(username,password,command);
	}
	
	/**
	 * 获取用户名
	 */
	private void getUsername() {
		System.out.print(REGISTER_USERNAME_PROMPT);
		username = input.next();
	}
	/**
	 * 获取密码
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
	 * 获取数据后。转入业务层处理
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
