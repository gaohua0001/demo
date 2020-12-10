package com.dvt.snjs.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.dvt.core.dao.springjdbc.GenericDao;
import com.dvt.snjs.dubbo.model.JsNbclCkfyDay;
import com.dvt.snjs.dubbo.model.JsNbclJkfyDay;
import com.dvt.snjs.dubbo.model.JsNbclYjxxDay;
import com.dvt.snjs.service.NbclService;
import com.dvt.snjs.util.JscppUtil;

public class NbclServiceImpl implements NbclService {

	private GenericDao genericDao;

	public void setGenericDao(GenericDao genericDao) {
		this.genericDao = genericDao;
	}

	@Override
	public List<JsNbclYjxxDay> getKsjz(String sfdm) {
		String sql = "select "
				+ " to_char(jsrq,'yyyymmddhh24miss') jsrq, "
				+ " zbtm, yjtm, yjzl, clj, cljgs, cljsf, "
				+ " cljds, cljxs, sjj, sjjgs, sjjsf, jdj, jdjsf, "
				+ " jssx, zlsx, zl, jhzl, zbzl, syfl, bcfl, syf, "
				+ " bcf, id, sjjds, sjjxs, ypdj, "
				+ " to_char(time,'yyyymmddhh24miss') time, info, syfl2, "
				+ " bcfl2, to_char(sjrq,'yyyymmddhh24miss') sjrq, "
				+ " jdjds, jbbz, khdm, yjly, xzbz"
				+ " from sn_js_nbcl_yjxx_day" 
				+ " where sfdm=:sfdm"
				+ " and rownum<" + JscppUtil.rownum;
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("sfdm", sfdm);
		return this.genericDao.getList(sql, paramMap, ksjzRowMapper);
	}

	@Override
	public void doDeleteKsjz(String sfdm, List<JsNbclYjxxDay> result) {
		if (result == null || result.isEmpty()) {
			return;
		}
		String sql = "delete  /*+index(a SN_JS_NBCL_YJXX_DAY_IND2)*/ from sn_js_nbcl_yjxx_day a"
				+ " where yjtm=:yjtm "
				+ " and syf=:syf "
				+ " and sfdm=:sfdm "
				+ " and cljds=:cljds "
				+ " and cljgs=:cljgs"
				+ " and jsrq=to_date(:jsrq,'yyyymmddhh24miss')";
		Map<String, Object> paramMap = new HashMap<String, Object>();
		for (JsNbclYjxxDay o : result) {
			paramMap.clear();
			paramMap.put("yjtm", o.getYjtm());
			paramMap.put("syf", o.getSyf());
			paramMap.put("sfdm", sfdm);
			paramMap.put("cljds", o.getCljds());
			paramMap.put("cljgs", o.getCljgs());
			paramMap.put("jsrq", o.getJsrq());
			this.genericDao.updateSql(sql, paramMap);
		}
	}

	@Override
	public List<JsNbclCkfyDay> getCkfy(String sfdm) {
		String sql = "select "
				+ " to_char(jsrq,'yyyymmddhh24miss') jsrq, "
				+ " zbtm, yjtm, yjzl, clj, cljgs, cljsf, "
				+ " cljds, cljxs, sjj, sjjgs, sjjsf, jdj, jdjsf, "
				+ " jssx, zlsx, zl, jhzl, zbzl, syfl, bcfl, syf, "
				+ " bcf, id, sjjds, sjjxs, ypdj, "
				+ " to_char(time,'yyyymmddhh24miss') time, info, syfl2, "
				+ " bcfl2, to_char(sjrq,'yyyymmddhh24miss') sjrq, ftcs, "
				+ " jdjds, jbbz, khdm, yjly, xzbz "
				+ " from sn_js_nbcl_ckfy_day" 
				+ " where sfdm=:sfdm"
				+ " and rownum<" + JscppUtil.rownum;
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("sfdm", sfdm);
		return this.genericDao.getList(sql, paramMap, ckfyRowMapper);
	}

	@Override
	public void doDeleteCkfy(String sfdm, List<JsNbclCkfyDay> result) {
		if (result == null || result.isEmpty()) {
			return;
		}
		String sql = "delete  /*+index(a SN_JS_NBCL_CKFY_DAY_IND2)*/ from sn_js_nbcl_ckfy_day a"
				+ " where yjtm=:yjtm "
				+ " and syf=:syf "
				+ " and sfdm=:sfdm "
				+ " and cljds=:cljds "
				+ " and cljgs=:cljgs"
				+ " and jsrq=to_date(:jsrq,'yyyymmddhh24miss')";
		Map<String, Object> paramMap = new HashMap<String, Object>();
		for (JsNbclCkfyDay o : result) {
			paramMap.clear();
			paramMap.put("yjtm", o.getYjtm());
			paramMap.put("syf", o.getSyf());
			paramMap.put("sfdm", sfdm);
			paramMap.put("cljds", o.getCljds());
			paramMap.put("cljgs", o.getCljgs());
			paramMap.put("jsrq", o.getJsrq());
			this.genericDao.updateSql(sql, paramMap);
		}
	}

	@Override
	public List<JsNbclJkfyDay> getJkfy(String sfdm) {
		String sql = "select "
				+ " to_char(jsrq,'yyyymmddhh24miss') jsrq, "
				+ " zbtm, yjtm, yjzl, clj, cljgs, cljsf, "
				+ " cljds, cljxs, sjj, sjjgs, sjjsf, jdj, jdjsf, "
				+ " jssx, zlsx, zl, jhzl, zbzl, syfl, bcfl, syf, "
				+ " bcf, id, sjjds, sjjxs, ypdj, "
				+ " to_char(time,'yyyymmddhh24miss') time, info, syfl2, "
				+ " bcfl2, to_char(sjrq,'yyyymmddhh24miss') sjrq, "
				+ " ftcs, jdjds, jbbz, khdm, yjly, xzbz "
				+ " from sn_js_nbcl_jkfy_day" 
				+ " where sfdm=:sfdm"
				+ " and rownum<" + JscppUtil.rownum;
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("sfdm", sfdm);
		return this.genericDao.getList(sql, paramMap, jkfyRowMapper);
	}  

	@Override
	public void doDeleteJkfy(String sfdm, List<JsNbclJkfyDay> result) {
		if (result == null || result.isEmpty()) {
			return;
		}
		String sql = "delete /*+index(a SN_JS_NBCL_JKFY_DAY_IND2)*/ from sn_js_nbcl_jkfy_day a"
				+ " where yjtm=:yjtm "
				+ " and syf=:syf "
				+ " and sfdm=:sfdm "
				+ " and cljds=:cljds "
				+ " and cljgs=:cljgs"
				+ " and jsrq=to_date(:jsrq,'yyyymmddhh24miss')";
		Map<String, Object> paramMap = new HashMap<String, Object>();
		for (JsNbclJkfyDay o : result) {
			paramMap.clear();
			paramMap.put("yjtm", o.getYjtm());
			paramMap.put("syf", o.getSyf());
			paramMap.put("sfdm", sfdm);
			paramMap.put("cljds", o.getCljds());
			paramMap.put("cljgs", o.getCljgs());
			paramMap.put("jsrq", o.getJsrq());
			this.genericDao.updateSql(sql, paramMap);
		}
	}

}
