/**
  * @filename OrderService.java
  * @description  
  * @version 1.0
  * @author qianye.zheng
 */
package com.hua.service;

import com.hua.interceptor.AuthInterceptor;
import com.hua.service.impl.CoreServiceImpl;
import com.jfinal.aop.Before;

 /**
 * @type OrderService
 * @description  
 * @author qianye.zheng
 */
public class OrderService extends CoreServiceImpl
{
	/**
	 * 
	 * @description 
	 * @author qianye.zheng
	 */
	@Before(AuthInterceptor.class)
	public void payment()
	{
		
	}
}
