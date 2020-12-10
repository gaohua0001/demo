package com.dvt.snjs.service;

import java.util.List;

import com.dvt.snjs.dubbo.model.*;
import org.springframework.jdbc.core.RowMapper;

import com.dvt.snjs.util.FormatUtil;

public interface YwxxService {
	
	public RowMapper<Qfdztb> fdRowMapper = (rs, i) -> {
		Qfdztb o = new Qfdztb();
		o.setFdid(rs.getString("FDID"));
		o.setJkldid(rs.getString("JKLDID"));
		o.setCkldid(rs.getString("CKLDID"));
		o.setFcj(rs.getString("FCJ"));
		o.setFcz(rs.getString("FCZ"));
		o.setJsj(rs.getString("JSJ"));
		o.setJsz(rs.getString("JSZ"));
		o.setFdlx(rs.getString("FDLX"));
		o.setFdzt(rs.getString("FDZT"));
		o.setJhzl(rs.getString("JHZL"));
		o.setJksj(rs.getString("JKSJ"));
		o.setCksj(rs.getString("CKSJ"));
		o.setJkrq(rs.getString("JKRQ"));
		o.setCkrq(rs.getString("CKRQ"));
		o.setZbsl(rs.getDouble("ZBSL"));
		o.setDsl(rs.getDouble("DSL"));
		o.setJsl(rs.getDouble("JSL"));
		o.setXsl(rs.getDouble("XSL"));
		o.setHsl(rs.getDouble("HSL"));
		o.setZbtm(rs.getString("ZBTM"));
		o.setZl(rs.getDouble("ZL"));
		o.setTjclbz(rs.getString("TJCLBZ"));
		o.setSjkcsj(rs.getString("SJKCSJ"));
		o.setSjddsj(rs.getString("SJDDSJ"));
		o.setBbh(rs.getString("BBH"));
		o.setTime(rs.getString("TIME"));
		o.setQstime(rs.getString("QSTIME"));
		o.setFscj(rs.getString("FSCJ"));
		o.setQscj(rs.getString("QSCJ"));
		o.setFczlx(rs.getString("FCZLX"));
		o.setXjzlx(rs.getString("XJZLX"));
		o.setYldm(rs.getString("YLDM"));
		o.setLdhm(rs.getString("LDHM"));
		o.setLdlsh(rs.getString("LDLSH"));
		o.setDwxx(rs.getString("DWXX"));
		o.setEsbtime(rs.getString("ESBTIME"));
		o.setPcdh(rs.getString("PCDH"));
		o.setJbcbz(rs.getString("JBCBZ"));
		o.setJbrxm(rs.getString("JBRXM"));
		o.setJczclbz(rs.getString("JCZCLBZ"));
		o.setFcdw(rs.getString("FCDW"));
		o.setJsdw(rs.getString("JSDW"));
		o.setGdbz(rs.getString("GDBZ"));
		o.setSfdm(rs.getString("SFDM"));
		return o;
	};
	
	public RowMapper<Qzbxxb> zbRowMapper = (rs, i) -> {
		Qzbxxb o = new Qzbxxb();
		o.setZbid(rs.getString("ZBID"));
		o.setFdid(rs.getString("FDID"));
		o.setZbtm(FormatUtil.format(rs.getString("ZBTM"),"*"));
		o.setZblx(rs.getString("ZBLX"));
		o.setHfbz(rs.getString("HFBZ"));
		o.setFfrq(rs.getString("FFRQ"));
		o.setFjlx(rs.getString("FJLX"));
		o.setZbzt(rs.getString("ZBZT"));
		o.setZbhm(FormatUtil.format(rs.getString("ZBHM"),"*"));
		o.setYjzl(rs.getString("YJZL"));
		o.setYjjdm(rs.getString("YJJDM"));
		o.setJdjdm(rs.getString("JDJDM"));
		o.setBzbz(rs.getString("BZBZ"));
		o.setCzrq(rs.getString("CZRQ"));
		o.setZl(rs.getDouble("ZL"));
		o.setYdxh(rs.getString("YDXH"));
		o.setBzdm(rs.getString("BZDM"));
		o.setCjdm(rs.getString("CJDM"));
		o.setYjjs(rs.getDouble("YJJS"));
		o.setGhfs(rs.getString("GHFS"));
		o.setScsj(rs.getString("SCSJ"));
		o.setSfdm(rs.getString("SFDM"));
		return o;
	};
	
