package com.dvt.snjs.service;

import java.util.List;

import org.springframework.jdbc.core.RowMapper;

import com.dvt.snjs.dubbo.model.JsNbclCkfyDay;
import com.dvt.snjs.dubbo.model.JsNbclJkfyDay;
import com.dvt.snjs.dubbo.model.JsNbclYjxxDay;

/**
 * 快递包裹内部处理
 * @author zane
 *
 */
public interface NbclService {

	public RowMapper<JsNbclYjxxDay> ksjzRowMapper = (rs, i) -> {
		JsNbclYjxxDay o = new JsNbclYjxxDay();
		
		o.setJsrq(rs.getString("jsrq"));
		o.setZbtm(rs.getString("zbtm"));
		o.setYjtm(rs.getString("yjtm"));
		o.setYjzl(rs.getString("yjzl"));
		o.setClj(rs.getString("clj"));
		o.setCljgs(rs.getString("cljgs"));
		o.setCljsf(rs.getString("cljsf"));
		o.setCljds(rs.getString("cljds"));
		o.setCljxs(rs.getString("cljxs"));
		o.setSjj(rs.getString("sjj"));
		o.setSjjgs(rs.getString("sjjgs"));
		o.setSjjsf(rs.getString("sjjsf"));
		o.setJdj(rs.getString("jdj"));
		o.setJdjsf(rs.getString("jdjsf"));
		o.setJssx(rs.getString("jssx"));
		o.setZlsx(rs.getString("zlsx"));
		o.setZl(rs.getDouble("zl"));
		o.setJhzl(rs.getDouble("jhzl"));
		o.setZbzl(rs.getDouble("zbzl"));
		o.setSyfl(rs.getDouble("syfl"));
		o.setBcfl(rs.getDouble("bcfl"));
		o.setSyf(rs.getDouble("syf"));
		o.setBcf(rs.getDouble("bcf"));
		o.setId(rs.getInt("id"));
		o.setSjjds(rs.getString("sjjds"));
		o.setSjjxs(rs.getString("sjjxs"));
		o.setYpdj(rs.getString("ypdj"));
		o.setTime(rs.getString("time"));
		o.setInfo(rs.getString("info"));
		o.setSyfl2(rs.getDouble("syfl2"));
		o.setBcfl2(rs.getDouble("bcfl2"));
		o.setSjrq(rs.getString("sjrq"));
		o.setJdjds(rs.getString("jdjds"));
		o.setJbbz(rs.getString("jbbz"));
		o.setKhdm(rs.getString("khdm"));
		o.setYjly(rs.getString("yjly"));
		o.setXzbz(rs.getString("xzbz"));
		return o;
	};
	
	public RowMapper<JsNbclCkfyDay> ckfyRowMapper = (rs, i) -> {
		JsNbclCkfyDay o = new JsNbclCkfyDay();
		o.setJsrq(rs.getString("jsrq"));
		o.setZbtm(rs.getString("zbtm"));
		o.setYjtm(rs.getString("yjtm"));
		o.setYjzl(rs.getString("yjzl"));
		o.setClj(rs.getString("clj"));
		o.setCljgs(rs.getString("cljgs"));
		o.setCljsf(rs.getString("cljsf"));
		o.setCljds(rs.getString("cljds"));
		o.setCljxs(rs.getString("cljxs"));
		o.setSjj(rs.getString("sjj"));
		o.setSjjgs(rs.getString("sjjgs"));
		o.setSjjsf(rs.getString("sjjsf"));
		o.setJdj(rs.getString("jdj"));
		o.setJdjsf(rs.getString("jdjsf"));
		o.setJssx(rs.getString("jssx"));
		o.setZlsx(rs.getString("zlsx"));
		o.setZl(rs.getDouble("zl"));
		o.setJhzl(rs.getDouble("jhzl"));
		o.setZbzl(rs.getDouble("zbzl"));
		o.setSyfl(rs.getDouble("syfl"));
		o.setBcfl(rs.getDouble("bcfl"));
		o.setSyf(rs.getDouble("syf"));
		o.setBcf(rs.getDouble("bcf"));
		o.setId(rs.getInt("id"));
		o.setSjjds(rs.getString("sjjds"));
		o.setSjjxs(rs.getString("sjjxs"));
		o.setYpdj(rs.getString("ypdj"));
		o.setTime(rs.getString("time"));
		o.setInfo(rs.getString("info"));
		o.setSyfl2(rs.getDouble("syfl2"));
		o.setBcfl2(rs.getDouble("bcfl2"));
		o.setSjrq(rs.getString("sjrq"));
		o.setFtcs(rs.getDouble("ftcs"));
		o.setJdjds(rs.getString("jdjds"));
		o.setJbbz(rs.getString("jbbz"));
		o.setKhdm(rs.getString("khdm"));
		o.setYjly(rs.getString("yjly"));
		o.setXzbz(rs.getString("xzbz"));
		return o;
	};
	
