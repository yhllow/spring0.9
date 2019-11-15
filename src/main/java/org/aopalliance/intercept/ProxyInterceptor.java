package org.aopalliance.intercept;

public interface ProxyInterceptor extends Interceptor {
    Object getTarget();
}