	public RowMapper<Qqdxxb> qdRowMapper = (rs, i) -> {
		Qqdxxb o = new Qqdxxb();
		o.setQdid(rs.getString("QDID"));
		o.setZbtm(rs.getString("ZBTM"));
		o.setFfrq(rs.getString("FFRQ"));
		o.setYjjdm(rs.getString("YJJDM"));
		o.setJdjdm(rs.getString("JDJDM"));
		o.setYjzl(rs.getString("YJZL"));
		o.setSjly(rs.getString("SJLY"));
		o.setScsj(rs.getString("SCSJ"));
		o.setScjg(rs.getString("SCJG"));
		o.setBy1(rs.getString("BY1"));
		o.setJbbz(rs.getString("JBBZ"));
		o.setSfdm(rs.getString("SFDM"));
		return o;
	};
	
	public RowMapper<Qyjxxb> qdyjRowMapper = (rs, i) -> {
		Qyjxxb o = new Qyjxxb();
		o.setQdid(rs.getString("QDID"));
		o.setYjtm(rs.getString("YJTM"));
		o.setScsj(rs.getString("SCSJ"));
		o.setZl(rs.getDouble("ZL"));
		o.setYjzl(rs.getString("YJZL"));
		o.setSfdm(rs.getString("SFDM"));
		return o;
	};
	
	public RowMapper<Qyjjbxxb> sjxxRowMapper = (rs, i) -> {
		Qyjjbxxb o = new Qyjjbxxb();
		o.setYjtm(rs.getString("YJTM"));
		o.setYjbz(rs.getString("YJBZ"));
		o.setYjzldm(rs.getString("YJZLDM"));
		o.setSjjdm(rs.getString("SJJDM"));
		o.setJdjdm(rs.getString("JDJDM"));
		o.setYjzl(rs.getDouble("YJZL"));
		o.setYjtj(rs.getDouble("YJTJ"));
		o.setScsj(rs.getString("SCSJ"));
		o.setSjrq(rs.getString("SJRQ"));
		o.setYjly(rs.getString("YJLY"));
		o.setJfzl(rs.getDouble("JFZL"));
		o.setJdgdm(rs.getString("JDGDM"));
		o.setTxdm(rs.getString("TXDM"));
		o.setYpdjbz(rs.getString("YPDJBZ"));
		o.setZzf(rs.getDouble("ZZF"));
		o.setYhje(rs.getDouble("YHJE"));
		o.setBzxbz(rs.getString("BZXBZ"));
		o.setZwsx(rs.getString("ZWSX"));
		o.setKhbm(rs.getString("KHBM"));
		o.setSfdm(rs.getString("SFDM"));
		return o;
	};
	
	public RowMapper<GdTdxxb> gdTdxxRowMapper = (rs, i) -> {
		GdTdxxb o = new GdTdxxb();
		o.setYjid(rs.getString("yjid"));
		o.setYjtm(rs.getString("yjtm"));
		o.setTdrq(rs.getString("tdrq"));
		o.setTdjdm(rs.getString("tdjdm"));
		o.setYjzl(rs.getString("yjzl"));
		o.setYjzlmc(rs.getString("yjzlmc"));
		o.setZl(rs.getDouble("zl"));
		o.setSftt(rs.getString("sftt"));
		o.setScsj(rs.getString("scsj"));
		o.setSjly(rs.getString("sjly"));
		o.setTddjsj(rs.getString("tddjsj"));
		o.setGxrq(rs.getString("gxrq"));
		o.setClbz(rs.getString("clbz"));
		o.setJkclbz(rs.getString("jkclbz"));
		o.setSfdm(rs.getString("sfdm"));
		o.setTdy(rs.getString("tdy"));
		return o;
	};
	
	public RowMapper<TmpFdxxb> tmpFdxxRowMapper = (rs, i) -> {
		TmpFdxxb o = new TmpFdxxb();
		o.setFdid(rs.getString("FDID"));
		o.setGls(rs.getDouble("GLS"));
		o.setFcz(rs.getString("FCZ"));
		o.setJsz(rs.getString("JSZ"));
		o.setPyj(rs.getString("PYJ"));
		o.setYldm(rs.getString("YLDM"));
		o.setLdlsh(rs.getString("LDLSH"));
		o.setZbsl(rs.getDouble("ZBSL"));
		o.setYsclbz(rs.getString("YSCLBZ"));
		o.setYlzl(rs.getString("YLZL"));
		o.setJsrq(rs.getString("JSRQ"));
		o.setSslj(rs.getString("SSLJ"));
		o.setHbbh(rs.getString("HBBH"));
		o.setYlgs(rs.getString("YLGS"));
		o.setFcj(rs.getString("FCJ"));
		o.setYljb(rs.getString("YLJB"));
		o.setZbtm(rs.getString("ZBTM"));
		o.setTime(rs.getString("TIME"));
		o.setJsj(rs.getString("JSJ"));
		o.setYlfl(rs.getString("YLFL"));
		o.setSfdm(rs.getString("sfdm"));
		return o;
	};
	
