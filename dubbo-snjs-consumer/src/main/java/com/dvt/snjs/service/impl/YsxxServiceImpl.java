package com.dvt.snjs.service.impl;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.dao.DataAccessException;

import com.dvt.core.dao.springjdbc.GenericDao;
import com.dvt.snjs.dubbo.model.JsYsxxDay;
import com.dvt.snjs.dubbo.model.JsYsxxHkfyDay;
import com.dvt.snjs.dubbo.model.Monitor;
import com.dvt.snjs.dubbo.model.YjsFkhzcmxb;
import com.dvt.snjs.dubbo.model.Zfgkzfywl;
import com.dvt.snjs.service.YsxxService;

public class YsxxServiceImpl extends AbstractMonitor implements YsxxService {

	private GenericDao genericDao;

	public void setGenericDao(GenericDao genericDao) {
		this.genericDao = genericDao;
	}

	@Override
	public void doSaveYsxx(List<JsYsxxDay> result) {
		if (result == null || result.isEmpty()) {
			return;
		}
		String sql = "merge into js_ysxx_day a"
				+ " using dual b"
				+ " on ("
				+ " a.yjtm=:yjtm"
				+ " and a.yldm = :yldm"
				+ " and a.jsrq = to_date(:jsrq,'yyyymmddhh24miss')"
				+ " and a.pyj=:pyj"
				+ " and a.fcz=:fcz )"
				+ " when NOT MATCHED then"
				+ " insert ("
				+ " jsrq, yjtm, sjjgs, sjjsf, pyjgs, pyjsf, "
				+ " fcz, fdid, zbtm, yldm, yljb, ylzl, "
				+ " ldlsh, gls, jsz, yjzl, sjjdm, sjjds, "
				+ " sjjxs, pyj, pyjds, pyjxs, syfl, bcfl, "
				+ " syf, bcf, zl, jhzl, hbbh, zlsx, jssx, "
				+ " yjsl, zbzl, lhbz, id, yjjdm, jdjdm, ypdj, "
				+ " info, sjrq, jdjsf, jdjds, khdm, xzbz, yjly)"
				+ " values( "
				+ " to_date(:jsrq,'yyyymmddhh24miss'), :yjtm, "
				+ " :sjjgs, :sjjsf, :pyjgs, :pyjsf, :fcz, "
				+ " :fdid, :zbtm, :yldm, :yljb, :ylzl, :ldlsh, :gls, "
				+ " :jsz, :yjzl, :sjjdm, :sjjds, :sjjxs, :pyj, :pyjds, "
				+ " :pyjxs, :syfl, :bcfl, :syf, :bcf, :zl, :jhzl, "
				+ " :hbbh, :zlsx, :jssx, :yjsl, :zbzl, :lhbz, :id, "
				+ " :yjjdm, :jdjdm, :ypdj, :info, "
				+ " to_date(:sjrq,'yyyymmddhh24miss') , :jdjsf, "
				+ " :jdjds, :khdm, :xzbz, :yjly)";
		Map<String, Object> paramMap = new HashMap<String, Object>();
		for (JsYsxxDay o : result) {
			paramMap.clear();
			paramMap.put("jsrq",o.getJsrq());
			paramMap.put("yjtm",o.getYjtm());
			paramMap.put("sjjgs",o.getSjjgs());
			paramMap.put("sjjsf",o.getSjjsf());
			paramMap.put("pyjgs",o.getPyjgs());
			paramMap.put("pyjsf",o.getPyjsf());
			paramMap.put("fcz",o.getFcz());
			paramMap.put("fdid",o.getFdid());
			paramMap.put("zbtm",o.getZbtm());
			paramMap.put("yldm",o.getYldm());
			paramMap.put("yljb",o.getYljb());
			paramMap.put("ylzl",o.getYlzl());
			paramMap.put("ldlsh",o.getLdlsh());
			paramMap.put("gls",o.getGls());
			paramMap.put("jsz",o.getJsz());
			paramMap.put("yjzl",o.getYjzl());
			paramMap.put("sjjdm",o.getSjjdm());
			paramMap.put("sjjds",o.getSjjds());
			paramMap.put("sjjxs",o.getSjjxs());
			paramMap.put("pyj",o.getPyj());
			paramMap.put("pyjds",o.getPyjds());
			paramMap.put("pyjxs",o.getPyjxs());
			paramMap.put("syfl",o.getSyfl());
			paramMap.put("bcfl",o.getBcfl());
			paramMap.put("syf",o.getSyf());
			paramMap.put("bcf",o.getBcf());
			paramMap.put("zl",o.getZl());
			paramMap.put("jhzl",o.getJhzl());
			paramMap.put("hbbh",o.getHbbh());
			paramMap.put("zlsx",o.getZlsx());
			paramMap.put("jssx",o.getJssx());
			paramMap.put("yjsl",o.getYjsl());
			paramMap.put("zbzl",o.getZbzl());
			paramMap.put("lhbz",o.getLhbz());
			paramMap.put("id",o.getId());
			paramMap.put("yjjdm",o.getYjjdm());
			paramMap.put("jdjdm",o.getJdjdm());
			paramMap.put("ypdj",o.getYpdj());
			paramMap.put("info",o.getInfo());
			paramMap.put("sjrq",o.getSjrq());
			paramMap.put("jdjsf",o.getJdjsf());
			paramMap.put("jdjds",o.getJdjds());
			paramMap.put("khdm",o.getKhdm());
			paramMap.put("xzbz",o.getXzbz());
			paramMap.put("yjly",o.getYjly());

			this.genericDao.updateSql(sql, paramMap);
		}

		Monitor monitor = new Monitor();
		monitor.setQsrq(result.get(0).getJsrq());
		monitor.setZzrq(monitor.getZzrq());
		monitor.setTabname("JS_YSXX_DAY");
		monitor.setSuccessrecords(result.size());
		try {
			this.saveMonitor(monitor);
		} catch (SQLException ex) {

		} catch (DataAccessException ex) {

		}
	}

