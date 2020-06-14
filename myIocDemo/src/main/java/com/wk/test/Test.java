package com.wk.test;

import com.wk.annotation.MyAnnotation;
import com.wk.factoryBean.MyFactoryBean;
import com.wk.service.IndexService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * 测试类
 */
public class Test {
	public static void main(String[] args) {
		//把spring所有的前提环境准备好了，包括spring容器还有类的实例化都完成了。
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MyAnnotation.class);
//		System.out.println("indexUcc bean:"+context.getBean("indexUcc"));//com.wk.ucc.IndexUCC
//		System.out.println("MyFactoryBean getObject:"+ MyFactoryBean.class);
		IndexService service = (IndexService)context.getBean("service");
		service.query();
//		System.out.println("service end:"+service.getClass().getSimpleName());
	}
}
