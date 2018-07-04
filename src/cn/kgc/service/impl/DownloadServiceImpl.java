package cn.kgc.service.impl;


import cn.kgc.model.DataTransmission;
import cn.kgc.model.Novel;
import cn.kgc.service.intf.Service;
import cn.kgc.util.NovelUtils;
import cn.kgc.util.Prompt;

public class DownloadServiceImpl implements Service,Prompt {
	private String downloadPath;	//当前下载地址
	@Override
	public DataTransmission start(Object... o) {
		DataTransmission data = (DataTransmission)o[0];
		downloadPath = (String)o[1];
		if(String.valueOf(DOWNLOAD_DEFAULT_COMMAND).equals(downloadPath)) {
			downloadPath = DOWNLOAD_DEFAULT_PASH;
		}
		data.setResult(downloadPath);
		return data;
	}

	@Override
	public DataTransmission after(DataTransmission data) throws Exception {
		if(data.getStatus() == ERORR) {
			throw new Exception(READ_ERORR);
		}
		try {
			NovelUtils.downloadNovel((Novel)data.getObject(),(String)data.getResult(),downloadPath);			
		} catch (Exception e) {
			throw new Exception(DOWNLOAD_ERORR);
		}
		return data;
	}

}
