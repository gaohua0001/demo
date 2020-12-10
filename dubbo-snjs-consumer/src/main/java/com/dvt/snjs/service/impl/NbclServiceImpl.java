package com.dvt.snjs.service.impl;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.dao.DataAccessException;

import com.dvt.core.dao.springjdbc.GenericDao;
import com.dvt.snjs.dubbo.model.JsNbclCkfyDay;
import com.dvt.snjs.dubbo.model.JsNbclJkfyDay;
import com.dvt.snjs.dubbo.model.JsNbclYjxxDay;
import com.dvt.snjs.dubbo.model.Monitor;
import com.dvt.snjs.service.NbclService;

public class NbclServiceImpl extends AbstractMonitor implements NbclService {

	private GenericDao genericDao;

	public void setGenericDao(GenericDao genericDao) {
		this.genericDao = genericDao;
	}

	@Override
	public void doSaveKsjz(List<JsNbclYjxxDay> result) {
		if (result == null || result.isEmpty()) {
			return;
		}
		String sql = "merge into js_nbcl_yjxx_day a" 
				+ " using dual b" 
				+ " on ("
				+ " a.yjtm=:yjtm " 
				+ " and a.cljds = :cljds "
				+ " and a.jsrq = to_date(:jsrq,'yyyymmddhh24miss')" 
				+ " )" 
				+ " when NOT MATCHED then"
				+ " insert ("
				+ " jsrq, zbtm, yjtm, yjzl, clj, cljgs, cljsf, " 
				+ " cljds, cljxs, sjj, sjjgs, sjjsf, jdj, "
				+ " jdjsf, jssx, zlsx, zl, jhzl, zbzl, syfl, " 
				+ " bcfl, syf, bcf, id, sjjds, sjjxs, ypdj, "
				+ " time, info, syfl2, bcfl2, sjrq, jdjds, " 
				+ " jbbz, khdm, yjly, xzbz)"
				+ " values( "
				+ " to_date(:jsrq,'yyyymmddhh24miss'), :zbtm, " 
				+ " :yjtm, :yjzl, :clj, :cljgs, :cljsf, :cljds, "
				+ " :cljxs, :sjj, :sjjgs, :sjjsf, :jdj, :jdjsf, " 
				+ " :jssx, :zlsx, :zl, :jhzl, :zbzl, :syfl, :bcfl, "
				+ " :syf, :bcf, :id, :sjjds, :sjjxs, :ypdj, "
				+ " to_date(:time,'yyyymmddhh24miss'), :info, :syfl2, :bcfl2, "
				+ " to_date(:sjrq,'yyyymmddhh24miss'), :jdjds, " 
				+ " :jbbz, :khdm, :yjly, :xzbz)";
		Map<String, Object> paramMap = new HashMap<String, Object>();
		for (JsNbclYjxxDay o : result) {
			paramMap.clear();
			paramMap.put("jsrq", o.getJsrq());
			paramMap.put("zbtm", o.getZbtm());
			paramMap.put("yjtm", o.getYjtm());
			paramMap.put("yjzl", o.getYjzl());
			paramMap.put("clj", o.getClj());
			paramMap.put("cljgs", o.getCljgs());
			paramMap.put("cljsf", o.getCljsf());
			paramMap.put("cljds", o.getCljds());
			paramMap.put("cljxs", o.getCljxs());
			paramMap.put("sjj", o.getSjj());
			paramMap.put("sjjgs", o.getSjjgs());
			paramMap.put("sjjsf", o.getSjjsf());
			paramMap.put("jdj", o.getJdj());
			paramMap.put("jdjsf", o.getJdjsf());
			paramMap.put("jssx", o.getJssx());
			paramMap.put("zlsx", o.getZlsx());
			paramMap.put("zl", o.getZl());
			paramMap.put("jhzl", o.getJhzl());
			paramMap.put("zbzl", o.getZbzl());
			paramMap.put("syfl", o.getSyfl());
			paramMap.put("bcfl", o.getBcfl());
			paramMap.put("syf", o.getSyf());
			paramMap.put("bcf", o.getBcf());
			paramMap.put("id", o.getId());
			paramMap.put("sjjds", o.getSjjds());
			paramMap.put("sjjxs", o.getSjjxs());
			paramMap.put("ypdj", o.getYpdj());
			paramMap.put("time", o.getTime());
			paramMap.put("info", o.getInfo());
			paramMap.put("syfl2", o.getSyfl2());
			paramMap.put("bcfl2", o.getBcfl2());
			paramMap.put("sjrq", o.getSjrq());
			paramMap.put("jdjds", o.getJdjds());
			paramMap.put("jbbz", o.getJbbz());
			paramMap.put("khdm", o.getKhdm());
			paramMap.put("yjly", o.getYjly());
			paramMap.put("xzbz", o.getXzbz());
			this.genericDao.updateSql(sql, paramMap);
		}

		Monitor monitor = new Monitor();
		monitor.setQsrq(result.get(0).getJsrq());
		monitor.setZzrq(monitor.getZzrq());
		monitor.setTabname("JS_NBCL_YJXX_DAY");
		monitor.setSuccessrecords(result.size());
		try {
			this.saveMonitor(monitor);
		} catch (SQLException ex) {

		} catch (DataAccessException ex) {

		}
	}

