package cn.kgc.service.impl;

import cn.kgc.model.DataTransmission;
import cn.kgc.service.intf.Service;
import cn.kgc.util.Prompt;

public class ReadNovelServiceImpl implements Service,Prompt {

	@Override
	public DataTransmission start(Object... o) {
		DataTransmission data = (DataTransmission)o[0];	
		data.setStatus(SUCCUSS);
		return data;
	}

	@Override
	public DataTransmission after(DataTransmission data) throws Exception {
		if(data.getStatus() == ERORR) {
			throw new Exception(READ_ERORR);
		}
		data.setStatus(COMMAND_AGIN);
		return data;
	}

}
