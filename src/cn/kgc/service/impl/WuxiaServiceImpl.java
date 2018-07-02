package cn.kgc.service.impl;

import cn.kgc.model.DataTransmission;
import cn.kgc.service.intf.Service;
import cn.kgc.util.Prompt;

public class WuxiaServiceImpl implements Service,Prompt{
	 /**
	  * 构建武侠数据传输对象
	  */
	@Override
	public DataTransmission start(Object... o) {
		return new DataTransmission((String)o[0]);
	}
	 /**
	  * 获得数据后的相关逻辑
	  */
	@Override
	public DataTransmission after(DataTransmission data) throws Exception {
		if(data.getStatus() == -1) {
			throw new Exception(GET_NOVE_ERORR);
		}
		return null;
	}

}
