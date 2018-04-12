/**
  * @filename AuthInterceptor.java
  * @description  
  * @version 1.0
  * @author qianye.zheng
 */
package com.hua.interceptor;

import com.jfinal.aop.Interceptor;
import com.jfinal.aop.Invocation;

 /**
 * @type AuthInterceptor
 * @description  
 * @author qianye.zheng
 */
public class AuthInterceptor implements Interceptor
{
	
	/**
	 * @Before
	 * @After
	 * @Clear 可以清除所处层的上一层的拦截器，本层和下层不清除，不带参数清除所有的，带参数则
	 * 清除指定的拦截器
	 */

	/**
	 * @description 
	 * @param inv
	 * @author qianye.zheng
	 */
	@Override
	public void intercept(Invocation inv)
	{
		System.out.println("viewPath: " + inv.getViewPath());
		inv.invoke();
	}

}
