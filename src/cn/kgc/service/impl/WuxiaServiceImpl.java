package cn.kgc.service.impl;

import cn.kgc.model.DataTransmission;
import cn.kgc.service.intf.Service;
import cn.kgc.util.Prompt;

public class WuxiaServiceImpl implements Service,Prompt{
	 /**
	  * �����������ݴ������
	  */
	@Override
	public DataTransmission start(Object... o) {
		return new DataTransmission((String)o[0]);
	}
	 /**
	  * ������ݺ������߼�
	  */
	@Override
	public DataTransmission after(DataTransmission data) throws Exception {
		if(data.getStatus() == -1) {
			throw new Exception(GET_NOVE_ERORR);
		}
		return null;
	}

}