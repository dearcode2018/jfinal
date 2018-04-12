/**
  * @filename MyJFinalConfig.java
  * @description  
  * @version 1.0
  * @author qianye.zheng
 */
package com.hua.config;

import com.hua.controller.HelloWorldController;
import com.hua.entity.User;
import com.hua.handler.ResourceHandler;
import com.hua.interceptor.AuthInterceptor;
import com.hua.route.FrontRoutes;
import com.jfinal.config.Constants;
import com.jfinal.config.Handlers;
import com.jfinal.config.Interceptors;
import com.jfinal.config.JFinalConfig;
import com.jfinal.config.Plugins;
import com.jfinal.config.Routes;
import com.jfinal.plugin.activerecord.ActiveRecordPlugin;
import com.jfinal.plugin.c3p0.C3p0Plugin;
import com.jfinal.render.ViewType;

 /**
 * @type MyJFinalConfig
 * @description  
 * @author qianye.zheng
 */
public class MyJFinalConfig extends JFinalConfig
{

	/**
	 * @description 配置常量
	 * @param me
	 * @author qianye.zheng
	 */
	@Override
	public void configConstant(Constants me)
	{
		/*
		 * 模式设置，设置为开发模式
		 * 在开发模式下，JFinal会对每次请求输出报告，如输出本次请求的controller、method
		 * 以及请求所携带的参数
		 */
		me.setDevMode(true);
		/*
		 * 设置视图类型
		 * JFinal支持jsp/freemarker/velocity 3种常用的视图
		 */
		me.setViewType(ViewType.JSP);
		/*
		 * 设置文件上传基础路径
		 * 绝对路径: 以 / 开头
		 * 先对路径: a/bc，相对于项目根路径
		 */
		me.setUploadedFileSaveDirectory("upload/a");
		// 文件下载路径
		me.setFileRenderPath("download/a");
	}

	/**
	 * @description 配置路由
	 * @param me
	 * @author qianye.zheng
	 */
	@Override
	public void configRoute(Routes me)
	{
		// 添加路由
		/*
		 * 配置路由地址和Controller映射
		 * hello 访问 index()方法，hello/methodName访问 methodName方法
		 * methodName默认值是 index
		 * viewPath参数未指定时默认值为controllerKey
		 * url中的多个参数用 - 隔开
		 */
		me.add("/hello", HelloWorldController.class);
		
		// 添加路由对象
		me.add(new FrontRoutes());
		
	}

	/**
	 * @description 配置插件
	 * @param me
	 * @author qianye.zheng
	 */
	@Override
	public void configPlugin(Plugins me)
	{
		//
		loadPropertyFile("conf/properties/jfinal.properties");
		C3p0Plugin c3p0Plugin = new C3p0Plugin(getProperty("db.jdbc.c3p0.jdbcUrl"), 
				getProperty("db.jdbc.c3p0.user"), getProperty("db.jdbc.c3p0.password"));
		me.add(c3p0Plugin);
		ActiveRecordPlugin activeRecoredPlugin = new ActiveRecordPlugin(c3p0Plugin);
		me.add(activeRecoredPlugin);
		activeRecoredPlugin.addMapping("t_user", User.class);
	}

	/**
	 * @description 配置拦截器
	 * @param me
	 * @author qianye.zheng
	 */
	@Override
	public void configInterceptor(Interceptors me)
	{
		// 添加拦截器(全局)
		me.addGlobalActionInterceptor(new AuthInterceptor());
	}

	/**
	 * @description 配置处理器
	 * @param me
	 * @author qianye.zheng
	 */
	@Override
	public void configHandler(Handlers me)
	{
		/*
		 * Handler可以接管所有web请求，并对应用拥有完全的控制权
		 * 可以很方便地实现更高层的功能性扩展
		 */
		me.add(new ResourceHandler());
	}

	/**
	 * @description 系统启动之后回调
	 * @author qianye.zheng
	 */
	@Override
	public void afterJFinalStart()
	{
		super.afterJFinalStart();
		System.out.println("MyJFinalConfig.afterJFinalStart()");
	}
	
	/**
	 * @description 系统关闭之前回调
	 * @author qianye.zheng
	 */
	@Override
	public void beforeJFinalStop()
	{
		super.beforeJFinalStop();
		System.out.println("MyJFinalConfig.beforeJFinalStop()");
	}
	
}
