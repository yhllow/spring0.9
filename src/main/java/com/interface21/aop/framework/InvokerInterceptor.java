
package com.interface21.aop.framework;

import org.aopalliance.aop.AspectException;
import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.aopalliance.intercept.ProxyInterceptor;

import java.lang.reflect.InvocationTargetException;

/**
 * Implementation of Interceptor interface that
 * invokes a local target object using reflection.
 * This is always a final interceptor. It's the only interceptor in the ****
 *
 * @author Rod Johnson
 */
public class InvokerInterceptor implements MethodInterceptor, ProxyInterceptor {


    /**
     * Target invoked using reflection
     */
    private Object target;

    public InvokerInterceptor() {
    }

    public InvokerInterceptor(Object target) {
        this.target = target;
    }

    public void setTarget(Object target) {
        this.target = target;
    }

    public Object getTarget() {
        return this.target;
    }

    public Object invoke(MethodInvocation invocation) throws Throwable {

        // Set the target on the invocation
        if (invocation instanceof MethodInvocationImpl) {
            ((MethodInvocationImpl) invocation).setTarget(this.target);
        }

        // Use reflection to invoke the method
        try {
            Object rval = invocation.getMethod().invoke(this.target, AopUtils.getArguments(invocation));
//			if (rval == null OR VOID OR this
            return rval;
        } catch (InvocationTargetException ex) {
            // Invoked method threw a checked exception.
            // We must rethrow it. The client won't see the interceptor
            Throwable t = ex.getTargetException();
            throw t;
        } catch (IllegalAccessException ex) {
            throw new AspectException("Couldn't access method " + invocation.getMethod() + ", ", ex);
        }
    }

}
