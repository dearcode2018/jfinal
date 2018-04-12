/**
  * @filename HelloWorldController.java
  * @description  
  * @version 1.0
  * @author qianye.zheng
 */
package com.hua.controller;

import com.hua.service.OrderService;
import com.jfinal.aop.Clear;
import com.jfinal.core.ActionKey;
import com.jfinal.core.Controller;

 /**
 * @type HelloWorldController
 * @description 控制器
 * @author qianye.zheng
 */
public class HelloWorldController extends Controller
{
	
	/**
	 * 可以使用的基类方法:
	 * renderText / getAttr / getPara (从请求中获取参数) / 
	 * getModel: 接收页面表单域传过来的model对象，表单域 名称 以 modelName.attrName方式命名
	 * 例如: getModel(Class<T extends Model>, "xx")
	 *  setAttr: 该方法调用了setAttribute()，可以将各种参数传递给view并在view中展示出来
	 */
	
	/*
	 * session
	 * 在web容器中可以设置session对象的生命周期，一个session对象和用户的关系由应用程序去维护，
	 * 通过 token或用户ID等作为key去建立一个用户和用户信息的对应关系
	 */
	
	/**
	 * 
	 * @description 
	 * @author qianye.zheng
	 */
	public void index()
	{
		//renderText("hello world jfinal...");
	}
	
	/**
	 * 
	 * @description 
	 * @author qianye.zheng
	 */
	// ActionKey注解配置映射路由
	@ActionKey("/lott")
	// @Clear 清除拦截功能
	//@Clear
	public void lott()
	{
		//renderText("hello world lott...");
	}
	
	/**
	 * 
	 * @description 文件上传
	 * @author qianye.zheng
	 */
	public void upload()
	{
		/*
		 * 默认上传路径是 项目根路径下upload
		 */
		// 解析文件上传请求
		//getFile();
	}
	
	/**
	 * 
	 * @description 
	 * @author qianye.zheng
	 */
	public void download()
	{
		/*
		 * 默认下载路径 项目根路径下download
		 */
		// readerFile();
	}
	
	/**
	 * 
	 * @description 
	 * @author qianye.zheng
	 */
	// ActionKey注解配置映射路由
	@ActionKey("/renderJson1")
	// @Clear 清除拦截功能
	public void renderJson1()
	{
		renderJson("{\"name\":\"zhangsan\"}");
	}
	
	/**
	 * 
	 * @description 
	 * @author qianye.zheng
	 */
	public void payment()
	{
		System.out.println("HelloWorldController.payment()");
		OrderService service = enhance(OrderService.class);
		service.payment();
	}
}
