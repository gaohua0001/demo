package com.dvt.snjs.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.dvt.core.dao.springjdbc.GenericDao;
import com.dvt.snjs.dubbo.model.JsYsxxDay;
import com.dvt.snjs.dubbo.model.JsYsxxHkfyDay;
import com.dvt.snjs.dubbo.model.SnjsJkxxb;
import com.dvt.snjs.dubbo.model.Tzbjsbhk;
import com.dvt.snjs.dubbo.model.Tzbjsbly;
import com.dvt.snjs.dubbo.model.YjsFkhzcmxb;
import com.dvt.snjs.dubbo.model.Zfgkzfywl;
import com.dvt.snjs.service.YsxxService;
import com.dvt.snjs.util.JscppUtil;

public class YsxxServiceImpl implements YsxxService {
	
	private GenericDao genericDao;

	public void setGenericDao(GenericDao genericDao) {
		this.genericDao = genericDao;
	}

	@Override
	public List<JsYsxxDay> getYsxx(String sfdm) {
		String sql = "select "
				+ " to_char(jsrq,'yyyymmddhh24miss') jsrq, "
				+ " yjtm, sjjgs, sjjsf, pyjgs, "
				+ " pyjsf, fcz, fdid, zbtm, yldm, yljb, "
				+ " ylzl, ldlsh, gls, jsz, yjzl, sjjdm, "
				+ " sjjds, sjjxs, pyj, pyjds, pyjxs, syfl, "
				+ " bcfl, syf, bcf, zl, jhzl, hbbh, zlsx, "
				+ " jssx, yjsl, zbzl, lhbz, id, yjjdm, jdjdm, "
				+ " ypdj, info, to_char(sjrq,'yyyymmddhh24miss') sjrq, "
				+ " jdjsf, jdjds, khdm, xzbz, yjly"
				+ " from sn_js_ysxx_day"
				+ " where sfdm=:sfdm"
				+ " and rownum<" + JscppUtil.rownum;
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("sfdm", sfdm);
		return this.genericDao.getList(sql, paramMap, ysxxRowMapper);
	}

	@Override
	public void doDeleteYsxx(String sfdm, List<JsYsxxDay> result) {
		if(result == null || result.isEmpty()) {
			return;
		}
		String sql = "delete /*+index(a SN_JS_YSXX_DAY_IND2)*/ from sn_js_ysxx_day a"
				+ " where yjtm=:yjtm"
				+ " and bcf=:bcf"
				+ " and sfdm=:sfdm"
				+ " and yldm=:yldm"
				+ " and jsrq=to_date(:jsrq,'yyyymmddhh24miss')"
				+ " and pyj=:pyj"
				+ " and fcz=:fcz";
		Map<String, Object> paramMap = new HashMap<String, Object>();
		for(JsYsxxDay o : result) {
			paramMap.clear();
			paramMap.put("yjtm", o.getYjtm());
			paramMap.put("bcf", o.getBcf());
			paramMap.put("sfdm", sfdm);
			paramMap.put("yldm", o.getYldm());
			paramMap.put("jsrq", o.getJsrq());
			paramMap.put("pyj", o.getPyj());
			paramMap.put("fcz", o.getFcz());
			this.genericDao.updateSql(sql, paramMap);
		}
	}

	@Override
	public List<JsYsxxHkfyDay> getHkxx(String sfdm) {
		String sql = "select "
				+ " to_char(jsrq,'yyyymmddhh24miss') jsrq, "
				+ " fdid, zbtm, yjtm, sjjgs, "
				+ " sjjsf, pyjgs, pyjsf, yldm, yljb, ylzl, "
				+ " ldlsh, gls, fcz, jsz, yjzl, zl, jhzl, "
				+ " sjjdm, sjjds, sjjxs, pyj, pyjds, pyjxs, "
				+ " syfl, bcfl, syf, bcf, hbbh, zlsx, jssx, "
				+ " yjsl, zbzl, lhbz, id, yjjdm, jdjdm, jdjsf, "
				+ " ypdj, info, to_char(sjrq,'yyyymmddhh24miss') sjrq, "
				+ " jdjds, khdm, xzbz, yjly "
				+ " from sn_js_ysxx_hkfy_day"
				+ " where sfdm=:sfdm"
				+ " and rownum<" + JscppUtil.rownum;
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("sfdm", sfdm);
		return this.genericDao.getList(sql, paramMap, hkfyRowMapper);
	}

