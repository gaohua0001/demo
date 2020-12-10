package com.dvt.core.dao;

import java.util.List;

public class NameParameterObject {

	private String sql;
	private List<Object> parameters;
	/**
	 * 批量执行
	 */
	private List<List<Object>> parameterArr;
	
	public String getSql() {
		return sql;
	}
	public void setSql(String sql) {
		this.sql = sql;
	}
	public List<Object> getParameters() {
		return parameters;
	}
	public void setParameters(List<Object> parameters) {
		this.parameters = parameters;
	}
	public List<List<Object>> getParameterArr() {
		return parameterArr;
	}
	public void setParameterArr(List<List<Object>>  parameterArr) {
		this.parameterArr = parameterArr;
	}
}
