package com.dvt.snjs.dubbo.model;

import java.io.Serializable;

public class Qyjxxb implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7380207783957246991L;

	private String qdid;
	private String yjtm;
	private String scsj;
	private double zl;
	private String yjzl;
	private String sfdm;
	
	public String getQdid() {
		return qdid;
	}
	public void setQdid(String qdid) {
		this.qdid = qdid;
	}
	public String getYjtm() {
		return yjtm;
	}
	public void setYjtm(String yjtm) {
		this.yjtm = yjtm;
	}
	public String getScsj() {
		return scsj;
	}
	public void setScsj(String scsj) {
		this.scsj = scsj;
	}
	public double getZl() {
		return zl;
	}
	public void setZl(double zl) {
		this.zl = zl;
	}
	public String getYjzl() {
		return yjzl;
	}
	public void setYjzl(String yjzl) {
		this.yjzl = yjzl;
	}
	public String getSfdm() {
		return sfdm;
	}
	public void setSfdm(String sfdm) {
		this.sfdm = sfdm;
	}

}