	@Override
	public void doSaveCkfy(List<JsNbclCkfyDay> result) {
		if (result == null || result.isEmpty()) {
			return;
		}
		String sql = "merge into js_nbcl_ckfy_day a" 
				+ " using dual b" 
				+ " on ("
				+ " a.yjtm=:yjtm " 
				+ " and a.cljds = :cljds "
				+ " and a.jsrq = to_date(:jsrq,'yyyymmddhh24miss'))" 
				+ " when NOT MATCHED then"
				+ " insert (" 
				+ " jsrq, zbtm, yjtm, yjzl, clj, cljgs, "
				+ " cljsf, cljds, cljxs, sjj, sjjgs, sjjsf, "
				+ " jdj, jdjsf, jssx, zlsx, zl, jhzl, zbzl, "
				+ " syfl, bcfl, syf, bcf, id, sjjds, sjjxs, "
				+ " ypdj, time, info, syfl2, bcfl2, sjrq, "
				+ " ftcs, jdjds, jbbz, khdm, yjly, xzbz)"
				+ " values( "
				+ " to_date(:jsrq,'yyyymmddhh24miss'), :zbtm, :yjtm, :yjzl, "
				+ " :clj, :cljgs, :cljsf, :cljds, :cljxs, :sjj, :sjjgs, "
				+ " :sjjsf, :jdj, :jdjsf, :jssx, :zlsx, :zl, :jhzl, :zbzl, "
				+ " :syfl, :bcfl, :syf, :bcf, :id, :sjjds, :sjjxs, :ypdj, "
				+ " to_date(:time,'yyyymmddhh24miss'), :info, :syfl2, :bcfl2, "
				+ " to_date(:sjrq,'yyyymmddhh24miss'), :ftcs, :jdjds, :jbbz, "
				+ " :khdm, :yjly, :xzbz)";
		Map<String, Object> paramMap = new HashMap<String, Object>();
		for (JsNbclCkfyDay o : result) {
			paramMap.clear();
			paramMap.put("jsrq",o.getJsrq());
			paramMap.put("zbtm",o.getZbtm());
			paramMap.put("yjtm",o.getYjtm());
			paramMap.put("yjzl",o.getYjzl());
			paramMap.put("clj",o.getClj());
			paramMap.put("cljgs",o.getCljgs());
			paramMap.put("cljsf",o.getCljsf());
			paramMap.put("cljds",o.getCljds());
			paramMap.put("cljxs",o.getCljxs());
			paramMap.put("sjj",o.getSjj());
			paramMap.put("sjjgs",o.getSjjgs());
			paramMap.put("sjjsf",o.getSjjsf());
			paramMap.put("jdj",o.getJdj());
			paramMap.put("jdjsf",o.getJdjsf());
			paramMap.put("jssx",o.getJssx());
			paramMap.put("zlsx",o.getZlsx());
			paramMap.put("zl",o.getZl());
			paramMap.put("jhzl",o.getJhzl());
			paramMap.put("zbzl",o.getZbzl());
			paramMap.put("syfl",o.getSyfl());
			paramMap.put("bcfl",o.getBcfl());
			paramMap.put("syf",o.getSyf());
			paramMap.put("bcf",o.getBcf());
			paramMap.put("id",o.getId());
			paramMap.put("sjjds",o.getSjjds());
			paramMap.put("sjjxs",o.getSjjxs());
			paramMap.put("ypdj",o.getYpdj());
			paramMap.put("time",o.getTime());
			paramMap.put("info",o.getInfo());
			paramMap.put("syfl2",o.getSyfl2());
			paramMap.put("bcfl2",o.getBcfl2());
			paramMap.put("sjrq",o.getSjrq());
			paramMap.put("ftcs",o.getFtcs());
			paramMap.put("jdjds",o.getJdjds());
			paramMap.put("jbbz",o.getJbbz());
			paramMap.put("khdm",o.getKhdm());
			paramMap.put("yjly",o.getYjly());
			paramMap.put("xzbz",o.getXzbz());
			this.genericDao.updateSql(sql, paramMap);
		}

		Monitor monitor = new Monitor();
		monitor.setQsrq(result.get(0).getJsrq());
		monitor.setZzrq(monitor.getZzrq());
		monitor.setTabname("JS_NBCL_CKFY_DAY");
		monitor.setSuccessrecords(result.size());
		try {
			this.saveMonitor(monitor);
		} catch (SQLException ex) {

		} catch (DataAccessException ex) {

		}
	}

