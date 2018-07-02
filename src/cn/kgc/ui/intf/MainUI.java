package cn.kgc.ui.intf;

import cn.kgc.model.DataTransmission;

public interface MainUI {
	/**
	 * 主菜单UI各选项界面逻辑
	 */
	DataTransmission start(String command);
	/**
	 * 主菜单UI各选项获得服务器数据后的逻辑
	 * @param data
	 * @return
	 */
	DataTransmission after(DataTransmission data);
}
