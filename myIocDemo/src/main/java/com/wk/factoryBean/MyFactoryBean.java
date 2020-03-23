package com.wk.factoryBean;

import com.wk.invocationHandler.MyInvocationHandler;
import com.wk.test.Test;
import com.wk.ucc.IndexUCC;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.stereotype.Component;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

@SuppressWarnings("rawtypes")//jdk8如果不使用这个注解会导致报rawtypes类型错误
public class MyFactoryBean implements FactoryBean, InvocationHandler {
	// 创建构造方法，方便动态传入接口类
	Class clazz;
	public MyFactoryBean(Class clazz){
		this.clazz = clazz;
	}
	// 这里利用了FactoryBean的getObject返回的是自己定义的代理对象的特性来实现接口的实现类的创建
	// 实现了FactoryBean的类，在使用MyFactoryBean.class的时候获取的是getObject()返回的类
	@Override
	public Object getObject(){
		Class[] classes = new Class[]{clazz};
		Object proxy = Proxy.newProxyInstance(this.getClass().getClassLoader(), classes ,this);
		return proxy;
	}

	@Override
	public Class<?> getObjectType() {
		return clazz;
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args){
		System.out.println("myInvocationHandler....");
		//可以在这里通过method进行自己的逻辑处理
		Method[] methods = proxy.getClass().getInterfaces()[0].getMethods();
		for (Method method1 : methods){
			System.out.println("method1:"+method1);
		}
		System.out.println("method:"+method.getName());
		return null;
	}
}
