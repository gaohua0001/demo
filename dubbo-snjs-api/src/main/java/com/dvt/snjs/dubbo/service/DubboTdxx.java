package com.dvt.snjs.dubbo.service;

import java.util.List;

import com.dvt.snjs.dubbo.model.JsTdxxDay;

/**
 * 投递信息
 * @author zane
 *
 */
public interface DubboTdxx {

	/**
	 * 投递信息
	 * @param sfdm
	 * @return
	 */
	public List<JsTdxxDay> getTdxx(String sfdm);
	
	/**
	 * 删除投递信息
	 * @param sfdm
	 * @param result
	 */
	public void doDeleteTdxx(String sfdm, List<JsTdxxDay> result);
}