	@Override
	public void doSaveHkfy(List<JsYsxxHkfyDay> result) {
		if (result == null || result.isEmpty()) {
			return;
		}
		String sql = "merge into JS_YSXX_HKFY_DAY a"
				+ " using dual b"
				+ " on (a.yjtm=:yjtm and a.id = :id "
				+ " and a.jsrq = to_date(:jsrq,'yyyymmddhh24miss') "
				+ " and a.yldm=:yldm"
				+ " and a.bcf=:bcf"
				+ " and a.pyj=:pyj"
				+ " and a.fcz=:fcz)"
				+ " when NOT MATCHED then"
				+ " insert ("
				+ " jsrq, fdid, zbtm, yjtm, sjjgs, sjjsf, pyjgs, "
				+ " pyjsf, yldm, yljb, ylzl, ldlsh, gls, fcz, "
				+ " jsz, yjzl, zl, jhzl, sjjdm, sjjds, sjjxs, "
				+ " pyj, pyjds, pyjxs, syfl, bcfl, syf, bcf, "
				+ " hbbh, zlsx, jssx, yjsl, zbzl, lhbz, id, yjjdm, "
				+ " jdjdm, jdjsf, ypdj, info, sjrq, jdjds, khdm, xzbz, yjly)"
				+ " values( "
				+ " to_date(:jsrq,'yyyymmddhh24miss'), :fdid, :zbtm, :yjtm, "
				+ " :sjjgs, :sjjsf, :pyjgs, :pyjsf, :yldm, :yljb, :ylzl, "
				+ " :ldlsh, :gls, :fcz, :jsz, :yjzl, :zl, :jhzl, :sjjdm, "
				+ " :sjjds, :sjjxs, :pyj, :pyjds, :pyjxs, :syfl, :bcfl, "
				+ " :syf, :bcf, :hbbh, :zlsx, :jssx, :yjsl, :zbzl, :lhbz, "
				+ " :id, :yjjdm, :jdjdm, :jdjsf, :ypdj, :info, "
				+ " to_date(:sjrq,'yyyymmddhh24miss'), :jdjds, :khdm, :xzbz, :yjly)";
		Map<String, Object> paramMap = new HashMap<String, Object>();
		for (JsYsxxHkfyDay o : result) {
			paramMap.clear();
			paramMap.put("jsrq",o.getJsrq());
			paramMap.put("fdid",o.getFdid());
			paramMap.put("zbtm",o.getZbtm());
			paramMap.put("yjtm",o.getYjtm());
			paramMap.put("sjjgs",o.getSjjgs());
			paramMap.put("sjjsf",o.getSjjsf());
			paramMap.put("pyjgs",o.getPyjgs());
			paramMap.put("pyjsf",o.getPyjsf());
			paramMap.put("yldm",o.getYldm());
			paramMap.put("yljb",o.getYljb());
			paramMap.put("ylzl",o.getYlzl());
			paramMap.put("ldlsh",o.getLdlsh());
			paramMap.put("gls",o.getGls());
			paramMap.put("fcz",o.getFcz());
			paramMap.put("jsz",o.getJsz());
			paramMap.put("yjzl",o.getYjzl());
			paramMap.put("zl",o.getZl());
			paramMap.put("jhzl",o.getJhzl());
			paramMap.put("sjjdm",o.getSjjdm());
			paramMap.put("sjjds",o.getSjjds());
			paramMap.put("sjjxs",o.getSjjxs());
			paramMap.put("pyj",o.getPyj());
			paramMap.put("pyjds",o.getPyjds());
			paramMap.put("pyjxs",o.getPyjxs());
			paramMap.put("syfl",o.getSyfl());
			paramMap.put("bcfl",o.getBcfl());
			paramMap.put("syf",o.getSyf());
			paramMap.put("bcf",o.getBcf());
			paramMap.put("hbbh",o.getHbbh());
			paramMap.put("zlsx",o.getZlsx());
			paramMap.put("jssx",o.getJssx());
			paramMap.put("yjsl",o.getYjsl());
			paramMap.put("zbzl",o.getZbzl());
			paramMap.put("lhbz",o.getLhbz());
			paramMap.put("id",o.getId());
			paramMap.put("yjjdm",o.getYjjdm());
			paramMap.put("jdjdm",o.getJdjdm());
			paramMap.put("jdjsf",o.getJdjsf());
			paramMap.put("ypdj",o.getYpdj());
			paramMap.put("info",o.getInfo());
			paramMap.put("sjrq",o.getSjrq());
			paramMap.put("jdjds",o.getJdjds());
			paramMap.put("khdm",o.getKhdm());
			paramMap.put("xzbz",o.getXzbz());
			paramMap.put("yjly",o.getYjly());
			this.genericDao.updateSql(sql, paramMap);
		}

		Monitor monitor = new Monitor();
		monitor.setQsrq(result.get(0).getJsrq());
		monitor.setZzrq(monitor.getZzrq());
		monitor.setTabname("JS_YSXX_HKFY_DAY");
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
/*
	@Override
	public void doSaveZfgkzfywl(List<Zfgkzfywl> result) {
		if (result == null || result.isEmpty()) {
			return;
		}
		String sql = "merge into zfgk_zf_ywl_day a"
				+ " using dual b"
				+ " on ("
				+ " a.jsrq = to_date(:jsrq,'yyyymmddhh24miss') "
				+ " and a.sjjdm	= :sjjdm"
				+ " and a.jdjds = :jdjds"
				+ " and a.sjjgs = :sjjgs"
				+ " and a.khbm = :khbm"
				+ " and a.yjzldm = :yjzldm"
				+ " )"
				+ " when NOT MATCHED then"
				+ " insert ("
				+ " jsrq, sjjgs, sjjsf, sjjds, sjjxs, sjjdm, jdjsf, "
				+ " jdjds, khbm, yjzldm, js, jfzl, zzf, yhje, hyyg_zf, "
				+ " hyyg_ywl, qyyg_zf, qyyg_ywl, yhyg_zf, yhyg_ywl, "
				+ " mhyg_zf, mhyg_ywl, ck_ly_snys_zf, ck_ly_snys_ywl, "
				+ " ck_hk_snys_zf, ck_hk_snys_ywl, jk_ly_snys_zf, "
				+ " jk_ly_snys_ywl, jk_hk_snys_zf, jk_hk_snys_ywl, "
				+ " ck_nbcl_zf, ck_nbcl_ywl, jk_nbcl_zf, jk_nbcl_ywl, "
				+ " zbzy_zf, zbzy_ywl, sjzy_zf, sjzy_ywl, td_zf, td_ywl, jszchj)"
				+ " values( "
				+ " to_date(:jsrq,'yyyymmddhh24miss'),:sjjgs, :sjjsf, :sjjds, "
				+ " :sjjxs, :sjjdm, :jdjsf, :jdjds, :khbm, :yjzldm, :js, :jfzl, "
				+ " :zzf, :yhje, :hyyg_zf, :hyyg_ywl, :qyyg_zf, :qyyg_ywl, "
				+ " :yhyg_zf, :yhyg_ywl, :mhyg_zf, :mhyg_ywl, :ck_ly_snys_zf, "
				+ " :ck_ly_snys_ywl, :ck_hk_snys_zf, :ck_hk_snys_ywl, :jk_ly_snys_zf, "
				+ " :jk_ly_snys_ywl, :jk_hk_snys_zf, :jk_hk_snys_ywl, :ck_nbcl_zf, "
				+ " :ck_nbcl_ywl, :jk_nbcl_zf, :jk_nbcl_ywl, :zbzy_zf, :zbzy_ywl, "
				+ " :sjzy_zf, :sjzy_ywl, :td_zf, :td_ywl, :jszchj)";
		Map<String, Object> paramMap = new HashMap<String, Object>();
		for (Zfgkzfywl o : result) {
			paramMap.clear();
			
			paramMap.put("jsrq",o.getJsrq());
			paramMap.put("sjjgs",o.getSjjgs());
			paramMap.put("sjjsf",o.getSjjsf());
			paramMap.put("sjjds",o.getSjjds());
			paramMap.put("sjjxs",o.getSjjxs());
			paramMap.put("sjjdm",o.getSjjdm());
			paramMap.put("jdjsf",o.getJdjsf());
			paramMap.put("jdjds",o.getJdjds());
			paramMap.put("khbm",o.getKhbm());
			paramMap.put("yjzldm",o.getYjzldm());
			paramMap.put("js",o.getJs());
			paramMap.put("jfzl",o.getJfzl());
			paramMap.put("zzf",o.getZzf());
			paramMap.put("yhje",o.getYhje());
			paramMap.put("hyyg_zf",o.getHyyg_zf());
			paramMap.put("hyyg_ywl",o.getHyyg_ywl());
			paramMap.put("qyyg_zf",o.getQyyg_zf());
			paramMap.put("qyyg_ywl",o.getQyyg_ywl());
			paramMap.put("yhyg_zf",o.getYhyg_zf());
			paramMap.put("yhyg_ywl",o.getYhyg_ywl());
			paramMap.put("mhyg_zf",o.getMhyg_zf());
			paramMap.put("mhyg_ywl",o.getMhyg_ywl());
			paramMap.put("ck_ly_snys_zf",o.getCk_ly_snys_zf());
			paramMap.put("ck_ly_snys_ywl",o.getCk_ly_snys_ywl());
			paramMap.put("ck_hk_snys_zf",o.getCk_hk_snys_zf());
			paramMap.put("ck_hk_snys_ywl",o.getCk_hk_snys_ywl());
			paramMap.put("jk_ly_snys_zf",o.getJk_ly_snys_zf());
			paramMap.put("jk_ly_snys_ywl",o.getJk_ly_snys_ywl());
			paramMap.put("jk_hk_snys_zf",o.getJk_hk_snys_zf());
			paramMap.put("jk_hk_snys_ywl",o.getJk_hk_snys_ywl());
			paramMap.put("ck_nbcl_zf",o.getCk_nbcl_zf());
			paramMap.put("ck_nbcl_ywl",o.getCk_nbcl_ywl());
			paramMap.put("jk_nbcl_zf",o.getJk_nbcl_zf());
			paramMap.put("jk_nbcl_ywl",o.getJk_nbcl_ywl());
			paramMap.put("zbzy_zf",o.getZbzy_zf());
			paramMap.put("zbzy_ywl",o.getZbzy_ywl());
			paramMap.put("sjzy_zf",o.getSjzy_zf());
			paramMap.put("sjzy_ywl",o.getSjzy_ywl());
			paramMap.put("td_zf",o.getTd_zf());
			paramMap.put("td_ywl",o.getTd_ywl());
			paramMap.put("jszchj",o.getJszchj());

			this.genericDao.updateSql(sql, paramMap);
		}

		Monitor monitor = new Monitor();
		monitor.setQsrq(result.get(0).getJsrq());
		monitor.setZzrq(monitor.getZzrq());
		monitor.setTabname("ZFGK_ZF_YWL_DAY");
		monitor.setSuccessrecords(result.size());
		try {
			this.saveMonitor(monitor);
		} catch (SQLException ex) {

		} catch (DataAccessException ex) {

		}
	}

	@Override
	public void doSaveYjsFkhzcmxb(List<YjsFkhzcmxb> result) {
		if (result == null || result.isEmpty()) {
			return;
		}
		String sql = "merge into YJS_FKHZCFYMXB a"
				+ " using dual b"
				+ " on ("
				+ " a.sjrq = to_date(:sjrq,'yyyymmddhh24miss') "
				+ " and a.sjjsf=:sjjsf and a.sjjdm=:sjjdm"
				+ " and a.khbm=:khbm and a.jdjds=:jdjds and a.yjtm=:yjtm "
				+ " and a.yjly=:yjly and a.zzf=:zzf and a.yjzl=:yjzl "
				+ " )"
				+ " when NOT MATCHED then"
				+ " insert ("
				+ " sjrq, sjjgs, sjjsf, sjjds, sjjxs, sjjdm, yjly, "
				+ " khbm, jdjsf, jdjds, yjtm, yjzl, jfzl, zzf, yhje, "
				+ " ysfy, nbclfy, zyfy, tdfy, hj, yjbz )"
				+ " values ("
				+ " to_date(:jsrq,'yyyymmddhh24miss'), "
				+ " :sjjgs, :sjjsf, :sjjds, :sjjxs, :sjjdm, :yjly, "
				+ " :khbm, :jdjsf, :jdjds, :yjtm, :yjzl, :jfzl, :zzf, "
				+ " :yhje, :ysfy, :nbclfy, :zyfy, :tdfy, :hj, :yjbz )";
		Map<String, Object> paramMap = new HashMap<String, Object>();
		for (YjsFkhzcmxb o : result) {
			paramMap.clear();
			
			paramMap.put("sjrq",o.getSjrq());
			paramMap.put("sjjgs",o.getSjjgs());
			paramMap.put("sjjsf",o.getSjjsf());
			paramMap.put("sjjds",o.getSjjds());
			paramMap.put("sjjxs",o.getSjjxs());
			paramMap.put("sjjdm",o.getSjjdm());
			paramMap.put("yjly",o.getYjly());
			paramMap.put("khbm",o.getKhbm());
			paramMap.put("jdjsf",o.getJdjsf());
			paramMap.put("jdjds",o.getJdjds());
			paramMap.put("yjtm",o.getYjtm());
			paramMap.put("yjzl",o.getYjzl());
			paramMap.put("jfzl",o.getJfzl());
			paramMap.put("zzf",o.getZzf());
			paramMap.put("yhje",o.getYhje());
			paramMap.put("ysfy",o.getYsfy());
			paramMap.put("nbclfy",o.getNbclfy());
			paramMap.put("zyfy",o.getZyfy());
			paramMap.put("tdfy",o.getTdfy());
			paramMap.put("hj",o.getHj());
			paramMap.put("yjbz",o.getYjbz());

			
			this.genericDao.updateSql(sql, paramMap);
		}

		Monitor monitor = new Monitor();
		monitor.setQsrq(result.get(0).getSjrq());
		monitor.setZzrq(monitor.getZzrq());
		monitor.setTabname("YJS_FKHZCFYMXB");
		monitor.setSuccessrecords(result.size());
		try {
			this.saveMonitor(monitor);
		} catch (SQLException ex) {

		} catch (DataAccessException ex) {

		}
	}*/

}
