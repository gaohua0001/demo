package com.dvt.snjs.service;

import java.util.List;

import org.springframework.jdbc.core.RowMapper;

import com.dvt.snjs.dubbo.model.JsYsxxDay;
import com.dvt.snjs.dubbo.model.JsYsxxHkfyDay;
import com.dvt.snjs.dubbo.model.SnjsJkxxb;
import com.dvt.snjs.dubbo.model.Tzbjsbhk;
import com.dvt.snjs.dubbo.model.Tzbjsbly;
import com.dvt.snjs.dubbo.model.YjsFkhzcmxb;
import com.dvt.snjs.dubbo.model.Zfgkzfywl;

/**
 * 快递包裹运输费用
 * @author zane
 *
 */
public interface YsxxService {

	public RowMapper<JsYsxxDay> ysxxRowMapper = (rs, i) -> {
		JsYsxxDay o = new JsYsxxDay();
		o.setJsrq(rs.getString("jsrq"));
		o.setYjtm(rs.getString("yjtm"));
		o.setSjjgs(rs.getString("sjjgs"));
		o.setSjjsf(rs.getString("sjjsf"));
		o.setPyjgs(rs.getString("pyjgs"));
		o.setPyjsf(rs.getString("pyjsf"));
		o.setFcz(rs.getString("fcz"));
		o.setFdid(rs.getString("fdid"));
		o.setZbtm(rs.getString("zbtm"));
		o.setYldm(rs.getString("yldm"));
		o.setYljb(rs.getString("yljb"));
		o.setYlzl(rs.getString("ylzl"));
		o.setLdlsh(rs.getString("ldlsh"));
		o.setGls(rs.getString("gls"));
		o.setJsz(rs.getString("jsz"));
		o.setYjzl(rs.getString("yjzl"));
		o.setSjjdm(rs.getString("sjjdm"));
		o.setSjjds(rs.getString("sjjds"));
		o.setSjjxs(rs.getString("sjjxs"));
		o.setPyj(rs.getString("pyj"));
		o.setPyjds(rs.getString("pyjds"));
		o.setPyjxs(rs.getString("pyjxs"));
		o.setSyfl(rs.getDouble("syfl"));
		o.setBcfl(rs.getDouble("bcfl"));
		o.setSyf(rs.getDouble("syf"));
		o.setBcf(rs.getDouble("bcf"));
		o.setZl(rs.getDouble("zl"));
		o.setJhzl(rs.getDouble("jhzl"));
		o.setHbbh(rs.getString("hbbh"));
		o.setZlsx(rs.getString("zlsx"));
		o.setJssx(rs.getString("jssx"));
		o.setYjsl(rs.getString("yjsl"));
		o.setZbzl(rs.getDouble("zbzl"));
		o.setLhbz(rs.getString("lhbz"));
		o.setId(rs.getInt("id"));
		o.setYjjdm(rs.getString("yjjdm"));
		o.setJdjdm(rs.getString("jdjdm"));
		o.setYpdj(rs.getString("ypdj"));
		o.setInfo(rs.getString("info"));
		o.setSjrq(rs.getString("sjrq"));
		o.setJdjsf(rs.getString("jdjsf"));
		o.setJdjds(rs.getString("jdjds"));
		o.setKhdm(rs.getString("khdm"));
		o.setXzbz(rs.getString("xzbz"));
		o.setYjly(rs.getString("yjly"));

		return o;
	};
	
