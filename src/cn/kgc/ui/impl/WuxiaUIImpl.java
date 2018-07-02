package cn.kgc.ui.impl;

import cn.kgc.model.DataTransmission;
import cn.kgc.service.impl.WuxiaServiceImpl;
import cn.kgc.service.intf.Service;
import cn.kgc.ui.intf.MainUI;

public class WuxiaUIImpl implements MainUI{
	 Service service = new WuxiaServiceImpl();
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
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return data;
	}

}
