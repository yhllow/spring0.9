package org.springframework.aop.interceptor;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import org.springframework.util.ClassLoaderAnalyzer;

/**
 * Trivial classloader analyzer interceptor
 * @version $Id: ClassLoaderAnalyzerInterceptor.java,v 1.1 2003/06/13 13:40:11 jhoeller Exp $
 * @author Rod Johnson
 * @author Dmitriy Kopylenko
 */
public class ClassLoaderAnalyzerInterceptor implements MethodInterceptor {

	protected final Log logger = LogFactory.getLog(getClass());

	public Object invoke(MethodInvocation pInvocation) throws Throwable {
		logger.info("Begin...");

		logger.info(ClassLoaderAnalyzer.showClassLoaderHierarchy(
			pInvocation.getInvokedObject(),
			pInvocation.getInvokedObject().getClass().getName(),
			"\n",
			"-"));
		Object rval = pInvocation.invokeNext();

		logger.info("End.");

		return rval;
	}

}
