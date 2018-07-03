package cn.kgc.ui.impl;

import java.util.Scanner;

import org.junit.Test;

import cn.kgc.model.DataTransmission;
import cn.kgc.service.impl.BIOServiceImpl;
import cn.kgc.service.intf.IOService;
import cn.kgc.ui.intf.MainUI;
import cn.kgc.util.Prompt;
import cn.kgc.util.UIUtils;

public class Client implements Prompt{
	Scanner input = new Scanner(System.in);
	private int preMenu = MAIN_MENU;
	/**
	 * �ͻ�������
	 */
	@Test
	public void start() {
		DataTransmission data = Menu(preMenu);
		if(data.getStatus() == SECONDARY_MENU) {
			preMenu = SECOND_MENU;
		} else if(data.getStatus() == THIRD_RUN_MENU) {
			preMenu = THIRD_MENU;
		} else if(data.getStatus() == RETURN) {
			preMenu--;
		}
		start();
	}
	/**
	 * �˵�ִ�У����ػ������
	 * @return
	 */
	private DataTransmission Menu(int type) {
		showMenu(type);
		String command = userChoose(type);
		MainUI mainUI = UIUtils.Parse(command);
		return sendAndGetData(mainUI,command);
	}
	
	
	/**
	 * ���ͼ���������
	 * @param mainUI
	 * @param command
	 * @return
	 */
	private DataTransmission sendAndGetData(MainUI mainUI,String command) {
		DataTransmission data = mainUI.start(command);
		if(data.getStatus() != RETURN) {
			IOService iOService = new BIOServiceImpl();
			data = iOService.open(data);
			return mainUI.after(data);			
		}
		return data;
	}
	/**
	 * �˵�չʾ
	 */
	private void showMenu(int type) {
		if(type == MAIN_MENU) {
			System.out.println(TITLE);
		}
		System.out.println(DIVIDER);
		System.out.println(UIUtils.parseMenuList(type));
		System.out.println(DIVIDER);			
	}
	
	/**
	 * �û�ѡ��
	 * @return ����
	 */
	private String userChoose(int type) {
		System.out.print(USER_CHOOSE);
		try {
			return UIUtils.getCommandByNum(input.next(),type);
		} catch (Exception e) {
			System.out.print(CHOOSE_ERORR);
			return userChoose(type);
		}
	}
}
