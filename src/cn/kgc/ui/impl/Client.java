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
	private DataTransmission preData = new DataTransmission();
	/**
	 * 客户端启动
	 */
	@Test
	public void start() {
		preData = Menu(preMenu,true);
		if(preData.getStatus() == SECONDARY_MENU) {
			preMenu = SECOND_MENU;
		} else if(preData.getStatus() == THIRD_RUN_MENU) {
			preMenu = THIRD_MENU;
		} else if(preData.getStatus() == RETURN) {
			preMenu--;
		} else if(preData.getStatus() == COMMAND_AGIN) {
			while(preData.getStatus() == COMMAND_AGIN) {
				preData = Menu(preMenu,false,preData);			
			}
		}
		start();
	}
	/**
	 * 菜单执行，返回获得数据
	 * @return
	 */
	private DataTransmission Menu(int type,boolean flag,DataTransmission...data) {
		String command = null;
		if(flag) {
			showMenu(type);
			command = userChoose(type);			
		} else {
			command = data[0].getCommand();
		}
		MainUI mainUI = UIUtils.Parse(command);
		return sendAndGetData(mainUI,command);
	}
	
	
	/**
	 * 发送及接收数据
	 * @param mainUI
	 * @param command
	 * @return
	 */
	private DataTransmission sendAndGetData(MainUI mainUI,String command) {
		preData.setCommand(command);
		preData = mainUI.start(preData);
		if(preData.getStatus() != RETURN && preData.getStatus() != REPEAT) {
			IOService iOService = new BIOServiceImpl();
			preData = iOService.open(preData);
			preData =  mainUI.after(preData);	
		}
		return preData;
	}
	/**
	 * 菜单展示
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
	 * 用户选择
	 * @return 命令
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
