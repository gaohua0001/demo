package com.dvt.snjs.dubbo.model;

import java.io.Serializable;

public class Tyjzljbb implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5353404738764634283L;

	
	 private String id;
	 private String name;
	 private String parentid;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getParentid() {
		return parentid;
	}
	public void setParentid(String parentid) {
		this.parentid = parentid;
	}
	
	
}
