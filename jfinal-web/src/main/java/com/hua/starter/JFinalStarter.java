/**
 * 描述: 
 * JFinalStarter.java
 * @author	qye.zheng
 * 
 *  version 1.0
 */
package com.hua.starter;

import org.junit.Test;

import com.jfinal.core.JFinal;

/**
 * 描述: 启动器
 * @author  qye.zheng
 * 
 * JFinalStarter
 */
public final class JFinalStarter
{

	

	// 启动器模板
	/**
	 * 
	 * 描述: 
	 * @author qye.zheng
	 * 
	 */
	@Test
	public void start()
	{
		/** ===== begin 驱动参数设置  ===== */
		// 设置例子
		
		/** ===== end of 驱动参数设置 ===== */

		// 启动驱动
		// target/jfinal-web-0.0.1 80 / 5
		String webAppDir = "target/jfinal-web-0.0.1";
		int port = 8080;
		String contextPath = "/jfinal-web";
		// 多少秒扫描一次
		int scanIntervalSeconds = 5;
		/*
		 * 访问 http://localhost:8080/jfinal-web/hello
		 */
		JFinal.start(webAppDir, port, contextPath, scanIntervalSeconds);
		while (true)
		{
			//
			//JFinal.stop();
		}
	}

}
