package org.springframework.web.context.support;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.util.ResponseTimeMonitor;
import org.springframework.util.ResponseTimeMonitorImpl;
import org.springframework.web.context.RequestHandledEvent;

/**
 *
 * @author  RodJohnson
 * @since January 21, 2001
 * @version $RevisionId$
 */
public class PerformanceMonitorListener implements ApplicationListener {

	protected final Log logger = LogFactory.getLog(getClass());

	private ResponseTimeMonitorImpl responseTimeMonitor;

	public PerformanceMonitorListener() {
		responseTimeMonitor = new ResponseTimeMonitorImpl();
	}

	/**
	 * Ignore log events
	 */
	public void onApplicationEvent(ApplicationEvent e) {
		if (e instanceof RequestHandledEvent) {
			RequestHandledEvent rhe = (RequestHandledEvent) e;
			// Could use one monitor per URL
			responseTimeMonitor.recordResponseTime(rhe.getTimeMillis());
			if (logger.isInfoEnabled()) {
				// Stringifying objects is expensive. Don't do it unless it will show.
				logger.info("PerformanceMonitorListener: last=" + rhe.getTimeMillis() + "ms; " + responseTimeMonitor + "; client was " + rhe.getIP());
			}
		}
	}

	public ResponseTimeMonitor getResponseTimeMonitor() {
		return responseTimeMonitor;
	}

}
