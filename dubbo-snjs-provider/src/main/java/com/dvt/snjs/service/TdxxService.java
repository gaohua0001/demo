package com.dvt.snjs.service;

import java.util.List;

import org.springframework.jdbc.core.RowMapper;

import com.dvt.snjs.dubbo.model.JsTdxxDay;

/**
 * 投递信息service
 * @author zane
 *
 */
public interface TdxxService {
	
	public RowMapper<JsTdxxDay> tdxxRowMapper = (rs, i) -> {
		JsTdxxDay o = new JsTdxxDay();
		o.setId(rs.getInt("id"));
		o.setYjtm(rs.getString("yjtm"));
		o.setTdrq(rs.getString("tdrq"));
		o.setYjzl(rs.getString("yjzl"));
		o.setZl(rs.getDouble("zl"));
		o.setJhzl(rs.getDouble("jhzl"));
		o.setPydq(rs.getString("pydq"));
		o.setTdjdm(rs.getString("tdjdm"));
		o.setTdjgs(rs.getString("tdjgs"));
		o.setTdxs(rs.getString("tdxs"));
		o.setTdds(rs.getString("tdds"));
		o.setTdsf(rs.getString("tdsf"));
		o.setBcfl1(rs.getDouble("bcfl1"));
		o.setBcfl2(rs.getDouble("bcfl2"));
		o.setBcf(rs.getDouble("bcf"));
		o.setSjjdm(rs.getString("sjjdm"));
		o.setSjjgs(rs.getString("sjjgs"));
		o.setSjjxs(rs.getString("sjjxs"));
		o.setSjjds(rs.getString("sjjds"));
		o.setSjjsf(rs.getString("sjjsf"));
		o.setSyfl1(rs.getDouble("syfl1"));
		o.setSyfl2(rs.getDouble("syfl2"));
		o.setSyf(rs.getDouble("syf"));
		o.setJssx(rs.getString("jssx"));
		o.setSjrq(rs.getString("sjrq"));
		o.setSftt(rs.getString("sftt"));
		o.setYpdj(rs.getString("ypdj"));
		o.setInfo(rs.getString("info"));
		o.setSyfl3(rs.getDouble("syfl3"));
		o.setBcfl3(rs.getDouble("bcfl3"));
		o.setYpdjjs(rs.getDouble("ypdjjs"));
		o.setJdjdm(rs.getString("jdjdm"));
		o.setJdjsf(rs.getString("jdjsf"));
		o.setJdjds(rs.getString("jdjds"));
		o.setKhdm(rs.getString("khdm"));
		o.setTdy(rs.getString("tdy"));
		o.setXzbz(rs.getString("xzbz"));
		o.setYjly(rs.getString("yjly"));
		
		return o;
	};
	
	/**
	 * 投递信息
	 * @param sfdm
	 * @return
	 */
	public List<JsTdxxDay> getTdxx(String sfdm);
	
	/**
	 * 删除投递信息
	 * @param sfdm
	 * @param result
	 */
	public void doDeleteTdxx(String sfdm, List<JsTdxxDay> result);
}
