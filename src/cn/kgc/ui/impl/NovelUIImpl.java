package cn.kgc.ui.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import cn.kgc.model.DataTransmission;
import cn.kgc.model.Novel;
import cn.kgc.service.impl.NovelServiceImpl;
import cn.kgc.service.intf.Service;
import cn.kgc.ui.intf.MainUI;
import cn.kgc.util.Prompt;

public class NovelUIImpl implements MainUI,Prompt{
	private List<Novel> novelList = new ArrayList<>();	//С˵�б�
	 Service service = new NovelServiceImpl();
		Scanner input = new Scanner(System.in);
	 /**
	  * �����������ݴ������
	  */
	@Override
	public DataTransmission start(String command) {		
		return service.start(command);
	}
	 /**
	  * ������ݺ������߼�
	  */
	@Override
	public DataTransmission after(DataTransmission data) {
		try {
			showNovelList(data);
			data = userChoose(data);
		} catch (Exception e) {
			System.out.println(GET_NOVE_ERORR);
		}
		return data;
	}
	
	/**
	 * չʾС˵�б�
	 * @param data
	 */
	@SuppressWarnings("unchecked")
	private void showNovelList(DataTransmission data) {
		System.out.println(NOVE_LIST_PRINT);
		novelList = (List<Novel>) data.getObject();
		int count = 0;
		for (Object novel : novelList) {
			System.out.println(++count + ".\t" + novel);
		}
	}
	
	/**
	 * �û�ѡ��
	 * @return ����
	 */
	private DataTransmission userChoose(DataTransmission data) {
		System.out.print(USER_CHOOSE_NOVEL);
		int num = input.nextInt();
		data.setResult(num);
		try {			
			return service.after(data);		
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return userChoose(data);
		}
	}
}
