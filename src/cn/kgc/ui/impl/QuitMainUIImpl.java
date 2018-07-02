package cn.kgc.ui.impl;


import cn.kgc.model.DataTransmission;
import cn.kgc.ui.intf.MainUI;
import cn.kgc.util.Prompt;

public class QuitMainUIImpl implements MainUI,Prompt{

	@Override
	public DataTransmission start(String command) {
		System.out.println(SYSTEM_QUIT);
		System.exit(1);
		return null;
	}
	/**
	 * 退出成功后，无后续逻辑
	 */
	@Override
	public DataTransmission after(DataTransmission data) {
		return null;
	}

}
