package com.dvt.snjs.service.impl;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.dvt.snjs.dubbo.model.*;
import org.springframework.dao.DataAccessException;

import com.dvt.core.dao.springjdbc.GenericDao;
import com.dvt.snjs.service.YwxxService;

public class YwxxServiceImpl extends AbstractMonitor implements YwxxService {
	
	private GenericDao genericDao;

	public void setGenericDao(GenericDao genericDao) {
		this.genericDao = genericDao;
	}

	@Override
	public void doSaveFd(List<Qfdztb> result) {
		if(result == null || result.isEmpty()) {
			return;
		}
		String sql = "merge into qfdztb a"
				+ " using (select :fdid fdid,to_date(:jkrq,'yyyymmddhh24miss') jkrq from dual) b"
				+ " on (a.fdid=b.fdid and a.jkrq = b.jkrq)"
				+ " when NOT MATCHED then"
				+ " insert ("
				+ "  fdid,jkldid,ckldid,fcj,fcz,jsj,jsz,fdlx,fdzt,jhzl,jksj,cksj,"
				+ " jkrq,ckrq,zbsl,dsl,jsl,xsl,hsl,zbtm,zl,sjkcsj,sjddsj,bbh,time,"
				+ " fscj,qscj,fczlx,xjzlx,yldm,ldhm,ldlsh,dwxx,esbtime,pcdh,jbcbz,"
				+ " jbrxm,fcdw,jsdw,gdbz,qstime)"
				+ " values( "
				+ " :fdid,:jkldid,:ckldid,:fcj,:fcz,:jsj,:jsz,:fdlx,:fdzt,:jhzl,:jksj,:cksj,"
				+ "TO_DATE(:jkrq,'YYYYMMDDHH24MISS'),TO_DATE(:ckrq,'YYYYMMDDHH24MISS'),"
				+ ":zbsl,:dsl,:jsl,:xsl,:hsl,:zbtm,:zl,TO_DATE(:sjkcsj,'YYYYMMDDHH24MISS'),"
				+ "TO_DATE(:sjddsj,'YYYYMMDDHH24MISS'),:bbh,TO_DATE(:time,'YYYYMMDDHH24MISS'),"
				+ "trim(:fscj),trim(:qscj),:fczlx,:xjzlx,:yldm,:ldhm,:ldlsh,:dwxx,"
				+ "TO_DATE(:esbtime,'YYYYMMDDHH24MISS'),:pcdh,:jbcbz,:jbrxm,:fcdw,"
				+ ":jsdw,:gdbz,TO_DATE(:qstime,'YYYYMMDDHH24MISS'))";
		Map<String, Object> paramMap = new HashMap<String, Object>();
		for(Qfdztb o : result) {
			paramMap.clear();
			paramMap.put("fdid", o.getFdid());
			paramMap.put("jkldid", o.getJkldid());
			paramMap.put("ckldid", o.getCkldid());
			paramMap.put("fcj", o.getFcj());
			paramMap.put("fcz", o.getFcz());
			paramMap.put("jsj", o.getJsj());
			paramMap.put("jsz", o.getJsz());
			paramMap.put("fdlx", o.getFdlx());
			paramMap.put("fdzt", o.getFdzt());
			paramMap.put("jhzl", o.getJhzl());
			paramMap.put("jksj", o.getJksj());
			paramMap.put("cksj", o.getCksj());
			paramMap.put("jkrq", o.getJkrq());
			paramMap.put("ckrq", o.getCkrq());
			paramMap.put("zbsl", o.getZbsl());
			paramMap.put("dsl", o.getDsl());
			paramMap.put("jsl", o.getJsl());
			paramMap.put("xsl", o.getXsl());
			paramMap.put("hsl", o.getHsl());
			paramMap.put("zbtm", o.getZbtm());
			paramMap.put("zl", o.getZl());
			paramMap.put("sjkcsj", o.getSjkcsj());
			paramMap.put("sjddsj", o.getSjddsj());
			paramMap.put("bbh", o.getBbh());
			paramMap.put("time", o.getTime());
			paramMap.put("fscj", o.getFscj());
			paramMap.put("qscj", o.getQscj());
			paramMap.put("fczlx", o.getFczlx());
			paramMap.put("xjzlx", o.getXjzlx());
			paramMap.put("yldm", o.getYldm());
			paramMap.put("ldhm", o.getLdhm());
			paramMap.put("ldlsh", o.getLdlsh());
			paramMap.put("dwxx", o.getDwxx());
			paramMap.put("esbtime", o.getEsbtime());
			paramMap.put("pcdh", o.getPcdh());
			paramMap.put("jbcbz", o.getJbcbz());
			paramMap.put("jbrxm", o.getJbrxm());
			paramMap.put("fcdw", o.getFcdw());
			paramMap.put("jsdw", o.getJsdw());
			paramMap.put("gdbz", o.getGdbz());
			paramMap.put("qstime", o.getQstime());
			this.genericDao.updateSql(sql, paramMap);
		}	
		
		Monitor monitor = new Monitor();
		monitor.setQsrq(result.get(0).getJkrq());
		monitor.setZzrq(monitor.getQsrq());
		monitor.setTabname("QFDZTB");
		monitor.setSuccessrecords(result.size());
		try {
			this.saveMonitor(monitor);
		} catch(SQLException ex) {
			
		} catch(DataAccessException ex) {
			
		}	
	}

	@Override
	public void doSaveZb(List<Qzbxxb> result) {
		if(result == null || result.isEmpty()) {
			return;
		}
		String sql = "merge into QZBXXB a"
				+ " using (select :fdid fdid, :zbid zbid,:zbtm zbtm,to_date(:ffrq,'YYYYMMDDHH24MISS') ffrq from dual) b"
				+ " on (a.fdid=b.fdid and a.zbid=b.zbid and a.ffrq=b.ffrq )"
				+ " when NOT MATCHED then"
				+ " insert ("
				+ "  zbid,fdid,zbtm,zblx,hfbz,ffrq,zbzt,zbhm,yjzl,"
				+ " yjjdm,jdjdm,bzbz,zl,ydxh,bzdm,cjdm,yjjs,fjlx,czrq,ghfs,scsj)"
				+ " values( "
				+ " :zbid,:fdid,:zbtm,:zblx,:hfbz,TO_DATE(:ffrq,'YYYYMMDDHH24MISS'),"
				+ " :zbzt,:zbhm,:yjzl,:yjjdm,:jdjdm,:bzbz,:zl,:ydxh,:bzdm,:cjdm,"
				+ " :yjjs,:fjlx,:czrq,:ghfs,TO_DATE(:scsj,'YYYYMMDDHH24MISS'))";
		Map<String, Object> paramMap = new HashMap<String, Object>();
		for(Qzbxxb o : result) {
			paramMap.clear();
			paramMap.put("zbid", o.getZbid());
			paramMap.put("fdid", o.getFdid());
			paramMap.put("zbtm", o.getZbtm());
			paramMap.put("zblx", o.getZblx());
			paramMap.put("hfbz", o.getHfbz());
			paramMap.put("ffrq", o.getFfrq());
			paramMap.put("zbzt", o.getZbzt());
			paramMap.put("zbhm", o.getZbhm());
			paramMap.put("yjzl", o.getYjzl());
			paramMap.put("yjjdm", o.getYjjdm());
			paramMap.put("jdjdm", o.getJdjdm());
			paramMap.put("bzbz", o.getBzbz());
			paramMap.put("zl", o.getZl());
			paramMap.put("ydxh", o.getYdxh());
			paramMap.put("bzdm", o.getBzdm());
			paramMap.put("cjdm", o.getCjdm());
			paramMap.put("yjjs", o.getYjjs());
			paramMap.put("fjlx", o.getFjlx());
			paramMap.put("czrq", o.getCzrq());
			paramMap.put("ghfs", o.getGhfs());
			paramMap.put("scsj", o.getScsj());
			this.genericDao.updateSql(sql, paramMap);
		}
		
		Monitor monitor = new Monitor();
		monitor.setQsrq(result.get(0).getFfrq());
		monitor.setZzrq(monitor.getQsrq());
		monitor.setTabname("QZBXXB");
		monitor.setSuccessrecords(result.size());
		try {
			this.saveMonitor(monitor);
		} catch(SQLException ex) {
			
		} catch(DataAccessException ex) {
			
		}		
	}

