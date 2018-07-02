package cn.kgc.ui.impl;

import cn.kgc.model.DataTransmission;
import cn.kgc.ui.intf.MainUI;
import cn.kgc.util.Prompt;

public class ReturnMainUIImpl implements MainUI,Prompt{

	@Override
	public DataTransmission start(String command) {
		System.out.println(RETURN_MAIN_MENU);
		System.out.println(DIVIDER);
		return null;
	}

	@Override
	public DataTransmission after(DataTransmission data) {
		return null;
	}

}
