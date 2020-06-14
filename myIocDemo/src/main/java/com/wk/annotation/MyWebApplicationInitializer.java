package com.wk.annotation;


import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.Servlet;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

//Tomcat可以调用到这个类，因为Tomcat可以借用servlet3.0的技术标准来进行扫描，
//调用实现了WebApplicationInitializer接口的类中的onStartup方法
public class MyWebApplicationInitializer implements WebApplicationInitializer {
	//onStartup方法有两个作用：
	//1.初始化Spring环境
	//2.配置DispatcherServlet，然后把DispatcherServlet注册给容器
	@Override
	public void onStartup(ServletContext servletContext) throws ServletException {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.register(MyAnnotation.class);
		//实例化你的bean
		context.refresh();

		DispatcherServlet servlet = new DispatcherServlet(context);
		//把servlet注册给Tomcat容器
		ServletRegistration.Dynamic registration = servletContext.addServlet("mvc", (Servlet) servlet);
		//Tomcat拦截的路径
		registration.addMapping("*.do");
		registration.setLoadOnStartup(1);
	}

}
