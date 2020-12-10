package com.dvt.snjs.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.dvt.core.dao.springjdbc.GenericDao;
import com.dvt.snjs.dubbo.model.*;
import com.dvt.snjs.service.YwxxService;
import com.dvt.snjs.util.JscppUtil;

public class YwxxServiceImpl implements YwxxService {
	
	private GenericDao genericDao;

	public void setGenericDao(GenericDao genericDao) {
		this.genericDao = genericDao;
	}

	@Override
	public List<Qfdztb> getQfdztb(String sfdm) {
		String sql = "select /*+INDEX(T SN_GD_QFDZTB_IND1)*/ "
				+ "FDID,JKLDID,CKLDID,FCJ,FCZ,JSJ,JSZ,FDLX,FDZT,JHZL,JKSJ,CKSJ,"
				+ "TO_CHAR(JKRQ,'YYYYMMDDHH24MISS') JKRQ,"
				+ "TO_CHAR(CKRQ,'YYYYMMDDHH24MISS') CKRQ,"
				+ "ZBSL,DSL,JSL,XSL,HSL,ZBTM,ZL,TJCLBZ,"
				+ "TO_CHAR(SJKCSJ,'YYYYMMDDHH24MISS') SJKCSJ,"
				+ "TO_CHAR(SJDDSJ,'YYYYMMDDHH24MISS') SJDDSJ,"
				+ "BBH,TO_CHAR(TIME,'YYYYMMDDHH24MISS') TIME,"
				+ "TO_CHAR(QSTIME,'YYYYMMDDHH24MISS') QSTIME,"
				+ "FSCJ,QSCJ,FCZLX,XJZLX,YLDM,LDHM,LDLSH,DWXX,"
				+ "TO_CHAR(ESBTIME,'YYYYMMDDHH24MISS') ESBTIME,"
				+ "PCDH,JBCBZ,JBRXM,JCZCLBZ,FCDW,JSDW,GDBZ,SFDM"
				+ " FROM SN_GD_QFDZTB T"
				+ " WHERE sfdm=:sfdm"
				+ " and rownum<" + JscppUtil.rownum;
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("sfdm", sfdm);
		return this.genericDao.getList(sql, paramMap, fdRowMapper);
	}

	@Override
	public void doDeleteQfdztb(String sfdm, List<Qfdztb> result) {
		if(result == null || result.isEmpty()) {
			return;
		}
		String sql = "delete /*+INDEX(T SN_GD_QFDZTB_IND1)*/"
				+ " from sn_gd_qfdztb T"
				+ " where fdid=:fdid"
				+ " and sfdm=:sfdm"
				+ " and jkrq = to_date(:jkrq,'yyyymmddhh24miss')";
		Map<String, Object> paramMap = new HashMap<String, Object>();
		for(Qfdztb o : result) {
			paramMap.clear();
			paramMap.put("fdid", o.getFdid());
			paramMap.put("sfdm", sfdm);
			paramMap.put("jkrq", o.getJkrq());
			this.genericDao.updateSql(sql, paramMap);
		}
	}

	@Override
	public List<Qzbxxb> getQzbxxb(String sfdm) {
		String sql = "select /*+INDEX(T SN_GD_QZBXXB_IND1)*/"
				+ " ZBID,FDID,ZBTM,ZBLX,HFBZ,"
				+ "TO_CHAR(FFRQ,'YYYYMMDDHH24MISS') FFRQ,"
				+ "FJLX,ZBZT,ZBHM,YJZL,YJJDM,JDJDM,BZBZ,CZRQ,"
				+ "ZL,YDXH,BZDM,CJDM,YJJS,GHFS,"
				+ "TO_CHAR(SCSJ,'YYYYMMDDHH24MISS') SCSJ,SFDM"
				+ " FROM SN_GD_QZBXXB T"
				+ " where sfdm=:sfdm"
				+ " and rownum<" + JscppUtil.rownum;
		
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("sfdm", sfdm);
		return this.genericDao.getList(sql, paramMap, zbRowMapper);
	}

	@Override
	public void doDeleteQzbxxb(String sfdm, List<Qzbxxb> result) {
		if(result == null || result.isEmpty()) {
			return;
		}
		String sql = "delete /*+INDEX(T SN_GD_QZBXXB_IND1)*/"
				+ " from sn_gd_qzbxxb T"
				+ " where fdid=:fdid"
				+ " and zbid=:zbid"
				+ " and sfdm=:sfdm"
				+ " and ffrq = to_date(:ffrq,'yyyymmddhh24miss')";
		Map<String, Object> paramMap = new HashMap<String, Object>();
		for(Qzbxxb o : result) {
			paramMap.clear();
			paramMap.put("fdid", o.getFdid());
			paramMap.put("zbid", o.getZbid());
			paramMap.put("sfdm", sfdm);
			paramMap.put("ffrq", o.getFfrq());
			this.genericDao.updateSql(sql, paramMap);
		}
	}

	@Override
	public List<Qqdxxb> getQqdxxb(String sfdm) {
		String sql = "select /*+INDEX(T SN_GD_QQDXXB_IND1)*/ "
				+ " QDID,ZBTM,TO_CHAR(FFRQ,'YYYYMMDDHH24MISS') FFRQ,"
				+ "YJJDM,JDJDM,YJZL,SJLY,"
				+ "TO_CHAR(SCSJ,'YYYYMMDDHH24MISS') SCSJ,"
				+ "SCJG,BY1,JBBZ,SFDM"
				+ " FROM SN_GD_QQDXXB T"
				+ " WHERE sfdm=:sfdm"
				+ " and rownum<" + JscppUtil.rownum;
		
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("sfdm", sfdm);
		return this.genericDao.getList(sql, paramMap, qdRowMapper);
	}

	@Override
	public void doDeleteQqdxxb(String sfdm, List<Qqdxxb> result) {
		if(result == null || result.isEmpty()) {
			return;
		}
		String sql = "delete /*+INDEX(T SN_GD_QQDXXB_IND1)*/ "
				+ " from sn_gd_qqdxxb T"
				+ " where qdid=:qdid"
				+ " and sfdm=:sfdm"
				+ " and ffrq = to_date(:ffrq,'yyyymmddhh24miss')";
		Map<String, Object> paramMap = new HashMap<String, Object>();
		for(Qqdxxb o : result) {
			paramMap.clear();
			paramMap.put("qdid", o.getQdid());
			paramMap.put("sfdm", sfdm);
			paramMap.put("ffrq", o.getFfrq());
			this.genericDao.updateSql(sql, paramMap);
		}
	}