	@Override
	public void doSaveQd(List<Qqdxxb> result) {
		if(result == null || result.isEmpty()) {
			return;
		}
		String sql = "merge into GD_QQDXXB a"
				+ " using (select :qdid qdid,to_date(:ffrq,'yyyymmddhh24miss') ffrq from dual) b"
				+ " on (a.qdid=b.qdid and a.ffrq = b.ffrq)"
				+ " when NOT MATCHED then"
				+ " insert ("
				+ "  qdid,zbtm,ffrq,yjjdm,jdjdm,yjzl,sjly,scsj,scjg,by1,jbbz)"
				+ " values( "
				+ " :qdid,:zbtm,TO_DATE(:ffrq,'YYYYMMDDHH24MISS'),:yjjdm,:jdjdm,"
				+ ":yjzl,:sjly,TO_DATE(:scsj,'YYYYMMDDHH24MISS'),:scjg,:by1,:jbbz)";
		Map<String, Object> paramMap = new HashMap<String, Object>();
		for(Qqdxxb o : result) {
			paramMap.clear();
			paramMap.put("qdid", o.getQdid());
			paramMap.put("zbtm", o.getZbtm());
			paramMap.put("ffrq", o.getFfrq());
			paramMap.put("yjjdm", o.getYjjdm());
			paramMap.put("jdjdm", o.getJdjdm());
			paramMap.put("yjzl", o.getYjzl());
			paramMap.put("sjly", o.getSjly());
			paramMap.put("scsj", o.getScsj());
			paramMap.put("scjg", o.getScjg());
			paramMap.put("by1", o.getBy1());
			paramMap.put("jbbz", o.getJbbz());
			this.genericDao.updateSql(sql, paramMap);
		}		
		
		Monitor monitor = new Monitor();
		monitor.setQsrq(result.get(0).getFfrq());
		monitor.setZzrq(monitor.getQsrq());
		monitor.setTabname("QQDXXB");
		monitor.setSuccessrecords(result.size());
		try {
			this.saveMonitor(monitor);
		} catch(SQLException ex) {
			
		} catch(DataAccessException ex) {
			
		}
	}

	@Override
	public void doSaveYj(List<Qyjxxb> result) {
		if(result == null || result.isEmpty()) {
			return;
		}
		String sql = "merge into GD_QYJXXB a"
				+ " using (select :qdid qdid, :yjtm yjtm from dual) b"
				+ " on ( a.qdid=b.qdid and a.yjtm=b.yjtm)"
				+ " when NOT MATCHED then"
				+ " insert ("
				+ "  qdid,yjtm,scsj,zl,yjzl)"
				+ " values( "
				+ " :qdid,:yjtm,TO_DATE(:scsj,'YYYYMMDDHH24MISS'),:zl,:yjzl)";
		Map<String, Object> paramMap = new HashMap<String, Object>();
		for(Qyjxxb o : result) {
			paramMap.clear();
			paramMap.put("qdid", o.getQdid());
			paramMap.put("yjtm", o.getYjtm());
			paramMap.put("scsj", o.getScsj());
			paramMap.put("zl", o.getZl());
			paramMap.put("yjzl", o.getYjzl());
			this.genericDao.updateSql(sql, paramMap);
		}	
		
		Monitor monitor = new Monitor();
		monitor.setQsrq(result.get(0).getScsj());
		monitor.setZzrq(monitor.getQsrq());
		monitor.setTabname("QYJXXB");
		monitor.setSuccessrecords(result.size());
		try {
			this.saveMonitor(monitor);
		} catch(SQLException ex) {
			
		} catch(DataAccessException ex) {
			
		}	
	}

	@Override
	public void doSaveSj(List<Qyjjbxxb> result) {
		if(result == null || result.isEmpty()) {
			return;
		}
		String sql = "merge into GD_QYJJBXXB a"
				+ " using (select :yjtm yjtm, :sjjdm sjjdm, :yjbz yjbz, to_date(:sjrq,'YYYYMMDDHH24MISS') sjrq from dual)  b"
				+ " on (a.yjtm=b.yjtm and a.sjjdm=b.sjjdm and a.yjbz=b.yjbz"
				+ "  and a.sjrq = b.sjrq)"
				+ " when NOT MATCHED then"
				+ " insert ("
				+ "  yjtm,yjbz,yjzldm,sjjdm,jdjdm,yjzl,yjtj,scsj,sjrq,yjly,jfzl,jdgdm,txdm,ypdjbz,zzf,yhje,khbm,bzxbz,zwsx)"
				+ " values( "
				+ " :yjtm,:yjbz,:yjzldm,:sjjdm,:jdjdm,:yjzl,:yjtj,"
				+ " TO_DATE(:scsj,'YYYYMMDDHH24MISS'),"
				+ " TO_DATE(:sjrq,'YYYYMMDDHH24MISS'),:yjly,:jfzl,:jdgdm,:txdm,:ypdjbz,:zzf,:yhje,:khbm,:bzxbz,:zwsx)";
		Map<String, Object> paramMap = new HashMap<String, Object>();
		for(Qyjjbxxb o : result) {
			paramMap.clear();
			paramMap.put("yjtm", o.getYjtm());
			paramMap.put("yjbz", o.getYjbz());
			paramMap.put("yjzldm", o.getYjzldm());
			paramMap.put("sjjdm", o.getSjjdm());
			paramMap.put("jdjdm", o.getJdjdm());
			paramMap.put("yjzl", o.getYjzl());
			paramMap.put("yjtj", o.getYjtj());
			paramMap.put("scsj", o.getScsj());
			paramMap.put("sjrq", o.getSjrq());
			paramMap.put("yjly", o.getYjly());
			paramMap.put("jfzl", o.getJfzl());
			paramMap.put("jdgdm", o.getJdgdm());
			paramMap.put("txdm", o.getTxdm());
			paramMap.put("ypdjbz", o.getYpdjbz());
			paramMap.put("zzf", o.getZzf());
			paramMap.put("yhje", o.getYhje());
			paramMap.put("khbm", o.getKhbm());
			paramMap.put("bzxbz", o.getBzxbz());
			paramMap.put("zwsx", o.getZwsx());
			this.genericDao.updateSql(sql, paramMap);
		}		
		
		Monitor monitor = new Monitor();
		monitor.setQsrq(result.get(0).getSjrq());
		monitor.setZzrq(monitor.getQsrq());
		monitor.setTabname("QYJJBXXB");
		monitor.setSuccessrecords(result.size());
		try {
			this.saveMonitor(monitor);
		} catch(SQLException ex) {
			
		} catch(DataAccessException ex) {
			
		}
	}
	
