package cn.kgc.service.intf;

import cn.kgc.model.DataTransmission;

public interface Service {
	/**
	 * �����������߼�
	 */
	DataTransmission start(Object...o);

	
	/**
	 * ������������ȡ���ݺ���߼�
	 * @param data
	 * @return
	 */
	DataTransmission after(DataTransmission data) throws Exception;
}
