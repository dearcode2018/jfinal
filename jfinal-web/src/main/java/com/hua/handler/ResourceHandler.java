/**
  * @filename ResourceHandler.java
  * @description  
  * @version 1.0
  * @author qianye.zheng
 */
package com.hua.handler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jfinal.handler.Handler;

 /**
 * @type ResourceHandler
 * @description  资源处理器
 * @author qianye.zheng
 */
public class ResourceHandler extends Handler
{

	/**
	 * @description 
	 * @param target
	 * @param request
	 * @param response
	 * @param isHandled
	 * @author qianye.zheng
	 */
	@Override
	public void handle(String target, HttpServletRequest request,
			HttpServletResponse response, boolean[] isHandled)
	{
		System.out.println("target: " + target + ", isHandled: " + isHandled);
	}

}
