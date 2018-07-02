package cn.kgc.service.impl;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

import cn.kgc.model.DataTransmission;
import cn.kgc.service.intf.IOService;
import cn.kgc.util.NetConfigUtils;

public class BIOServiceImpl implements IOService {
	private Socket socket;	//���߳����е�socket
	private ObjectInputStream ois;	//����������
	private ObjectOutputStream oos;	//���������
	
	/**
	 * ��ʼ��BIO�׽��֣����������
	 */
	public BIOServiceImpl() {
		try {
			socket = new Socket(NetConfigUtils.IP,NetConfigUtils.port);
			oos = new ObjectOutputStream(socket.getOutputStream());
			ois = new ObjectInputStream(socket.getInputStream());	
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	/**
	 * �����ݴ����������
	 */
	@Override
	public DataTransmission open(DataTransmission data) {
		try {
			oos.writeObject(data);
			data = (DataTransmission)ois.readObject();			
			socket.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return data;
	}	
}
