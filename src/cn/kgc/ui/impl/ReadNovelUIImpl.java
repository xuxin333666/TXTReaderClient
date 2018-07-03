package cn.kgc.ui.impl;

import java.util.Scanner;

import cn.kgc.model.DataTransmission;
import cn.kgc.service.impl.ReadNovelServiceImpl;
import cn.kgc.service.intf.Service;
import cn.kgc.ui.intf.MainUI;
import cn.kgc.util.Prompt;

public class ReadNovelUIImpl implements MainUI,Prompt {
	Service service = new ReadNovelServiceImpl();
	Scanner input = new Scanner(System.in);

	@Override
	public DataTransmission start(DataTransmission data) {	
		return service.start(data);
	}

	@Override
	public DataTransmission after(DataTransmission data) {
		try {
			service.after(data);
			String content = (String)data.getResult();
			System.out.println(content);
			data = userChoose(data);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return data;
	}
	
	/**
	 * ”√ªß—°‘Ò
	 * @return √¸¡Ó
	 */
	private DataTransmission userChoose(DataTransmission data) {
		System.out.print(READ_ISCONTINUE);
		int num = input.nextInt();
		switch(num) {
		case RETURN_BY_USER:
			data.setStatus(REPEAT);
			break;
		case CONYINUE_READ:
			break;
		default:
			System.out.println(DIVIDER);
			System.out.println(CHOOSE_ERORR);
			data = userChoose(data);
			break;
		}
		return data;
	}

}
