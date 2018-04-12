/**
  * @filename FrontRoutes.java
  * @description  
  * @version 1.0
  * @author qianye.zheng
 */
package com.hua.route;

import com.hua.controller.BlobController;
import com.hua.controller.IndexController;
import com.jfinal.config.Routes;

 /**
 * @type FrontRoutes
 * @description  
 * @author qianye.zheng
 */
public class FrontRoutes extends Routes
{

	/**
	 * @description 
	 * @author qianye.zheng
	 */
	@Override
	public void config()
	{
		add("/", IndexController.class, "/viws/index.html");
		add("/blob", BlobController.class, "/viws/blob.html");
	}

}
