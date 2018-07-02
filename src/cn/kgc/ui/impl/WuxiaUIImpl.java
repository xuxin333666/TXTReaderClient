package cn.kgc.ui.impl;

import java.util.List;
import java.util.Scanner;

import cn.kgc.model.DataTransmission;
import cn.kgc.service.impl.WuxiaServiceImpl;
import cn.kgc.service.intf.Service;
import cn.kgc.ui.intf.MainUI;
import cn.kgc.util.Prompt;

public class WuxiaUIImpl implements MainUI,Prompt{
	 Service service = new WuxiaServiceImpl();
		Scanner input = new Scanner(System.in);
	 /**
	  * 构建武侠数据传输对象
	  */
	@Override
	public DataTransmission start(String command) {		
		return service.start(command);
	}
	 /**
	  * 获得数据后的相关逻辑
	  */
	@Override
	public DataTransmission after(DataTransmission data) {
		try {
			service.after(data);
			showNovelList(data);
			userChoose();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return data;
	}
	
	/**
	 * 展示小说列表
	 * @param data
	 */
	private void showNovelList(DataTransmission data) {
		System.out.println(NOVE_LIST_PRINT);
		List<?> novelList = (List<?>) data.getObject();
		int count = 0;
		for (Object novel : novelList) {
			System.out.println(++count + ".\t" + novel);
		}
	}
	
	/**
	 * 用户选择
	 * @return 命令
	 */
	private String userChoose() {
//		System.out.print(USER_CHOOSE);
//		try {
//			return UIUtils.getCommandByNum(input.next(),SECOND_MENU);
//		} catch (Exception e) {
//			System.out.print(CHOOSE_ERORR);
//			return userChoose();
//		}
		return null;
	}

}
