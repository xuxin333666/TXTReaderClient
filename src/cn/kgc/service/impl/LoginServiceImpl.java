package cn.kgc.service.impl;

import cn.kgc.model.DataTransmission;
import cn.kgc.service.intf.Service;
import cn.kgc.util.Prompt;

public class LoginServiceImpl implements Service,Prompt {
	
	
	/**
	 * ������½���ܣ���װDataTransmission
	 */
	@Override
	public DataTransmission start(Object...o) {
		return new DataTransmission((String)o[COMMAND_INDEX], new String[]{(String)o[USERNAME_INDEX],(String)o[PASSWORD_INDEX]});
	}
	/**
	 * �ж��û����Ƿ���ڻ������Ƿ���ȷ
	 */
	@Override
	public DataTransmission after(DataTransmission data) throws Exception {
		if(data.getStatus() == ERORR) {
			throw new Exception((String)data.getResult());
		}
		return data;
	}	
}
