package com.dvt.snjs.dubbo.model;

import java.io.Serializable;

public class SnjsJkxxb implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8882109332418760711L;
	private String jsrq;
	private String tabname;
	private String sfdm;
	private String xfbz;
	private String xfsj;
	private String status;
	/**
	 * 01-一干结算
	 * 02-快递包裹结算库接口库
	 * 03-快递包裹结算库明细库
	 */
	private String xtly;
	
	public String getJsrq() {
		return jsrq;
	}
	public void setJsrq(String jsrq) {
		this.jsrq = jsrq;
	}
	public String getTabname() {
		return tabname;
	}
	public void setTabname(String tabname) {
		this.tabname = tabname;
	}
	public String getSfdm() {
		return sfdm;
	}
	public void setSfdm(String sfdm) {
		this.sfdm = sfdm;
	}
	public String getXfbz() {
		return xfbz;
	}
	public void setXfbz(String xfbz) {
		this.xfbz = xfbz;
	}
	public String getXfsj() {
		return xfsj;
	}
	public void setXfsj(String xfsj) {
		this.xfsj = xfsj;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getXtly() {
		return xtly;
	}
	public void setXtly(String xtly) {
		this.xtly = xtly;
	}
}
