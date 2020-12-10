package com.dvt.snjs.service.impl;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.dao.DataAccessException;

import com.dvt.core.dao.springjdbc.GenericDao;
import com.dvt.snjs.dubbo.model.JsTdxxDay;
import com.dvt.snjs.dubbo.model.Monitor;
import com.dvt.snjs.service.TdxxService;

public class TdxxServiceImpl extends AbstractMonitor implements TdxxService {
	
	private GenericDao genericDao;

	public void setGenericDao(GenericDao genericDao) {
		this.genericDao = genericDao;
	}

	@Override
	public void doSaveTdxx(List<JsTdxxDay> result) {
		if(result == null || result.isEmpty()) {
			return;
		}
		
		String sql = "merge into js_tdxx_day a"
				+ " using dual b"
				+ " on (a.yjtm=:yjtm "
				+ " and a.tdjdm = :tdjdm "
				+ " and a.tdrq = to_date(:tdrq,'yyyymmddhh24miss') )"
				+ " when NOT MATCHED then"
				+ " insert ("
				+ " id, yjtm, tdrq, yjzl, zl, jhzl, pydq, "
				+ " tdjdm, tdjgs, tdxs, tdds, tdsf, bcfl1, "
				+ " bcfl2, bcf, sjjdm, sjjgs, sjjxs, sjjds, "
				+ " sjjsf, syfl1, syfl2, syf, jssx, sjrq, "
				+ " sftt, ypdj, info, syfl3, bcfl3, ypdjjs, "
				+ " jdjdm, jdjsf, jdjds, khdm, tdy, xzbz, yjly)"
				+ " values( "
				+ " :id, :yjtm, to_date(:tdrq,'yyyymmddhh24miss'), :yjzl, "
				+ " :zl, :jhzl,:pydq, :tdjdm, :tdjgs, :tdxs, :tdds, "
				+ " :tdsf, :bcfl1, :bcfl2, :bcf, :sjjdm, "
				+ " :sjjgs, :sjjxs, :sjjds, :sjjsf, :syfl1, "
				+ " :syfl2, :syf, :jssx, to_date(:sjrq,'yyyymmddhh24miss'), "
				+ " :sftt, :ypdj,:info, :syfl3, :bcfl3, :ypdjjs, :jdjdm, "
				+ " :jdjsf, :jdjds, :khdm, :tdy, :xzbz, :yjly)";
		
		Map<String, Object> paramMap = new HashMap<String, Object>();
		for(JsTdxxDay o : result) {
			paramMap.clear();
			
			paramMap.put("id",o.getId());
			paramMap.put("yjtm",o.getYjtm());
			paramMap.put("tdrq",o.getTdrq());
			paramMap.put("yjzl",o.getYjzl());
			paramMap.put("zl",o.getZl());
			paramMap.put("jhzl",o.getJhzl());
			paramMap.put("pydq",o.getPydq());
			paramMap.put("tdjdm",o.getTdjdm());
			paramMap.put("tdjgs",o.getTdjgs());
			paramMap.put("tdxs",o.getTdxs());
			paramMap.put("tdds",o.getTdds());
			paramMap.put("tdsf",o.getTdsf());
			paramMap.put("bcfl1",o.getBcfl1());
			paramMap.put("bcfl2",o.getBcfl2());
			paramMap.put("bcf",o.getBcf());
			paramMap.put("sjjdm",o.getSjjdm());
			paramMap.put("sjjgs",o.getSjjgs());
			paramMap.put("sjjxs",o.getSjjxs());
			paramMap.put("sjjds",o.getSjjds());
			paramMap.put("sjjsf",o.getSjjsf());
			paramMap.put("syfl1",o.getSyfl1());
			paramMap.put("syfl2",o.getSyfl2());
			paramMap.put("syf",o.getSyf());
			paramMap.put("jssx",o.getJssx());
			paramMap.put("sjrq",o.getSjrq());
			paramMap.put("sftt",o.getSftt());
			paramMap.put("ypdj",o.getYpdj());
			paramMap.put("info",o.getInfo());
			paramMap.put("syfl3",o.getSyfl3());
			paramMap.put("bcfl3",o.getBcfl3());
			paramMap.put("ypdjjs",o.getYpdjjs());
			paramMap.put("jdjdm",o.getJdjdm());
			paramMap.put("jdjsf",o.getJdjsf());
			paramMap.put("jdjds",o.getJdjds());
			paramMap.put("khdm",o.getKhdm());
			paramMap.put("tdy",o.getTdy());
			paramMap.put("xzbz",o.getXzbz());
			paramMap.put("yjly",o.getYjly());
			
			this.genericDao.updateSql(sql, paramMap);
		}
		
		Monitor monitor = new Monitor();
		monitor.setQsrq(result.get(0).getTdrq());
		monitor.setZzrq(monitor.getZzrq());
		monitor.setTabname("JS_TDXX_DAY");
		monitor.setSuccessrecords(result.size());
		try {
			this.saveMonitor(monitor);
		} catch(SQLException ex) {
			
		} catch(DataAccessException ex) {
			
		}
	}

	@Override
	public GenericDao getGenericDao() {
		return this.genericDao;
	}

}
