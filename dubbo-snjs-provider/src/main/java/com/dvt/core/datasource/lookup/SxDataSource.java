package com.dvt.core.datasource.lookup;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class SxDataSource implements MethodInterceptor {
	static Log log = LogFactory.getLog(SxDataSource.class.getName());

	public Object invoke(MethodInvocation me) throws Throwable {
		DataSourceContextHolder.setDataSourceType(DataSourceType.SX_DATESOURCE);
		//log.info("时限库...");
		return me.proceed();
	}
}
