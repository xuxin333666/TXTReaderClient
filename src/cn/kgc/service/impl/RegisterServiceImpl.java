package cn.kgc.service.impl;


import cn.kgc.model.DataTransmission;
import cn.kgc.service.intf.Service;
import cn.kgc.util.Prompt;

public class RegisterServiceImpl implements Service,Prompt {
	/**
	 * ʵ����data����
	 */
	@Override
	public DataTransmission start(Object...o) {
		return new DataTransmission((String)o[2],new String[]{(String)o[USERNAME_INDEX],(String)o[PASSWORD_INDEX]}); 
	}
	/**
	 * �ж��Ƿ��Ѿ����ڸ��û��ˡ�
	 */
	@Override
	public DataTransmission after(DataTransmission data) throws Exception {
		if(data.getStatus() == ERORR) {
			throw new Exception((String)data.getResult());
		}
		return data;
	}
}
