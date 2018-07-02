package cn.kgc.model;

import java.io.Serializable;


/**
 * 通讯传输的对象
 * @author Administrator
 *
 */
public class DataTransmission implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -7919290412524754237L;	
	private String command;	//协议命令
	private Object object;	//传输具体对象
	private int status;	//回复状态
	private Object result;	//回复具体内容
	
	/**
	 * 有参构造方法
	 * @param command
	 * @param object
	 * @param status
	 * @param result
	 */
	
	public DataTransmission(String command, Object object, int status, Object result) {
		this(command,object);
		this.status = status;
		this.result = result;
	}
	public DataTransmission(String command) {
		this.command = command;
	}
	public DataTransmission(String command, Object object) {
		this(command);
		this.object = object;
	}
	/**
	 * 无参构造方法
	 */
	public DataTransmission() {
		super();
		// TODO Auto-generated constructor stub
	}
	/**
	 * get、set方法
	 * @return
	 */
	public String getCommand() {
		return command;
	}
	public void setCommand(String command) {
		this.command = command;
	}
	public Object getObject() {
		return object;
	}
	public void setObject(Object object) {
		this.object = object;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public Object getResult() {
		return result;
	}
	public void setResult(Object result) {
		this.result = result;
	}
	@Override
	public String toString() {
		return "DataTransmission [command=" + command + ", object=" + object + ", status=" + status + ", result="
				+ result + "]";
	}
	
	
	
}
