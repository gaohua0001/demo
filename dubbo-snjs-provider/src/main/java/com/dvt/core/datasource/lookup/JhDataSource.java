package com.dvt.core.datasource.lookup;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class JhDataSource implements MethodInterceptor {
	private Log log = LogFactory.getLog(JhDataSource.class.getName());

	public Object invoke(MethodInvocation me) throws Throwable {
		DataSourceContextHolder.setDataSourceType(DataSourceType.JH_DATESOURCE);
		//log.info("交换库...");
		return me.proceed();
	}

}