	public RowMapper<JcTYlxxzb> ylxxRowMapper = (rs, i) -> {
		JcTYlxxzb o = new JcTYlxxzb();
		o.setYldm(rs.getString("YLDM"));
		o.setYlmc(rs.getString("YLMC"));
		o.setYljb(rs.getString("YLJB"));
		o.setYlzl(rs.getString("YLZL"));
		o.setChc(rs.getString("CHC"));
		o.setPyj(rs.getString("PYJ"));
		o.setSfj(rs.getString("SFJ"));
		o.setZdj(rs.getString("ZDJ"));
		o.setQszxrq(rs.getString("QSZXRQ"));
		o.setZzzxrq(rs.getString("ZZZXRQ"));
		o.setSslj(rs.getString("SSLJ"));
		o.setGjxh(rs.getString("GJXH"));
		o.setBgwz(rs.getString("BGWZ"));
		o.setRj(rs.getDouble("RJ"));
		o.setYlxz(rs.getString("YLXZ"));
		o.setSxxbs(rs.getString("SXXBS"));
		o.setZjsx(rs.getString("ZJSX"));
		o.setQcyldm(rs.getString("QCYLDM"));
		o.setSfdysdyj(rs.getString("SFDYSDYJ"));
		o.setSfdygjyj(rs.getString("SFDYGJYJ"));
		o.setZwbxx(rs.getString("ZWBXX"));
		o.setGxjs(rs.getString("GXJS"));
		o.setQlc(rs.getDouble("QLC"));
		o.setDw(rs.getDouble("DW"));
		o.setYqsx(rs.getString("YQSX"));
		return o;
	};
	
	public RowMapper<Xfkzb> sfkzbRowMapper = (rs, i) -> {
		Xfkzb o = new Xfkzb();
		o.setSfdm(rs.getString("sfdm"));
		o.setTabname(rs.getString("tabname"));
		return o;
	};
	
	public RowMapper<JcJgxxb> jgxxRowMapper = (rs,i) -> {
		JcJgxxb o = new JcJgxxb();
		o.setJgdm(rs.getString("jgdm"));
		o.setJgmc(rs.getString("jgmc"));
		o.setJggs(rs.getString("jggs"));
		o.setSssf(rs.getString("sssf"));
		o.setSsds(rs.getString("ssds"));
		o.setSsxs(rs.getString("ssxs"));
		o.setJgjc(rs.getString("jgjc"));
		return o;
	};

	public RowMapper<Tylpcxxb> ylpcxxbRowMapper = (rs, rowNum) -> {
		Tylpcxxb o = new Tylpcxxb();
		o.setPcdh(rs.getString("pcdh"));
		o.setQcyldm(rs.getString("qcyldm"));
		o.setFcyldm(rs.getString("fcyldm"));
		o.setYlzlc(rs.getString("ylzlc"));
		o.setYxts(rs.getString("yxts"));
		o.setLdlsh(rs.getString("ldlsh"));
		o.setClid(rs.getString("clid"));
		o.setSydw(rs.getString("sydw"));
		o.setCph(rs.getString("cph"));
		o.setJsy(rs.getString("jsy"));
		o.setByjsy(rs.getString("byjsy"));
		o.setYyy(rs.getString("yyy"));
		o.setGbcl(rs.getString("gbcl"));
		o.setJhddr(rs.getDate("jhddr"));
		o.setJhkcr(rs.getDate("jhkcr"));
		o.setPcdw(rs.getString("pcdw"));
		o.setCzydm(rs.getString("czydm"));
		o.setCzsj(rs.getDate("czsj"));
		o.setPclx(rs.getString("pclx"));
		o.setPcbz(rs.getString("pcbz"));
		o.setXfbz(rs.getString("xfbz"));
		o.setXfsj(rs.getDate("xfsj"));
		o.setBbh(rs.getString("bbh"));
		o.setGcclid(rs.getString("gcclid"));
		o.setGccph(rs.getString("gccph"));
		o.setJsymc(rs.getString("jsymc"));
		o.setDapbz(rs.getString("dapbz"));
		o.setDaptime(rs.getDate("daptime"));
		o.setPccx(rs.getString("pccx"));
		o.setJsyphone(rs.getString("jsyphone"));
		o.setCldw(rs.getString("cldw"));
		o.setScsj(rs.getDate("scsj"));
		o.setDw(rs.getString("dw"));
		o.setXtscsj(rs.getDate("xtscsj"));
		return o;
	};
	

