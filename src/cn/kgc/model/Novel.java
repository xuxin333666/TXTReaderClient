package cn.kgc.model;

import java.io.Serializable;

public class Novel implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 2866841876962640908L;
	private String name;	//小说名称
	private String author;	//作者
	private String describe;	//简介
	private String content;	//内容
	private String type;	//类型
	private String fileName;	//文件名称
	
	
	/**
	 * 无参构造方法
	 */
	public Novel() {

	}
	/**
	 * 有参构造方法
	 * @param name
	 * @param author
	 * @param describe
	 * @param content
	 * @param fileName
	 */
	public Novel(String name, String author, String describe, String fileName) {
		this.name = name;
		this.author = author;
		this.describe = describe;
		this.fileName = fileName;
	}
	/**
	 * get、set方法
	 * @return
	 */
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getDescribe() {
		return describe;
	}
	public void setDescribe(String describe) {
		this.describe = describe;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	@Override
	public String toString() {
		return name + "\t" + author + "\t" + describe;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Novel other = (Novel) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
	
	
	
}
