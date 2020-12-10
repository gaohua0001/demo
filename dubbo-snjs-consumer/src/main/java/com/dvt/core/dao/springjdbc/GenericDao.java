package com.dvt.core.dao.springjdbc;

import java.util.List;
import java.util.Map;
import java.util.Vector;

import org.springframework.jdbc.core.RowMapper;

import com.dvt.core.exception.CommonException;

public interface GenericDao {

	/**
	 * 使用原生sql进行数据更新
	 * @param sql
	 * @return
	 * @throws Exception
	 */
	public int updateSql(final String sql, final Map<String, Object> paramMap);
	
	public int updateSql(final String sql, final List<Object> paraList);
	
	public int updateSqlBatch(final String sql, final List<List<Object>> batchValues);
	
	public int updateSqlBatch(String sql, Map<String, ?>[] batchValues);
	
	/**
	 * 使用原生SQL查询
	 * @param nativeSQL
	 * @param paramsMap
	 * @param entityClass
	 * @param start
	 * @param length
	 * @return
	 */
	public <T> List<T> getList(String sql, Map<String, Object> paramMap, RowMapper<T> rowMapper);
	
	public String getSingleString(String sql, Map<String, Object> paramMap)throws CommonException;
	
	public int getSingleInt(String sql, Map<String, Object> paramMap)throws CommonException;
	
	public double getSingleDouble(String sql, Map<String, Object> paramMap)throws CommonException;

	public Vector<Vector<String>> getVectorString(String sql, Map<String, Object> paramMap)throws CommonException;

	public <T> List<T> getList(String sql, Map<String, Object> paramMap, Class<T> entityClass);
}
