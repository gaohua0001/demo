package com.dvt.core.datasource.lookup;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class NewGxjsDataSource implements MethodInterceptor {
	
	private static Log log = LogFactory.getLog(NewGxjsDataSource.class);

	@Override
	public Object invoke(MethodInvocation invocation) throws Throwable {
		DataSourceContextHolder.setDataSourceType(DataSourceType.NEWGXJS_DATASOURCE);
		//log.debug("快递包裹结算库...");
		return invocation.proceed();
	}

}