	@Override
	public List<Qyjxxb> getQyjxxb(String sfdm) {
		String sql = "SELECT /*+INDEX(T SN_GD_QYJXXB_IND1)*/"
				+ " QDID,YJTM,TO_CHAR(SCSJ,'YYYYMMDDHH24MISS') SCSJ,"
				+ "ZL,YJZL,SFDM"
				+ " FROM SN_GD_QYJXXB T"
				+ " WHERE sfdm=:sfdm"
				+ " and rownum<" + JscppUtil.rownum;
		
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("sfdm", sfdm);
		return this.genericDao.getList(sql, paramMap, qdyjRowMapper);
	}

	@Override
	public void doDeleteQyjxxb(String sfdm, List<Qyjxxb> result) {
		if(result == null || result.isEmpty()) {
			return;
		}
		String sql = "delete /*+INDEX(T SN_GD_QYJXXB_IND1)*/"
				+ " from sn_gd_qyjxxb T"
				+ " where yjtm=:yjtm"
				+ " and qdid=:qdid"
				+ " and sfdm=:sfdm"
				+ " and scsj = to_date(:scsj,'yyyymmddhh24miss')";
		Map<String, Object> paramMap = new HashMap<String, Object>();
		for(Qyjxxb o : result) {
			paramMap.clear();
			paramMap.put("yjtm", o.getYjtm());
			paramMap.put("qdid", o.getQdid());
			paramMap.put("sfdm", sfdm);
			paramMap.put("scsj", o.getScsj());
			this.genericDao.updateSql(sql, paramMap);
		}
	}

	@Override
	public List<Qyjjbxxb> getQyjjbxxb(String sfdm) {
		String sql = "SELECT /*+INDEX(T SN_GD_QYJJBXXB_IND1)*/ "
				+ "YJTM,YJBZ,YJZLDM,SJJDM,JDJDM,YJZL,YJTJ,"
				+ "TO_CHAR(SCSJ,'YYYYMMDDHH24MISS') SCSJ,"
				+ "TO_CHAR(SJRQ,'YYYYMMDDHH24MISS') SJRQ,"
				+ "YJLY,JFZL,JDGDM,TXDM,YPDJBZ,SFDM,ZZF,YHJE,BZXBZ,ZWSX,KHBM"
				+ " FROM SN_GD_QYJJBXXB T"
				+ " where sfdm=:sfdm"
				+ " and rownum<" + JscppUtil.rownum;
		
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("sfdm", sfdm);
		return this.genericDao.getList(sql, paramMap, sjxxRowMapper);
	}

	@Override
	public void doDeleteQyjjbxxb(String sfdm, List<Qyjjbxxb> result) {
		if(result == null || result.isEmpty()) {
			return;
		}
		String sql = "delete /*+INDEX(T SN_GD_QYJJBXXB_IND1)*/"
				+ " from sn_gd_qyjjbxxb T"
				+ " where yjtm=:yjtm"
				+ " and sjjdm=:sjjdm"
				+ " and sfdm=:sfdm"
				+ " and yjbz=:yjbz"
				+ " and sjrq = to_date(:sjrq,'yyyymmddhh24miss')";
		Map<String, Object> paramMap = new HashMap<String, Object>();
		for(Qyjjbxxb o : result) {
			paramMap.clear();
			paramMap.put("yjtm", o.getYjtm());
			paramMap.put("sjjdm", o.getSjjdm());
			paramMap.put("sfdm", sfdm);
			paramMap.put("sjrq", o.getSjrq());
			paramMap.put("yjbz", o.getYjbz());
			this.genericDao.updateSql(sql, paramMap);
		}
	}

	@Override
	public List<GdTdxxb> getGdTdxxb(String sfdm) {
		String sql = "select /*+INDEX(T SN_GD_TDXXB_IND1)*/"
				+ " yjid,yjtm,to_char(TDRQ,'yyyymmddhh24miss') tdrq,tdjdm,"
				+ " yjzl,yjzlmc,zl,sftt,to_char(SCSJ,'yyyymmddhh24miss') scsj,sjly,"
				+ " to_char(TDDJSJ,'yyyymmddhh24miss') tddjsj,to_char(GXRQ,'yyyymmddhh24miss') gxrq,clbz,jkclbz,sfdm,tdy"
				+ " from sn_gd_tdxxb T"
				+ " where sfdm=:sfdm"
				+ " and rownum<" + JscppUtil.rownum;
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("sfdm", sfdm);
		return this.genericDao.getList(sql, paramMap, gdTdxxRowMapper);
	}

	@Override
	public void doDeleteGdTdxxb(String sfdm, List<GdTdxxb> result) {
		if(result == null || result.isEmpty()) {
			return;
		}
		String sql = "delete /*+INDEX(T SN_GD_TDXXB_IND1)*/"
				+ " from sn_gd_tdxxb T"
				+ " where sfdm=:sfdm"
				+ " and yjtm=:yjtm"
				+ " and tdjdm=:tdjdm"
				+ " and sftt=:sftt"
				+ " and tdrq=to_date(:tdrq,'yyyymmddhh24miss')";
		Map<String, Object> paramMap = new HashMap<String, Object>();
		for(GdTdxxb o : result) {
			paramMap.clear();
			paramMap.put("sfdm", sfdm);
			paramMap.put("tdjdm", o.getTdjdm());
			paramMap.put("yjtm", o.getYjtm());
			paramMap.put("sftt", o.getSftt());
			paramMap.put("tdrq", o.getTdrq());
			this.genericDao.updateSql(sql, paramMap);
		}
	}

	@Override
	public String getXfkzb(String sfdm) {
		String sql = "SELECT SFDM,TABNAME"
				+ " FROM SNJS_XFKZB"
				+ " where sfdm=:sfdm";
		
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("sfdm", sfdm);
		List<Xfkzb> list = this.genericDao.getList(sql, paramMap, sfkzbRowMapper);
		String tabnamepj = "";
		for (int i = 0; i < list.size(); i++) {
			tabnamepj += list.get(i).getTabname();
		}
		return tabnamepj;
	}

	@Override
	public List<TmpFdxxb> getTmpFdxxb(String sfdm) {
		String sql = "select fdid,gls,fcz,jsz,pyj,yldm,ldlsh,zbsl,ysclbz,ylzl,"
				+ " to_char(jsrq,'yyyymmddhh24miss') jsrq,sslj,hbbh,ylgs,fcj,yljb,zbtm,"
				+ " to_char(time,'yyyymmddhh24miss') time,jsj,'*' ylfl,sfdm"
				+ " from sn_tmp_fdxxb"
				+ " where sfdm=:sfdm"
				+ " and rownum<" + JscppUtil.rownum;
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("sfdm", sfdm);
		return this.genericDao.getList(sql, paramMap, tmpFdxxRowMapper);
	}

	@Override
	public void doDeleteTmpFdxxb(String sfdm, List<TmpFdxxb> result) {
		if(result == null || result.isEmpty()) {
			return;
		}
		String sql = "delete from sn_tmp_fdxxb"
				+ " where sfdm=:sfdm"
				+ " and fdid=:fdid";
		Map<String, Object> paramMap = new HashMap<String, Object>();
		for(TmpFdxxb o : result) {
			paramMap.clear();
			paramMap.put("sfdm", sfdm);
			paramMap.put("fdid", o.getFdid());
			this.genericDao.updateSql(sql, paramMap);
		}
	}

