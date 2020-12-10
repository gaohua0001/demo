package com.dvt.core.dao.springjdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Vector;
import java.util.stream.IntStream;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCallback;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import com.dvt.core.dao.NameParameterObject;
import com.dvt.core.dao.NameParameterUtil;
import com.dvt.core.exception.CommonException;

public class GenericDaoImpl implements GenericDao {
	
	private JdbcTemplate jdbcTemplate;

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	public NamedParameterJdbcTemplate getNamedParameterJdbcTemplate() {
		return namedParameterJdbcTemplate;
	}

	public void setNamedParameterJdbcTemplate(
			NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
		this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
	}

	@Override
	public int updateSql(String sql, Map<String, Object> paramMap) {
		return namedParameterJdbcTemplate.update(sql, paramMap);
	}
	
	@Override
	public int updateSql(String sql, List<Object> paraList) {
		if(paraList != null) {
			return jdbcTemplate.update(sql, paraList.toArray(new Object[0]));
		} else {
			return jdbcTemplate.update(sql);
		}
	}

	@Override
	public int updateSqlBatch(String sql, Map<String, ?>[] batchValues) {
		int[] arr = namedParameterJdbcTemplate.batchUpdate(sql, batchValues);
		return IntStream.of(arr).sum();
	}

	@Override
	public int updateSqlBatch(String sql, List<List<Object>> batchValues) {
		List<Object[]> parameterArr = new ArrayList<Object[]>();
		for(List<Object> o : batchValues) {
			parameterArr.add(o.toArray(new Object[0]));
		}
		int[] arr = jdbcTemplate.batchUpdate(sql, parameterArr);
		return IntStream.of(arr).sum();
	}

	@Override
	public <T> List<T> getList(String sql, Map<String, Object> paramMap, RowMapper<T> rowMapper) {
		return namedParameterJdbcTemplate.query(sql, paramMap, rowMapper);
	}
	
	@Override
	public <T> List<T> getList(String sql, Map<String, Object> paramMap, Class<T> entityClass) {
		return namedParameterJdbcTemplate.queryForList(sql, paramMap, entityClass);
	}
	
	@Override
	public String getSingleString(String sql, Map<String, Object> paramMap) throws CommonException {
		Vector<Vector<String>> _vArr = getVectorString(sql, paramMap);
		if(_vArr == null || _vArr.size() == 0) {
			return null;
		}
		Vector<String> _v = _vArr.get(0);
		if(_v ==  null || _v.size() == 0) {
			return null;
		} else {
			return _v.get(0);
		}
	}

	@Override
	public int getSingleInt(String sql, Map<String, Object> paramMap) throws CommonException {
		String v = getSingleString(sql, paramMap);
		if(v == null || v.trim().length() == 0) {
			return 0;
		} else {
			return Integer.parseInt(v);
		}
	}
	@Override
	public double getSingleDouble(String sql, Map<String, Object> paramMap) throws CommonException {
		String v = getSingleString(sql, paramMap);
		if(v == null || v.trim().length() == 0) {
			return 0d;
		} else {
			return Double.parseDouble(v);
		}
	}
	
	public Vector<Vector<String>> getVectorString(String sql, Map<String, Object> paramMap) throws CommonException {
		NameParameterObject v = NameParameterUtil.preparesql(sql, paramMap);
		return jdbcTemplate.execute(new PreparedStatementCreator() {
			
			@Override
			public PreparedStatement createPreparedStatement(Connection con)
					throws SQLException {
				//创建PrepareStatement
				return con.prepareStatement(v.getSql());
			}
		}, new PreparedStatementCallback<Vector<Vector<String>>>() {
			@Override
			public Vector<Vector<String>> doInPreparedStatement(PreparedStatement ps)
					throws SQLException, DataAccessException {
				//设置参数
				int len = v.getParameters().size();
				for(int i=0;i<len;i++) {
					ps.setObject((i+1), v.getParameters().get(i));
				}
				//查询结果集
				ResultSet rs = ps.executeQuery();
				int cols = rs.getMetaData().getColumnCount();
				Vector<Vector<String>> _vArr = new Vector<Vector<String>>();
				if(rs.next()) {
					Vector<String> _v = new Vector<String>();
					Object obj = null;
					for(int i=1;i<cols+1;i++) {
						obj = rs.getObject(i);
						_v.add(obj == null ? null : obj.toString());
					}
					_vArr.add(_v);
				}
				return _vArr;
			}
			
		});
	}

}
