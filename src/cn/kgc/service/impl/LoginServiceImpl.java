package cn.kgc.service.impl;

import cn.kgc.model.DataTransmission;
import cn.kgc.service.intf.Service;
import cn.kgc.util.Prompt;

public class LoginServiceImpl implements Service,Prompt {
	
	
	/**
	 * 启动登陆功能，组装DataTransmission
	 */
	@Override
	public DataTransmission start(Object...o) {
		return new DataTransmission((String)o[COMMAND_INDEX], new String[]{(String)o[USERNAME_INDEX],(String)o[PASSWORD_INDEX]});
	}
	/**
	 * 判断用户名是否存在或密码是否正确
	 */
	@Override
	public DataTransmission after(DataTransmission data) throws Exception {
		if(data.getStatus() == ERORR) {
			throw new Exception((String)data.getResult());
		}
		return data;
	}	
}