	public RowMapper<ZdjsPcyjxxDay> pcyjRowMapper = (rs, i) -> {
		ZdjsPcyjxxDay o = new ZdjsPcyjxxDay();
		o.setJsrq(rs.getString("jsrq"));
		o.setFdid(rs.getString("fdid"));
		o.setZbid(rs.getString("zbid"));
		o.setYldm(rs.getString("yldm"));
		o.setLdhm(rs.getString("ldhm"));
		o.setLdlsh(rs.getString("ldlsh"));
		o.setFcj(rs.getString("fcj"));
		o.setJsj(rs.getString("jsj"));
		o.setPcdh(rs.getString("pcdh"));
		o.setZbtm(rs.getString("zbtm"));
		o.setYjjdm(rs.getString("yjjdm"));
		o.setJdjdm(rs.getString("jdjdm"));
		o.setYjzldm(rs.getString("yjzldm"));
		o.setCpbh(rs.getString("cpbh"));
		o.setSscj(rs.getString("sscj"));
		o.setZbhm(rs.getString("zbhm"));
		o.setYjjsf(rs.getString("yjjsf"));
		o.setYjjds(rs.getString("yjjds"));
		o.setJdjsf(rs.getString("jdjsf"));
		o.setJdjds(rs.getString("jdjds"));
		o.setZl(rs.getDouble("zl"));
		o.setJhzl(rs.getDouble("jhzl"));
		o.setJssf(rs.getString("jssf"));
		o.setBcsf(rs.getString("bcsf"));
		o.setJsfl(rs.getDouble("jsfl"));
		o.setBcfl(rs.getDouble("bcfl"));
		o.setJsf(rs.getDouble("jsf"));
		o.setBcf(rs.getDouble("bcf"));

		return o;
	};
	
	public RowMapper<ZdjsGjyjxxDay> gjyjRowMapper = (rs, i) -> {
		ZdjsGjyjxxDay o = new ZdjsGjyjxxDay();
		o.setJsrq(rs.getString("jsrq"));
		o.setYjtm(rs.getString("yjtm"));
		o.setYjzldm(rs.getString("yjzldm"));
		o.setCpbh(rs.getString("cpbh"));
		o.setSscj(rs.getString("sscj"));
		o.setSjjdm(rs.getString("sjjdm"));
		o.setJdjdm(rs.getString("jdjdm"));
		o.setYjzl(rs.getDouble("yjzl"));
		o.setSjsf(rs.getString("sjsf"));
		o.setSjds(rs.getString("sjds"));
		o.setSjxs(rs.getString("sjxs"));
		o.setJdsf(rs.getString("jdsf"));
		o.setJdds(rs.getString("jdds"));
		o.setJdxs(rs.getString("jdxs"));
		o.setJhzl(rs.getDouble("jhzl"));
		o.setJsfl1(rs.getDouble("jsfl1"));
		o.setJsfl2(rs.getDouble("jsfl2"));
		o.setJsf(rs.getDouble("jsf"));
		o.setBcfl1(rs.getDouble("bcfl1"));
		o.setBcfl2(rs.getDouble("bcfl2"));
		o.setBcf(rs.getDouble("bcf"));
		o.setInfo(rs.getString("info"));

		return o;
	};
	
