package cn.kgc.util;


import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;
import java.util.Set;


import cn.kgc.ui.intf.MainUI;

public class UIUtils implements Prompt {
	private static Map<String, String> MainList = new HashMap<>();	//���˵������б�
	private static Map<String, String> commandMap = new HashMap<>();	//Э����������
	private static Map<String, String> secondList = new HashMap<>();	//�����˵������б�
	private static Map<String, String> secondCommandMap = new HashMap<>();	//Э����������
	/**
	 * ��ʼ�����湤���࣬��ȡ�˵��б�,Э�������б�
	 */
	static {
		Properties p1 = new Properties();
		Properties p2 = new Properties();
		Properties p3 = new Properties();
		Properties p4 = new Properties();
		try {
			Reader fr = new FileReader("config/mainMenu.properties");
			p1.load(fr);
			Set<Object> keySet = p1.keySet();
			Iterator<Object> iterator = keySet.iterator();
			while(iterator.hasNext()) {
				String key = (String)iterator.next();
				MainList.put(key, p1.getProperty(key));
			}
			fr = new FileReader("config/service.properties");
			p2.load(fr);
			keySet = p2.keySet();
			iterator = keySet.iterator();
			while(iterator.hasNext()) {
				String command = (String)iterator.next();
				commandMap.put(command, p2.getProperty(command));
			}
			fr = new FileReader("config/secondMenu.properties");
			p3.load(fr);
			keySet = p3.keySet();
			iterator = keySet.iterator();
			while(iterator.hasNext()) {
				String key = (String)iterator.next();
				secondList.put(key, p3.getProperty(key));
			}
			fr = new FileReader("config/secondMenuService.properties");
			p4.load(fr);
			keySet = p4.keySet();
			iterator = keySet.iterator();
			while(iterator.hasNext()) {
				String command = (String)iterator.next();
				secondCommandMap.put(command, p4.getProperty(command));
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}  catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	/**
	 * �����˵��б�
	 * @return �����б��ַ���
	 */
	public static String parseMenuList(int type) {
		StringBuilder sb = new StringBuilder();
		Map<String, String> map = new HashMap<>();
		if(type == MAIN_MENU) {
			map = MainList;
		} else if(type == SECOND_MENU) {
			map = secondList;
		}
		Set<String> set = map.keySet();
		Iterator<String> iterator = set.iterator();
		while(iterator.hasNext()) {
			String key = iterator.next();
			sb.append(key + "." + map.get(key) + "\n");				
		}
		return sb.toString();
	}
	
	/**
	 * ��������ѡ����Ӧ������
	 * @param nextInt
	 * @return
	 * @throws Exception 
	 */
	public static String getCommandByNum(String str,int type) throws Exception {
		Map<String, String> map = new HashMap<>();
		if(type == MAIN_MENU) {
			map = MainList;
		} else if(type == SECOND_MENU) {
			map = secondList;
		}
		String command = map.get(str);
		if(command == null) {
			throw new Exception();
		}
		return command;
	}
	
	
	/**
	 * ���ݸ��������ݣ�������Э��������������ļ��л�ȡ��Ӧ��serviceʵ���࣬ʵ�������󷵻�
	 * @param command
	 * @return
	 */
	public static MainUI Parse(String command,int type) {
		Map<String, String> map = new HashMap<>();
		if(type == MAIN_MENU) {
			map = commandMap;
		} else if(type == SECOND_MENU) {
			map = secondCommandMap;
		}
		String serviceStr = map.get(command);
		MainUI mainUI = null;
		try {
			Class<?> clazz = Class.forName(serviceStr);
			mainUI = (MainUI)clazz.newInstance();
			return mainUI;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
		return null;
	}
	
}
