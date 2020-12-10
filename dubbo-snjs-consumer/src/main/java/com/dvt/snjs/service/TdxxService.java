package com.dvt.snjs.service;

import java.util.List;

import com.dvt.snjs.dubbo.model.JsTdxxDay;

/**
 * 投递信息
 * @author zane
 *
 */
public interface TdxxService {

	/**
	 * 保存投递信息
	 * @param result
	 */
	public void doSaveTdxx(List<JsTdxxDay> result);
}
