/*
 * The Spring Framework is published under the terms
 * of the Apache Software License.
 */
 
package org.springframework.aop.attributes;

import org.aopalliance.intercept.AttributeRegistry;

import java.lang.reflect.AccessibleObject;

//import attrib4j.Attributes;

/**
 * @author Rod Johnson
 * @since 13-Mar-2003
 * @version $Revision: 1.3 $
 */
public class Attrib4jAttributeRegistry implements AttributeRegistry {

	public Object[] getAttributes(AccessibleObject ao) {
		// TODO: could cache, or want independent instances?
//		Method m = (Method) ao;
//		attrib4j.Attribute[] attrib4jAtts = Attributes.getAttributes(m);
//		return attrib4jAtts;

		throw new UnsupportedOperationException("Attrib4j integration not yet implemented");
	}
		

	public Object[] getAttributes(Class clazz) {
		throw new UnsupportedOperationException("Attrib4j integration not yet implemented");
	}

}
