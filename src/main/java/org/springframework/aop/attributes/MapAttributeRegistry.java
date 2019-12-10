/*
 * The Spring Framework is published under the terms
 * of the Apache Software License.
 */

package org.springframework.aop.attributes;

import org.aopalliance.intercept.AttributeRegistry;

import java.lang.reflect.AccessibleObject;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Rod Johnson
 * @version $Id: MapAttributeRegistry.java,v 1.1 2003/05/19 13:00:28 johnsonr Exp $
 * @since 19-May-2003
 */
public class MapAttributeRegistry implements AttributeRegistry {

    /**
     * Map from Method (on class or interface) to attribute[]
     */
    private Map attributeMap = new HashMap();

    public void setAttributes(AccessibleObject ao, Object[] atts) {
        this.attributeMap.put(ao, atts);
    }

    public Object[] getAttributes(AccessibleObject ao) {
        return (Object[]) this.attributeMap.get(ao);
    }

    public Object[] getAttributes(Class clazz) {
        throw new UnsupportedOperationException("getAttributes");
    }

}
