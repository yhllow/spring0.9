package org.springframework.ejb.access;

import org.springframework.aop.framework.AopUtils;
import org.aopalliance.aop.AspectException;
import org.aopalliance.intercept.MethodInvocation;

import javax.ejb.EJBObject;
import java.lang.reflect.InvocationTargetException;


/**
 * Basic remote invoker for EJBs.
 * "Creates" a new EJB instance for each invocation.
 *
 * @version $Revision: 1.1 $
 */
public class SimpleRemoteSlsbInvokerInterceptor extends AbstractRemoteSlsbInvokerInterceptor {

    /**
     * JavaBean constructor
     */
    public SimpleRemoteSlsbInvokerInterceptor() {
    }

    /**
     * Convenient constructor for programmatic use.
     *
     * @param jndiName
     * @param inContainer
     * @throws AspectException
     */
    public SimpleRemoteSlsbInvokerInterceptor(String jndiName, boolean inContainer) throws AspectException {
        setJndiName(jndiName);
        setInContainer(inContainer);
        try {
            afterPropertiesSet();
        } catch (Exception ex) {
            throw new AspectException("Failed to create EJB invoker interceptor", ex);
        }
    }

    /**
     * This is the last invoker in the chain
     *
     */
    public Object invoke(MethodInvocation invocation) throws Throwable {
        EJBObject ejb = newSessionBeanInstance();
        try {
            return invocation.getMethod().invoke(ejb, AopUtils.getArguments(invocation));
        } catch (InvocationTargetException ex) {
            logger.warn(ex + " thrown invoking remote EJB method " + invocation.getMethod());
            throw ex.getTargetException();
        } catch (Throwable t) {
            throw new AspectException("Failed to invoke remote EJB", t);
        }
    }

}
