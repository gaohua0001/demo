package com.dvt.snjs.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.dvt.core.dao.springjdbc.GenericDao;
import com.dvt.snjs.dubbo.model.SnjsJkxxb;
import com.dvt.snjs.service.GxjsService;
import com.dvt.snjs.util.JscppUtil;

public class GxjsServiceImpl implements GxjsService {
	
	private GenericDao genericDao;

	public void setGenericDao(GenericDao genericDao) {
		this.genericDao = genericDao;
	}

	@Override
	public List<SnjsJkxxb> doGetSnjsJkxxb(String sfdm) {
		String sql = "call SN_DATA_JKXX_DAY(:sfdm)";
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("sfdm", sfdm);
		this.genericDao.updateSql(sql, paramMap);
		
		sql = "select to_char(jsrq,'yyyymmdd') jsrq,tabname,xfbz,sfdm,"
				+ " to_char(xfsj,'yyyymmddhh24miss') xfsj,"
				+ " '01' xtly"
				+ " from snjs_jkxxb "
				+ " where xfbz='1'"
				+ " and status='0'"
				+ " and sfdm=:sfdm";
		return this.genericDao.getList(sql, paramMap, (rs,i) -> {
			SnjsJkxxb o = new SnjsJkxxb();
			o.setJsrq(rs.getString("jsrq"));
			o.setTabname(rs.getString("tabname"));
			o.setSfdm(rs.getString("sfdm"));
			o.setXfbz(rs.getString("xfbz"));
			o.setXfsj(rs.getString("xfsj"));
			o.setXtly(rs.getString("xtly"));
			return o;
		});
	}

	@Override
	public void doUpdateSnjsJkxxb(String jsrq, String sfdm, String tabname) {
		String sql = "update snjs_jkxxb"
				+ " set status='1'"
				+ " where jsrq=to_date(:jsrq,'yyyymmdd')"
				+ " and sfdm=:sfdm"
				+ " and tabname=:tabname";
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("jsrq", jsrq);
		paramMap.put("sfdm", sfdm);
		paramMap.put("tabname", tabname);
		this.genericDao.updateSql(sql, paramMap);		
	}

}
