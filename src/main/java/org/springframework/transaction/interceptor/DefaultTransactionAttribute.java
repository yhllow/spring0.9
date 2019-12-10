/*
 * The Spring Framework is published under the terms
 * of the Apache Software License.
 */
 
package org.springframework.transaction.interceptor;

import org.springframework.transaction.support.DefaultTransactionDefinition;

/**
 * Transaction attribute that takes EJB approach to rolling
 * back on runtime, but not checked, exceptions.
 * @author Rod Johnson
 * @since 16-Mar-2003
 * @version $Revision: 1.1 $
 */
public class DefaultTransactionAttribute extends DefaultTransactionDefinition
    implements TransactionAttribute {

	public DefaultTransactionAttribute(int propagationBehavior, int isolationLevel) {
		super(propagationBehavior, isolationLevel);
	}
	
	/**
	 * Default behaviour is as with EJB: rollback on unchecked exception.
	 * Consistent with TransactionTemplate's behavior.
	 */
	public boolean rollBackOn(Throwable t) {
		return (t instanceof RuntimeException);
	}

}