	public RowMapper<ZdjsGjyjxxKsjzDay> ksjzRowMapper = (rs, i) -> {
		ZdjsGjyjxxKsjzDay o = new ZdjsGjyjxxKsjzDay();
		o.setJsrq(rs.getString("jsrq"));
		o.setYjtm(rs.getString("yjtm"));
		o.setYjzldm(rs.getString("yjzldm"));
		o.setCpbh(rs.getString("cpbh"));
		o.setSscj(rs.getString("sscj"));
		o.setSjjdm(rs.getString("sjjdm"));
		o.setJdjdm(rs.getString("jdjdm"));
		o.setYjzl(rs.getDouble("yjzl"));
		o.setSjsf(rs.getString("sjsf"));
		o.setSjds(rs.getString("sjds"));
		o.setSjxs(rs.getString("sjxs"));
		o.setJdsf(rs.getString("jdsf"));
		o.setJdds(rs.getString("jdds"));
		o.setJhzl(rs.getDouble("jhzl"));
		o.setJsfl(rs.getDouble("jsfl"));
		o.setJsf(rs.getDouble("jsf"));
		o.setBcfl(rs.getDouble("bcfl"));
		o.setBcf(rs.getDouble("bcf"));
		o.setJsds(rs.getString("jsds"));
		o.setBcds(rs.getString("bcds"));
		o.setInfo(rs.getString("info"));

		return o;
	};
	
	public RowMapper<ZdjsSjzyDay> sjzyRowMapper = (rs, i) -> {
		ZdjsSjzyDay o = new ZdjsSjzyDay();
		o.setJsrq(rs.getString("jsrq"));
		o.setFdid(rs.getString("fdid"));
		o.setZbid(rs.getString("zbid"));
		o.setYldm(rs.getString("yldm"));
		o.setLdhm(rs.getString("ldhm"));
		o.setLdlsh(rs.getString("ldlsh"));
		o.setFcj(rs.getString("fcj"));
		o.setJsj(rs.getString("jsj"));
		o.setPcdh(rs.getString("pcdh"));
		o.setZbtm(rs.getString("zbtm"));
		o.setYjjdm(rs.getString("yjjdm"));
		o.setJdjdm(rs.getString("jdjdm"));
		o.setYjzldm(rs.getString("yjzldm"));
		o.setCpbh(rs.getString("cpbh"));
		o.setSscj(rs.getString("sscj"));
		o.setZbhm(rs.getString("zbhm"));
		o.setYjjsf(rs.getString("yjjsf"));
		o.setJdjsf(rs.getString("jdjsf"));
		o.setFcjsf(rs.getString("fcjsf"));
		o.setZl(rs.getDouble("zl"));
		o.setJssf(rs.getString("jssf"));
		o.setBcsf(rs.getString("bcsf"));
		o.setJsfl(rs.getDouble("jsfl"));
		o.setBcfl(rs.getDouble("bcfl"));
		o.setJsf(rs.getDouble("jsf"));
		o.setBcf(rs.getDouble("bcf"));

		return o;
	};
	public RowMapper<JcYjzlxxb> yjzlxxRowMapper = (rs, i) -> {
		JcYjzlxxb o = new JcYjzlxxb();
		o.setYjzldm(rs.getString("yjzldm"));
		o.setYjzlmc(rs.getString("yjzlmc"));
		o.setKdbz(rs.getString("kdbz"));
		o.setSscj(rs.getString("sscj"));
		return o;
	};
	
	public RowMapper<JcTcjxxb> tcjxxRowMapper = (rs, i) -> {
		JcTcjxxb o = new JcTcjxxb();
		o.setSsdw(rs.getString("ssdw"));
		o.setCjdm(rs.getString("cjdm"));
		o.setCjmc(rs.getString("cjmc"));
		o.setCjjp(rs.getString("cjjp"));
		o.setCjjc(rs.getString("cjjc"));
		o.setSndm(rs.getString("sndm"));
		o.setCjlx(rs.getString("cjlx"));
		o.setSsbm(rs.getString("ssbm"));
		o.setSxbz(rs.getString("sxbz"));
		o.setXfsj(rs.getString("xfsj"));
		o.setXfbz(rs.getString("xfbz"));
		o.setBbh(rs.getString("bbh"));
		o.setDapbz(rs.getString("dapbz"));
		o.setDaptime(rs.getString("daptime"));
		o.setSendbz(rs.getString("sendbz"));
		o.setSendtime(rs.getString("sendtime"));
		return o;
	};
	
