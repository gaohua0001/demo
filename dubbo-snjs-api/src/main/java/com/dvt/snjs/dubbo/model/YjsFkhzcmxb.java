package com.dvt.snjs.dubbo.model;

import java.io.Serializable;
/**
 * 
 * @Description: 预结算分客户支出明细表    
 * @author yangbing
 * @date 2019年4月26日
 */
public class YjsFkhzcmxb implements Serializable{

	private static final long serialVersionUID = 300923848844864237L;

	private String sjrq;
	private String sjjgs;
	private String sjjsf;
	private String sjjds;
	private String sjjxs;
	private String sjjdm;
	private String yjly;
	private String khbm;
	private String jdjsf;
	private String jdjds;
	private String yjtm;
	private double yjzl;//邮件重量
	private double jfzl;//计费重量
	private double zzf;//总资费
	private double yhje;//优惠金额
	private double ysfy;//运输费用
	private double nbclfy;//内部处理费用
	private double zyfy;//转运费用
	private double tdfy;//投递费用
	private double hj;//合计
	private String yjbz;//邮件标志 ;快递包裹：KDBG  标准快递：BZKD
	
	public String getSjrq() {
		return sjrq;
	}
	public void setSjrq(String sjrq) {
		this.sjrq = sjrq;
	}
	public String getSjjgs() {
		return sjjgs;
	}
	public void setSjjgs(String sjjgs) {
		this.sjjgs = sjjgs;
	}
	public String getSjjsf() {
		return sjjsf;
	}
	public void setSjjsf(String sjjsf) {
		this.sjjsf = sjjsf;
	}
	public String getSjjds() {
		return sjjds;
	}
	public void setSjjds(String sjjds) {
		this.sjjds = sjjds;
	}
	public String getSjjxs() {
		return sjjxs;
	}
	public void setSjjxs(String sjjxs) {
		this.sjjxs = sjjxs;
	}
	public String getSjjdm() {
		return sjjdm;
	}
	public void setSjjdm(String sjjdm) {
		this.sjjdm = sjjdm;
	}
	public String getYjly() {
		return yjly;
	}
	public void setYjly(String yjly) {
		this.yjly = yjly;
	}
	public String getKhbm() {
		return khbm;
	}
	public void setKhbm(String khbm) {
		this.khbm = khbm;
	}
	public String getJdjsf() {
		return jdjsf;
	}
	public void setJdjsf(String jdjsf) {
		this.jdjsf = jdjsf;
	}
	public String getJdjds() {
		return jdjds;
	}
	public void setJdjds(String jdjds) {
		this.jdjds = jdjds;
	}
	public String getYjtm() {
		return yjtm;
	}
	public void setYjtm(String yjtm) {
		this.yjtm = yjtm;
	}
	public double getYjzl() {
		return yjzl;
	}
	public void setYjzl(double yjzl) {
		this.yjzl = yjzl;
	}
	public double getJfzl() {
		return jfzl;
	}
	public void setJfzl(double jfzl) {
		this.jfzl = jfzl;
	}
	public double getZzf() {
		return zzf;
	}
	public void setZzf(double zzf) {
		this.zzf = zzf;
	}
	public double getYhje() {
		return yhje;
	}
	public void setYhje(double yhje) {
		this.yhje = yhje;
	}
	public double getYsfy() {
		return ysfy;
	}
	public void setYsfy(double ysfy) {
		this.ysfy = ysfy;
	}
	public double getNbclfy() {
		return nbclfy;
	}
	public void setNbclfy(double nbclfy) {
		this.nbclfy = nbclfy;
	}
	public double getZyfy() {
		return zyfy;
	}
	public void setZyfy(double zyfy) {
		this.zyfy = zyfy;
	}
	public double getTdfy() {
		return tdfy;
	}
	public void setTdfy(double tdfy) {
		this.tdfy = tdfy;
	}
	public double getHj() {
		return hj;
	}
	public void setHj(double hj) {
		this.hj = hj;
	}
	public String getYjbz() {
		return yjbz;
	}
	public void setYjbz(String yjbz) {
		this.yjbz = yjbz;
	}

	
}
