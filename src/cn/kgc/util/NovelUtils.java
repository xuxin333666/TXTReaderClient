package cn.kgc.util;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

import cn.kgc.model.Novel;

public class NovelUtils {
	public static Map<String, String> commandMap = new HashMap<>();	//Э����������
	/**
	 * ��ʼ�����湤���࣬��ȡ�˵��б�,Э�������б�
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
	 * ����·����ȡ�ļ�����ȡ�ĵ���ת�ֽ�����
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
	
	/**
	 * ����С˵�����ȡ��Ӧ���ϴ�С˵����
	 * @param string
	 * @return
	 */
	public static String getUploadCommandByCommand(String string) {	
		return commandMap.get(string);
	}
	/**
	 * ����С˵
	 * @param string 
	 * @param novel 
	 * @param downloadPath 
	 * @throws IOException 
	 */
	public static void downloadNovel(Novel novel, String string, String downloadPath) throws IOException {
		Writer writer = new FileWriter(downloadPath + "/" + novel.getFileName());
		BufferedWriter bw = new BufferedWriter(writer);
		String[] strArr = string.split("\n");
		for (String string2 : strArr) {
			bw.write(string2);
			bw.newLine();		
		}
		bw.close();
	}
	
	
	

}