	@Override
	public void doSaveJkfy(List<JsNbclJkfyDay> result) {
		if (result == null || result.isEmpty()) {
			return;
		}
		String sql = "merge into js_nbcl_jkfy_day a" 
				+ " using dual b" 
				+ " on ("
				+ " a.yjtm=:yjtm " 
				+ " and a.cljds = :cljds "
				+ " and a.jsrq = to_date(:jsrq,'yyyymmddhh24miss'))" 
				+ " when NOT MATCHED then"
				+ " insert (" 
				+ " jsrq, zbtm, yjtm, yjzl, clj, cljgs, cljsf, "
				+ " cljds, cljxs, sjj, sjjgs, sjjsf, jdj, jdjsf, "
				+ " jssx, zlsx, zl, jhzl, zbzl, syfl, bcfl, syf, "
				+ " bcf, id, sjjds, sjjxs, ypdj, time, info, syfl2, "
				+ " bcfl2, sjrq, ftcs, jdjds, jbbz, khdm, yjly, xzbz)"
				+ " values( "
				+ " to_date(:jsrq,'yyyymmddhh24miss'), :zbtm, :yjtm, :yjzl, "
				+ " :clj, :cljgs, :cljsf, :cljds, :cljxs, :sjj, :sjjgs, "
				+ " :sjjsf, :jdj, :jdjsf, :jssx, :zlsx, :zl, :jhzl, :zbzl, "
				+ " :syfl, :bcfl, :syf, :bcf, :id, :sjjds, :sjjxs, :ypdj, "
				+ " to_date(:time,'yyyymmddhh24miss'), :info, :syfl2, :bcfl2,"
				+ " to_date(:sjrq,'yyyymmddhh24miss'), :ftcs, :jdjds, "
				+ ":jbbz, :khdm, :yjly, :xzbz)";
		Map<String, Object> paramMap = new HashMap<String, Object>();
		for (JsNbclJkfyDay o : result) {
			paramMap.clear();
			paramMap.put("jsrq",o.getJsrq());
			paramMap.put("zbtm",o.getZbtm());
			paramMap.put("yjtm",o.getYjtm());
			paramMap.put("yjzl",o.getYjzl());
			paramMap.put("clj",o.getClj());
			paramMap.put("cljgs",o.getCljgs());
			paramMap.put("cljsf",o.getCljsf());
			paramMap.put("cljds",o.getCljds());
			paramMap.put("cljxs",o.getCljxs());
			paramMap.put("sjj",o.getSjj());
			paramMap.put("sjjgs",o.getSjjgs());
			paramMap.put("sjjsf",o.getSjjsf());
			paramMap.put("jdj",o.getJdj());
			paramMap.put("jdjsf",o.getJdjsf());
			paramMap.put("jssx",o.getJssx());
			paramMap.put("zlsx",o.getZlsx());
			paramMap.put("zl",o.getZl());
			paramMap.put("jhzl",o.getJhzl());
			paramMap.put("zbzl",o.getZbzl());
			paramMap.put("syfl",o.getSyfl());
			paramMap.put("bcfl",o.getBcfl());
			paramMap.put("syf",o.getSyf());
			paramMap.put("bcf",o.getBcf());
			paramMap.put("id",o.getId());
			paramMap.put("sjjds",o.getSjjds());
			paramMap.put("sjjxs",o.getSjjxs());
			paramMap.put("ypdj",o.getYpdj());
			paramMap.put("time",o.getTime());
			paramMap.put("info",o.getInfo());
			paramMap.put("syfl2",o.getSyfl2());
			paramMap.put("bcfl2",o.getBcfl2());
			paramMap.put("sjrq",o.getSjrq());
			paramMap.put("ftcs",o.getFtcs());
			paramMap.put("jdjds",o.getJdjds());
			paramMap.put("jbbz",o.getJbbz());
			paramMap.put("khdm",o.getKhdm());
			paramMap.put("yjly",o.getYjly());
			paramMap.put("xzbz",o.getXzbz());
			this.genericDao.updateSql(sql, paramMap);
		}

		Monitor monitor = new Monitor();
		monitor.setQsrq(result.get(0).getJsrq());
		monitor.setZzrq(monitor.getZzrq());
		monitor.setTabname("JS_NBCL_JKFY_DAY");
		monitor.setSuccessrecords(result.size());
		try {
			this.saveMonitor(monitor);
		} catch (SQLException ex) {

		} catch (DataAccessException ex) {

		}
	}

	@Override
	public GenericDao getGenericDao() {
		return this.genericDao;
	}

}
