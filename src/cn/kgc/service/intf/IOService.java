package cn.kgc.service.intf;

import cn.kgc.model.DataTransmission;

public interface IOService {
	/**
	 * IO����
	 */
	DataTransmission open(DataTransmission data);
}
