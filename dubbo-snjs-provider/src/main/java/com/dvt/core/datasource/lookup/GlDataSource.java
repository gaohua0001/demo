package com.dvt.core.datasource.lookup;


import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class GlDataSource implements MethodInterceptor {
	static Log log = LogFactory.getLog(GlDataSource.class.getName());

	public Object invoke(MethodInvocation me) throws Throwable {
		DataSourceContextHolder.setDataSourceType(DataSourceType.GL_DATESOURCE);
		//log.info("管理库...");
		return me.proceed();
	}
}
