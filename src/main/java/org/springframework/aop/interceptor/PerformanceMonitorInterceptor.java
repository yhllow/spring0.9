package org.springframework.aop.interceptor;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import org.springframework.util.StopWatch;

/**
 * Trivial performance monitor interceptor.
 * Could make this much more sophisticated, storing information.
 * Presently logs information using Log4j. This interceptor
 * has no effect on the intercepted method call.
 * @author Rod Johnson
 * @author Dmitriy Kopylenko
 * @version $Id: PerformanceMonitorInterceptor.java,v 1.1 2003/06/13 13:40:11 jhoeller Exp $
 */
public class PerformanceMonitorInterceptor implements MethodInterceptor {

	protected final Log logger = LogFactory.getLog(getClass());

	public Object invoke(MethodInvocation invocation) throws Throwable {
		logger.info("Begin...");

		StopWatch sw = new StopWatch();
		sw.start(invocation.getMethod().getName());
		Object rval = invocation.invokeNext();
		sw.stop();

		logger.info(sw.prettyPrint());

		logger.info("End.");

		return rval;
	}

}
