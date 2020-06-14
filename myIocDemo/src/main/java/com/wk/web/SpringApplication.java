package com.wk.web;

import com.wk.annotation.MyAnnotation;
import org.apache.catalina.LifecycleException;
import org.apache.catalina.Wrapper;
import org.apache.catalina.startup.Tomcat;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.ServletRegistration;

public class SpringApplication {
	public static void run(){
		//start tomcat
		Tomcat tomcat = new Tomcat();
		tomcat.setPort(8000);
//		tomcat.addWebapp("/","");
		//如果使用addContext，那么Tomcat就认为不是一个web项目，所以不会去找jsp的依赖
//		tomcat.addContext("/","d:\\wk\\");
		try {
			//复制WebApplicationInitializer的代码
			//---------------start
			/*AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
			context.register(MyAnnotation.class);
			//实例化你的bean
			context.refresh();

			DispatcherServlet servlet = new DispatcherServlet((WebApplicationContext) context);
			Wrapper registration = tomcat.addServlet("/","mvc",servlet);
			registration.addMapping("*.do");
			registration.setLoadOnStartup(1);*/
			//----------------end
			tomcat.start();
			tomcat.getServer().await();
		} catch (LifecycleException e) {
			e.printStackTrace();
		}
	}
}
