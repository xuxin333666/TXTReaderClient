package cn.kgc.util;

public interface Prompt {
	String USER_NOT_EXIST = "该用户名不存在或密码错误！";		//用户不存在
	String USER_EXIST = "该用户名已经注册了！";	//用户存在
	String CONNECTION = "  正在连接，指令：";	//服务器输出链接内容
	int USERNAME_INDEX = 0;	//用户名所在的小标
	int PASSWORD_INDEX = 1;	//密码所在的下标
	int COMMAND_INDEX = 2;	//命令所在的下标
	int ERORR = -1;		//登陆错误
	int SUCCUSS = 0;	//登陆成功
	int SECONDARY_MENU = 1230;	//客户端二级菜单启动命令
	
	String TITLE = "欢迎使用在线迷你TXT小说管理器";		//开场白
	String DIVIDER = "————————————————————————————————";	//分割线
	String USER_CHOOSE = "请选择："; 	//用户选择提示
	String SYSTEM_QUIT = "谢谢使用";		//退出提示
	String CHOOSE_ERORR = "找不到改功能，请重新输入选项\n";	//用户输入错误选项提示
	String REGISTER_USERNAME_PROMPT = "请输入注册账号：";		//用户注册账户提示
	String REGISTER_PASSWORD_PROMPT = "请输入注册密码：";		//用户注册密码提示
	String REGISTER_PASSWORD2_PROMPT = "请再次输入密码：";		//用户注册再次输入密码提示
	String REGISTER_PASSWORD2_ERORR = "两次输入的密码不一致，请重新输入";	//用户注册再次输入密码错误提示
	String REGISTER_SUCCUSS = "注册成功！！";	//用户注册成功后的提示
	String LOGIN_USERNAME_PROMPT = "请输入账号：";		//用户登陆账户提示
	String LOGIN_PASSWORD_PROMPT = "请输入密码：";		//用户登陆密码提示
	String LOGIN_SUCCUSS = "登陆成功！！";	//用户登陆成功后的提示
	String RETURN_MAIN_MENU = "返回上一级菜单";	//返回上一级菜单的提示
	String GET_NOVE_ERORR = "该类型没有相应数据，请联系管理员";	//找不到小说时的提示
	String NOVE_LIST_PRINT = "序号\t小说名\t作者\t简介";	//小说列表输出
	int MAIN_MENU = 1;	//主菜单
	int SECOND_MENU = 2;	//二级菜单
}
