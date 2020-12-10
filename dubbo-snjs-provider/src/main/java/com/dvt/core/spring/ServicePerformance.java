package com.dvt.core.spring;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * 监视service性能
 * @author zanewang
 *
 */
public class ServicePerformance implements MethodInterceptor {

	private Log log = LogFactory.getLog(this.getClass());
	
	public Object invoke(MethodInvocation invocation) throws Throwable {

		long start = System.currentTimeMillis();

		Object result = invocation.proceed();
		
		if(log.isInfoEnabled()) {
			log.info(invocation.getThis().getClass().getName() + "."
					+ invocation.getMethod().getName() + "-performance(ms) "
					+ (System.currentTimeMillis() - start));
		}
		
		return result;
	}

}