	public RowMapper<JcYjzldygx> YjzldygxRowMapper = (rs, i) -> {
		JcYjzldygx o = new JcYjzldygx();
		o.setYjzldm(rs.getString("yjzldm"));
		o.setYjzlmc(rs.getString("yjzlmc"));
		o.setCpbh(rs.getString("cpbh"));
		o.setSjly(rs.getString("sjly"));
		o.setZsds(rs.getDouble("zsds"));
		o.setZsjs(rs.getDouble("zsjs"));
		o.setJsbz(rs.getString("jsbz"));
		o.setKdbz(rs.getString("kdbz"));
		o.setKdjssx(rs.getString("kdjssx"));
		o.setZlgsyth(rs.getString("zlgsyth"));
		o.setPfjssx(rs.getString("pfjssx"));
		o.setZlgspf(rs.getString("zlgspf"));
		return o;
	};
	public RowMapper<Tyjzljbb> yjzljbbRowMapper = (rs, i) -> {
		Tyjzljbb o = new Tyjzljbb();
		o.setId(rs.getString("id"));
		o.setName(rs.getString("name"));
		o.setParentid(rs.getString("parentid"));
		return o;
	};
	public RowMapper<Tyjzlgsb> yjzlgsbRowMapper = (rs, i) -> {
		Tyjzlgsb o = new Tyjzlgsb();
		o.setYjzldm(rs.getString("yjzldm"));
		o.setJb_1(rs.getString("jb_1"));
		o.setJb_2(rs.getString("jb_2"));
		o.setJb_3(rs.getString("jb_3"));
		o.setJb_4(rs.getString("jb_4"));
		o.setJb_5(rs.getString("jb_5"));
		return o;
	};
	public RowMapper<JcTYjzlb> yjzlbRowMapper = (rs, i) -> {
		JcTYjzlb o = new JcTYjzlb();
		o.setYjzlbh(rs.getString("yjzlbh"));
		o.setYjzlmc(rs.getString("yjzlmc"));
		o.setYjzljc(rs.getString("yjzljc"));
		o.setMcjp(rs.getString("mcjp"));
		o.setCzrq(rs.getString("czrq"));
		o.setBpdh(rs.getString("bpdh"));
		o.setZlsx(rs.getString("zlsx"));
		o.setZdsx(rs.getString("zdsx"));
		o.setZlbz(rs.getString("zlbz"));
		o.setXfbz(rs.getString("xfbz"));
		o.setXfsj(rs.getString("xfsj"));
		o.setBbh(rs.getString("bbh"));
		o.setGxsx(rs.getString("gxsx"));
		o.setDapbz(rs.getString("dapbz"));
		o.setDaptime(rs.getString("daptime"));
		return o;
	};
	public RowMapper<AcJcYlxxb> ylxxbRowMapper = (rs, i) -> {
		AcJcYlxxb o = new AcJcYlxxb();
		o.setModifyuserid(rs.getInt("modifyuserid"));
		o.setModifyusercode(rs.getString("modifyusercode"));
		o.setModifyusername(rs.getString("modifyusername"));
		o.setGmtmodified(rs.getString("gmtmodified"));
		o.setBeginprovincecode(rs.getString("beginprovincecode"));
		o.setBeginssjcode(rs.getString("beginssjcode"));
		o.setBeginstationcode(rs.getString("beginstationcode"));
		o.setDeparturetime(rs.getString("departuretime"));
		o.setEndprovincecode(rs.getString("endprovincecode"));
		o.setEndssjcode(rs.getString("endssjcode"));
		o.setEndstationcode(rs.getString("endstationcode"));
		o.setArrivetime(rs.getString("arrivetime"));
		o.setReturnlinecode(rs.getString("returnlinecode"));
		o.setFullruntime(rs.getString("fullruntime"));
		o.setProvincename(rs.getString("provincename"));
		o.setDescription(rs.getString("description"));
		o.setDirection(rs.getString("direction"));
		o.setRoundtriptype(rs.getString("roundtriptype"));
		o.setTraintype(rs.getString("traintype"));
		o.setSchedule(rs.getString("schedule"));
		o.setRunschedule(rs.getString("runschedule"));
		o.setFullmileage(rs.getInt("fullmileage"));
		o.setLinestationsuiteid(rs.getInt("linestationsuiteid"));
		o.setReturnlineid(rs.getInt("returnlineid"));
		o.setStatus(rs.getString("status"));
		o.setIsrequestmodify(rs.getString("isrequestmodify"));
		o.setTransportlineapprovalid(rs.getString("transportlineapprovalid"));
		o.setIsdeleted(rs.getString("isdeleted"));
		o.setCreateuserid(rs.getInt("createuserid"));
		o.setCreateusercode(rs.getString("createusercode"));
		o.setCreateusername(rs.getString("createusername"));
		o.setGmtcreated(rs.getString("gmtcreated"));
		o.setId(rs.getInt("id"));
		o.setLinetype(rs.getString("linetype"));
		o.setTransporttype(rs.getString("transporttype"));
		o.setCode(rs.getString("code"));
		o.setName(rs.getString("name"));
		o.setRegionlinetype(rs.getString("regionlinetype"));
		o.setLineattribute(rs.getString("lineattribute"));
		o.setAssigninfo(rs.getString("assigninfo"));
		o.setEffectivetime(rs.getString("effectivetime"));
		o.setExpirytime(rs.getString("expirytime"));
		o.setIsinternational(rs.getString("isinternational"));
		o.setIslogistics(rs.getString("islogistics"));
		o.setIsexpresscar(rs.getString("isexpresscar"));
		o.setSettlementtype(rs.getString("settlementtype"));
		o.setRunorgcode(rs.getString("runorgcode"));
		o.setRunorgname(rs.getString("runorgname"));
		o.setIstemporary(rs.getString("istemporary"));
		o.setIsoutage(rs.getString("isoutage"));
		o.setRatetonnage(rs.getInt("ratetonnage"));
		o.setSgsx(rs.getString("sgsx"));
		o.setPzcs(rs.getInt("pzcs"));
		o.setPcxs(rs.getInt("pcxs"));
		o.setPcts(rs.getInt("pcts"));
		o.setProvincecode(rs.getString("provincecode"));
		return o;
	};

