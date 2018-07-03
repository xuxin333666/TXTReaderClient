package cn.kgc.service.impl;

import java.io.IOException;

import cn.kgc.model.DataTransmission;
import cn.kgc.model.Novel;
import cn.kgc.service.intf.Service;
import cn.kgc.util.NovelUtils;
import cn.kgc.util.Prompt;

public class UploadServiceImpl implements Service,Prompt{

	@Override
	public DataTransmission start(Object... o) {
		DataTransmission data = (DataTransmission)o[0];
		Novel novel = (Novel)data.getObject();
		try {
			String text = NovelUtils.getText(novel.getFileName());
			novel.setContent(text);
		} catch (IOException e) {
			data.setStatus(ERORR);
		}		
		return data;
	}

	@Override
	public DataTransmission after(DataTransmission data) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
