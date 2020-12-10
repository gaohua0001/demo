package com.dvt.snjs.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.dvt.core.dao.springjdbc.GenericDao;
import com.dvt.core.exception.CommonException;
import com.dvt.snjs.dubbo.model.SnjsJkxxb;
import com.dvt.snjs.service.CommonService;

public class CommonServiceImpl implements CommonService {
	
	private GenericDao genericDao;

	public void setGenericDao(GenericDao genericDao) {
		this.genericDao = genericDao;
	}

	@Override
	public String getSfdm() throws CommonException {
		String sql = "select trim(csz) from snjs_xtcsb where csdm='SFDM'";
		return this.genericDao.getSingleString(sql, null);
	}

	@Override
	public void doSaveSnjsJkxx(List<SnjsJkxxb> result) throws CommonException {
		if(result == null || result.isEmpty()) {
			return;
		}
		String sql = "insert into snjs_jkxxb(jsrq,tabname,xfbz,xfsj)"
				+ " values(to_date(:jsrq,'yyyymmdd'),:tabname,:xfbz,"
				+ "to_date(:xfsj,'yyyymmddhh24miss'))";
		Map<String, Object> params = new HashMap<String, Object>();
		for(SnjsJkxxb o : result) {
			params.clear();
			params.put("jsrq", o.getJsrq());
			params.put("tabname", o.getTabname());
			params.put("xfbz", o.getXfbz());
			params.put("xfsj", o.getXfsj());
			this.genericDao.updateSql(sql, params);
		}
	}

}
