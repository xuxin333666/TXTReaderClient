package cn.kgc.service.intf;

import cn.kgc.model.DataTransmission;
import cn.kgc.model.Novel;

public interface Service {
	/**
	 * 各功能启动逻辑
	 */
	DataTransmission start(Object...o);

	
	/**
	 * 各功能启动获取数据后的逻辑
	 * @param data
	 * @return
	 */
	DataTransmission after(DataTransmission data) throws Exception;
}
