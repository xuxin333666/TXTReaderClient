package cn.kgc.ui.intf;

import cn.kgc.model.DataTransmission;

public interface MainUI {
	/**
	 * ���˵�UI��ѡ������߼�
	 */
	DataTransmission start(String command);
	/**
	 * ���˵�UI��ѡ���÷��������ݺ���߼�
	 * @param data
	 * @return
	 */
	DataTransmission after(DataTransmission data);
}
