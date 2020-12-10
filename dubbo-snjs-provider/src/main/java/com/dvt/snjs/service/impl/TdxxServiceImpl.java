package com.dvt.snjs.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.dvt.core.dao.springjdbc.GenericDao;
import com.dvt.snjs.dubbo.model.JsTdxxDay;
import com.dvt.snjs.service.TdxxService;
import com.dvt.snjs.util.JscppUtil;

/**
 * 投递信息
 * @author zane
 *
 */
public class TdxxServiceImpl implements TdxxService {
	
	private GenericDao genericDao;

	public void setGenericDao(GenericDao genericDao) {
		this.genericDao = genericDao;
	}

	@Override
	public List<JsTdxxDay> getTdxx(String sfdm) {
		String sql = "select "
				+ " id, yjtm, to_char(tdrq,'yyyymmddhh24miss') tdrq, "
				+ " yjzl, zl, jhzl, pydq, "
				+ " tdjdm, tdjgs, tdxs, tdds, tdsf, bcfl1, "
				+ " bcfl2, bcf, sjjdm, sjjgs, sjjxs, sjjds, "
				+ " sjjsf, syfl1, syfl2, syf, jssx, "
				+ " to_char(sjrq,'yyyymmddhh24miss') sjrq, "
				+ " sftt, ypdj, info, syfl3, bcfl3, ypdjjs, "
				+ " jdjdm, jdjsf, jdjds, khdm, tdy, xzbz, yjly "
				+ " from sn_js_tdxx_day"
				+ " where sfdm=:sfdm"
				+ " and rownum<" + JscppUtil.rownum;
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("sfdm", sfdm);
		return this.genericDao.getList(sql, paramMap, tdxxRowMapper);
	}

	@Override
	public void doDeleteTdxx(String sfdm, List<JsTdxxDay> result) {
		if(result == null || result.isEmpty()) {
			return;
		}
		String sql = "delete /*+index(a SN_JS_TDXX_DAY_IND2)*/ from sn_js_tdxx_day a"
				+ " where sfdm = :sfdm"
				+ " and yjtm=:yjtm"
				+ " and tdjdm=:tdjdm"
				+ " and tdjgs=:tdjgs"
				+ " and tdrq=to_date(:tdrq,'yyyymmddhh24miss')"
				+ " and syf=:syf";
		Map<String, Object> paramMap = new HashMap<String, Object>();
		for(JsTdxxDay o : result) {
			paramMap.clear();
			paramMap.put("sfdm", sfdm);
			paramMap.put("tdjdm", o.getTdjdm());
			paramMap.put("yjtm", o.getYjtm());
			paramMap.put("tdjgs", o.getTdjgs());
			paramMap.put("tdrq", o.getTdrq());
			paramMap.put("syf", o.getSyf());
			this.genericDao.updateSql(sql, paramMap);
		}
	}

}
