package org.aopalliance.intercept;

import org.springframework.transaction.TransactionStatus;

import java.lang.reflect.Method;

public interface MethodInvocation extends Invocation {
    Method getMethod();

    Object invokeNext() throws Throwable;

    Object getInvokedObject();

    AttributeRegistry getAttributeRegistry();

    void setResource(String name, TransactionStatus status);
}