	@Override
	public void doSaveGdtd(List<GdTdxxb> result) {
		if(result == null || result.isEmpty()) {
			return;
		}
		
		String sql = "merge into gd_tdxxb a"
				+ " using (select :yjtm yjtm,:tdjdm tdjdm,to_date(:tdrq,'yyyymmddhh24miss') tdrq,:sftt sftt from dual) b"
				+ " on (a.yjtm=b.yjtm and a.tdjdm = b.tdjdm and a.tdrq = b.tdrq and a.sftt = b.sftt)"
				+ " when NOT MATCHED then"
				+ " insert (yjid,yjtm,tdrq,tdjdm," 
				+ " yjzl,yjzlmc,zl,sftt,scsj,sjly,tddjsj,gxrq,clbz,jkclbz,tdy)"
				+ " values( "
				+ " :yjid,:yjtm,to_date(:tdrq,'yyyymmddhh24miss'),:tdjdm," 
				+ " :yjzl,:yjzlmc,:zl,:sftt,to_date(:scsj,'yyyymmddhh24miss'),"
				+ " :sjly,to_date(:tddjsj,'yyyymmddhh24miss'),to_date(:gxrq,'yyyymmddhh24miss'),:clbz,:jkclbz,:tdy)";
		Map<String, Object> paramMap = new HashMap<String, Object>();
		for(GdTdxxb o : result) {
			paramMap.clear();
			paramMap.put("yjid", o.getYjid());
			paramMap.put("yjtm", o.getYjtm());
			paramMap.put("tdrq", o.getTdrq());
			paramMap.put("tdjdm", o.getTdjdm());
			paramMap.put("yjzl", o.getYjzl());
			paramMap.put("yjzlmc", o.getYjzlmc());
			paramMap.put("zl", o.getZl());
			paramMap.put("sftt", o.getSftt());
			paramMap.put("scsj", o.getScsj());
			paramMap.put("sjly", o.getSjly());
			paramMap.put("tddjsj", o.getTddjsj());
			paramMap.put("gxrq", o.getGxrq());
			paramMap.put("clbz", o.getClbz());
			paramMap.put("jkclbz", o.getJkclbz());
			paramMap.put("sfdm", o.getSfdm());
			paramMap.put("tdy", o.getTdy());
			this.genericDao.updateSql(sql, paramMap);
		}
		
		Monitor monitor = new Monitor();
		monitor.setQsrq(result.get(0).getTdrq());
		monitor.setZzrq(monitor.getQsrq());
		monitor.setTabname("GD_TDXXB");
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

	@Override
	public void doSaveTmpFdxx(List<TmpFdxxb> result) {
		if(result == null || result.isEmpty()) {
			return;
		}
		
		String sql = "merge into tmp_fdxxb a"
				+ " using dual"
				+ " on (a.fdid=:fdid)"
				+ " when NOT MATCHED then"
				+ " insert (fdid,gls,fcz,jsz,pyj,yldm,ldlsh,zbsl,ysclbz,ylzl,jsrq,"
				+ " sslj,hbbh,ylgs,fcj,yljb,zbtm,time,jsj,ylfl)"
				+ " values(:fdid,:gls,:fcz,:jsz,:pyj,:yldm,:ldlsh,:zbsl,:ysclbz,:ylzl,"
				+ " to_date(:jsrq,'yyyymmddhh24miss'),:sslj,:hbbh,:ylgs,:fcj,:yljb,:zbtm,"
				+ " to_date(:time,'yyyymmddhh24miss'),:jsj,:ylfl)";
		Map<String, Object> paramMap = new HashMap<String, Object>();
		for(TmpFdxxb o : result) {
			paramMap.clear();
			paramMap.put("fdid",o.getFdid());
			paramMap.put("gls",o.getGls());
			paramMap.put("fcz",o.getFcz());
			paramMap.put("jsz",o.getJsz());
			paramMap.put("pyj",o.getPyj());
			paramMap.put("yldm",o.getYldm());
			paramMap.put("ldlsh",o.getLdlsh());
			paramMap.put("zbsl",o.getZbsl());
			paramMap.put("ysclbz",o.getYsclbz());
			paramMap.put("ylzl",o.getYlzl());
			paramMap.put("jsrq",o.getJsrq());
			paramMap.put("sslj",o.getSslj());
			paramMap.put("hbbh",o.getHbbh());
			paramMap.put("ylgs",o.getYlgs());
			paramMap.put("fcj",o.getFcj());
			paramMap.put("yljb",o.getYljb());
			paramMap.put("zbtm",o.getZbtm());
			paramMap.put("time",o.getTime());
			paramMap.put("jsj",o.getJsj());
			paramMap.put("ylfl",o.getYlfl());
			this.genericDao.updateSql(sql, paramMap);
		}
		
		Monitor monitor = new Monitor();
		monitor.setQsrq(result.get(0).getJsrq());
		monitor.setZzrq(monitor.getQsrq());
		monitor.setTabname("TMP_FDXXB");
		monitor.setSuccessrecords(result.size());
		try {
			this.saveMonitor(monitor);
		} catch(SQLException ex) {
			
		} catch(DataAccessException ex) {
			
		}		
	}

	@Override
	public void doSaveYlxx(List<JcTYlxxzb> result) {
		if(result == null || result.isEmpty()) {
			return;
		}
		
		String sql = "merge into tylxxzb a"
				+ " using dual"
				+ " on (a.yldm=:yldm)"
				+ " when NOT MATCHED then"
				+ " insert ("
				+ " yljb, ylzl, yldm, ylmc, chc, pyj, "
				+ " sfj, zdj, qszxrq, zzzxrq, sslj, "
				+ " gjxh, bgwz, rj, dw, ylxz, sxxbs, "
				+ " zjsx, qcyldm, sfdysdyj, sfdygjyj, "
				+ " gxjs, zwbxx, yqsx, qlc )"
				+ " values("
				+ " :yljb, :ylzl, :yldm, :ylmc, "
				+ " :chc, :pyj, :sfj, :zdj, "
				+ " to_date(:qszxrq,'yyyymmddhh24miss', "
				+ " to_date(:zzzxrq,'yyyymmddhh24miss'), "
				+ " :sslj, :gjxh, :bgwz, :rj, :dw, :ylxz, "
				+ " :sxxbs, :zjsx, :qcyldm, :sfdysdyj, "
				+ " :sfdygjyj, :gxjs, :zwbxx, :yqsx, :qlc)";
		Map<String, Object> paramMap = new HashMap<String, Object>();
		for(JcTYlxxzb o : result) {
			paramMap.clear();
			paramMap.put("yldm",o.getYldm());
			paramMap.put("ylmc",o.getYlmc());
			paramMap.put("yljb",o.getYljb());
			paramMap.put("ylzl",o.getYlzl());
			paramMap.put("chc",o.getChc());
			paramMap.put("pyj",o.getPyj());
			paramMap.put("sfj",o.getSfj());
			paramMap.put("zdj",o.getZdj());
			paramMap.put("qszxrq",o.getQszxrq());
			paramMap.put("zzzxrq",o.getZzzxrq());
			paramMap.put("sslj",o.getSslj());
			paramMap.put("gjxh",o.getGjxh());
			paramMap.put("bgwz",o.getBgwz());
			paramMap.put("rj",o.getRj());
			paramMap.put("ylxz",o.getYlxz());
			paramMap.put("sxxbs",o.getSxxbs());
			paramMap.put("zjsx",o.getZjsx());
			paramMap.put("qcyldm",o.getQcyldm());
			paramMap.put("sfdysdyj",o.getSfdysdyj());
			paramMap.put("sfdygjyj",o.getSfdygjyj());
			paramMap.put("zwbxx",o.getZwbxx());
			paramMap.put("gxjs",o.getGxjs());
			paramMap.put("qlc",o.getQlc());
			paramMap.put("dw",o.getDw());
			paramMap.put("yqsx",o.getYqsx());

			this.genericDao.updateSql(sql, paramMap);
		}
		
	}

	@Override
	public void doSaveJgxx(List<JcJgxxb> result) {
		if(result == null || result.isEmpty()) {
			return;
		}
		
		String sql = "merge into ac_jc_jgxxb a"
				+ " using dual"
				+ " on (a.jgdm=:jgdm )"
				+ " when NOT MATCHED then"
				+ " insert (jgdm,jgmc,jggs,sssf,ssds,ssxs,jgjc)"
				+ " values(:jgdm, :jgmc, :jggs,  :sssf, :ssds, :ssxs, :jgjc)"
				+ " WHEN MATCHED THEN"
				+ " update set jggs=:jggs,sssf=:sssf,ssds=:ssds,ssxs=:ssxs";
		Map<String, Object> paramMap = new HashMap<String, Object>();
		for(JcJgxxb o : result) {
			paramMap.clear();
			paramMap.put("jgdm",o.getJgdm());
			paramMap.put("jgmc",o.getJgmc());
			paramMap.put("jggs",o.getJggs());
			paramMap.put("sssf",o.getSssf());
			paramMap.put("ssds",o.getSsds());
			paramMap.put("ssxs",o.getSsxs());
			paramMap.put("jgjc", o.getJgjc());

			this.genericDao.updateSql(sql, paramMap);
		}
		
	}

	@Override
	public void doSaveTylpcxx(List<Tylpcxxb> result) {
		if(result == null || result.isEmpty()) {
			return;
		}
		String sql = "merge into snjs_cl_tylpcxxb a" +
				" using dual" +
				" on (a.pcdh=:pcdh)" +
				" when not matched then" +
				" insert (pcdh,qcyldm,fcyldm,ylzlc,yxts,ldlsh,clid,sydw,cph,jsy,byjsy,yyy,gbcl,jhddr,jhkcr,pcdw,czydm," +
				" czsj,pclx,pcbz,xfbz,xfsj,bbh,gcclid,gccph,jsymc,dapbz,daptime,pccx,jsyphone,cldw,scsj,dw,xtscsj)" +
				" values(:pcdh,:qcyldm,:fcyldm,:ylzlc,:yxts,:ldlsh,:clid,:sydw,:cph,:jsy,:byjsy,:yyy,:gbcl,:jhddr," +
				" :jhkcr,:pcdw,:czydm,:czsj,:pclx,:pcbz,:xfbz,:xfsj,:bbh,:gcclid,:gccph,:jsymc,:dapbz,:daptime," +
				" :pccx,:jsyphone,:cldw,:scsj,:dw,:xtscsj) WHEN MATCHED THEN " + 
				"update set qcyldm=:qcyldm,fcyldm=:fcyldm,cph=:cph,cldw=:cldw,dw=:dw";
		Map<String, Object> paramMap = new HashMap<>();
		for (Tylpcxxb o : result) {
			paramMap.clear();//清空map
			paramMap.put("pcdh", o.getPcdh());
			paramMap.put("qcyldm", o.getQcyldm());
			paramMap.put("fcyldm", o.getFcyldm());
			paramMap.put("ylzlc", o.getYlzlc());
			paramMap.put("yxts", o.getYxts());
			paramMap.put("ldlsh", o.getLdlsh());
			paramMap.put("clid", o.getClid());
			paramMap.put("sydw", o.getSydw());
			paramMap.put("cph", o.getCph());
			paramMap.put("jsy", o.getJsy());
			paramMap.put("byjsy", o.getByjsy());
			paramMap.put("yyy", o.getYyy());
			paramMap.put("gbcl", o.getGbcl());
			paramMap.put("jhddr", o.getJhddr());
			paramMap.put("jhkcr", o.getJhkcr());
			paramMap.put("pcdw", o.getPcdw());
			paramMap.put("czydm", o.getCzydm());
			paramMap.put("czsj", o.getCzsj());
			paramMap.put("pclx", o.getPclx());
			paramMap.put("pcbz", o.getPcbz());
			paramMap.put("xfbz", o.getXfbz());
			paramMap.put("xfsj", o.getXfsj());
			paramMap.put("bbh", o.getBbh());
			paramMap.put("gcclid", o.getGcclid());
			paramMap.put("gccph", o.getGccph());
			paramMap.put("jsymc", o.getJsymc());
			paramMap.put("dapbz",o.getDapbz());
			paramMap.put("daptime",o.getDaptime());
			paramMap.put("pccx", o.getPccx());
			paramMap.put("jsyphone", o.getJsyphone());
			paramMap.put("cldw", o.getCldw());
			paramMap.put("scsj",o.getScsj());
			paramMap.put("dw", o.getDw());
			paramMap.put("xtscsj", o.getXtscsj());

			this.genericDao.updateSql(sql, paramMap);
		}
	}
	@Override
	public void doSaveCkld(List<Tckldzb> result) {
		if(result == null || result.isEmpty()) {
			return;
		}
		String sql = "merge into tckldzb a"
				+ " using (select :ldid ldid, :zzrq zzrq from dual) b"
				+ " on (a.ldid=b.ldid and a.zzrq = b.zzrq)"
				+ " when NOT MATCHED then"
				+ " insert ("
				+ "  ldid,yldm,ldhm,hbcp,gdrq,cjdm,bcdm,ldzt,ldsx,zzrq,zzsj,zzbc,"
				+ "fsbc,zzczy,fsczy,fsrq,gzrq,ldbz,gdbz,ldlsh,scbz,"
				+ "ssjdm,sjkcsj,jbbz,pcdh,jbcbz,pcdhbz,zbsl,zbzl)"
				+ " values( "
				+ " :ldid,:yldm,:ldhm,:hbcp,to_DATE(:gdrq,'YYYYMMDDHH24MISS') ,:cjdm,:bcdm,:ldzt,:ldsx,"
				+ ":zzrq,:zzsj,:zzbc,:fsbc,:zzczy,:fsczy,to_DATE(:fsrq,'YYYYMMDDHH24MISS') ,"
				+ "to_DATE(:gzrq,'YYYYMMDDHH24MISS') ,:ldbz,:gdbz,:ldlsh,:scbz,:ssjdm,"
				+ "to_DATE(:sjkcsj,'YYYYMMDDHH24MISS') ,:jbbz,:pcdh,:jbcbz,:pcdhbz,:zbsl,:zbzl)";
		Map<String, Object> paramMap = new HashMap<String, Object>();
		for(Tckldzb o : result) {
			paramMap.clear();
			paramMap.put("ldid",o.getLdid());
			paramMap.put("yldm",o.getYldm());
			paramMap.put("ldhm",o.getLdhm());
			paramMap.put("hbcp",o.getHbcp());
			paramMap.put("gdrq",o.getGdrq());
			paramMap.put("cjdm",o.getCjdm());
			paramMap.put("bcdm",o.getBcdm());
			paramMap.put("ldzt",o.getLdzt());
			paramMap.put("ldsx",o.getLdsx());
			paramMap.put("zzrq",o.getZzrq());
			paramMap.put("zzsj",o.getZzsj());
			paramMap.put("zzbc",o.getZzbc());
			paramMap.put("fsbc",o.getFsbc());
			paramMap.put("zzczy",o.getZzczy());
			paramMap.put("fsczy",o.getFsczy());
			paramMap.put("fsrq",o.getFsrq());
			paramMap.put("gzrq",o.getGzrq());
			paramMap.put("ldbz",o.getLdbz());
			paramMap.put("gdbz",o.getGdbz());
			paramMap.put("ldlsh",o.getLdlsh());
			paramMap.put("scbz",o.getScbz());
			paramMap.put("ssjdm",o.getSsjdm());
			paramMap.put("sjkcsj",o.getSjkcsj());
			paramMap.put("jbbz",o.getJbbz());
			paramMap.put("pcdh",o.getPcdh());
			paramMap.put("jbcbz",o.getJbcbz());
			paramMap.put("pcdhbz",o.getPcdhbz());
			paramMap.put("zbsl",o.getZbsl());
			paramMap.put("zbzl",o.getZbzl());
			this.genericDao.updateSql(sql, paramMap);
		}	
		
		Monitor monitor = new Monitor();
		monitor.setQsrq(result.get(0).getZzrq());
		monitor.setZzrq(monitor.getQsrq());
		monitor.setTabname("TCKLDZB");
		monitor.setSuccessrecords(result.size());
		try {
			this.saveMonitor(monitor);
		} catch(SQLException ex) {
		} catch(DataAccessException ex) {
		}
	}

	@Override
	public void doSaveZbfjxx(List<Tzbfjxx> result) {
		if(result == null || result.isEmpty()) {
			return;
		}
		String sql = "merge into tzbfjxx a"
				+ " using (select :ckldid ckldid,:zbid zbid from dual) b"
				+ " on (a.zbid=b.zbid and a.ckldid=b.ckldid)"
				+ " when NOT MATCHED then"
				+ " insert ("
				+ "  zbid,jkldid,ckldid,ssdwbh,lsdbh,lsdmc,zdid,zdmc,xjz,scsj,rdsj,rdczydm,"
				+ "cjsj,ghsj,ghczydm,kcsj,kcczydm,zbzt,hfbz,zzbz,lhbz,ghbz,fybz,ydhm,zzcc,"
				+ "dsjzbid,flag,cjdm,bcdm,ckbz,gdbz,gdrq,scbz,jbbz,czydm,gph,ggbf,zbly,fjxxid,"
				+ "ffjdm,ghfs,fcz,smcj,dsjzbtm,fczlx,xjzlx,gbth,ghczym,fcdw,sbtm,tch,zbhm,"
				+ "yjzl,yjjdm,jdjdm,bzbz,czrq,zl,ydxh,bzdm,zbtm,gjzbtm,ffrq)"
				+ " values( "
				+ " :zbid,:jkldid,:ckldid,:ssdwbh,:lsdbh,:lsdmc,:zdid,:zdmc,:xjz,"
				+ "to_DATE(:scsj,'YYYYMMDDHH24MISS') ,to_DATE(:rdsj,'YYYYMMDDHH24MISS') ,"
				+ ":rdczydm,to_DATE(:cjsj,'YYYYMMDDHH24MISS') ,to_DATE(:ghsj,'YYYYMMDDHH24MISS') ,"
				+ ":ghczydm,to_DATE(:kcsj,'YYYYMMDDHH24MISS') ,:kcczydm,:zbzt,:hfbz,:zzbz,:lhbz,"
				+ ":ghbz,:fybz,:ydhm,:zzcc,:dsjzbid,:flag,:cjdm,:bcdm,:ckbz,:gdbz,"
				+ "to_DATE(:gdrq,'YYYYMMDDHH24MISS') ,:scbz,:jbbz,:czydm,:gph,:ggbf,:zbly,"
				+ ":fjxxid,:ffjdm,:ghfs,:fcz,:smcj,:dsjzbtm,:fczlx,:xjzlx,:gbth,:ghczym,"
				+ ":fcdw,:sbtm,:tch,:zbhm,:yjzl,:yjjdm,:jdjdm,:bzbz,:czrq,:zl,:ydxh,"
				+ ":bzdm,:zbtm,:gjzbtm,to_DATE(:ffrq,'YYYYMMDDHH24MISS') )";
		Map<String, Object> paramMap = new HashMap<String, Object>();
		for(Tzbfjxx o : result) {
			paramMap.clear();
			paramMap.put("zbid",o.getZbid());
			paramMap.put("jkldid",o.getJkldid());
			paramMap.put("ckldid",o.getCkldid());
			paramMap.put("ssdwbh",o.getSsdwbh());
			paramMap.put("lsdbh",o.getLsdbh());
			paramMap.put("lsdmc",o.getLsdmc());
			paramMap.put("zdid",o.getZdid());
			paramMap.put("zdmc",o.getZdmc());
			paramMap.put("xjz",o.getXjz());
			paramMap.put("scsj",o.getScsj());
			paramMap.put("rdsj",o.getRdsj());
			paramMap.put("rdczydm",o.getRdczydm());
			paramMap.put("cjsj",o.getCjsj());
			paramMap.put("ghsj",o.getGhsj());
			paramMap.put("ghczydm",o.getGhczydm());
			paramMap.put("kcsj",o.getKcsj());
			paramMap.put("kcczydm",o.getKcczydm());
			paramMap.put("zbzt",o.getZbzt());
			paramMap.put("hfbz",o.getHfbz());
			paramMap.put("zzbz",o.getZzbz());
			paramMap.put("lhbz",o.getLhbz());
			paramMap.put("ghbz",o.getGhbz());
			paramMap.put("fybz",o.getFybz());
			paramMap.put("ydhm",o.getYdhm());
			paramMap.put("zzcc",o.getZzcc());
			paramMap.put("dsjzbid",o.getDsjzbid());
			paramMap.put("flag",o.getFlag());
			paramMap.put("cjdm",o.getCjdm());
			paramMap.put("bcdm",o.getBcdm());
			paramMap.put("ckbz",o.getCkbz());
			paramMap.put("gdbz",o.getGdbz());
			paramMap.put("gdrq",o.getGdrq());
			paramMap.put("scbz",o.getScbz());
			paramMap.put("jbbz",o.getJbbz());
			paramMap.put("czydm",o.getCzydm());
			paramMap.put("gph",o.getGph());
			paramMap.put("ggbf",o.getGgbf());
			paramMap.put("zbly",o.getZbly());
			paramMap.put("fjxxid",o.getFjxxid());
			paramMap.put("ffjdm",o.getFfjdm());
			paramMap.put("ghfs",o.getGhfs());
			paramMap.put("fcz",o.getFcz());
			paramMap.put("smcj",o.getSmcj());
			paramMap.put("dsjzbtm",o.getDsjzbtm());
			paramMap.put("fczlx",o.getFczlx());
			paramMap.put("xjzlx",o.getXjzlx());
			paramMap.put("gbth",o.getGbth());
			paramMap.put("ghczym",o.getGhczym());
			paramMap.put("fcdw",o.getFcdw());
			paramMap.put("sbtm",o.getSbtm());
			paramMap.put("tch",o.getTch());
			paramMap.put("zbhm",o.getZbhm());
			paramMap.put("yjzl",o.getYjzl());
			paramMap.put("yjjdm",o.getYjjdm());
			paramMap.put("jdjdm",o.getJdjdm());
			paramMap.put("bzbz",o.getBzbz());
			paramMap.put("czrq",o.getCzrq());
			paramMap.put("zl",o.getZl());
			paramMap.put("ydxh",o.getYdxh());
			paramMap.put("bzdm",o.getBzdm());
			paramMap.put("zbtm",o.getZbtm());
			paramMap.put("gjzbtm",o.getGjzbtm());
			paramMap.put("ffrq",o.getFfrq());
			paramMap.put("sfdm",o.getSfdm());
			this.genericDao.updateSql(sql, paramMap);
		}	
		
		Monitor monitor = new Monitor();
		monitor.setQsrq(result.get(0).getFfrq());
		monitor.setZzrq(monitor.getQsrq());
		monitor.setTabname("TZBFJXX");
		monitor.setSuccessrecords(result.size());
		try {
			this.saveMonitor(monitor);
		} catch(SQLException ex) {
		} catch(DataAccessException ex) {
		}
	}

	@Override
	public void doSaveFfqd(List<Tffqdzb> result) {
		if(result == null || result.isEmpty()) {
			return;
		}
		String sql = "merge into tffqdzb a"
				+ " using (select :qdid qdid from dual) b"
				+ " on (a.qdid=b.qdid)"
				+ " when NOT MATCHED then"
				+ " insert ("
				+ "  qdid,zbtm,qdhm,yjzl,ffjdm,jdjdm,cjdm,ffrq,bcdm,txdm,ffrdm,yjjs,qdgg,qdlx,"
				+ "beizhudm,bzbz,qdzt,gdbz,gdrq,czydm,scsj,dybz,gzrq,czrq,ydxh,ddxh,gkmc,"
				+ "jsbz,jsxh,fsbz,gkhm,ssjdm,ffrxm)"
				+ " values( "
				+ " :qdid,:zbtm,:qdhm,:yjzl,:ffjdm,:jdjdm,:cjdm,to_DATE(:ffrq,'YYYYMMDDHH24MISS') ,"
				+ ":bcdm,:txdm,:ffrdm,:yjjs,:qdgg,:qdlx,:beizhudm,:bzbz,:qdzt,:gdbz,"
				+ "to_DATE(:gdrq,'YYYYMMDDHH24MISS') ,:czydm,to_DATE(:scsj,'YYYYMMDDHH24MISS') ,"
				+ ":dybz,to_DATE(:gzrq,'YYYYMMDDHH24MISS') ,:czrq,:ydxh,:ddxh,:gkmc,:jsbz,"
				+ ":jsxh,:fsbz,:gkhm,:ssjdm,:ffrxm)";
		Map<String, Object> paramMap = new HashMap<String, Object>();
		for(Tffqdzb o : result) {
			paramMap.clear();
			paramMap.put("qdid",o.getQdid());
			paramMap.put("zbtm",o.getZbtm());
			paramMap.put("qdhm",o.getQdhm());
			paramMap.put("yjzl",o.getYjzl());
			paramMap.put("ffjdm",o.getFfjdm());
			paramMap.put("jdjdm",o.getJdjdm());
			paramMap.put("cjdm",o.getCjdm());
			paramMap.put("ffrq",o.getFfrq());
			paramMap.put("bcdm",o.getBcdm());
			paramMap.put("txdm",o.getTxdm());
			paramMap.put("ffrdm",o.getFfrdm());
			paramMap.put("yjjs",o.getYjjs());
			paramMap.put("qdgg",o.getQdgg());
			paramMap.put("qdlx",o.getQdlx());
			paramMap.put("beizhudm",o.getBeizhudm());
			paramMap.put("bzbz",o.getBzbz());
			paramMap.put("qdzt",o.getQdzt());
			paramMap.put("gdbz",o.getGdbz());
			paramMap.put("gdrq",o.getGdrq());
			paramMap.put("czydm",o.getCzydm());
			paramMap.put("scsj",o.getScsj());
			paramMap.put("dybz",o.getDybz());
			paramMap.put("gzrq",o.getGzrq());
			paramMap.put("czrq",o.getCzrq());
			paramMap.put("ydxh",o.getYdxh());
			paramMap.put("ddxh",o.getDdxh());
			paramMap.put("gkmc",o.getGkmc());
			paramMap.put("jsbz",o.getJsbz());
			paramMap.put("jsxh",o.getJsxh());
			paramMap.put("fsbz",o.getFsbz());
			paramMap.put("gkhm",o.getGkhm());
			paramMap.put("ssjdm",o.getSsjdm());
			paramMap.put("ffrxm",o.getFfrxm());
			paramMap.put("sfdm",o.getSfdm());

			this.genericDao.updateSql(sql, paramMap);
		}	
		
		Monitor monitor = new Monitor();
		monitor.setQsrq(result.get(0).getFfrq());
		monitor.setZzrq(monitor.getQsrq());
		monitor.setTabname("TFFQDZB");
		monitor.setSuccessrecords(result.size());
		try {
			this.saveMonitor(monitor);
		} catch(SQLException ex) {
		} catch(DataAccessException ex) {
		}
	}

	@Override
	public void doSaveFfqdyj(List<Tyjxxb> result) {
		if(result == null || result.isEmpty()) {
			return;
		}
		String sql = "merge into tyjxxb a"
				+ " using (select :ffqdid ffqdid, :yjtm yjtm from dual) b"
				+ " on (a.yjtm=b.yjtm and a.ffqdid=b.ffqdid)"
				+ " when NOT MATCHED then"
				+ " insert ("
				+ "  yjid,qsqdid,ffqdid,qsxh,ffxh,yjtm,yjhm,yjzl,sjjdm,jdjdm,zl,beizhudm,ghbz,yjzt,sjly,"
				+ "gdbz,gdrq,sjrxm,sjrdz,ysyjtm,cjdm,yjtj,jjryb,sjryb,xzqhdm,mzbz,ybjybz,gkyjzl,gkjdj,"
				+ "bzbz,ddxh,sjrq,gkczydm,gkbz,zjxxbz,bzxx,ysjdj,fjjbz,ssjdm,pcdm,qyjid,gjthm,"
				+ "gjczy,ffrq,gzrq)"
				+ " values( "
				+ " :yjid,:qsqdid,:ffqdid,:qsxh,:ffxh,:yjtm,:yjhm,:yjzl,:sjjdm,:jdjdm,:zl,:beizhudm,"
				+ ":ghbz,:yjzt,:sjly,:gdbz,to_DATE(:gdrq,'YYYYMMDDHH24MISS') ,:sjrxm,:sjrdz,"
				+ ":ysyjtm,:cjdm,:yjtj,:jjryb,:sjryb,:xzqhdm,:mzbz,:ybjybz,:gkyjzl,:gkjdj,"
				+ ":bzbz,:ddxh,to_DATE(:sjrq,'YYYYMMDDHH24MISS') ,:gkczydm,:gkbz,:zjxxbz,"
				+ ":bzxx,:ysjdj,:fjjbz,:ssjdm,:pcdm,:qyjid,:gjthm,:gjczy,"
				+ "to_DATE(:ffrq,'YYYYMMDDHH24MISS') ,to_DATE(:gzrq,'YYYYMMDDHH24MISS') )";
		Map<String, Object> paramMap = new HashMap<String, Object>();
		for(Tyjxxb o : result) {
			paramMap.clear();
			paramMap.put("yjid",o.getYjid());
			paramMap.put("qsqdid",o.getQsqdid());
			paramMap.put("ffqdid",o.getFfqdid());
			paramMap.put("qsxh",o.getQsxh());
			paramMap.put("ffxh",o.getFfxh());
			paramMap.put("yjtm",o.getYjtm());
			paramMap.put("yjhm",o.getYjhm());
			paramMap.put("yjzl",o.getYjzl());
			paramMap.put("sjjdm",o.getSjjdm());
			paramMap.put("jdjdm",o.getJdjdm());
			paramMap.put("zl",o.getZl());
			paramMap.put("beizhudm",o.getBeizhudm());
			paramMap.put("ghbz",o.getGhbz());
			paramMap.put("yjzt",o.getYjzt());
			paramMap.put("sjly",o.getSjly());
			paramMap.put("gdbz",o.getGdbz());
			paramMap.put("gdrq",o.getGdrq());
			paramMap.put("sjrxm",o.getSjrxm());
			paramMap.put("sjrdz",o.getSjrdz());
			paramMap.put("ysyjtm",o.getYsyjtm());
			paramMap.put("cjdm",o.getCjdm());
			paramMap.put("yjtj",o.getYjtj());
			paramMap.put("jjryb",o.getJjryb());
			paramMap.put("sjryb",o.getSjryb());
			paramMap.put("xzqhdm",o.getXzqhdm());
			paramMap.put("mzbz",o.getMzbz());
			paramMap.put("ybjybz",o.getYbjybz());
			paramMap.put("gkyjzl",o.getGkyjzl());
			paramMap.put("gkjdj",o.getGkjdj());
			paramMap.put("bzbz",o.getBzbz());
			paramMap.put("ddxh",o.getDdxh());
			paramMap.put("sjrq",o.getSjrq());
			paramMap.put("gkczydm",o.getGkczydm());
			paramMap.put("gkbz",o.getGkbz());
			paramMap.put("zjxxbz",o.getZjxxbz());
			paramMap.put("bzxx",o.getBzxx());
			paramMap.put("ysjdj",o.getYsjdj());
			paramMap.put("fjjbz",o.getFjjbz());
			paramMap.put("ssjdm",o.getSsjdm());
			paramMap.put("pcdm",o.getPcdm());
			paramMap.put("qyjid",o.getQyjid());
			paramMap.put("gjthm",o.getGjthm());
			paramMap.put("gjczy",o.getGjczy());
			paramMap.put("ffrq",o.getFfrq());
			paramMap.put("gzrq",o.getGzrq());
			paramMap.put("sfdm",o.getSfdm());

			this.genericDao.updateSql(sql, paramMap);
		}	
		
		Monitor monitor = new Monitor();
		monitor.setQsrq(result.get(0).getGzrq());
		monitor.setZzrq(monitor.getQsrq());
		monitor.setTabname("TYJXXB");
		monitor.setSuccessrecords(result.size());
		try {
			this.saveMonitor(monitor);
		} catch(SQLException ex) {
		} catch(DataAccessException ex) {
		}
	}

	@Override
	public void doSaveYjzlxx(List<JcYjzlxxb> result) {
		if(result == null || result.isEmpty()) {
			return;
		}
		
		String sql = "merge into JC_T_YLXXZB a"
				+ " using (select :yjzldm yjzldm, :yjzlmc yjzlmc from dual) b"
				+ " on (a.yjzldm=b.yjzldm and a.yjzlmc=b.yjzlmc)"
				+ " when NOT MATCHED then"
				+ " insert (yjzldm, yjzlmc, sscj, kdbz)"
				+ " values( "
				+ " :yjzldm, :yjzlmc, :sscj, :kdbz)";
		Map<String, Object> paramMap = new HashMap<String, Object>();
		for(JcYjzlxxb o : result) {
			paramMap.clear();
			
			paramMap.put("yjzldm",o.getYjzldm());
			paramMap.put("yjzlmc",o.getYjzlmc());
			paramMap.put("sscj",o.getSscj());
			paramMap.put("kdbz",o.getKdbz());

			this.genericDao.updateSql(sql, paramMap);
		}	
		
		Monitor monitor = new Monitor();
		monitor.setQsrq(" ");
		monitor.setZzrq(monitor.getQsrq());
		monitor.setTabname("TYJXXB");
		monitor.setSuccessrecords(result.size());
		try {
			this.saveMonitor(monitor);
		} catch(SQLException ex) {
		} catch(DataAccessException ex) {
		}
	}

	@Override
	public void doSaveJcTcjxx(List<JcTcjxxb> result) {
		if(result == null || result.isEmpty()) {
			return;
		}
		
		String sql = "merge into TCJXXB a"
				+ " using (select :cjdm cjdm from dual) b"
				+ " on (a.cjdm=b.cjdm)"
				+ " when NOT MATCHED then"
				+ " insert "
				+ " (ssdw, cjdm, cjmc, cjjp, cjjc, sndm, cjlx, "
				+ " ssbm, sxbz, xfsj, xfbz, bbh, dapbz, "
				+ " daptime, sendbz, sendtime) "
				+ " values "
				+ " (:ssdw, :cjdm, :cjmc, :cjjp, :cjjc, "
				+ " :sndm, :cjlx, :ssbm, :sxbz, "
				+ " to_date(:xfsj,'yyyymmddhh24miss'), :xfbz, "
				+ " :bbh, :dapbz, to_date(:daptime,'yyyymmddhh24miss'), "
				+ " :sendbz, to_date(:sendtime,'yyyymmddhh24miss')) ";

		Map<String, Object> paramMap = new HashMap<String, Object>();
		for(JcTcjxxb o : result) {
			paramMap.clear();
			
			paramMap.put("ssdw",o.getSsdw());
			paramMap.put("cjdm",o.getCjdm());
			paramMap.put("cjmc",o.getCjmc());
			paramMap.put("cjjp",o.getCjjp());
			paramMap.put("cjjc",o.getCjjc());
			paramMap.put("sndm",o.getSndm());
			paramMap.put("cjlx",o.getCjlx());
			paramMap.put("ssbm",o.getSsbm());
			paramMap.put("sxbz",o.getSxbz());
			paramMap.put("xfsj",o.getXfsj());
			paramMap.put("xfbz",o.getXfbz());
			paramMap.put("bbh",o.getBbh());
			paramMap.put("dapbz",o.getDapbz());
			paramMap.put("daptime",o.getDaptime());
			paramMap.put("sendbz",o.getSendbz());
			paramMap.put("sendtime",o.getSendtime());
			
			this.genericDao.updateSql(sql, paramMap);
		}	
		
		Monitor monitor = new Monitor();
		monitor.setQsrq(" ");
		monitor.setZzrq(monitor.getQsrq());
		monitor.setTabname("TCJXXB");
		monitor.setSuccessrecords(result.size());
		try {
			this.saveMonitor(monitor);
		} catch(SQLException ex) {
		} catch(DataAccessException ex) {
		}
	}

	@Override
	public void doSaveJcYjzldygx(List<JcYjzldygx> result) {
		if(result == null || result.isEmpty()) {
			return;
		}
		
		String sql = "merge into JC_YJZLDYGXB a"
				+ " using (select :yjzldm yjzldm,:yjzlmc yjzlmc from dual) b"
				+ " on (a.yjzldm=b.yjzldm and a.yjzlmc=b.yjzlmc)"
				+ " when NOT MATCHED then"
				+ " insert "
				+ " (yjzldm, yjzlmc, cpbh, sjly, "
				+ " zsds, zsjs, jsbz, kdbz, kdjssx, "
				+ " zlgsyth, pfjssx, zlgspf)"
				+ " values "
				+ " (:yjzldm, :yjzlmc, :cpbh, :sjly, "
				+ " :zsds, :zsjs, :jsbz, :kdbz, :kdjssx, "
				+ " :zlgsyth, :pfjssx, :zlgspf)";

		Map<String, Object> paramMap = new HashMap<String, Object>();
		for(JcYjzldygx o : result) {
			paramMap.clear();
			
			paramMap.put("yjzldm",o.getYjzldm());
			paramMap.put("yjzlmc",o.getYjzlmc());
			paramMap.put("cpbh",o.getCpbh());
			paramMap.put("sjly",o.getSjly());
			paramMap.put("zsds",o.getZsds());
			paramMap.put("zsjs",o.getZsjs());
			paramMap.put("jsbz",o.getJsbz());
			paramMap.put("kdbz",o.getKdbz());
			paramMap.put("kdjssx",o.getKdjssx());
			paramMap.put("zlgsyth",o.getZlgsyth());
			paramMap.put("pfjssx",o.getPfjssx());
			paramMap.put("zlgspf",o.getZlgspf());
			
			this.genericDao.updateSql(sql, paramMap);
		}	
		
		Monitor monitor = new Monitor();
		monitor.setQsrq(" ");
		monitor.setZzrq(monitor.getQsrq());
		monitor.setTabname("YJZLDYGX");
		monitor.setSuccessrecords(result.size());
		try {
			this.saveMonitor(monitor);
		} catch(SQLException ex) {
		} catch(DataAccessException ex) {
		}
	}

	@Override
	public void doSaveYjzljbb(List<Tyjzljbb> result) {
		if(result == null || result.isEmpty()) {
			return;
		}
		
		String sql = "merge into TYJZLJBB a"
				+ " using (select :id id from dual) b"
				+ " on (a.id=b.id)"
				+ " when NOT MATCHED then"
				+ " insert "
				+ " (id, name, parentid)"
				+ " values "
				+ " (:id, :name, :parentid)";

		Map<String, Object> paramMap = new HashMap<String, Object>();
		for(Tyjzljbb o : result) {
			paramMap.clear();
			
			paramMap.put("id",o.getId());
			paramMap.put("name",o.getName());
			paramMap.put("parentid",o.getParentid());
			
			this.genericDao.updateSql(sql, paramMap);
		}	
		
		Monitor monitor = new Monitor();
		monitor.setQsrq(" ");
		monitor.setZzrq(monitor.getQsrq());
		monitor.setTabname("Tyjzljbb");
		monitor.setSuccessrecords(result.size());
		try {
			this.saveMonitor(monitor);
		} catch(SQLException ex) {
		} catch(DataAccessException ex) {
		}
	}

	@Override
	public void doSaveYjzlgsb(List<Tyjzlgsb> result) {
		if(result == null || result.isEmpty()) {
			return;
		}
		
		String sql = " insert into TYJZLGSB a"
				+ " (yjzldm, jb_1, jb_2, "
				+ " jb_3, jb_4, jb_5)"
				+ " values "
				+ " (:yjzldm, :jb_1, :jb_2, "
				+ " :jb_3, :jb_4, :jb_5)";

		Map<String, Object> paramMap = new HashMap<String, Object>();
		for(Tyjzlgsb o : result) {
			paramMap.clear();
			
			paramMap.put("yjzldm",o.getYjzldm());
			paramMap.put("jb_1",o.getJb_1());
			paramMap.put("jb_2",o.getJb_2());
			paramMap.put("jb_3",o.getJb_3());
			paramMap.put("jb_4",o.getJb_4());
			paramMap.put("jb_5",o.getJb_5());
			
			this.genericDao.updateSql(sql, paramMap);
		}	
		
		Monitor monitor = new Monitor();
		monitor.setQsrq(" ");
		monitor.setZzrq(monitor.getQsrq());
		monitor.setTabname("Tyjzlgsb");
		monitor.setSuccessrecords(result.size());
		try {
			this.saveMonitor(monitor);
		} catch(SQLException ex) {
		} catch(DataAccessException ex) {
		}
	}

	@Override
	public void doSaveTYjzlb(List<JcTYjzlb> result) {
		if(result == null || result.isEmpty()) {
			return;
		}

		String sql = "merge into tyjzlb  a"
				+ " using (select :yjzlbh yjzlbh,:yjzlmc yjzlmc from dual) b"
				+ " on (a.yjzlbh=b.yjzlbh and a.yjzlmc=b.yjzlmc)"
				+ " when NOT MATCHED then"
				+ " insert "
				+ " (yjzlbh, yjzlmc, yjzljc, mcjp, czrq, "
				+ " bpdh, zlsx, zdsx, zlbz, gxsx, xfbz, "
				+ " xfsj, bbh, dapbz, daptime)"
				+ " values "
				+ " (:yjzlbh, :yjzlmc, :yjzljc, :mcjp, "
				+ " :czrq, :bpdh, :zlsx, :zdsx, :zlbz, "
				+ " :gxsx, :xfbz, to_date(:xfsj,'yyyymmddhh24miss'), "
				+ " :bbh, :dapbz,to_date(:daptime,'yyyymmddhh24miss'))";

		Map<String, Object> paramMap = new HashMap<String, Object>();
		for(JcTYjzlb o : result) {
			paramMap.clear();
			paramMap.put("yjzlbh",o.getYjzlbh());
			paramMap.put("yjzlmc",o.getYjzlmc());
			paramMap.put("yjzljc",o.getYjzljc());
			paramMap.put("mcjp",o.getMcjp());
			paramMap.put("czrq",o.getCzrq());
			paramMap.put("bpdh",o.getBpdh());
			paramMap.put("zlsx",o.getZlsx());
			paramMap.put("zdsx",o.getZdsx());
			paramMap.put("zlbz",o.getZlbz());
			paramMap.put("gxsx",o.getGxsx());
			paramMap.put("xfbz",o.getXfbz());
			paramMap.put("xfsj",o.getXfsj());
			paramMap.put("bbh",o.getBbh());
			paramMap.put("dapbz",o.getDapbz());
			paramMap.put("daptime",o.getDaptime());
			
			this.genericDao.updateSql(sql, paramMap);
		}	
		
		Monitor monitor = new Monitor();
		monitor.setQsrq(" ");
		monitor.setZzrq(monitor.getQsrq());
		monitor.setTabname("Tyjzljbb");
		monitor.setSuccessrecords(result.size());
		try {
			this.saveMonitor(monitor);
		} catch(SQLException ex) {
		} catch(DataAccessException ex) {
		}
	}

}