	public RowMapper<AcJcZxxxb> ylzxbRowMapper = (rs, i) -> {
		AcJcZxxxb o = new AcJcZxxxb();
		o.setSequence(rs.getInt("sequence"));
		o.setStationorgcode(rs.getString("stationorgcode"));
		o.setStationorgname(rs.getString("stationorgname"));
		o.setSsjcode(rs.getString("ssjcode"));
		o.setSsjname(rs.getString("ssjname"));
		o.setCitycode(rs.getString("citycode"));
		o.setCityname(rs.getString("cityname"));
		o.setCountycode(rs.getString("countycode"));
		o.setCountyname(rs.getString("countyname"));
		o.setArriveday(rs.getInt("arriveday"));
		o.setDepartureday(rs.getString("departureday"));
		o.setMileage(rs.getInt("mileage"));
		o.setMapmileage(rs.getInt("mapmileage"));
		o.setStationtype(rs.getString("stationtype"));
		o.setStationarytime(rs.getString("stationarytime"));
		o.setTransporttime(rs.getString("transporttime"));
		o.setIsforcedispatch(rs.getString("isforcedispatch"));
		o.setIsbatchdispatch(rs.getString("isbatchdispatch"));
		o.setIsscanmandatory(rs.getString("isscanmandatory"));
		o.setDocumenttype(rs.getString("documenttype"));
		o.setIscontrolseal(rs.getString("iscontrolseal"));
		o.setUpdatetime(rs.getString("updatetime"));
		o.setId(rs.getInt("id"));
		o.setCode(rs.getString("code"));
		o.setEffectivetime(rs.getString("effectivetime"));
		o.setExpirytime(rs.getString("expirytime"));
		o.setLinestationsuite_id(rs.getInt("linestationsuite_id"));
		o.setProvincecode(rs.getString("provincecode"));
		o.setModifyuserid(rs.getInt("modifyuserid"));
		o.setModifyusercode(rs.getString("modifyusercode"));
		o.setModifyusername(rs.getString("modifyusername"));
		o.setGmtmodified(rs.getString("gmtmodified"));
		o.setDeparturetime(rs.getString("departuretime"));
		o.setArrivetime(rs.getString("arrivetime"));
		o.setProvincename(rs.getString("provincename"));
		o.setIsdeleted(rs.getString("isdeleted"));
		o.setCreateuserid(rs.getInt("createuserid"));
		o.setCreateusercode(rs.getString("createusercode"));
		o.setCreateusername(rs.getString("createusername"));
		o.setGmtcreated(rs.getString("gmtcreated"));
		return o;
	};

	public List<Qfdztb> getQfdztb(String sfdm);
	
	public void doDeleteQfdztb(String sfdm, List<Qfdztb> result);
	
	public List<Qzbxxb> getQzbxxb(String sfdm);
	
	public void doDeleteQzbxxb(String sfdm, List<Qzbxxb> result);
	
	public List<Qqdxxb> getQqdxxb(String sfdm);
	
	public void doDeleteQqdxxb(String sfdm, List<Qqdxxb> result);
	
	public List<Qyjxxb> getQyjxxb(String sfdm);
	
	public void doDeleteQyjxxb(String sfdm, List<Qyjxxb> result);
	