	public RowMapper<JsYsxxHkfyDay> hkfyRowMapper = (rs, i) -> {
		JsYsxxHkfyDay o = new JsYsxxHkfyDay();
		o.setJsrq(rs.getString("jsrq"));
		o.setFdid(rs.getString("fdid"));
		o.setZbtm(rs.getString("zbtm"));
		o.setYjtm(rs.getString("yjtm"));
		o.setSjjgs(rs.getString("sjjgs"));
		o.setSjjsf(rs.getString("sjjsf"));
		o.setPyjgs(rs.getString("pyjgs"));
		o.setPyjsf(rs.getString("pyjsf"));
		o.setYldm(rs.getString("yldm"));
		o.setYljb(rs.getString("yljb"));
		o.setYlzl(rs.getString("ylzl"));
		o.setLdlsh(rs.getString("ldlsh"));
		o.setGls(rs.getDouble("gls"));
		o.setFcz(rs.getString("fcz"));
		o.setJsz(rs.getString("jsz"));
		o.setYjzl(rs.getString("yjzl"));
		o.setZl(rs.getDouble("zl"));
		o.setJhzl(rs.getDouble("jhzl"));
		o.setSjjdm(rs.getString("sjjdm"));
		o.setSjjds(rs.getString("sjjds"));
		o.setSjjxs(rs.getString("sjjxs"));
		o.setPyj(rs.getString("pyj"));
		o.setPyjds(rs.getString("pyjds"));
		o.setPyjxs(rs.getString("pyjxs"));
		o.setSyfl(rs.getDouble("syfl"));
		o.setBcfl(rs.getDouble("bcfl"));
		o.setSyf(rs.getDouble("syf"));
		o.setBcf(rs.getDouble("bcf"));
		o.setHbbh(rs.getString("hbbh"));
		o.setZlsx(rs.getString("zlsx"));
		o.setJssx(rs.getString("jssx"));
		o.setYjsl(rs.getDouble("yjsl"));
		o.setZbzl(rs.getDouble("zbzl"));
		o.setLhbz(rs.getString("lhbz"));
		o.setId(rs.getInt("id"));
		o.setYjjdm(rs.getString("yjjdm"));
		o.setJdjdm(rs.getString("jdjdm"));
		o.setJdjsf(rs.getString("jdjsf"));
		o.setYpdj(rs.getString("ypdj"));
		o.setInfo(rs.getString("info"));
		o.setSjrq(rs.getString("sjrq"));
		o.setJdjds(rs.getString("jdjds"));
		o.setKhdm(rs.getString("khdm"));
		o.setXzbz(rs.getString("xzbz"));
		o.setYjly(rs.getString("yjly"));
		return o;
	};

