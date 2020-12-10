package com.dvt.snjs.service.impl;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.dvt.core.exception.CommonException;
import com.dvt.snjs.app.DataTask;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.dao.DataAccessException;

import com.dvt.core.dao.springjdbc.GenericDao;
import com.dvt.snjs.dubbo.model.AcJcYlxxb;
import com.dvt.snjs.dubbo.model.AcJcZxxxb;
import com.dvt.snjs.dubbo.model.Monitor;
import com.dvt.snjs.dubbo.model.Tzbjsbhk;
import com.dvt.snjs.dubbo.model.Tzbjsbly;
import com.dvt.snjs.dubbo.model.ZdjsGjyjxxDay;
import com.dvt.snjs.dubbo.model.ZdjsGjyjxxKsjzDay;
import com.dvt.snjs.dubbo.model.ZdjsPcyjxxDay;
import com.dvt.snjs.dubbo.model.ZdjsSjzyDay;
import com.dvt.snjs.service.GxjsService;

public class GxjsServiceImpl extends AbstractMonitor implements GxjsService {
	
	private GenericDao genericDao;
	private static Log log = LogFactory.getLog(DataTask.class);
	public void setGenericDao(GenericDao genericDao) {
		this.genericDao = genericDao;
	}
	
	public GenericDao getGenericDao() {
		return genericDao;
	}