	public List<Qyjjbxxb> getQyjjbxxb(String sfdm);
	
	public void doDeleteQyjjbxxb(String sfdm, List<Qyjjbxxb> result);
	
	public List<GdTdxxb> getGdTdxxb(String sfdm);
	
	public void doDeleteGdTdxxb(String sfdm, List<GdTdxxb> result);
	
	public List<TmpFdxxb> getTmpFdxxb(String sfdm);
	
	public void doDeleteTmpFdxxb(String sfdm, List<TmpFdxxb> result);
	
	public List<JcTYlxxzb> getJcTYlxxzb(String sfdm);
	public void doDeleteJcTYlxxzb(String sfdm, List<JcTYlxxzb> result);
	
	public List<SnjsJkxxb> doGetSnjsJkxxb(String sfdm);
	public void doUpdateSnjsJkxxb(String jsrq, String sfdm, String tabname);
	
	public String getXfkzb(String sfdm);
	
	public List<JcJgxxb> getJcJgxxb(String sfdm);
	
	public void doDeleteJcJgxxb(String sfdm, List<JcJgxxb> result);

	public List<Tylpcxxb> getTylpcxxb(String sfdm);
	public void doDeleteTylpcxxb(String sfdm, List<Tylpcxxb> result);
	

	/**
	 * 
	 * @param sfdm
	 * @return
	 */
	public List<Tckldzb> getTckldb(String sfdm);
	
	public void doDeleteTckldzb(String sfdm, List<Tckldzb> result);
	
	/**
	 * 
	 * @param sfdm
	 * @return
	 */
	public List<Tzbfjxx> getTzbfjxx(String sfdm);
	
	public void doDeleteTzbfjxx(String sfdm, List<Tzbfjxx> result);
	
	/**
	 * 
	 * @param sfdm
	 * @return
	 */
	public List<Tffqdzb> getTffqdzb(String sfdm);
	
	public void doDeleteTffqdzb(String sfdm, List<Tffqdzb> result);
	
	/**
	 *
	 * @param sfdm
	 * @return
	 */
	public List<Tyjxxb> getTyjxxb(String sfdm);
	
	public void doDeleteTyjxxb(String sfdm, List<Tyjxxb> result);
	
	
	public List<ZdjsPcyjxxDay> getZdjsPcyj(String sfdm);
	
	public void doDeleteZdjsPcyj(String sfdm, List<ZdjsPcyjxxDay> result);
	
	public List<ZdjsGjyjxxDay> getZdjsGjyj(String sfdm);
	
	public void doDeleteZdjsGjyj(String sfdm, List<ZdjsGjyjxxDay> result);
	
	public List<ZdjsGjyjxxKsjzDay> getZdjsKsjz(String sfdm);
	
	public void doDeleteZdjsKsjz(String sfdm, List<ZdjsGjyjxxKsjzDay> result);
	
	public List<ZdjsSjzyDay> getZdjsSjzy(String sfdm);
	
	public void doDeleteZdjsSjzy(String sfdm, List<ZdjsSjzyDay> result);
	
	public List<JcYjzlxxb> getYjzlxx(String sfdm);
	
	public void doDeleteJcYjzlxxb(String sfdm, List<JcYjzlxxb> result);
	
	public List<JcTcjxxb> getJcTcjxx(String sfdm);
	public void doDeleteJcTcjxxb(String sfdm, List<JcTcjxxb> result);

	public List<JcYjzldygx> getJcYjzldygx(String sfdm);
	public void doDeleteJcYjzldygxb(String sfdm, List<JcYjzldygx> result);
	
	public List<Tyjzljbb> getYjzljbb(String sfdm);
	public void doDeleteYjzljbb(String sfdm, List<Tyjzljbb> result);
	
	public List<Tyjzlgsb> getYjzlgsb(String sfdm);
	public void doDeleteYjzlgsb(String sfdm, List<Tyjzlgsb> result);
	
	
	public List<JcTYjzlb> getTYjzlb(String sfdm);
	public void doDeleteTYjzlb(String sfdm, List<JcTYjzlb> result);
	
	
	public List<AcJcYlxxb> getAcJcYlxxb(String sfdm);
	public void doDeleteAcJcYlxxb(String sfdm, List<AcJcYlxxb> result);
	
	public List<AcJcZxxxb> getAcJcZxxxb(String sfdm);
	public void doDeleteAcJcZxxxb(String sfdm, List<AcJcZxxxb> result);
	
	
	
	
}
