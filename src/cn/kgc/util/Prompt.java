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
	int RETURN_BY_USER = 0;	//返回上一级的用户指令
	int UPLOAD = -1;	//上传小说的用户指令
	int COMMAND_AGIN = 1227;	//重新选择命令
	int REPEAT = 1228;	//返回当前菜单
	int RETURN = 1229;	//返回上一级指令
	int SECONDARY_MENU = 1230;	//客户端二级菜单启动命令
	int THIRD_RUN_MENU = 1231;	//客户端三级菜单启动命令
	
	String TITLE = "欢迎使用在线迷你TXT小说管理器";		//开场白
	String DIVIDER = "————————————————————————————————";	//分割线
	String USER_CHOOSE = "请选择："; 	//用户选择提示
	String USER_CHOOSE_NOVEL = "阅读和下载请选择文件序号，上传TXT请输入-1，返回输入0："; //用户选择小说的提示
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
	String RETURN_MAIN_MENU = "返回上级菜单";	//返回上一级菜单的提示
	String GET_NOVE_ERORR = "该类型没有相应数据，请联系管理员";	//找不到小说时的提示
	String WUXIA = "武侠";	//	武侠命令
	String YANQING = "言情";	//言情命令
	String NOVE_LIST_PRINT = "序号\t小说名\t作者\t简介";	//小说列表输出
	String NOVEL_NAME = "name";	//小说名称的XML标签名
	String NOVEL_AUTHOR = "author";	//小说作者的XML标签名
	String NOVEL_DESCRIPTION = "description";	//小说简介的XML标签名
	String NOVEL_FILENAME = "filename";	//小说文件名称的XML标签名
	String UPLOAD_COMMAND_WUXIA = "武侠上传";	//上传小说命令
	String UPLOAD_COMMAND_YANQING = "言情上传";	//上传小说命令
	String UPLOAD_NAME = "请输入小说名：";	//上传时的提示
	String UPLOAD_AUTHOR = "请输入小说作者：";	//上传时的提示
	String UPLOAD_DESCRIPTION = "请输入小说简介：";	//上传时的提示
	String UPLOAD_PATH = "请输入上传的TXT（请注意路径用/或者\\）：";		//上传时的提示
	String UPLOAD_SUCCESS = "小说保存成功";	//上传成功时的提示
	String UPLOAD_ERORR_CLIENT = "小说上传失败，请确认上传地址正确";	//本地上传失败时的提示
	String UPLOAD_ERORR_SERVER = "小说上传失败，请确认网络正常";	//网络上传失败时的提示
	String UPLOAD_CONTINUE = "继续上传请输入-1，返回请输入0：";	//询问是否继续上传
	int MAIN_MENU = 1;	//主菜单
	int SECOND_MENU = 2;	//二级菜单
	int THIRD_MENU = 3;	//三级菜单
}
