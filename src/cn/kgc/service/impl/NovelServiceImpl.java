package cn.kgc.service.impl;

import java.util.List;

import cn.kgc.model.DataTransmission;
import cn.kgc.model.Novel;
import cn.kgc.service.intf.Service;
import cn.kgc.util.Prompt;

public class NovelServiceImpl implements Service,Prompt{
	 /**
	  * 构建武侠数据传输对象
	  */
	@Override
	public DataTransmission start(Object... o) {
		return new DataTransmission((String)o[0]);
	}
	 /**
	  * 获得数据后的相关逻辑
	 * @throws Exception 
	  */
	@SuppressWarnings("unchecked")
	@Override
	public DataTransmission after(DataTransmission data) throws Exception {
		int num = (int)data.getResult();
		switch(num) {
		case RETURN_BY_USER:
			data.setStatus(REPEAT);
			break;
		default:
			List<Novel> novelList = (List<Novel>) data.getObject();
			Novel novel = novelList.get(--num);
			if(novel == null) {
				throw new Exception(CHOOSE_ERORR);
			}
			data.setObject(novel);
		}
		return data;
	}

}
