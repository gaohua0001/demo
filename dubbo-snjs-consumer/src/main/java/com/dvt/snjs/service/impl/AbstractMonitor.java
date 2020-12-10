package com.dvt.snjs.service.impl;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.dao.DataAccessException;

import com.dvt.core.dao.springjdbc.GenericDao;
import com.dvt.snjs.dubbo.model.Monitor;

public abstract class AbstractMonitor {

	public abstract  GenericDao getGenericDao();
	
	public void saveMonitor(Monitor monitor) throws SQLException, DataAccessException {
		String sql = "merge into  snjs_datax_monitor a"
				+ " using(select trunc(to_date(:qsrq,'yyyymmddhh24miss')) qsrq, "
				+ " trunc(to_date(:zzrq,'yyyymmddhh24miss')) zzrq,:tabname tabname, :lx lx from dual) b"
				+ " on (a.qsrq=b.qsrq and a.zzrq=b.zzrq and a.lx=b.lx and a.tabname=b.tabname)"
				+ " when not matched then insert (qsrq,zzrq,lx,tabname,successrows,failrows,scsj) "
				+ " values(trunc(to_date(:qsrq,'yyyymmddhh24miss')),"
				+ "trunc(to_date(:zzrq,'yyyymmddhh24miss')),:lx,:tabname,:successrows,:failrows,sysdate)"
				+ " when matched then update set successrows=:successrows,failrows=:failrows,scsj=sysdate";
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("qsrq", monitor.getQsrq());
		paramMap.put("zzrq", monitor.getQsrq());
		paramMap.put("lx", monitor.getLx());
		paramMap.put("tabname", monitor.getTabname());
		paramMap.put("successrows", monitor.getSuccessrecords());
		paramMap.put("failrows", monitor.getFailedrecords());
		this.getGenericDao().updateSql(sql, paramMap);
	}
}