	public RowMapper<Tzbjsbly> tzbjslyRowMapper = (rs, i) -> {
		Tzbjsbly o = new Tzbjsbly();
		o.setJsrq(rs.getString("jsrq"));
		o.setYjtm(rs.getString("yjtm"));
		o.setSjjgs(rs.getString("sjjgs"));
		o.setSjjsf(rs.getString("sjjsf"));
		o.setPyjgs(rs.getString("pyjgs"));
		o.setPyjsf(rs.getString("pyjsf"));
		o.setFcz(rs.getString("fcz"));
		o.setFdid(rs.getString("fdid"));
		o.setZbtm(rs.getString("zbtm"));
		o.setYldm(rs.getString("yldm"));
		o.setYljb(rs.getString("yljb"));
		o.setYlzl(rs.getString("ylzl"));
		o.setLdlsh(rs.getString("ldlsh"));
		o.setGls(rs.getDouble("gls"));
		o.setJsz(rs.getString("jsz"));
		o.setYjzl(rs.getString("yjzl"));
		o.setSjjdm(rs.getString("sjjdm"));
		o.setSjjds(rs.getString("sjjds"));
		o.setSjjxs(rs.getString("sjjxs"));
		o.setPyj(rs.getString("pyj"));
		o.setPyjds(rs.getString("pyjds"));
		o.setPyjxs(rs.getString("pyjxs"));
		o.setSyfl(rs.getDouble("syfl"));
		o.setBcfl(rs.getDouble("bcfl"));
		o.setSyf(rs.getDouble("syf"));
		o.setBcf(rs.getDouble("bcf"));
		o.setZl(rs.getDouble("zl"));
		o.setJhzl(rs.getDouble("jhzl"));
		o.setHbbh(rs.getString("hbbh"));
		o.setZlsx(rs.getString("zlsx"));
		o.setJssx(rs.getString("jssx"));
		o.setYjsl(rs.getDouble("yjsl"));
		o.setZbzl(rs.getDouble("zbzl"));
		o.setLhbz(rs.getString("lhbz"));
		o.setId(rs.getInt("id"));
		o.setYjjdm(rs.getString("yjjdm"));
		o.setJdjdm(rs.getString("jdjdm"));
		o.setYpdj(rs.getString("ypdj"));
		o.setInfo(rs.getString("info"));
		o.setSjrq(rs.getString("sjrq"));
		o.setJdjsf(rs.getString("jdjsf"));
		o.setJdjds(rs.getString("jdjds"));
		o.setKhdm(rs.getString("khdm"));
		o.setXzbz(rs.getString("xzbz"));
		o.setYjly(rs.getString("yjly"));

		return o;
	};
	public RowMapper<Tzbjsbhk> tzbjslyhkRowMapper = (rs, i) -> {
		Tzbjsbhk o = new Tzbjsbhk();
		o.setJsrq(rs.getString("jsrq"));
		o.setYjtm(rs.getString("yjtm"));
		o.setSjjgs(rs.getString("sjjgs"));
		o.setSjjsf(rs.getString("sjjsf"));
		o.setPyjgs(rs.getString("pyjgs"));
		o.setPyjsf(rs.getString("pyjsf"));
		o.setFcz(rs.getString("fcz"));
		o.setFdid(rs.getString("fdid"));
		o.setZbtm(rs.getString("zbtm"));
		o.setYldm(rs.getString("yldm"));
		o.setYljb(rs.getString("yljb"));
		o.setYlzl(rs.getString("ylzl"));
		o.setLdlsh(rs.getString("ldlsh"));
		o.setGls(rs.getDouble("gls"));
		o.setJsz(rs.getString("jsz"));
		o.setYjzl(rs.getString("yjzl"));
		o.setSjjdm(rs.getString("sjjdm"));
		o.setSjjds(rs.getString("sjjds"));
		o.setSjjxs(rs.getString("sjjxs"));
		o.setPyj(rs.getString("pyj"));
		o.setPyjds(rs.getString("pyjds"));
		o.setPyjxs(rs.getString("pyjxs"));
		o.setSyfl(rs.getDouble("syfl"));
		o.setBcfl(rs.getDouble("bcfl"));
		o.setSyf(rs.getDouble("syf"));
		o.setBcf(rs.getDouble("bcf"));
		o.setZl(rs.getDouble("zl"));
		o.setJhzl(rs.getDouble("jhzl"));
		o.setHbbh(rs.getString("hbbh"));
		o.setZlsx(rs.getString("zlsx"));
		o.setJssx(rs.getString("jssx"));
		o.setYjsl(rs.getDouble("yjsl"));
		o.setZbzl(rs.getDouble("zbzl"));
		o.setLhbz(rs.getString("lhbz"));
		o.setId(rs.getInt("id"));
		o.setYjjdm(rs.getString("yjjdm"));
		o.setJdjdm(rs.getString("jdjdm"));
		o.setYpdj(rs.getString("ypdj"));
		o.setInfo(rs.getString("info"));
		o.setSjrq(rs.getString("sjrq"));
		o.setJdjsf(rs.getString("jdjsf"));
		o.setJdjds(rs.getString("jdjds"));
		o.setKhdm(rs.getString("khdm"));
		o.setXzbz(rs.getString("xzbz"));
		o.setYjly(rs.getString("yjly"));

		return o;
	};
	
