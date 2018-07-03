package cn.kgc.ui.impl;

import java.util.Scanner;

import cn.kgc.model.DataTransmission;
import cn.kgc.model.Novel;
import cn.kgc.service.impl.UploadServiceImpl;
import cn.kgc.service.intf.Service;
import cn.kgc.ui.intf.MainUI;
import cn.kgc.util.Prompt;

public class UploadUIImpl implements MainUI,Prompt{
	Service service = new UploadServiceImpl();
	Scanner input = new Scanner(System.in);

	@Override
	public DataTransmission start(String command) {
		DataTransmission data = new DataTransmission(command, getNovel());
		data = service.start(data);
		if(data.getStatus() == ERORR) {
			System.out.println(UPLOAD_ERORR_CLIENT);
			return isContinue(data);
		}
		return data;
	}

	@Override
	public DataTransmission after(DataTransmission data) {
		if(data.getStatus() == ERORR) {
			System.out.println(UPLOAD_ERORR_SERVER);
		} else {
			System.out.println(UPLOAD_SUCCESS);
		}
		return isContinue(data);
	}
	/**
	 * 获取用户输入的小说属性
	 * @return
	 */
	private Novel getNovel() {
		System.out.print(UPLOAD_NAME);
		String name = input.next();
		System.out.print(UPLOAD_AUTHOR);
		String author = input.next();
		System.out.print(UPLOAD_DESCRIPTION);
		String describe = input.next();
		System.out.print(UPLOAD_PATH);
		String fileName = input.next();
		System.out.println(DIVIDER);
		return new Novel(name, author, describe, fileName);
	}
	/**
	 * 询问用户是否继续
	 */
	private DataTransmission isContinue(DataTransmission data) {
		System.out.println(DIVIDER);
		System.out.print(UPLOAD_CONTINUE);
		int num = input.nextInt();
		switch(num) {
		case UPLOAD:
			data.setStatus(COMMAND_AGIN);
			break;
		case RETURN_BY_USER:
			data.setStatus(REPEAT);
			break;
		default:
			System.out.println(CHOOSE_ERORR);
			return isContinue(data);
		}
		return data;
	}

}
