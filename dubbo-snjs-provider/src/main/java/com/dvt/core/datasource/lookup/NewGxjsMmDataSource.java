package com.dvt.core.datasource.lookup;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class NewGxjsMmDataSource implements MethodInterceptor {
	
	private static Log log = LogFactory.getLog(NewGxjsMmDataSource.class);

	@Override
	public Object invoke(MethodInvocation invocation) throws Throwable {
		DataSourceContextHolder.setDataSourceType(DataSourceType.NEWGXJSMM_DATASOURCE);
		//log.debug("快递包裹结算明细库...");
		return invocation.proceed();
	}

}