	@Override
	public List<JcTYlxxzb> getJcTYlxxzb(String sfdm) {
		String sql = "select "
				+ " yljb, ylzl, yldm, ylmc, chc, pyj, sfj, zdj, "
				+ " to_char(qszxrq,'yyyymmddhh24miss') qszxrq, "
				+ " to_char(zzzxrq,'yyyymmddhh24miss') zzzxrq, "
				+ " sslj, gjxh, bgwz, rj, dw, ylxz, sxxbs, "
				+ " zjsx,qcyldm, sfdysdyj, sfdygjyj, "
				+ " gxjs, zwbxx, yqsx, qlc "
				+ " from sn_jc_t_ylxxzb"
				+ " where sfdm=:sfdm"
				+ " and rownum<" + JscppUtil.rownum;
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("sfdm", sfdm);
		return this.genericDao.getList(sql, paramMap, ylxxRowMapper);
	}

	@Override
	public void doDeleteJcTYlxxzb(String sfdm, List<JcTYlxxzb> result) {
		if(result == null || result.isEmpty()) {
			return;
		}
		String sql = "delete from sn_jc_t_ylxxzb"
				+ " where sfdm=:sfdm"
				+ " and yldm=:yldm";
		Map<String, Object> paramMap = new HashMap<String, Object>();
		for(JcTYlxxzb o : result) {
			paramMap.clear();
			paramMap.put("sfdm", sfdm);
			paramMap.put("yldm", o.getYldm());
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
				+ " '02' xtly"
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
	public List<JcJgxxb> getJcJgxxb(String sfdm) {
		String sql = "select jgdm,  jgmc, jggs, sssf, ssds, ssxs, jgjc "
				+ " from sn_ac_jc_jgxxb"
				+ " where sfdm=:sfdm"
				+ " and rownum<" + JscppUtil.rownum;
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("sfdm", sfdm);
		return this.genericDao.getList(sql, paramMap, jgxxRowMapper);
	}

	@Override
	public void doDeleteJcJgxxb(String sfdm, List<JcJgxxb> result) {
		if(result == null || result.isEmpty()) {
			return;
		}
		String sql = "delete from sn_ac_jc_jgxxb"
				+ " where sfdm=:sfdm"
				+ " and jgdm=:jgdm";
		Map<String, Object> paramMap = new HashMap<String, Object>();
		for(JcJgxxb o : result) {
			paramMap.clear();
			paramMap.put("sfdm", sfdm);
			paramMap.put("jgdm", o.getJgdm());
			this.genericDao.updateSql(sql, paramMap);
		}
	}
	@Override
	public List<Tylpcxxb> getTylpcxxb(String sfdm) {
		String sql = "select pcdh,qcyldm,fcyldm,ylzlc,yxts,ldlsh,clid,sydw,cph,jsy,byjsy,yyy,gbcl,jhddr,jhkcr,pcdw,czydm," +
                " czsj,pclx,pcbz,xfbz,xfsj,bbh,gcclid,gccph,jsymc,dapbz,daptime,pccx,jsyphone,cldw,scsj,dw,xtscsj" +
				" from sn_cl_tylpcxxb" +
				" where sfdm=:sfdm" +
				" and rownum < " + JscppUtil.rownum;
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("sfdm", sfdm);
		return this.genericDao.getList(sql, paramMap, ylpcxxbRowMapper);
	}

	@Override
	public void doDeleteTylpcxxb(String sfdm, List<Tylpcxxb> result) {
		String sql = "delete from sn_cl_tylpcxxb where sfdm=:sfdm and pcdh=:pcdh";
		Map<String, Object> paramMap = new HashMap<String, Object>();
		for (Tylpcxxb o : result) {
			paramMap.put("sfdm", sfdm);
			paramMap.put("pcdh", o.getPcdh());
			this.genericDao.updateSql(sql, paramMap);
		}
	}
	@Override
	public List<Tckldzb> getTckldb(String sfdm) {
		String sql = "SELECT ldid,yldm,ldhm,hbcp,to_char(gdrq,'YYYYMMDDHH24MISS') gdrq,cjdm,bcdm,ldzt,ldsx,"
				+ "zzrq,zzsj,zzbc,fsbc,zzczy,fsczy,to_char(fsrq,'YYYYMMDDHH24MISS') fsrq,"
				+ "to_char(gzrq,'YYYYMMDDHH24MISS') gzrq,ldbz,gdbz,ldlsh,scbz,ssjdm,"
				+ "to_char(sjkcsj,'YYYYMMDDHH24MISS') sjkcsj,jbbz,pcdh,jbcbz,"
				+ "pcdhbz,zbsl,zbzl,sfdm"
				+ " FROM sn_tckldzb"
				+ " where sfdm=:sfdm"
				+ " and rownum<" + JscppUtil.rownum;
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("sfdm", sfdm);
		return this.genericDao.getList(sql, paramMap, (rs, i) -> {
			Tckldzb o = new Tckldzb();
			o.setLdid(rs.getString("ldid"));
			o.setYldm(rs.getString("yldm"));
			o.setLdhm(rs.getString("ldhm"));
			o.setHbcp(rs.getString("hbcp"));
			o.setGdrq(rs.getString("gdrq"));
			o.setCjdm(rs.getString("cjdm"));
			o.setBcdm(rs.getString("bcdm"));
			o.setLdzt(rs.getString("ldzt"));
			o.setLdsx(rs.getString("ldsx"));
			o.setZzrq(rs.getString("zzrq"));
			o.setZzsj(rs.getString("zzsj"));
			o.setZzbc(rs.getString("zzbc"));
			o.setFsbc(rs.getString("fsbc"));
			o.setZzczy(rs.getString("zzczy"));
			o.setFsczy(rs.getString("fsczy"));
			o.setFsrq(rs.getString("fsrq"));
			o.setGzrq(rs.getString("gzrq"));
			o.setLdbz(rs.getString("ldbz"));
			o.setGdbz(rs.getString("gdbz"));
			o.setLdlsh(rs.getString("ldlsh"));
			o.setScbz(rs.getString("scbz"));
			o.setSsjdm(rs.getString("ssjdm"));
			o.setSjkcsj(rs.getString("sjkcsj"));
			o.setJbbz(rs.getString("jbbz"));
			o.setPcdh(rs.getString("pcdh"));
			o.setJbcbz(rs.getString("jbcbz"));
			o.setPcdhbz(rs.getString("pcdhbz"));
			o.setZbsl(rs.getInt("zbsl"));
			o.setZbzl(rs.getInt("zbzl"));
			o.setSfdm(rs.getString("sfdm"));

			return o;
		});
	}

	@Override
	public void doDeleteTckldzb(String sfdm, List<Tckldzb> result) {
		if(result == null || result.isEmpty()) {
			return;
		}
		String sql = "delete from sn_tckldzb"
				+ " where sfdm=:sfdm"
				+ " and ldid=:ldid"
				+ " and zzrq=:zzrq";
		Map<String, Object> paramMap = new HashMap<String, Object>();
		for(Tckldzb o : result) {
			paramMap.clear();
			paramMap.put("sfdm", sfdm);
			paramMap.put("ldid", o.getLdid());
			paramMap.put("zzrq", o.getZzrq());
			this.genericDao.updateSql(sql, paramMap);
		}
	}

	@Override
	public List<Tzbfjxx> getTzbfjxx(String sfdm) {
		String sql = "select /*+INDEX(T SN_TZBFJXX_IND1)*/"
				+ " zbid,jkldid,ckldid,ssdwbh,lsdbh,lsdmc,zdid,zdmc,xjz,"
				+ "to_char(scsj,'YYYYMMDDHH24MISS') scsj,to_char(rdsj,'YYYYMMDDHH24MISS') rdsj,"
				+ "rdczydm,to_char(cjsj,'YYYYMMDDHH24MISS') cjsj,to_char(ghsj,'YYYYMMDDHH24MISS') ghsj,"
				+ "ghczydm,to_char(kcsj,'YYYYMMDDHH24MISS') kcsj,kcczydm,zbzt,hfbz,zzbz,lhbz,ghbz,fybz,"
				+ "ydhm,zzcc,dsjzbid,flag,cjdm,bcdm,ckbz,gdbz,to_char(gdrq,'YYYYMMDDHH24MISS') gdrq,"
				+ "scbz,jbbz,czydm,gph,ggbf,zbly,fjxxid,ffjdm,ghfs,fcz,smcj,dsjzbtm,fczlx,xjzlx,"
				+ "gbth,ghczym,fcdw,sbtm,tch,zbhm,yjzl,yjjdm,jdjdm,bzbz,czrq,zl,ydxh,bzdm,zbtm,"
				+ "gjzbtm,to_char(ffrq,'YYYYMMDDHH24MISS') ffrq,sfdm"
				+ " from sn_tzbfjxx t"
				+ " where sfdm=:sfdm"
				+ " and rownum<" + JscppUtil.rownum;
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("sfdm", sfdm);
		return this.genericDao.getList(sql, paramMap, (rs, i) -> {
			Tzbfjxx o = new Tzbfjxx();
			o.setZbid(rs.getString("zbid"));
			o.setJkldid(rs.getString("jkldid"));
			o.setCkldid(rs.getString("ckldid"));
			o.setSsdwbh(rs.getInt("ssdwbh"));
			o.setLsdbh(rs.getString("lsdbh"));
			o.setLsdmc(rs.getString("lsdmc"));
			o.setZdid(rs.getString("zdid"));
			o.setZdmc(rs.getString("zdmc"));
			o.setXjz(rs.getString("xjz"));
			o.setScsj(rs.getString("scsj"));
			o.setRdsj(rs.getString("rdsj"));
			o.setRdczydm(rs.getString("rdczydm"));
			o.setCjsj(rs.getString("cjsj"));
			o.setGhsj(rs.getString("ghsj"));
			o.setGhczydm(rs.getString("ghczydm"));
			o.setKcsj(rs.getString("kcsj"));
			o.setKcczydm(rs.getString("kcczydm"));
			o.setZbzt(rs.getString("zbzt"));
			o.setHfbz(rs.getString("hfbz"));
			o.setZzbz(rs.getString("zzbz"));
			o.setLhbz(rs.getString("lhbz"));
			o.setGhbz(rs.getString("ghbz"));
			o.setFybz(rs.getString("fybz"));
			o.setYdhm(rs.getString("ydhm"));
			o.setZzcc(rs.getString("zzcc"));
			o.setDsjzbid(rs.getString("dsjzbid"));
			o.setFlag(rs.getString("flag"));
			o.setCjdm(rs.getString("cjdm"));
			o.setBcdm(rs.getString("bcdm"));
			o.setCkbz(rs.getString("ckbz"));
			o.setGdbz(rs.getString("gdbz"));
			o.setGdrq(rs.getString("gdrq"));
			o.setScbz(rs.getString("scbz"));
			o.setJbbz(rs.getString("jbbz"));
			o.setCzydm(rs.getString("czydm"));
			o.setGph(rs.getString("gph"));
			o.setGgbf(rs.getString("ggbf"));
			o.setZbly(rs.getString("zbly"));
			o.setFjxxid(rs.getString("fjxxid"));
			o.setFfjdm(rs.getString("ffjdm"));
			o.setGhfs(rs.getString("ghfs"));
			o.setFcz(rs.getString("fcz"));
			o.setSmcj(rs.getString("smcj"));
			o.setDsjzbtm(rs.getString("dsjzbtm"));
			o.setFczlx(rs.getString("fczlx"));
			o.setXjzlx(rs.getString("xjzlx"));
			o.setGbth(rs.getString("gbth"));
			o.setGhczym(rs.getString("ghczym"));
			o.setFcdw(rs.getString("fcdw"));
			o.setSbtm(rs.getString("sbtm"));
			o.setTch(rs.getInt("tch"));
			o.setZbhm(rs.getString("zbhm"));
			o.setYjzl(rs.getString("yjzl"));
			o.setYjjdm(rs.getString("yjjdm"));
			o.setJdjdm(rs.getString("jdjdm"));
			o.setBzbz(rs.getString("bzbz"));
			o.setCzrq(rs.getString("czrq"));
			o.setZl(rs.getString("zl"));
			o.setYdxh(rs.getString("ydxh"));
			o.setBzdm(rs.getString("bzdm"));
			o.setZbtm(rs.getString("zbtm"));
			o.setGjzbtm(rs.getString("gjzbtm"));
			o.setFfrq(rs.getString("ffrq"));
			o.setSfdm(rs.getString("sfdm"));
			return o;
		});
	}

	@Override
	public void doDeleteTzbfjxx(String sfdm, List<Tzbfjxx> result) {
		if(result == null || result.isEmpty()) {
			return;
		}
		String sql = "delete /*+INDEX(T SN_TZBFJXX_IND1)*/"
				+ " from sn_tzbfjxx t"
				+ " where sfdm=:sfdm"
				+ " and ckldid=:ckldid"
				+ " and zbid=:zbid"
				+ " and ffrq=to_date(:ffrq,'yyyymmddhh24miss')";
		Map<String, Object> paramMap = new HashMap<String, Object>();
		for(Tzbfjxx o : result) {
			paramMap.clear();
			paramMap.put("sfdm", sfdm);
			paramMap.put("ckldid", o.getCkldid());
			paramMap.put("zbid", o.getZbid());
			paramMap.put("ffrq", o.getFfrq());
			this.genericDao.updateSql(sql, paramMap);
		}
	}

	@Override
	public List<Tffqdzb> getTffqdzb(String sfdm) {

		String sql = "select qdid,zbtm,qdhm,yjzl,ffjdm,jdjdm,cjdm,to_char(ffrq,'YYYYMMDDHH24MISS') ffrq,"
				+ "bcdm,txdm,ffrdm,yjjs,qdgg,qdlx,beizhudm,bzbz,qdzt,gdbz,"
				+ "to_char(gdrq,'YYYYMMDDHH24MISS') gdrq,czydm,"
				+ "to_char(scsj,'YYYYMMDDHH24MISS') scsj,dybz,"
				+ "to_char(gzrq,'YYYYMMDDHH24MISS') gzrq,czrq,ydxh,ddxh,gkmc,"
				+ "jsbz,jsxh,fsbz,gkhm,ssjdm,ffrxm,sfdm"
				+ " from sn_tffqdzb"
				+ " where sfdm=:sfdm"
				+ " and rownum<" + JscppUtil.rownum;
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("sfdm", sfdm);
		return this.genericDao.getList(sql, paramMap, (rs, i) -> {
			Tffqdzb o = new Tffqdzb();
			o.setQdid(rs.getString("qdid"));
			o.setZbtm(rs.getString("zbtm"));
			o.setQdhm(rs.getString("qdhm"));
			o.setYjzl(rs.getString("yjzl"));
			o.setFfjdm(rs.getString("ffjdm"));
			o.setJdjdm(rs.getString("jdjdm"));
			o.setCjdm(rs.getString("cjdm"));
			o.setFfrq(rs.getString("ffrq"));
			o.setBcdm(rs.getString("bcdm"));
			o.setTxdm(rs.getString("txdm"));
			o.setFfrdm(rs.getString("ffrdm"));
			o.setYjjs(rs.getInt("yjjs"));
			o.setQdgg(rs.getString("qdgg"));
			o.setQdlx(rs.getString("qdlx"));
			o.setBeizhudm(rs.getString("beizhudm"));
			o.setBzbz(rs.getString("bzbz"));
			o.setQdzt(rs.getString("qdzt"));
			o.setGdbz(rs.getString("gdbz"));
			o.setGdrq(rs.getString("gdrq"));
			o.setCzydm(rs.getString("czydm"));
			o.setScsj(rs.getString("scsj"));
			o.setDybz(rs.getString("dybz"));
			o.setGzrq(rs.getString("gzrq"));
			o.setCzrq(rs.getString("czrq"));
			o.setYdxh(rs.getString("ydxh"));
			o.setDdxh(rs.getInt("ddxh"));
			o.setGkmc(rs.getString("gkmc"));
			o.setJsbz(rs.getString("jsbz"));
			o.setJsxh(rs.getString("jsxh"));
			o.setFsbz(rs.getString("fsbz"));
			o.setGkhm(rs.getString("gkhm"));
			o.setSsjdm(rs.getString("ssjdm"));
			o.setFfrxm(rs.getString("ffrxm"));
			o.setSfdm(rs.getString("sfdm"));
			return o;
		});
	}

	@Override
	public void doDeleteTffqdzb(String sfdm, List<Tffqdzb> result) {
		if(result == null || result.isEmpty()) {
			return;
		}
		String sql = "delete from sn_tffqdzb"
				+ " where sfdm=:sfdm"
				+ " and qdid=:qdid"
				+ " and ffrq=to_date(:ffrq,'yyyymmddhh24miss')";
		Map<String, Object> paramMap = new HashMap<String, Object>();
		for(Tffqdzb o : result) {
			paramMap.clear();
			paramMap.put("sfdm", sfdm);
			paramMap.put("qdid", o.getQdid());
			paramMap.put("ffrq", o.getFfrq());
			this.genericDao.updateSql(sql, paramMap);
		}
	}

	@Override
	public List<Tyjxxb> getTyjxxb(String sfdm) {

		String sql = "select yjid,qsqdid,ffqdid,qsxh,ffxh,yjtm,yjhm,yjzl,sjjdm,jdjdm,zl,"
				+ "beizhudm,ghbz,yjzt,sjly,gdbz,to_char(gdrq,'YYYYMMDDHH24MISS') gdrq,"
				+ "sjrxm,sjrdz,ysyjtm,cjdm,yjtj,jjryb,sjryb,xzqhdm,mzbz,ybjybz,gkyjzl,"
				+ "gkjdj,bzbz,ddxh,to_char(sjrq,'YYYYMMDDHH24MISS') sjrq,"
				+ "gkczydm,gkbz,zjxxbz,bzxx,ysjdj,fjjbz,ssjdm,pcdm,qyjid,gjthm,gjczy,"
				+ "to_char(ffrq,'YYYYMMDDHH24MISS') ffrq,"
				+ "to_char(gzrq,'YYYYMMDDHH24MISS') gzrq,sfdm"
				+ " from sn_tyjxxb"
				+ " where sfdm=:sfdm"
				+ " and rownum<" + JscppUtil.rownum;
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("sfdm", sfdm);
		return this.genericDao.getList(sql, paramMap, (rs, i) -> {
			Tyjxxb o = new Tyjxxb();
			o.setYjid(rs.getString("yjid"));
			o.setQsqdid(rs.getString("qsqdid"));
			o.setFfqdid(rs.getString("ffqdid"));
			o.setQsxh(rs.getInt("qsxh"));
			o.setFfxh(rs.getInt("ffxh"));
			o.setYjtm(rs.getString("yjtm"));
			o.setYjhm(rs.getString("yjhm"));
			o.setYjzl(rs.getString("yjzl"));
			o.setSjjdm(rs.getString("sjjdm"));
			o.setJdjdm(rs.getString("jdjdm"));
			o.setZl(rs.getInt("zl"));
			o.setBeizhudm(rs.getString("beizhudm"));
			o.setGhbz(rs.getString("ghbz"));
			o.setYjzt(rs.getString("yjzt"));
			o.setSjly(rs.getString("sjly"));
			o.setGdbz(rs.getString("gdbz"));
			o.setGdrq(rs.getString("gdrq"));
			o.setSjrxm(rs.getString("sjrxm"));
			o.setSjrdz(rs.getString("sjrdz"));
			o.setYsyjtm(rs.getString("ysyjtm"));
			o.setCjdm(rs.getString("cjdm"));
			o.setYjtj(rs.getInt("yjtj"));
			o.setJjryb(rs.getString("jjryb"));
			o.setSjryb(rs.getString("sjryb"));
			o.setXzqhdm(rs.getString("xzqhdm"));
			o.setMzbz(rs.getString("mzbz"));
			o.setYbjybz(rs.getString("ybjybz"));
			o.setGkyjzl(rs.getString("gkyjzl"));
			o.setGkjdj(rs.getString("gkjdj"));
			o.setBzbz(rs.getString("bzbz"));
			o.setDdxh(rs.getInt("ddxh"));
			o.setSjrq(rs.getString("sjrq"));
			o.setGkczydm(rs.getString("gkczydm"));
			o.setGkbz(rs.getString("gkbz"));
			o.setZjxxbz(rs.getString("zjxxbz"));
			o.setBzxx(rs.getString("bzxx"));
			o.setYsjdj(rs.getString("ysjdj"));
			o.setFjjbz(rs.getString("fjjbz"));
			o.setSsjdm(rs.getString("ssjdm"));
			o.setPcdm(rs.getString("pcdm"));
			o.setQyjid(rs.getString("qyjid"));
			o.setGjthm(rs.getInt("gjthm"));
			o.setGjczy(rs.getString("gjczy"));
			o.setFfrq(rs.getString("ffrq"));
			o.setGzrq(rs.getString("gzrq"));
			o.setSfdm(rs.getString("sfdm"));

			return o;
		});
	}

	@Override
	public void doDeleteTyjxxb(String sfdm, List<Tyjxxb> result) {
		if(result == null || result.isEmpty()) {
			return;
		}
		String sql = "delete from sn_tyjxxb"
				+ " where sfdm=:sfdm"
				+ " and ffqdid=:ffqdid"
				+ " and yjtm=:yjtm"
				+ " and gzrq=to_date(:gzrq,'yyyymmddhh24miss')";
		Map<String, Object> paramMap = new HashMap<String, Object>();
		for(Tyjxxb o : result) {
			paramMap.clear();
			paramMap.put("sfdm", sfdm);
			paramMap.put("ffqdid", o.getFfqdid());
			paramMap.put("yjtm", o.getYjtm());
			paramMap.put("gzrq", o.getGzrq());
			this.genericDao.updateSql(sql, paramMap);
		}
	}
	

	@Override
	public List<ZdjsPcyjxxDay> getZdjsPcyj(String sfdm) {
		
		String sql = "select "
				+ " to_char(jsrq,'yyyymmddhh24miss') jsrq,"
				+ " fdid,zbid,yldm,ldhm,ldlsh,fcj,jsj,"
				+ " pcdh,zbtm,yjjdm,jdjdm,yjzldm,cpbh,sscj,"
				+ " zbhm,yjjsf,yjjds,jdjsf,jdjds,zl,jhzl,"
				+ " jssf,bcsf,jsfl,bcfl,jsf,bcf"
				+ " from sn_sjclf_pcyjxx_day"
				+ " where sfdm=:sfdm"
				+ " and rownum<" + JscppUtil.rownum;
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("sfdm", sfdm);
		return this.genericDao.getList(sql, paramMap, pcyjRowMapper);
	}

	@Override
	public void doDeleteZdjsPcyj(String sfdm, List<ZdjsPcyjxxDay> result) {
		if(result == null || result.isEmpty()) {
			return;
		}
		String sql = "delete /*+index(a SN_SJCLF_PCYJXX_DAY_IND2)*/"
				+ " from SN_SJCLF_PCYJXX_DAY a"
				+ " where fdid=:fdid"
				+ " and zbid=:zbid"
				+ " and jsrq=to_date(:jsrq,'yyyymmddhh24miss')"
				+ " and sfdm=:sfdm";
		Map<String, Object> paramMap = new HashMap<String, Object>();
		for(ZdjsPcyjxxDay o : result) {
			paramMap.clear();
			paramMap.put("fdid", o.getFdid());
			paramMap.put("zbid", o.getZbid());
			paramMap.put("jsrq", o.getJsrq());
			paramMap.put("sfdm", sfdm);
			this.genericDao.updateSql(sql, paramMap);
		}
	}

	@Override
	public List<ZdjsGjyjxxDay> getZdjsGjyj(String sfdm) {
		String sql = "select  "
				+ " to_char(jsrq,'yyyymmddhh24miss') jsrq,"
				+ " yjtm,yjzldm,cpbh,sscj,sjjdm,jdjdm,yjzl,"
				+ " sjsf,sjds,sjxs,jdsf,jdds,jdxs,jhzl,jsfl1,"
				+ " jsfl2,jsf,bcfl1,bcfl2,bcf,info"
				+ " from sn_sjclf_gjyjxx_day"
				+ " where sfdm=:sfdm"
				+ " and rownum<" + JscppUtil.rownum;
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("sfdm", sfdm);
		return this.genericDao.getList(sql, paramMap, gjyjRowMapper);
	}

	@Override
	public void doDeleteZdjsGjyj(String sfdm, List<ZdjsGjyjxxDay> result) {
		if(result == null || result.isEmpty()) {
			return;
		}
		String sql = "delete /*+index(a SN_SJCLF_GJYJXX_DAY_IND2)*/"
				+ " from SN_SJCLF_GJYJXX_DAY a"
				+ " where yjtm=:yjtm"
				+ " and sjjdm=:sjjdm"
				+ " and jsrq=to_date(:jsrq,'yyyymmddhh24miss')"
				+ " and sfdm=:sfdm";
		Map<String, Object> paramMap = new HashMap<String, Object>();
		for(ZdjsGjyjxxDay o : result) {
			paramMap.clear();
			paramMap.put("yjtm", o.getYjtm());
			paramMap.put("sjjdm", o.getSjjdm());
			paramMap.put("jsrq", o.getJsrq());
			paramMap.put("sfdm", sfdm);
			this.genericDao.updateSql(sql, paramMap);
		}
	}

	@Override
	public List<ZdjsGjyjxxKsjzDay> getZdjsKsjz(String sfdm) {
		String sql = "select "
				+ " to_char(jsrq,'yyyymmddhh24miss') jsrq, yjtm, "
				+ " yjzldm, cpbh, sscj, sjjdm, jdjdm, "
				+ " yjzl, sjsf, sjds, sjxs, jdsf, jdds, jhzl, "
				+ " jsfl, jsf, bcfl, bcf, jsds, bcds, info" 
				+ " from sn_sjclf_gjyjksjz_day"
				+ " where sfdm=:sfdm"
				+ " and rownum<" + JscppUtil.rownum;
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("sfdm", sfdm);
		return this.genericDao.getList(sql, paramMap, ksjzRowMapper);
	}

	@Override
	public void doDeleteZdjsKsjz(String sfdm, List<ZdjsGjyjxxKsjzDay> result) {
		if(result == null || result.isEmpty()) {
			return;
		}
		String sql = "delete /*+index(a SN_SJCLF_GJYJKSJZ_DAY_IND2)*/"
				+ " from SN_SJCLF_GJYJKSJZ_DAY a"
				+ " where yjtm=:yjtm"
				+ " and sjjdm=:sjjdm"
				+ " and jsrq=to_date(:jsrq,'yyyymmddhh24miss')"
				+ " and sfdm=:sfdm";
		Map<String, Object> paramMap = new HashMap<String, Object>();
		for(ZdjsGjyjxxKsjzDay o : result) {
			paramMap.clear();
			paramMap.put("yjtm", o.getYjtm());
			paramMap.put("sjjdm", o.getSjjdm());
			paramMap.put("jsrq", o.getJsrq());
			paramMap.put("sfdm", sfdm);
			this.genericDao.updateSql(sql, paramMap);
		}
	}

	@Override
	public List<ZdjsSjzyDay> getZdjsSjzy(String sfdm) {
		String sql = "select "
				+ " to_char(jsrq,'yyyymmddhh24miss') jsrq,"
				+ " fdid,zbid,yldm,ldhm,ldlsh,fcj,jsj, pcdh,"
				+ " zbtm,yjjdm,jdjdm,yjzldm,cpbh,sscj,zbhm,yjjsf,"
				+ " jdjsf,fcjsf,zl,jssf,bcsf,jsfl,bcfl,jsf,bcf"
				+ " from SN_SJCLF_CZKZY_DAY"
				+ " where sfdm=:sfdm"
				+ " and rownum<" + JscppUtil.rownum;
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("sfdm", sfdm);
		return this.genericDao.getList(sql, paramMap, sjzyRowMapper);
	}

	@Override
	public void doDeleteZdjsSjzy(String sfdm, List<ZdjsSjzyDay> result) {
		if(result == null || result.isEmpty()) {
			return;
		}
		String sql = "delete /*+index(a SN_SJCLF_CZKZY_DAY_IND2)*/"
				+ " from SN_SJCLF_CZKZY_DAY a"
				+ " where fdid=:fdid"
				+ " and zbid=:zbid"
				+ " and jsrq=to_date(:jsrq,'yyyymmddhh24miss')"
				+ " and sfdm=:sfdm";
		Map<String, Object> paramMap = new HashMap<String, Object>();
		for(ZdjsSjzyDay o : result) {
			paramMap.clear();
			paramMap.put("fdid", o.getFdid());
			paramMap.put("zbid", o.getZbid());
			paramMap.put("jsrq", o.getJsrq());
			paramMap.put("sfdm", sfdm);
			this.genericDao.updateSql(sql, paramMap);
		}
	}

	@Override
	public List<JcYjzlxxb> getYjzlxx(String sfdm) {
		String sql = "select yjzldm, yjzlmc, sscj, kdbz "
				+ " from sn_ac_jc_yjzlxxb"
				+ " where rownum<" + JscppUtil.rownum;
		Map<String, Object> paramMap = new HashMap<String, Object>();
		return this.genericDao.getList(sql, paramMap, yjzlxxRowMapper);
	}

	@Override
	public void doDeleteJcYjzlxxb(String sfdm, List<JcYjzlxxb> result) {
		if(result == null || result.isEmpty()) {
			return;
		}
		String sql = "delete from sn_ac_jc_yjzlxxb a"
				+ " where yjzldm=:yjzldm"
				+ " and yjzlmc=:yjzlmc";
		Map<String, Object> paramMap = new HashMap<String, Object>();
		for(JcYjzlxxb o : result) {
			paramMap.clear();
			paramMap.put("yjzldm", o.getYjzldm());
			paramMap.put("yjzlmc", o.getYjzlmc());
			this.genericDao.updateSql(sql, paramMap);
		}
	}

	@Override
	public List<JcTcjxxb> getJcTcjxx(String sfdm) {
		String sql = "select ssdw, cjdm, cjmc, cjjp, cjjc, sndm, "
				+ " cjlx, ssbm, sxbz, to_char(xfsj,'yyyymmddhh24miss') xfsj, "
				+ " xfbz, bbh, dapbz, to_char(daptime,'yyyymmddhh24miss') daptime, "
				+ " sendbz, to_char(sendtime,'yyyymmddhh24miss') sendtime "
				+ " from sn_jc_t_cjxxb"
				+ " where 1=1 "
				+ " and rownum<" + JscppUtil.rownum;
		Map<String, Object> paramMap = new HashMap<String, Object>();
		return this.genericDao.getList(sql, paramMap, tcjxxRowMapper);
	}

	@Override
	public void doDeleteJcTcjxxb(String sfdm, List<JcTcjxxb> result) {
		if(result == null || result.isEmpty()) {
			return;
		}
		String sql = "delete from sn_jc_t_cjxxb a"
				+ " where cjdm=:cjdm";
		Map<String, Object> paramMap = new HashMap<String, Object>();
		for(JcTcjxxb o : result) {
			paramMap.clear();
			paramMap.put("cjdm", o.getCjdm());
			this.genericDao.updateSql(sql, paramMap);
		}
	}

	@Override
	public List<JcYjzldygx> getJcYjzldygx(String sfdm) {
		
		String sql = "select "
				+ " yjzldm, yjzlmc, cpbh, sjly, "
				+ " zsds, zsjs, jsbz, kdbz, "
				+ " kdjssx, zlgsyth, pfjssx, zlgspf "
				+ " from sn_ac_jc_yjzldygxb"
				+ " where 1=1 "
				+ " and rownum<" + JscppUtil.rownum;
		Map<String, Object> paramMap = new HashMap<String, Object>();
		return this.genericDao.getList(sql, paramMap, YjzldygxRowMapper);
	}

	@Override
	public void doDeleteJcYjzldygxb(String sfdm, List<JcYjzldygx> result) {
		if(result == null || result.isEmpty()) {
			return;
		}
		String sql = "delete from sn_ac_jc_yjzldygxb"
				+ " where yjzldm=:yjzldm"
				+ " and yjzlmc=:yjzlmc";
		Map<String, Object> paramMap = new HashMap<String, Object>();
		for(JcYjzldygx o : result) {
			paramMap.clear();
			paramMap.put("yjzldm", o.getYjzldm());
			paramMap.put("yjzlmc", o.getYjzlmc());
			this.genericDao.updateSql(sql, paramMap);
		}
	}

	@Override
	public List<Tyjzljbb> getYjzljbb(String sfdm) {

		String sql = "select "
				+ " id, name, parentid "
				+ " from SN_AC_JC_YJZLJBB"
				+ " where 1=1"
				+ " and rownum<" + JscppUtil.rownum;
		Map<String, Object> paramMap = new HashMap<String, Object>();
		return this.genericDao.getList(sql, paramMap, yjzljbbRowMapper);
	}

	@Override
	public void doDeleteYjzljbb(String sfdm, List<Tyjzljbb> result) {
		if(result == null || result.isEmpty()) {
			return;
		}
		String sql = "delete from SN_AC_JC_YJZLJBB"
				+ " where id=:id"
				+ " and yjzlmc=:yjzlmc";
		Map<String, Object> paramMap = new HashMap<String, Object>();
		for(Tyjzljbb o : result) {
			paramMap.clear();
			paramMap.put("id", o.getId());
			this.genericDao.updateSql(sql, paramMap);
		}
	}

	@Override
	public List<Tyjzlgsb> getYjzlgsb(String sfdm) {

		String sql = "select "
				+ " yjzldm, jb_1, jb_2, jb_3, jb_4, jb_5 "
				+ " from sn_ac_jc_yjzlgsb"
				+ " where 1=1"
				+ " and rownum<" + JscppUtil.rownum;
		Map<String, Object> paramMap = new HashMap<String, Object>();
		return this.genericDao.getList(sql, paramMap, yjzlgsbRowMapper);
	}

	@Override
	public void doDeleteYjzlgsb(String sfdm, List<Tyjzlgsb> result) {
		if(result == null || result.isEmpty()) {
			return;
		}
		String sql = "delete from sn_ac_jc_yjzlgsb"
				+ " where yjzldm=:yjzldm";
		Map<String, Object> paramMap = new HashMap<String, Object>();
		for(Tyjzlgsb o : result) {
			paramMap.clear();
			paramMap.put("yjzldm", o.getYjzldm());
			this.genericDao.updateSql(sql, paramMap);
		}
	}

	@Override
	public List<JcTYjzlb> getTYjzlb(String sfdm) {
		String sql = "select "
				+ " yjzlbh, yjzlmc, yjzljc, "
				+ " mcjp, czrq, bpdh, zlsx, "
				+ " zdsx, zlbz, xfbz,"
				+ " to_char(xfsj,'yyyymmddhh24miss') xfsj, "
				+ " bbh, gxsx, dapbz, "
				+ " to_char(daptime,'yyyymmddhh24miss') daptime "
				+ " from sn_jc_t_yjzlb"
				+ " where 1=1"
				+ " and rownum<" + JscppUtil.rownum;
		Map<String, Object> paramMap = new HashMap<String, Object>();
		return this.genericDao.getList(sql, paramMap, yjzlbRowMapper);
	}

	@Override
	public void doDeleteTYjzlb(String sfdm, List<JcTYjzlb> result) {
		if(result == null || result.isEmpty()) {
			return;
		}
		String sql = "delete from sn_jc_t_yjzlb"
				+ " where yjzlbh=:yjzlbh";
		Map<String, Object> paramMap = new HashMap<String, Object>();
		for(JcTYjzlb o : result) {
			paramMap.clear();
			paramMap.put("yjzlbh",o.getYjzlbh());
			this.genericDao.updateSql(sql, paramMap);
		}
	}

	@Override
	public List<AcJcYlxxb> getAcJcYlxxb(String sfdm) {
		String sql = "select "
				+ " id, linetype, transporttype, code, name, "
				+ " regionlinetype, lineattribute, assigninfo, "
				+ " to_char(effectivetime,'yyyymmddhh24miss') effectivetime," +
				"to_char(expirytime,'yyyymmddhh24miss') expirytime, isinternational, "
				+ " islogistics, isexpresscar, settlementtype, "
				+ " runorgcode, runorgname, istemporary, isoutage, "
				+ " ratetonnage, sgsx, pzcs, pcxs, pcts, provincecode, "
				+ " provincename, description, direction, roundtriptype, "
				+ " traintype, schedule, runschedule, fullmileage, linestationsuiteid, "
				+ " returnlineid, status, isrequestmodify, transportlineapprovalid, "
				+ " isdeleted, createuserid, createusercode, createusername,to_char(gmtcreated,'yyyymmddhh24miss') gmtcreated, "
				+ " modifyuserid, modifyusercode, modifyusername, to_char(gmtmodified,'yyyymmddhh24miss') gmtmodified , "
				+ " beginprovincecode, beginssjcode, beginstationcode, departuretime, "
				+ " endprovincecode, endssjcode, endstationcode, arrivetime, returnlinecode, fullruntime "
				+ " from sn_ac_jc_ylxxb"
				+ " where 1=1"
				+ " and sfdm=:sfdm"
				+ " and rownum<" + JscppUtil.rownum;
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("sfdm", sfdm);
		return this.genericDao.getList(sql, paramMap, ylxxbRowMapper);
	}

	@Override
	public void doDeleteAcJcYlxxb(String sfdm, List<AcJcYlxxb> result) {
		if(result == null || result.isEmpty()) {
			return;
		}
		String sql = "delete from sn_ac_jc_ylxxb a"
				+ " where a.id=:id"
				+ " and sfdm=:sfdm";
		Map<String, Object> paramMap = new HashMap<String, Object>();
		for(AcJcYlxxb o : result) {
			paramMap.clear();
			paramMap.put("id", o.getId());
			paramMap.put("sfdm", sfdm);
			this.genericDao.updateSql(sql, paramMap);
		}
	}

	@Override
	public List<AcJcZxxxb> getAcJcZxxxb(String sfdm) {
		String sql = "select "
				+ " id, code,to_char(effectivetime,'yyyymmddhh24miss') effectivetime," +
				"to_char(expirytime,'yyyymmddhh24miss') expirytime, linestationsuite_id, "
				+ " sequence, stationorgcode, stationorgname, ssjcode, ssjname, "
				+ " provincecode, provincename, citycode, cityname, countycode, "
				+ " countyname, arriveday, arrivetime, departureday, "
				+ " departuretime, mileage, mapmileage, stationtype, "
				+ " stationarytime, transporttime, isforcedispatch, "
				+ " isbatchdispatch, isscanmandatory, documenttype, "
				+ " iscontrolseal, isdeleted,to_char(updatetime,'yyyymmddhh24miss') updatetime, createuserid, "
				+ " createusercode, createusername,to_char(gmtcreated,'yyyymmddhh24miss') gmtcreated, modifyuserid, "
				+ " modifyusercode, modifyusername,to_char(gmtmodified,'yyyymmddhh24miss') gmtmodified "
				+ " from sn_ac_jc_zxxxb"
				+ " where 1=1"
				+ " and sfdm=:sfdm"
				+ " and rownum<" + JscppUtil.rownum;
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("sfdm", sfdm);
		return this.genericDao.getList(sql, paramMap, ylzxbRowMapper);
	}

	@Override
	public void doDeleteAcJcZxxxb(String sfdm, List<AcJcZxxxb> result) {
		if(result == null || result.isEmpty()) {
			return;
		}
		String sql = "delete from sn_ac_jc_zxxxb a"
				+ " where a.id=:id"
				+ " and sfdm=:sfdm";
		Map<String, Object> paramMap = new HashMap<String, Object>();
		for(AcJcZxxxb o : result) {
			paramMap.clear();
			paramMap.put("id", o.getId());
			paramMap.put("sfdm", sfdm);
			this.genericDao.updateSql(sql, paramMap);
		}
	}
}