	public RowMapper<Zfgkzfywl> zfgkzfywlRowMapper = (rs, i) -> {
		Zfgkzfywl o = new Zfgkzfywl();
		o.setJsrq(rs.getString("jsrq"));
		o.setSjjgs(rs.getString("sjjgs"));
		o.setSjjsf(rs.getString("sjjsf"));
		o.setSjjds(rs.getString("sjjds"));
		o.setSjjxs(rs.getString("sjjxs"));
		o.setSjjdm(rs.getString("sjjdm"));
		o.setJdjsf(rs.getString("jdjsf"));
		o.setJdjds(rs.getString("jdjds"));
		o.setKhbm(rs.getString("khbm"));
		o.setYjzldm(rs.getString("yjzldm"));
		o.setJs(rs.getInt("js"));
		o.setJfzl(rs.getDouble("jfzl"));
		o.setZzf(rs.getDouble("zzf"));
		o.setYhje(rs.getDouble("yhje"));
		o.setHyyg_zf(rs.getDouble("hyyg_zf"));
		o.setHyyg_ywl(rs.getDouble("hyyg_ywl"));
		o.setQyyg_zf(rs.getDouble("qyyg_zf"));
		o.setQyyg_ywl(rs.getDouble("qyyg_ywl"));
		o.setYhyg_zf(rs.getDouble("yhyg_zf"));
		o.setYhyg_ywl(rs.getDouble("yhyg_ywl"));
		o.setMhyg_zf(rs.getDouble("mhyg_zf"));
		o.setMhyg_ywl(rs.getDouble("mhyg_ywl"));
		o.setCk_ly_snys_zf(rs.getDouble("ck_ly_snys_zf"));
		o.setCk_ly_snys_ywl(rs.getDouble("ck_ly_snys_ywl"));
		o.setCk_hk_snys_zf(rs.getDouble("ck_hk_snys_zf"));
		o.setCk_hk_snys_ywl(rs.getDouble("ck_hk_snys_ywl"));
		o.setJk_ly_snys_zf(rs.getDouble("jk_ly_snys_zf"));
		o.setJk_ly_snys_ywl(rs.getDouble("jk_ly_snys_ywl"));
		o.setJk_hk_snys_zf(rs.getDouble("jk_hk_snys_zf"));
		o.setJk_hk_snys_ywl(rs.getDouble("jk_hk_snys_ywl"));
		o.setCk_nbcl_zf(rs.getDouble("ck_nbcl_zf"));
		o.setCk_nbcl_ywl(rs.getDouble("ck_nbcl_ywl"));
		o.setJk_nbcl_zf(rs.getDouble("jk_nbcl_zf"));
		o.setJk_nbcl_ywl(rs.getDouble("jk_nbcl_ywl"));
		o.setZbzy_zf(rs.getDouble("zbzy_zf"));
		o.setZbzy_ywl(rs.getDouble("zbzy_ywl"));
		o.setSjzy_zf(rs.getDouble("sjzy_zf"));
		o.setSjzy_ywl(rs.getDouble("sjzy_ywl"));
		o.setTd_zf(rs.getDouble("td_zf"));
		o.setTd_ywl(rs.getDouble("td_ywl"));
		o.setJszchj(rs.getDouble("jszchj"));

		return o;
	};

	public RowMapper<YjsFkhzcmxb> yjsFkhzcmxbRowMapper = (rs, i) -> {
		YjsFkhzcmxb o = new YjsFkhzcmxb();
		o.setSjrq(rs.getString("sjrq"));
		o.setSjjgs(rs.getString("sjjgs"));
		o.setSjjsf(rs.getString("sjjsf"));
		o.setSjjds(rs.getString("sjjds"));
		o.setSjjxs(rs.getString("sjjxs"));
		o.setSjjdm(rs.getString("sjjdm"));
		o.setYjly(rs.getString("yjly"));
		o.setKhbm(rs.getString("khbm"));
		o.setJdjsf(rs.getString("jdjsf"));
		o.setJdjds(rs.getString("jdjds"));
		o.setYjtm(rs.getString("yjtm"));
		o.setYjzl(rs.getDouble("yjzl"));
		o.setJfzl(rs.getDouble("jfzl"));
		o.setZzf(rs.getDouble("zzf"));
		o.setYhje(rs.getDouble("yhje"));
		o.setYsfy(rs.getDouble("ysfy"));
		o.setNbclfy(rs.getDouble("nbclfy"));
		o.setZyfy(rs.getDouble("zyfy"));
		o.setTdfy(rs.getDouble("tdfy"));
		o.setHj(rs.getDouble("hj"));
		o.setYjbz(rs.getString("yjbz"));

		return o;
	};
	
	
	public List<JsYsxxDay> getYsxx(String sfdm);
	
	public void doDeleteYsxx(String sfdm, List<JsYsxxDay> result);
	
	public List<JsYsxxHkfyDay> getHkxx(String sfdm);
	
	public void doDeleteHkxx(String sfdm, List<JsYsxxHkfyDay> result);
	
	public List<SnjsJkxxb> doGetSnjsJkxxb(String sfdm);
	public void doUpdateSnjsJkxxb(String jsrq, String sfdm, String tabname);
	
	public List<Tzbjsbly> getTzbjsbly(String sfdm);
	
	public void doDeleteTzbjsbly(String sfdm, List<Tzbjsbly> result);

	List<Tzbjsbhk> getTzbjsbhk(String sfdm);
	void doDeleteTzbjsbhk(String sfdm, List<Tzbjsbhk> backlist);

/*	public List<Zfgkzfywl> getZfgkzfywl(String sfdm);

	public void doDeleteZfgkzfywl(String sfdm, List<Zfgkzfywl> backlist);

	public List<YjsFkhzcmxb> getYjsFkhzcmxb(String sfdm);

	public void doDeleteYjsFkhzcmxb(String sfdm, List<YjsFkhzcmxb> backlist);

	*/
}
