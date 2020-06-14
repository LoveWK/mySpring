package com.wk.postProcessor;

import com.wk.dao.IndexDao;
import com.wk.invocationHandler.MyInvocationHandler;
import com.wk.service.IndexService;
import com.wk.service.impl.IndexServiceImpl;
import org.springframework.beans.BeansException;
import org.springframework.beans.PropertyValues;
import org.springframework.beans.factory.config.InstantiationAwareBeanPostProcessor;
import org.springframework.stereotype.Component;

import java.lang.reflect.Proxy;


/**
 * InstantiationAwareBeanPostProcessor接口的主要作用在于目标对象的实例化过程中需要处理的事情，
 * 包括实例化对象的前后过程以及实例的属性设置
 */
@Component
public class MyInstantiation implements InstantiationAwareBeanPostProcessor {
	//如果你自己定义一个代理对象，并返回，那么就会使用你定义的代理对象，
	//如果返回null，spring就会走正常实例化流程给你创建对象
	@Override
	public Object postProcessBeforeInstantiation(Class<?> beanClass, String beanName) throws BeansException {
		//生成一个代理对象
		/*if ("service".equals(beanName)){
			System.out.println("service Proxy creat:");
			Class<?>[] classes = new Class<?>[]{IndexService.class};
			Object proxy = Proxy.newProxyInstance(this.getClass().getClassLoader(), classes ,new MyInvocationHandler());
			return proxy;
		}else {
			return null;
		}*/
		return null;
	}

	//如果返回true，那么会判断是否对属性进行填充
	@Override
	public boolean postProcessAfterInstantiation(Object bean, String beanName) throws BeansException {
//		System.out.println("AfterInstantiation:-------"+beanName);
		return true;
	}

	//对属性进行具体填充
	@Override
	public PropertyValues postProcessProperties(PropertyValues pvs, Object bean, String beanName) throws BeansException {
		return null;
	}
}