	@Override
	public void doDeleteHkxx(String sfdm, List<JsYsxxHkfyDay> result) {
		if(result == null || result.isEmpty()) {
			return;
		}
		String sql = "delete /*+index(a SN_JS_YSXX_HKFY_DAY_IND2)*/ from sn_js_ysxx_hkfy_day a"
				+ " where yjtm=:yjtm"
				+ " and yldm=:yldm"
				+ " and fcz=:fcz"
				+ " and sfdm=:sfdm"
				+ " and bcf=:bcf"
				+ " and jsrq=to_date(:jsrq,'yyyymmddhh24miss')"
				+ " and pyj=:pyj";
		Map<String, Object> paramMap = new HashMap<String, Object>();
		for(JsYsxxHkfyDay o : result) {
			paramMap.clear();
			paramMap.put("yjtm", o.getYjtm());
			paramMap.put("yldm", o.getYldm());
			paramMap.put("sfdm", sfdm);
			paramMap.put("fcz", o.getFcz());
			paramMap.put("bcf", o.getBcf());
			paramMap.put("jsrq", o.getJsrq());
			paramMap.put("pyj", o.getPyj());
			this.genericDao.updateSql(sql, paramMap);
		}
	}

	@Override
	public List<SnjsJkxxb> doGetSnjsJkxxb(String sfdm) {
		String sql = "call SN_DATA_JKXX_DAY(:sfdm)";
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("sfdm", sfdm);
		this.genericDao.updateSql(sql, paramMap);
		
		sql = "select to_char(jsrq,'yyyymmdd') jsrq,tabname,xfbz,sfdm,"
				+ " to_char(xfsj,'yyyymmddhh24miss') xfsj,"
				+ " '03' xtly"
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

	@Override
	public List<Tzbjsbly> getTzbjsbly(String sfdm) {
		String sql = "select "
				+ " to_char(jsrq,'yyyymmddhh24miss') jsrq,yjtm,"
				+ " sjjgs,sjjsf,pyjgs,pyjsf,fcz,fdid,zbtm,yldm,yljb,"
				+ " ylzl,ldlsh,gls,jsz,yjzl,sjjdm,sjjds,sjjxs,pyj,"
				+ " pyjds,pyjxs,syfl,bcfl,syf,bcf,zl,jhzl,hbbh,zlsx,"
				+ " jssx,yjsl,zbzl,lhbz,id,yjjdm,jdjdm,ypdj,info,"
				+ " to_char(sjrq,'yyyymmddhh24miss') sjrq,"
				+ " jdjsf,jdjds,khdm,xzbz,yjly"
				+ " from sn_ac_pfysxx_day"
				+ " where sfdm=:sfdm"
				+ " and rownum<" + JscppUtil.rownum;
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("sfdm", sfdm);
		return this.genericDao.getList(sql, paramMap, tzbjslyRowMapper);
	}

	@Override
	public void doDeleteTzbjsbly(String sfdm, List<Tzbjsbly> result) {
		if(result == null || result.isEmpty()) {
			return;
		}
		String sql = "delete /*+index(a SN_AC_PFYSXX_DAY_IND2)*/"
				+ " from SN_AC_PFYSXX_DAY a"
				+ " where yjtm=:yjtm"
				+ " and yldm=:yldm"
				+ " and pyj = :pyj "
				+ " and fcz = :fcz "
				+ " and bcf = :bcf "
				+ " and jsrq=to_date(:jsrq,'yyyymmddhh24miss')"
				+ " and sfdm=:sfdm";
		Map<String, Object> paramMap = new HashMap<String, Object>();
		for(Tzbjsbly o : result) {
			paramMap.clear();
			paramMap.put("yjtm", o.getYjtm());
			paramMap.put("yldm", o.getYldm());
			paramMap.put("pyj", o.getPyj());
			paramMap.put("sfdm", sfdm);
			paramMap.put("jsrq", o.getJsrq());
			paramMap.put("fcz", o.getFcz());
			paramMap.put("bcf", o.getBcf());
			this.genericDao.updateSql(sql, paramMap);
		}
	}

	@Override
	public List<Tzbjsbhk> getTzbjsbhk(String sfdm) {
		String sql = "select "
				+ " to_char(jsrq,'yyyymmddhh24miss') jsrq, "
				+ " fdid, zbtm, yjtm, sjjgs, sjjsf, "
				+ " pyjgs, pyjsf, yldm, yljb, ylzl, ldlsh, "
				+ " gls, fcz, jsz, yjzl, zl, jhzl, sjjdm, "
				+ " sjjds, sjjxs, pyj, pyjds, pyjxs, syfl, "
				+ " bcfl, syf, bcf, hbbh, zlsx, jssx, yjsl, "
				+ " zbzl, lhbz, id, yjjdm, jdjdm, jdjsf, ypdj, "
				+ " info, to_char(sjrq,'yyyymmddhh24miss') sjrq, "
				+ " jdjds, khdm, xzbz, yjly "
				+ " from sn_ac_pfysxx_hkfy_day"
				+ " where sfdm=:sfdm"
				+ " and rownum<" + JscppUtil.rownum;
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("sfdm", sfdm);
		return this.genericDao.getList(sql, paramMap, tzbjslyhkRowMapper);
	}

	@Override
	public void doDeleteTzbjsbhk(String sfdm, List<Tzbjsbhk> backlist) {
		if(backlist == null || backlist.isEmpty()) {
			return;
		}
		String sql = "delete /*+index(a SN_AC_PFYSXX_HKFY_DAY_IND2)*/"
				+ " from sn_ac_pfysxx_hkfy_day a"
				+ " where yjtm=:yjtm"
				+ " and yldm=:yldm"
				+ " and pyj = :pyj "
				+ " and fcz = :fcz "
				+ " and bcf = :bcf "
				+ " and jsrq=to_date(:jsrq,'yyyymmddhh24miss') "
				+ " and sfdm=:sfdm";
		Map<String, Object> paramMap = new HashMap<String, Object>();
		for(Tzbjsbhk o : backlist) {
			paramMap.clear();
			paramMap.put("yjtm", o.getYjtm());
			paramMap.put("yldm", o.getYldm());
			paramMap.put("pyj", o.getPyj());
			paramMap.put("sfdm", sfdm);
			paramMap.put("jsrq", o.getJsrq());
			paramMap.put("bcf", o.getBcf());
			paramMap.put("fcz", o.getFcz());
			this.genericDao.updateSql(sql, paramMap);
		}
	}
/*
	@Override
	public List<Zfgkzfywl> getZfgkzfywl(String sfdm) {
		String sql = "select "
				+ " to_char(jsrq,'yyyymmddhh24miss') jsrq, sjjgs, "
				+ " sjjsf, sjjds, sjjxs, sjjdm, jdjsf, jdjds, khbm, "
				+ " yjzldm, js, jfzl, zzf, yhje, hyyg_zf, hyyg_ywl, "
				+ " qyyg_zf, qyyg_ywl, yhyg_zf, yhyg_ywl, mhyg_zf, "
				+ " mhyg_ywl, ck_ly_snys_zf, ck_ly_snys_ywl, ck_hk_snys_zf, "
				+ " ck_hk_snys_ywl, jk_ly_snys_zf, jk_ly_snys_ywl, jk_hk_snys_zf, "
				+ " jk_hk_snys_ywl, ck_nbcl_zf, ck_nbcl_ywl, jk_nbcl_zf, jk_nbcl_ywl, "
				+ " zbzy_zf, zbzy_ywl, sjzy_zf, sjzy_ywl, td_zf, td_ywl, jszchj "
				+ " from sn_zfgk_zf_ywl_day"
				+ " where sfdm=:sfdm"
				+ " and rownum<" + JscppUtil.rownum;
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("sfdm", sfdm);
		return this.genericDao.getList(sql, paramMap, zfgkzfywlRowMapper);
	}
*/
	
//	@Override
//	public void doDeleteZfgkzfywl(String sfdm, List<Zfgkzfywl> backlist) {
//		if(backlist == null || backlist.isEmpty()) {
//			return;
//		}
//		String sql = "delete /*+index(a SN_ZFGK_ZF_YWL_DAY)*/"
//				+ " from SN_ZFGK_ZF_YWL_DAY a"
//				+ " and jsrq=to_date(:jsrq,'yyyymmddhh24miss') "
//				+ " and sfdm=:sfdm"
//				+ " and jdjds=:jdjds"
//				+ " and sjjgs=:sjjgs"
//				+ " and khbm=:khbm"
//				+ " and yjzldm=:yjzldm"
//				+ " and sjjdm=:sjjdm";
//		Map<String, Object> paramMap = new HashMap<String, Object>();
//		for(Zfgkzfywl o : backlist) {
//			paramMap.clear();
//			paramMap.put("sfdm", sfdm);
//			paramMap.put("jsrq", o.getJsrq());
//			paramMap.put("jdjds", o.getJdjds());
//			paramMap.put("sjjgs", o.getSjjgs());
//			paramMap.put("khbm", o.getKhbm());
//			paramMap.put("yjzldm", o.getYjzldm());
//			paramMap.put("sjjdm", o.getSjjdm());
//			this.genericDao.updateSql(sql, paramMap);
//		}
//	}
/*
	@Override
	public List<YjsFkhzcmxb> getYjsFkhzcmxb(String sfdm) {
		String sql = "select "
				+ " to_char(jsrq,'yyyymmddhh24miss')sjrq, "
				+ " sjjgs, sjjsf, sjjds, sjjxs, sjjdm, yjly, "
				+ " khbm, jdjsf, jdjds, yjtm, yjzl, jfzl, zzf, "
				+ " yhje, ysfy, nbclfy, zyfy, tdfy, hj, yjbz "
				+ " from sn_yjs_fkhzcfymxb"
				+ "	where sfdm = :sfdm"
				+ " and rownum<" + JscppUtil.rownum;
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("sfdm", sfdm);
		return this.genericDao.getList(sql, paramMap, yjsFkhzcmxbRowMapper);
	}
*/
//	
//	@Override
//	public void doDeleteYjsFkhzcmxb(String sfdm, List<YjsFkhzcmxb> backlist) {
//		if(backlist == null || backlist.isEmpty()) {
//			return;
//		}
//		String sql = "delete /*+index(a sn_yjs_fkhzcfymxb)*/"
//				+ " from sn_yjs_fkhzcfymxb a"
//				+ " and jsrq=to_date(:jsrq,'yyyymmddhh24miss') "
//				+ " and sfdm=:sfdm";
//		Map<String, Object> paramMap = new HashMap<String, Object>();
//		for(YjsFkhzcmxb o : backlist) {
//			paramMap.clear();
//			paramMap.put("sfdm", sfdm);
//			paramMap.put("sjrq", o.getSjrq());
//			paramMap.put("sjjsf", o.getSjjsf());
//			paramMap.put("sjjdm", o.getSjjdm());
//			paramMap.put("khbm", o.getKhbm());
//			paramMap.put("jdjds", o.getJdjds());
//			paramMap.put("yjtm", o.getYjtm());
//			paramMap.put("yjly", o.getYjly());
//			paramMap.put("zzf", o.getZzf());
//			paramMap.put("yjzl", o.getYjzl());
//			this.genericDao.updateSql(sql, paramMap);
//		}
//	}

	
}
