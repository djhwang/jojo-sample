/**
 * App.java 1.0 2012. 11. 15.
 *   
 * Copyright 2012 S-Core, Inc. All rights reserved.
 * S-Core PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.everm.propertydescriptor;

import java.beans.PropertyDescriptor;

import org.apache.commons.beanutils.PropertyUtils;

/**
 * @date 2012. 11. 15.
 * @author Davd
 *
 */
public class App {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
	      try{
	    	  Object bean = new App();
	          PropertyDescriptor[] pds = PropertyUtils.getPropertyDescriptors(bean);
	          Class beanClass = bean.getClass();
	          for( int i = 0; i < pds.length; i++ ){
	             String key = pds[i].getName();
	             Class type = pds[i].getPropertyType();
	             if( pds[i].getReadMethod() != null ){
	                Object value = PropertyUtils.getProperty( bean, key );
	             }else{
	                String warning = "Property '" + key + "' has no read method. SKIPPED";
	             }
	          }
	       }catch( Exception e ){
	    	   e.printStackTrace();
	       }
	}
	
	public void fail() {
		
	}
}
