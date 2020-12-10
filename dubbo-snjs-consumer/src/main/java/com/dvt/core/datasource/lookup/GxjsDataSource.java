package com.dvt.core.datasource.lookup;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class GxjsDataSource implements MethodInterceptor {
	
	private static Log log = LogFactory.getLog(GxjsDataSource.class);

	@Override
	public Object invoke(MethodInvocation invocation) throws Throwable {
		DataSourceContextHolder.setDataSourceType(DataSourceType.GXJS_DATASOURCE);
		//log.debug("一干结算库...");
		return invocation.proceed();
	}

}