	public RowMapper<JsNbclJkfyDay> jkfyRowMapper = (rs, i) -> {
		JsNbclJkfyDay o = new JsNbclJkfyDay();
		o.setJsrq(rs.getString("jsrq"));
		o.setZbtm(rs.getString("zbtm"));
		o.setYjtm(rs.getString("yjtm"));
		o.setYjzl(rs.getString("yjzl"));
		o.setClj(rs.getString("clj"));
		o.setCljgs(rs.getString("cljgs"));
		o.setCljsf(rs.getString("cljsf"));
		o.setCljds(rs.getString("cljds"));
		o.setCljxs(rs.getString("cljxs"));
		o.setSjj(rs.getString("sjj"));
		o.setSjjgs(rs.getString("sjjgs"));
		o.setSjjsf(rs.getString("sjjsf"));
		o.setJdj(rs.getString("jdj"));
		o.setJdjsf(rs.getString("jdjsf"));
		o.setJssx(rs.getString("jssx"));
		o.setZlsx(rs.getString("zlsx"));
		o.setZl(rs.getDouble("zl"));
		o.setJhzl(rs.getDouble("jhzl"));
		o.setZbzl(rs.getDouble("zbzl"));
		o.setSyfl(rs.getDouble("syfl"));
		o.setBcfl(rs.getDouble("bcfl"));
		o.setSyf(rs.getDouble("syf"));
		o.setBcf(rs.getDouble("bcf"));
		o.setId(rs.getInt("id"));
		o.setSjjds(rs.getString("sjjds"));
		o.setSjjxs(rs.getString("sjjxs"));
		o.setYpdj(rs.getString("ypdj"));
		o.setTime(rs.getString("time"));
		o.setInfo(rs.getString("info"));
		o.setSyfl2(rs.getDouble("syfl2"));
		o.setBcfl2(rs.getDouble("bcfl2"));
		o.setSjrq(rs.getString("sjrq"));
		o.setFtcs(rs.getDouble("ftcs"));
		o.setJdjds(rs.getString("jdjds"));
		o.setJbbz(rs.getString("jbbz"));
		o.setKhdm(rs.getString("khdm"));
		o.setYjly(rs.getString("yjly"));
		o.setXzbz(rs.getString("xzbz"));

		return o;
	};
	
	/**
	 * 省际经转费
	 * @param sfdm
	 * @return
	 */
	public List<JsNbclYjxxDay> getKsjz(String sfdm);
	
	/**
	 * 删除省际经转费
	 * @param sfdm
	 * @param result
	 */
	public void doDeleteKsjz(String sfdm, List<JsNbclYjxxDay> result);
	
	/**
	 * 出口省内部处理费
	 * @param sfdm
	 * @return
	 */
	public List<JsNbclCkfyDay> getCkfy(String sfdm);
	
	/**
	 * 删除出口省内部处理费
	 * @param sfdm
	 * @param result
	 */
	public void doDeleteCkfy(String sfdm, List<JsNbclCkfyDay> result);
	
	/**
	 * 进口省内部处理费
	 * @param sfdm
	 * @return
	 */
	public List<JsNbclJkfyDay> getJkfy(String sfdm);
	
	/**
	 * 删除进口省内部处理费
	 * @param sfdm
	 * @param result
	 */
	public void doDeleteJkfy(String sfdm, List<JsNbclJkfyDay> result);
}
