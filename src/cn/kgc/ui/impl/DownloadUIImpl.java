package cn.kgc.ui.impl;

import java.util.Scanner;


import cn.kgc.model.DataTransmission;
import cn.kgc.service.impl.DownloadServiceImpl;
import cn.kgc.service.intf.Service;
import cn.kgc.ui.intf.MainUI;
import cn.kgc.util.Prompt;

public class DownloadUIImpl implements MainUI,Prompt {
	Scanner input = new Scanner(System.in);
	Service service = new DownloadServiceImpl();
	@Override
	public DataTransmission start(DataTransmission data) {
		data.setStatus(SUCCUSS);
		System.out.print(DOWNLOAD_ASK_PASH);
		String downloadPath = input.next();
		return service.start(data,downloadPath);
	}

	@Override
	public DataTransmission after(DataTransmission data) {
		try {
			service.after(data);
			System.out.println(DIVIDER);
			System.out.println(DOWNLOAD_SUCCUSS);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return data;
	}


}
