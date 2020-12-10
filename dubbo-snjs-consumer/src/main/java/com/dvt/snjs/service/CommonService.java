package com.dvt.snjs.service;

import java.util.List;

import com.dvt.core.exception.CommonException;
import com.dvt.snjs.dubbo.model.SnjsJkxxb;

public interface CommonService {

	/**
	 * 省份代码
	 * @return
	 */
	public String getSfdm() throws CommonException;
	
	/**
	 * 监控信息
	 * @param result
	 * @throws CommonException
	 */
	public void doSaveSnjsJkxx(List<SnjsJkxxb> result) throws CommonException;
}
