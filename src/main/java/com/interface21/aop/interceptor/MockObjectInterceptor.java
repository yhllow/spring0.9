
package com.interface21.aop.interceptor;


import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

/**
 * Interceptor that throws UnsupportedOperationException
 * on any invocation. Useful during development.
 * <p>
 * ALSO MOCK INTERCEPTOR: can test
 *
 * @author Rod Johnson
 */
public class MockObjectInterceptor implements MethodInterceptor {

    // CREATE AN EASY MOCK

    // How to know when to verify?

    /**
     */
    public Object invoke(MethodInvocation invocation) throws Throwable {
        String s = invocation.getMethod().getName();
        throw new UnsupportedOperationException("StubInterceptor: '" + s + "' not implemented");

    }

}
