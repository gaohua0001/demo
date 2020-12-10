package com.dvt.snjs.dubbo.service.impl;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.dvt.snjs.dubbo.model.JsTdxxDay;
import com.dvt.snjs.dubbo.service.DubboTdxx;
import com.dvt.snjs.service.TdxxService;

/**
 * 投递信息
 * @author zane
 *
 */
public class DubboTdxxImpl implements DubboTdxx {
	
	private TdxxService tdxxService;
	
	private static Log log = LogFactory.getLog(DubboTdxxImpl.class);
	
	@Autowired
	public void setTdxxService(TdxxService tdxxService) {
		this.tdxxService = tdxxService;
	}

	public List<JsTdxxDay> getTdxx(String sfdm) {
		try {
			log.info("get tdxx sfdm=" + sfdm);
			return tdxxService.getTdxx(sfdm);
		} catch(Exception e) {
			log.error(e.getMessage(), e);
			return null;
		}
	}

	@Override
	public void doDeleteTdxx(String sfdm, List<JsTdxxDay> result) {
		try {
			log.info("delete tdxx sfdm=" + sfdm);
			tdxxService.doDeleteTdxx(sfdm, result);
		} catch(Exception e) {
			log.error(e.getMessage(), e);
		}
	}

}
