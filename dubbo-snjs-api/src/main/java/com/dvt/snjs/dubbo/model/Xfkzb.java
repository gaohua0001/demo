package com.dvt.snjs.dubbo.model;

import java.io.Serializable;

public class Xfkzb implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -1252884625196974570L;
	private String sfdm;
	private String tabname;
	
	public String getSfdm() {
		return sfdm;
	}
	public void setSfdm(String sfdm) {
		this.sfdm = sfdm;
	}
	public String getTabname() {
		return tabname;
	}
	public void setTabname(String tabname) {
		this.tabname = tabname;
	}

}