	@Override
	public void doSaveTzbjsly(List<Tzbjsbly> result) {
		if(result == null || result.isEmpty()) {
			return;
		}
		String sql = "merge into AC_PFYSXX_DAY a"
				+ " using dual b"
				+ " on (a.yjtm=:yjtm "
				+ " and a.yldm = :yldm "
				+ " and a.pyj = :pyj "
				+ " and a.fcz = :fcz "
				+ " and a.jsrq=to_date(:jsrq,'yyyymmddhh24miss'))"
				+ " when NOT MATCHED then"
				+ " insert ("
				+ " jsrq, yjtm, sjjgs, sjjsf, pyjgs, pyjsf, fcz,"
				+ " fdid, zbtm, yldm, yljb, ylzl, ldlsh, gls, jsz,"
				+ " yjzl, sjjdm, sjjds, sjjxs, pyj, pyjds, pyjxs,"
				+ " syfl, bcfl, syf, bcf, zl, jhzl, hbbh, zlsx,"
				+ " jssx, yjsl, zbzl, lhbz, id, yjjdm, jdjdm, ypdj,"
				+ " info, sjrq, jdjsf, jdjds, khdm, xzbz, yjly)"
				+ " values( "
				+ " to_date(:jsrq,'yyyymmddhh24miss') ,:yjtm,:sjjgs,"
				+ " :sjjsf,:pyjgs,:pyjsf,:fcz,:fdid,:zbtm,:yldm,:yljb,"
				+ " :ylzl,:ldlsh,:gls,:jsz,:yjzl,:sjjdm,:sjjds,:sjjxs,"
				+ " :pyj,:pyjds,:pyjxs,:syfl,:bcfl,:syf,:bcf,:zl,:jhzl,"
				+ " :hbbh,:zlsx,:jssx,:yjsl,:zbzl,:lhbz,:id,:yjjdm,"
				+ " :jdjdm,:ypdj,:info,to_date(:sjrq,'yyyymmddhh24miss'),"
				+ " :jdjsf,:jdjds,:khdm,:xzbz,:yjly)";
		Map<String, Object> paramMap = new HashMap<String, Object>();
		for(Tzbjsbly o : result) {
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
		monitor.setZzrq(monitor.getQsrq());
		monitor.setTabname("AC_PFYSXX_DAY");
		monitor.setSuccessrecords(result.size());
		try {
			this.saveMonitor(monitor);
		} catch(SQLException ex) {
			
		} catch(DataAccessException ex) {
			
		}
	}

	@Override
	public void doSaveZdjsGjyj(List<ZdjsGjyjxxDay> result) {
		if (result == null || result.isEmpty()) {
			return;
		}
		String sql = "merge into SJCLF_GJYJXX_DAY a" 
				+ " using dual b" 
				+ " on (a.yjtm=:yjtm" 
				+ " and a.sjjdm = :sjjdm"
				+ " and a.jsrq=to_date(:jsrq,'yyyymmddhh24miss'))" 
				+ " when NOT MATCHED then" 
				+ " insert ("
				+ " jsrq, yjtm, yjzldm, cpbh, sscj, sjjdm, jdjdm," 
				+ " yjzl, sjsf, sjds, sjxs, jdsf, jdds, jdxs, jhzl,"
				+ " jsfl1, jsfl2, jsf, bcfl1, bcfl2, bcf, info)" 
				+ " values( " 
				+ " to_date(:jsrq,'yyyymmddhh24miss'),"
				+ ":yjtm,:yjzldm,:cpbh,:sscj,:sjjdm,:jdjdm," 
				+ " :yjzl,:sjsf,:sjds,:sjxs,:jdsf,:jdds,:jdxs,:jhzl,"
				+ " :jsfl1,:jsfl2,:jsf,:bcfl1,:bcfl2,:bcf,:info)";
		Map<String, Object> paramMap = new HashMap<String, Object>();
		for (ZdjsGjyjxxDay o : result) {
			paramMap.clear();
			paramMap.put("jsrq", o.getJsrq());
			paramMap.put("yjtm", o.getYjtm());
			paramMap.put("yjzldm", o.getYjzldm());
			paramMap.put("cpbh", o.getCpbh());
			paramMap.put("sscj", o.getSscj());
			paramMap.put("sjjdm", o.getSjjdm());
			paramMap.put("jdjdm", o.getJdjdm());
			paramMap.put("yjzl", o.getYjzl());
			paramMap.put("sjsf", o.getSjsf());
			paramMap.put("sjds", o.getSjds());
			paramMap.put("sjxs", o.getSjxs());
			paramMap.put("jdsf", o.getJdsf());
			paramMap.put("jdds", o.getJdds());
			paramMap.put("jdxs", o.getJdxs());
			paramMap.put("jhzl", o.getJhzl());
			paramMap.put("jsfl1", o.getJsfl1());
			paramMap.put("jsfl2", o.getJsfl2());
			paramMap.put("jsf", o.getJsf());
			paramMap.put("bcfl1", o.getBcfl1());
			paramMap.put("bcfl2", o.getBcfl2());
			paramMap.put("bcf", o.getBcf());
			paramMap.put("info", o.getInfo());

			this.genericDao.updateSql(sql, paramMap);
		}

		Monitor monitor = new Monitor();
		monitor.setQsrq(result.get(0).getJsrq());
		monitor.setZzrq(monitor.getZzrq());
		monitor.setTabname("SJCLF_GJYJXX_DAY");
		monitor.setSuccessrecords(result.size());
		try {
			this.saveMonitor(monitor);
		} catch (SQLException ex) {

		} catch (DataAccessException ex) {

		}
	}

	@Override
	public void doSaveZdjsKsjz(List<ZdjsGjyjxxKsjzDay> result) {
		if (result == null || result.isEmpty()) {
			return;
		}
		String sql = "merge into SJCLF_GJYJKSJZ_DAY a" 
				+ " using dual b" 
				+ " on (a.yjtm=:yjtm" 
				+ " and a.sjjdm = :sjjdm"
				+ " and a.jsrq=to_date(:jsrq,'yyyymmddhh24miss'))" 
				+ " when NOT MATCHED then" 
				+ " insert ("
				+ " jsrq, yjtm, yjzldm, cpbh, sscj, sjjdm, jdjdm, "
				+ " yjzl, sjsf, sjds, sjxs, jdsf, jdds, jhzl, jsfl, " 
				+ " jsf, bcfl, bcf, jsds, bcds, info)"
				+ " values( " + " to_date(:jsrq,'yyyymmddhh24miss') ,:yjtm,"
				+ " :yjzldm,:cpbh,:sscj,:sjjdm,:jdjdm,:yjzl," 
				+ " :sjsf,:sjds,:sjxs,:jdsf,:jdds,:jhzl,:jsfl,"
				+ " :jsf,:bcfl,:bcf,:jsds,:bcds,:info)";
		Map<String, Object> paramMap = new HashMap<String, Object>();
		for (ZdjsGjyjxxKsjzDay o : result) {
			paramMap.clear();
			paramMap.put("jsrq", o.getJsrq());
			paramMap.put("yjtm", o.getYjtm());
			paramMap.put("yjzldm", o.getYjzldm());
			paramMap.put("cpbh", o.getCpbh());
			paramMap.put("sscj", o.getSscj());
			paramMap.put("sjjdm", o.getSjjdm());
			paramMap.put("jdjdm", o.getJdjdm());
			paramMap.put("yjzl", o.getYjzl());
			paramMap.put("sjsf", o.getSjsf());
			paramMap.put("sjds", o.getSjds());
			paramMap.put("sjxs", o.getSjxs());
			paramMap.put("jdsf", o.getJdsf());
			paramMap.put("jdds", o.getJdds());
			paramMap.put("jhzl", o.getJhzl());
			paramMap.put("jsfl", o.getJsfl());
			paramMap.put("jsf", o.getJsf());
			paramMap.put("bcfl", o.getBcfl());
			paramMap.put("bcf", o.getBcf());
			paramMap.put("jsds", o.getJsds());
			paramMap.put("bcds", o.getBcds());
			paramMap.put("info", o.getInfo());

			this.genericDao.updateSql(sql, paramMap);
		}

		Monitor monitor = new Monitor();
		monitor.setQsrq(result.get(0).getJsrq());
		monitor.setZzrq(monitor.getZzrq());
		monitor.setTabname("SJCLF_GJYJKSJZ_DAY");
		monitor.setSuccessrecords(result.size());
		try {
			this.saveMonitor(monitor);
		} catch (SQLException ex) {

		} catch (DataAccessException ex) {

		}
	}

	@Override
	public void doSaveZdjsSjzy(List<ZdjsSjzyDay> result) {
		if (result == null || result.isEmpty()) {
			return;
		}
		String sql = "merge into SJCLF_CZKZY_DAY a" 
				+ " using dual b" 
				+ " on (a.fdid=:fdid" 
				+ " and a.zbid = :zbid"
				+ " and a.jsrq=to_date(:jsrq,'yyyymmddhh24miss'))" 
				+ " when NOT MATCHED then" 
				+ " insert ("
				+ " jsrq, fdid, zbid, yldm, ldhm, ldlsh, fcj," 
				+ " jsj, pcdh, zbtm, yjjdm, jdjdm, yjzldm,"
				+ " cpbh, sscj, zbhm, yjjsf, jdjsf, fcjsf," 
				+ " zl, jssf, bcsf, jsfl, bcfl, jsf, bcf)" 
				+ " values( "
				+ " to_date(:jsrq,'yyyymmddhh24miss'),:fdid," 
				+ " :zbid,:yldm,:ldhm,:ldlsh,:fcj,:jsj,:pcdh,"
				+ " :zbtm,:yjjdm,:jdjdm,:yjzldm,:cpbh,:sscj," 
				+ " :zbhm,:yjjsf,:jdjsf,:fcjsf,:zl,:jssf,"
				+ " :bcsf,:jsfl,:bcfl,:jsf,:bcf)";
		Map<String, Object> paramMap = new HashMap<String, Object>();
		for (ZdjsSjzyDay o : result) {
			paramMap.clear();
			paramMap.put("jsrq", o.getJsrq());
			paramMap.put("fdid", o.getFdid());
			paramMap.put("zbid", o.getZbid());
			paramMap.put("yldm", o.getYldm());
			paramMap.put("ldhm", o.getLdhm());
			paramMap.put("ldlsh", o.getLdlsh());
			paramMap.put("fcj", o.getFcj());
			paramMap.put("jsj", o.getJsj());
			paramMap.put("pcdh", o.getPcdh());
			paramMap.put("zbtm", o.getZbtm());
			paramMap.put("yjjdm", o.getYjjdm());
			paramMap.put("jdjdm", o.getJdjdm());
			paramMap.put("yjzldm", o.getYjzldm());
			paramMap.put("cpbh", o.getCpbh());
			paramMap.put("sscj", o.getSscj());
			paramMap.put("zbhm", o.getZbhm());
			paramMap.put("yjjsf", o.getYjjsf());
			paramMap.put("jdjsf", o.getJdjsf());
			paramMap.put("fcjsf", o.getFcjsf());
			paramMap.put("zl", o.getZl());
			paramMap.put("jssf", o.getJssf());
			paramMap.put("bcsf", o.getBcsf());
			paramMap.put("jsfl", o.getJsfl());
			paramMap.put("bcfl", o.getBcfl());
			paramMap.put("jsf", o.getJsf());
			paramMap.put("bcf", o.getBcf());

			this.genericDao.updateSql(sql, paramMap);
		}

		Monitor monitor = new Monitor();
		monitor.setQsrq(result.get(0).getJsrq());
		monitor.setZzrq(monitor.getZzrq());
		monitor.setTabname("SJCLF_CZKZY_DAY");
		monitor.setSuccessrecords(result.size());
		try {
			this.saveMonitor(monitor);
		} catch (SQLException ex) {

		} catch (DataAccessException ex) {

		}
	}

	@Override
	public void doSaveZdjsPcyj(List<ZdjsPcyjxxDay> result) {
		if (result == null || result.isEmpty()) {
			return;
		}
		String sql = "merge into sjclf_pcyjxx_day a" 
				+ " using dual b" 
				+ " on (a.fdid=:fdid" 
				+ " and a.zbid = :zbid"
				+ " and a.jsrq=to_date(:jsrq,'yyyymmddhh24miss'))" 
				+ " when NOT MATCHED then" 
				+ " insert ("
				
				+ " jsrq, fdid, zbid, yldm, ldhm, ldlsh, fcj, "
				+ " jsj, pcdh, zbtm, yjjdm, jdjdm, yjzldm, cpbh, "
				+ " sscj, zbhm, yjjsf, yjjds, jdjsf, jdjds, zl, "
				+ " jhzl, jssf, bcsf, jsfl, bcfl, jsf, bcf)" 
				+ " values("
				+ " to_date(:jsrq,'yyyymmddhh24miss'), :fdid, :zbid, "
				+ " :yldm, :ldhm, :ldlsh, :fcj, :jsj, :pcdh, :zbtm, "
				+ " :yjjdm, :jdjdm, :yjzldm, :cpbh, :sscj, :zbhm, "
				+ " :yjjsf, :yjjds, :jdjsf, :jdjds, :zl, :jhzl, "
				+ " :jssf, :bcsf, :jsfl, :bcfl, :jsf, :bcf)";
		Map<String, Object> paramMap = new HashMap<String, Object>();
		for (ZdjsPcyjxxDay o : result) {
			paramMap.clear();
			paramMap.put("jsrq",o.getJsrq());
			paramMap.put("fdid",o.getFdid());
			paramMap.put("zbid",o.getZbid());
			paramMap.put("yldm",o.getYldm());
			paramMap.put("ldhm",o.getLdhm());
			paramMap.put("ldlsh",o.getLdlsh());
			paramMap.put("fcj",o.getFcj());
			paramMap.put("jsj",o.getJsj());
			paramMap.put("pcdh",o.getPcdh());
			paramMap.put("zbtm",o.getZbtm());
			paramMap.put("yjjdm",o.getYjjdm());
			paramMap.put("jdjdm",o.getJdjdm());
			paramMap.put("yjzldm",o.getYjzldm());
			paramMap.put("cpbh",o.getCpbh());
			paramMap.put("sscj",o.getSscj());
			paramMap.put("zbhm",o.getZbhm());
			paramMap.put("yjjsf",o.getYjjsf());
			paramMap.put("yjjds",o.getYjjds());
			paramMap.put("jdjsf",o.getJdjsf());
			paramMap.put("jdjds",o.getJdjds());
			paramMap.put("zl",o.getZl());
			paramMap.put("jhzl",o.getJhzl());
			paramMap.put("jssf",o.getJssf());
			paramMap.put("bcsf",o.getBcsf());
			paramMap.put("jsfl",o.getJsfl());
			paramMap.put("bcfl",o.getBcfl());
			paramMap.put("jsf",o.getJsf());
			paramMap.put("bcf",o.getBcf());

			this.genericDao.updateSql(sql, paramMap);
		}

		Monitor monitor = new Monitor();
		monitor.setQsrq(result.get(0).getJsrq());
		monitor.setZzrq(monitor.getZzrq());
		monitor.setTabname("SJCLF_PCYJXX_DAY");
		monitor.setSuccessrecords(result.size());
		try {
			this.saveMonitor(monitor);
		} catch (SQLException ex) {

		} catch (DataAccessException ex) {

		}
	}

	@Override
	public void doSaveTzbjshk(List<Tzbjsbhk> result) {
		if(result == null || result.isEmpty()) {
			return;
		}
		String sql = "merge into ac_pfysxx_hkfy_day a"
				+ " using dual b"
				+ " on (a.yjtm=:yjtm "
				+ " and a.yldm = :yldm "
				+ " and a.pyj = :pyj "
				+ " and a.bcf = :bcf "
				+ " and a.fcz = :fcz "
				+ " and a.jsrq=to_date(:jsrq,'yyyymmddhh24miss'))"
				+ " when NOT MATCHED then"
				+ " insert ("
				+ " jsrq, fdid, zbtm, yjtm, sjjgs, sjjsf, pyjgs, "
				+ " pyjsf, yldm, yljb, ylzl, ldlsh, gls, fcz, "
				+ " jsz, yjzl, zl, jhzl, sjjdm, sjjds, sjjxs, "
				+ " pyj, pyjds, pyjxs, syfl, bcfl, syf, bcf, hbbh, "
				+ " zlsx, jssx, yjsl, zbzl, lhbz, id, yjjdm, jdjdm, "
				+ " jdjsf, ypdj, info, sjrq, jdjds, khdm, xzbz, yjly)"
				+ " values( "
				+ " to_date(:jsrq,'yyyymmddhh24miss'), :fdid, :zbtm, :yjtm, "
				+ " :sjjgs, :sjjsf, :pyjgs, :pyjsf, :yldm, :yljb, :ylzl, "
				+ " :ldlsh, :gls, :fcz, :jsz, :yjzl, :zl, :jhzl, :sjjdm, "
				+ " :sjjds, :sjjxs, :pyj, :pyjds, :pyjxs, :syfl, :bcfl, "
				+ " :syf, :bcf, :hbbh, :zlsx, :jssx, :yjsl, :zbzl, :lhbz, "
				+ " :id, :yjjdm, :jdjdm, :jdjsf, :ypdj, :info, "
				+ " to_date(:sjrq,'yyyymmddhh24miss'), :jdjds, :khdm, :xzbz, :yjly)";
		Map<String, Object> paramMap = new HashMap<String, Object>();
		for(Tzbjsbhk o : result) {
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
		monitor.setZzrq(monitor.getQsrq());
		monitor.setTabname("AC_PFYSXX_DAY");
		monitor.setSuccessrecords(result.size());
		try {
			this.saveMonitor(monitor);
		} catch(SQLException ex) {
			
		} catch(DataAccessException ex) {
			
		}
	}

	@Override
	public void doSaveAcJcYlxxb(List<AcJcYlxxb> result) {
		if(result == null || result.isEmpty()) {
			return;
		}
		String selSql = "select count(1) from ac_jc_ylxxb where code=:code";
		String insSql="insert into ac_jc_ylxxb("
				+ " id, linetype, transporttype, code, name, regionlinetype, lineattribute, "
				+ " assigninfo, effectivetime, expirytime, isinternational, islogistics, "
				+ " isexpresscar, settlementtype, runorgcode, runorgname, istemporary, "
				+ " isoutage, ratetonnage, sgsx, pzcs, pcxs, pcts, provincecode, provincename, "
				+ " description, direction, roundtriptype, traintype, schedule, runschedule, "
				+ " fullmileage, linestationsuiteid, returnlineid, status, isrequestmodify, "
				+ " transportlineapprovalid, isdeleted, createuserid, createusercode, createusername, "
				+ " gmtcreated, modifyuserid, modifyusercode, modifyusername, gmtmodified, "
				+ " beginprovincecode, beginssjcode, beginstationcode, departuretime, endprovincecode, "
				+ " endssjcode, endstationcode, arrivetime, returnlinecode, fullruntime)"
				+ " values("
				+ " :id, :linetype, :transporttype, :code, :name, :regionlinetype, :lineattribute, "
				+ " :assigninfo, to_date(:effectivetime,'yyyymmddhh24miss'), to_date(:expirytime,'yyyymmddhh24miss'), :isinternational, :islogistics, "
				+ " :isexpresscar, :settlementtype, :runorgcode, :runorgname, :istemporary, "
				+ " :isoutage, :ratetonnage, :sgsx, :pzcs, :pcxs, :pcts, :provincecode, :provincename, "
				+ " :description, :direction, :roundtriptype, :traintype, :schedule, :runschedule, "
				+ " :fullmileage, :linestationsuiteid, :returnlineid, :status, :isrequestmodify, "
				+ " :transportlineapprovalid, :isdeleted, :createuserid, :createusercode, :createusername, "
				+ " to_date(:gmtcreated,'yyyymmddhh24miss'), :modifyuserid, :modifyusercode, :modifyusername, to_date(:gmtmodified,'yyyymmddhh24miss'), "
				+ " :beginprovincecode, :beginssjcode, :beginstationcode, :departuretime, :endprovincecode, "
				+ " :endssjcode, :endstationcode, :arrivetime, :returnlinecode, :fullruntime)";
		String sql = "update ac_jc_ylxxb set "
				+ "linetype=:linetype, transporttype=:transporttype,  name=:name, " +
				"regionlinetype=:regionlinetype, lineattribute=:lineattribute, "
				+ " assigninfo=:assigninfo, effectivetime=to_date(:effectivetime,'yyyymmddhh24miss')," +
				" expirytime=to_date(:expirytime,'yyyymmddhh24miss')," +
				" isinternational=:isinternational, islogistics=:islogistics, "
				+ " isexpresscar=:isexpresscar, settlementtype=:settlementtype, runorgcode=:runorgcode," +
				" runorgname=:runorgname, istemporary=:istemporary, "
				+ " isoutage=:isoutage, ratetonnage=:ratetonnage, sgsx=:sgsx, pzcs=:pzcs, pcxs=:pcxs, " +
				"pcts=:pcts, provincecode=:provincecode, provincename=:provincename, "
				+ " description=:description, direction=:direction, roundtriptype=:roundtriptype, " +
				"traintype=:traintype, schedule=:schedule, runschedule=runschedule, "
				+ " fullmileage=:fullmileage, linestationsuiteid=:linestationsuiteid, returnlineid=:returnlineid, " +
				"status=:status, isrequestmodify=:isrequestmodify, "
				+ " transportlineapprovalid=:transportlineapprovalid, isdeleted=:isdeleted, createuserid=:createuserid," +
				" createusercode=:createusercode, createusername=:createusername, "
				+ " gmtcreated=to_date(:gmtcreated,'yyyymmddhh24miss'), modifyuserid=:modifyuserid, modifyusercode=:modifyusercode, " +
				"modifyusername=:modifyusername, gmtmodified=to_date(:gmtmodified,'yyyymmddhh24miss'), "
				+ " beginprovincecode=:beginprovincecode, beginssjcode=:beginssjcode, beginstationcode=:beginstationcode, " +
				"departuretime=:beginstationcode, endprovincecode=:endprovincecode, "
				+ " endssjcode=:endssjcode, endstationcode=:endstationcode," +
				" arrivetime=:arrivetime, returnlinecode=:returnlinecode, fullruntime=:fullruntime where  code =:code";
		Map<String, Object> paramMap = new HashMap<String, Object>();
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> insertparamMap = new HashMap<String, Object>();
		for(AcJcYlxxb o : result) {
			paramMap.clear();
			param.clear();
			insertparamMap.clear();
			param.put("code",o.getCode());

			insertparamMap.put("id",o.getId());
			insertparamMap.put("linetype",o.getLinetype());
			insertparamMap.put("transporttype",o.getTransporttype());
			insertparamMap.put("code",o.getCode());
			insertparamMap.put("name",o.getName());
			insertparamMap.put("regionlinetype",o.getRegionlinetype());
			insertparamMap.put("lineattribute",o.getLineattribute());
			insertparamMap.put("assigninfo",o.getAssigninfo());
			insertparamMap.put("effectivetime",o.getEffectivetime());
			insertparamMap.put("expirytime",o.getExpirytime());
			insertparamMap.put("isinternational",o.getIsinternational());
			insertparamMap.put("islogistics",o.getIslogistics());
			insertparamMap.put("isexpresscar",o.getIsexpresscar());
			insertparamMap.put("settlementtype",o.getSettlementtype());
			insertparamMap.put("runorgcode",o.getRunorgcode());
			insertparamMap.put("runorgname",o.getRunorgname());
			insertparamMap.put("istemporary",o.getIstemporary());
			insertparamMap.put("isoutage",o.getIsoutage());
			insertparamMap.put("ratetonnage",o.getRatetonnage());
			insertparamMap.put("sgsx",o.getSgsx());
			insertparamMap.put("pzcs",o.getPzcs());
			insertparamMap.put("pcxs",o.getPcxs());
			insertparamMap.put("pcts",o.getPcts());
			insertparamMap.put("provincecode",o.getProvincecode());
			insertparamMap.put("provincename",o.getProvincename());
			insertparamMap.put("description",o.getDescription());
			insertparamMap.put("direction",o.getDirection());
			insertparamMap.put("roundtriptype",o.getRoundtriptype());
			insertparamMap.put("traintype",o.getTraintype());
			insertparamMap.put("schedule",o.getSchedule());
			insertparamMap.put("runschedule",o.getRunschedule());
			insertparamMap.put("fullmileage",o.getFullmileage());
			insertparamMap.put("linestationsuiteid",o.getLinestationsuiteid());
			insertparamMap.put("returnlineid",o.getReturnlineid());
			insertparamMap.put("status",o.getStatus());
			insertparamMap.put("isrequestmodify",o.getIsrequestmodify());
			insertparamMap.put("transportlineapprovalid",o.getTransportlineapprovalid());
			insertparamMap.put("isdeleted",o.getIsdeleted());
			insertparamMap.put("createuserid",o.getCreateuserid());
			insertparamMap.put("createusercode",o.getCreateusercode());
			insertparamMap.put("createusername",o.getCreateusername());
			insertparamMap.put("gmtcreated",o.getGmtcreated());
			insertparamMap.put("modifyuserid",o.getModifyuserid());
			insertparamMap.put("modifyusercode",o.getModifyusercode());
			insertparamMap.put("modifyusername",o.getModifyusername());
			insertparamMap.put("gmtmodified",o.getGmtmodified());
			insertparamMap.put("beginprovincecode",o.getBeginprovincecode());
			insertparamMap.put("beginssjcode",o.getBeginssjcode());
			insertparamMap.put("beginstationcode",o.getBeginstationcode());
			insertparamMap.put("departuretime",o.getDeparturetime());
			insertparamMap.put("endprovincecode",o.getEndprovincecode());
			insertparamMap.put("endssjcode",o.getEndssjcode());
			insertparamMap.put("endstationcode",o.getEndstationcode());
			insertparamMap.put("arrivetime",o.getArrivetime());
			insertparamMap.put("returnlinecode",o.getReturnlinecode());
			insertparamMap.put("fullruntime",o.getFullruntime());

			paramMap.put("linetype",o.getLinetype());
			paramMap.put("transporttype",o.getTransporttype());
			paramMap.put("code",o.getCode());
			paramMap.put("name",o.getName());
			paramMap.put("regionlinetype",o.getRegionlinetype());
			paramMap.put("lineattribute",o.getLineattribute());
			paramMap.put("assigninfo",o.getAssigninfo());
			paramMap.put("effectivetime",o.getEffectivetime());
			paramMap.put("expirytime",o.getExpirytime());
			paramMap.put("isinternational",o.getIsinternational());
			paramMap.put("islogistics",o.getIslogistics());
			paramMap.put("isexpresscar",o.getIsexpresscar());
			paramMap.put("settlementtype",o.getSettlementtype());
			paramMap.put("runorgcode",o.getRunorgcode());
			paramMap.put("runorgname",o.getRunorgname());
			paramMap.put("istemporary",o.getIstemporary());
			paramMap.put("isoutage",o.getIsoutage());
			paramMap.put("ratetonnage",o.getRatetonnage());
			paramMap.put("sgsx",o.getSgsx());
			paramMap.put("pzcs",o.getPzcs());
			paramMap.put("pcxs",o.getPcxs());
			paramMap.put("pcts",o.getPcts());
			paramMap.put("provincecode",o.getProvincecode());
			paramMap.put("provincename",o.getProvincename());
			paramMap.put("description",o.getDescription());
			paramMap.put("direction",o.getDirection());
			paramMap.put("roundtriptype",o.getRoundtriptype());
			paramMap.put("traintype",o.getTraintype());
			paramMap.put("schedule",o.getSchedule());
			paramMap.put("runschedule",o.getRunschedule());
			paramMap.put("fullmileage",o.getFullmileage());
			paramMap.put("linestationsuiteid",o.getLinestationsuiteid());
			paramMap.put("returnlineid",o.getReturnlineid());
			paramMap.put("status",o.getStatus());
			paramMap.put("isrequestmodify",o.getIsrequestmodify());
			paramMap.put("transportlineapprovalid",o.getTransportlineapprovalid());
			paramMap.put("isdeleted",o.getIsdeleted());
			paramMap.put("createuserid",o.getCreateuserid());
			paramMap.put("createusercode",o.getCreateusercode());
			paramMap.put("createusername",o.getCreateusername());
			paramMap.put("gmtcreated",o.getGmtcreated());
			paramMap.put("modifyuserid",o.getModifyuserid());
			paramMap.put("modifyusercode",o.getModifyusercode());
			paramMap.put("modifyusername",o.getModifyusername());
			paramMap.put("gmtmodified",o.getGmtmodified());
			paramMap.put("beginprovincecode",o.getBeginprovincecode());
			paramMap.put("beginssjcode",o.getBeginssjcode());
			paramMap.put("beginstationcode",o.getBeginstationcode());
			paramMap.put("departuretime",o.getDeparturetime());
			paramMap.put("endprovincecode",o.getEndprovincecode());
			paramMap.put("endssjcode",o.getEndssjcode());
			paramMap.put("endstationcode",o.getEndstationcode());
			paramMap.put("arrivetime",o.getArrivetime());
			paramMap.put("returnlinecode",o.getReturnlinecode());
			paramMap.put("fullruntime",o.getFullruntime());
			try {
				int count =this.genericDao.getSingleInt(selSql,param);
				if(count!=0){
					//log.info("AcJcylxxb code: " + o.getCode()+"   id:"+o.getId()  +"  count="+count+"--insert");
					this.genericDao.updateSql(sql, paramMap);
				}else{
					log.info("AcJcylxxb code: " + o.getCode()+"   id:"+o.getId()  +"  count="+count+"--insert");
					this.genericDao.updateSql(insSql, insertparamMap);
				}
			} catch (CommonException e) {
				e.printStackTrace();
				log.info("AcJcYlxxb code: " + o.getCode()+"   id:"+o.getId());
			}

		}
		
		Monitor monitor = new Monitor();
		monitor.setQsrq(new SimpleDateFormat("yyyy-mm-dd").format(new Date()));
		monitor.setZzrq(monitor.getQsrq());
		monitor.setTabname("AC_JC_YLXXB");
		monitor.setSuccessrecords(result.size());
		try {
			this.saveMonitor(monitor);
		} catch(SQLException ex) {
			
		} catch(DataAccessException ex) {
			
		}
	}

	@Override
	public void doSaveAcJcZxxxb(List<AcJcZxxxb> result) {
		if(result == null || result.isEmpty()) {
			return;
		}
		String selSql = "select count(1) from ac_jc_zxxxb where  id=:id";
		String insSql = "insert into ac_jc_zxxxb("
				+ " id, code, effectivetime, expirytime, linestationsuite_id, sequence, "
				+ " stationorgcode, stationorgname, ssjcode, ssjname, provincecode, "
				+ " provincename, citycode, cityname, countycode, countyname, arriveday, "
				+ " arrivetime, departureday, departuretime, mileage, mapmileage, stationtype, "
				+ " stationarytime, transporttime, isforcedispatch, isbatchdispatch, isscanmandatory, "
				+ " documenttype, iscontrolseal, isdeleted, updatetime, createuserid, createusercode, "
				+ " createusername, gmtcreated, modifyuserid, modifyusercode, modifyusername, gmtmodified)"
				+ " values("
				+ " :id, :code, to_date(:effectivetime,'yyyymmddhh24miss'),to_date(:expirytime,'yyyymmddhh24miss') , :linestationsuite_id, :sequence, "
				+ ":stationorgcode, :stationorgname, :ssjcode, :ssjname, :provincecode, "
				+ ":provincename, :citycode, :cityname, :countycode, :countyname, :arriveday, "
				+ ":arrivetime, :departureday, :departuretime, :mileage, :mapmileage, :stationtype, "
				+ ":stationarytime, :transporttime, :isforcedispatch, :isbatchdispatch, :isscanmandatory, "
				+ ":documenttype, :iscontrolseal, :isdeleted, to_date(:updatetime,'yyyymmddhh24miss'), :createuserid, :createusercode, "
				+ ":createusername, to_date(:gmtcreated,'yyyymmddhh24miss')," +
				" :modifyuserid, :modifyusercode, :modifyusername, to_date(:gmtmodified,'yyyymmddhh24miss'))";
		String sql = "update  ac_jc_zxxxb  set "
				+ "  code=:code, effectivetime=to_date(:effectivetime,'yyyymmddhh24miss')," +
				" expirytime=to_date(:expirytime,'yyyymmddhh24miss'), " +
				"linestationsuite_id=:linestationsuite_id, sequence=:sequence, "
				+ " stationorgcode=:stationorgcode, stationorgname=:stationorgname, ssjcode=:ssjcode, ssjname=:ssjname, " +
				"provincecode=:provincecode, provincename=:provincename, citycode=:citycode, cityname=:cityname, " +
				"countycode=:countycode, countyname=:countyname, arriveday=:arriveday, "
				+ " arrivetime=:arrivetime, departureday=:departureday, departuretime=:departuretime, mileage=:mileage, " +
				"mapmileage=:mapmileage, stationtype=:stationtype, "
				+ " stationarytime=:stationarytime, transporttime=:transporttime, isforcedispatch=:isforcedispatch, " +
				"isbatchdispatch=:isbatchdispatch, isscanmandatory=:isscanmandatory, "
				+ " documenttype=:documenttype, iscontrolseal=:iscontrolseal, isdeleted=:isdeleted, updatetime=to_date(:updatetime,'yyyymmddhh24miss')," +
				" createuserid=:createuserid, createusercode=:createusercode, "
				+ " createusername=:createusername, gmtcreated=to_date(:gmtcreated,'yyyymmddhh24miss'), modifyuserid=:modifyuserid, " +
				"modifyusercode=:modifyusercode, modifyusername=:modifyusername," +
				" gmtmodified=to_date(:gmtmodified,'yyyymmddhh24miss')  where id=:id  ";
		Map<String, Object> paramMap = new HashMap<String, Object>();
		Map<String, Object> param = new HashMap<String, Object>();
		for(AcJcZxxxb o : result) {
			paramMap.clear();
			param.clear();
			param.put("id", o.getId());
			paramMap.put("id", o.getId());
			paramMap.put("code", o.getCode());
			paramMap.put("effectivetime", o.getEffectivetime());
			paramMap.put("expirytime", o.getExpirytime());
			paramMap.put("linestationsuite_id", o.getLinestationsuite_id());
			paramMap.put("sequence", o.getSequence());
			paramMap.put("stationorgcode", o.getStationorgcode());
			paramMap.put("stationorgname", o.getStationorgname());
			paramMap.put("ssjcode", o.getSsjcode());
			paramMap.put("ssjname", o.getSsjname());
			paramMap.put("provincecode", o.getProvincecode());
			paramMap.put("provincename", o.getProvincename());
			paramMap.put("citycode", o.getCitycode());
			paramMap.put("cityname", o.getCityname());
			paramMap.put("countycode", o.getCountycode());
			paramMap.put("countyname", o.getCountyname());
			paramMap.put("arriveday", o.getArriveday());
			paramMap.put("arrivetime", o.getArrivetime());
			paramMap.put("departureday", o.getDepartureday());
			paramMap.put("departuretime", o.getDeparturetime());
			paramMap.put("mileage", o.getMileage());
			paramMap.put("mapmileage", o.getMapmileage());
			paramMap.put("stationtype", o.getStationtype());
			paramMap.put("stationarytime", o.getStationarytime());
			paramMap.put("transporttime", o.getTransporttime());
			paramMap.put("isforcedispatch", o.getIsforcedispatch());
			paramMap.put("isbatchdispatch", o.getIsbatchdispatch());
			paramMap.put("isscanmandatory", o.getIsscanmandatory());
			paramMap.put("documenttype", o.getDocumenttype());
			paramMap.put("iscontrolseal", o.getIscontrolseal());
			paramMap.put("isdeleted", o.getIsdeleted());
			paramMap.put("updatetime", o.getUpdatetime());
			paramMap.put("createuserid", o.getCreateuserid());
			paramMap.put("createusercode", o.getCreateusercode());
			paramMap.put("createusername", o.getCreateusername());
			paramMap.put("gmtcreated", o.getGmtcreated());
			paramMap.put("modifyuserid", o.getModifyuserid());
			paramMap.put("modifyusercode", o.getModifyusercode());
			paramMap.put("modifyusername", o.getModifyusername());
			paramMap.put("gmtmodified", o.getGmtmodified());
			try {
				int count =this.genericDao.getSingleInt(selSql,param);
				if(count!=0){
					//log.info("AcJczxxxb code: " + o.getCode()+"   id:"+o.getId()  +"  count="+count +"--update");
					this.genericDao.updateSql(sql, paramMap);
				}else{
					log.info("AcJczxxxb code: " + o.getCode()+"   id:"+o.getId()  +"  count="+count+"--insert");
					this.genericDao.updateSql(insSql, paramMap);
				}
			} catch (CommonException e) {
				e.printStackTrace();
				log.info("AcJczxxxb code: " + o.getCode()+"   id:"+o.getId());
			}
		}
		
		Monitor monitor = new Monitor();
		monitor.setQsrq(new SimpleDateFormat("yyyy-mm-dd").format(new Date()));
		monitor.setZzrq(monitor.getQsrq());
		monitor.setTabname("AC_JC_ZXXXB");
		monitor.setSuccessrecords(result.size());
		try {
			this.saveMonitor(monitor);
		} catch(SQLException ex) {
			
		} catch(DataAccessException ex) {
			
		}
	}

}
