package com.wk.processor;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

@Component
public class TestPostProcessor implements BeanPostProcessor {
	@Override
	public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
		/*if("dao".equals(beanName)){
			System.out.println("BeanPostProcessor:before processor");
		}*/
//		System.out.println(beanName+":BeanPostProcessor:before processor");
		return bean;
	}

	@Override
	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
		/*if("dao".equals(beanName)){
			System.out.println("BeanPostProcessor:after processor");
		}*/
//		System.out.println(beanName+":BeanPostProcessor:after processor");
		return bean;
	}
}
