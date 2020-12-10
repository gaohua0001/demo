package com.dvt.core.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

import com.dvt.core.exception.CommonException;

/**
 * 
 * @author zane
 *
 */
public class NameParameterUtil {

	public static final String HQL_SEPARATORS = " \n\r\f\t,()=<>&|+-=/*'^![]#~\\";
	
	public static NameParameterObject preparesql(String sql, Map<String,Object> paras) throws CommonException  {
		String SYMBOLS = HQL_SEPARATORS.replace( "'", "" );
		final StringTokenizer tokens = new StringTokenizer( sql, SYMBOLS, true );
		StringBuilder result = new StringBuilder();
		List<Object> parameters = new ArrayList<Object>();
		
		while ( tokens.hasMoreTokens() ) {
			final String token = tokens.nextToken();
			if ( token.startsWith(":") ) {
				if(!paras.containsKey(token.substring( 1 ))) {
					throw new CommonException("key is not exists " + token);
				}
				result.append('?');
				parameters.add(paras.get(token.substring( 1 )));
			} else {
				result.append(token);
			}
		}
		NameParameterObject v = new NameParameterObject();
		v.setSql(result.toString());
		v.setParameters(parameters);
		return v;
	}
	
	public static NameParameterObject preparesql(String sql, Map<String,Object>[] paras) throws CommonException  {
		String SYMBOLS = HQL_SEPARATORS.replace( "'", "" );
		final StringTokenizer tokens = new StringTokenizer( sql, SYMBOLS, true );
		StringBuilder result = new StringBuilder();
		//初始化参数集合
		int len = paras.length;
		List<List<Object>> parasArr = new ArrayList<List<Object>>();
		for(int i=0;i<len;i++) {
			parasArr.add(new ArrayList<Object>());
		}
		
		while ( tokens.hasMoreTokens() ) {
			final String token = tokens.nextToken();
			if ( token.startsWith(":") ) {
				result.append('?');
				for(int i=0;i<len;i++) {
					if(!paras[i].containsKey(token.substring( 1 ))) {
						throw new CommonException("key is not exists " + token);
					}
					parasArr.get(i).add(paras[i].get(token.substring( 1 )));
				}
			} else {
				result.append(token);
			}
		}
		NameParameterObject v = new NameParameterObject();
		v.setSql(result.toString());
		v.setParameterArr(parasArr);
		return v;
	}
	
	public static String preparesql(String sql)  {
		String SYMBOLS = HQL_SEPARATORS.replace( "'", "" );
		final StringTokenizer tokens = new StringTokenizer( sql, SYMBOLS, true );
		StringBuilder result = new StringBuilder();
		
		while ( tokens.hasMoreTokens() ) {
			final String token = tokens.nextToken();
			if ( token.startsWith(":") ) {
				result.append('?');
			} else {
				result.append(token);
			}
		}
		return result.toString();
	}
	
	public static List<Object> preparePrameter(String sql, Map<String,Object> paras) throws CommonException  {
		String SYMBOLS = HQL_SEPARATORS.replace( "'", "" );
		final StringTokenizer tokens = new StringTokenizer( sql, SYMBOLS, true );
		List<Object> parameters = new ArrayList<Object>();
		while ( tokens.hasMoreTokens() ) {
			final String token = tokens.nextToken();
			if ( token.startsWith(":") ) {
				if(!paras.containsKey(token.substring( 1 ))) {
					throw new CommonException("key is not exists " + token);
				}
				parameters.add(paras.get(token.substring( 1 )));
			} 
		}
		return parameters;
	}
	
}
