package org.springframework.aop.interceptor;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

public abstract class AbstractQaInterceptor implements MethodInterceptor {

    public Object invokeInternal(MethodInvocation invocation) throws Throwable {
        Object result = invocation.invokeNext();
        checkInvariants(invocation.getInvokedObject());
        return result;
    }

    protected abstract void checkInvariants(Object target);

}
