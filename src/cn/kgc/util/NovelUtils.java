package cn.kgc.util;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

public class NovelUtils {
	public static Map<String, String> commandMap = new HashMap<>();	//协议命令容器
	/**
	 * 初始化界面工具类，读取菜单列表,协议命令列表
	 */
	static {
		Properties p1 = new Properties();
		try {
			Reader fr = new FileReader("config/upload.properties");
			p1.load(fr);
			Set<Object> keySet = p1.keySet();
			Iterator<Object> iterator = keySet.iterator();
			while(iterator.hasNext()) {
				String command = (String)iterator.next();
				commandMap.put(command, p1.getProperty(command));
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}  catch (IOException e) {
			e.printStackTrace();
		}		
	}
	/**
	 * 根据路径获取文件，读取文档，转字节数组
	 * @param fileName
	 * @return
	 * @throws IOException 
	 */
	public static String getText(String fileName) throws IOException {
		StringBuilder sb = new StringBuilder();
		Reader reader = null;
		BufferedReader br = null;
		String str = null;
		try {
			reader = new FileReader(fileName);
			br = new BufferedReader(reader);
			while((str = br.readLine()) != null) {
				sb.append(str);
			}
		} catch (FileNotFoundException e) {
			throw new FileNotFoundException();
		}  catch (IOException e) {
			throw new IOException();
		} finally {
			try {
				reader.close();		
				br.close();
			} catch (Exception e2) {

			}
		}
		return sb.toString();
	}
	public static String getUploadCommandByCommand(String string) {	
		return commandMap.get(string);
	}

}
