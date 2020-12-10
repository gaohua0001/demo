package com.dvt.snjs.service;

import java.util.List;


import com.dvt.snjs.dubbo.model.SnjsJkxxb;

public interface GxjsService {
	
	/**
	 * 一干普服运费
	 * @param sfdm
	 * @return
	 */

	public List<SnjsJkxxb> doGetSnjsJkxxb(String sfdm);
	public void doUpdateSnjsJkxxb(String jsrq, String sfdm, String tabname);
}
