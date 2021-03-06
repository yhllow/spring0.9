/*
 * The Spring Framework is published under the terms
 * of the Apache Software License.
 */
 
package org.springframework.aop.framework;

import org.aopalliance.intercept.AttributeRegistry;
import org.aopalliance.intercept.MethodInterceptor;

import java.lang.reflect.Method;

/**
 * MethodPointcut implementation wrapping an
 * Interceptor that should always run.
 * @author Rod Johnson
 * @since 04-Apr-2003
 * @version $Revision: 1.2 $
 */
public class AlwaysInvoked implements MethodPointcut {

	private final MethodInterceptor interceptor;
	
	public AlwaysInvoked(MethodInterceptor interceptor) {
		this.interceptor = interceptor;
	}
	/**
	 * @see MethodPointcut#getInterceptor()
	 */
	public MethodInterceptor getInterceptor() {
		return this.interceptor;
	}

	public boolean applies(Method m, Object[] args, AttributeRegistry ar) {
		return true;
	}

}
