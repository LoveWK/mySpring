package com.wk.importBeanDefinitionRegister;

import com.wk.factoryBean.MyFactoryBean;
import com.wk.ucc.IndexUCC;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanNameGenerator;
import org.springframework.beans.factory.support.GenericBeanDefinition;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.stereotype.Component;

@Component
public class MyImportBeanDefinitionRegister implements ImportBeanDefinitionRegistrar {
	@Override
	public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry, BeanNameGenerator importBeanNameGenerator) {
		/**
		 * 得到BeanDefinition
		 * 通过BeanDefinitionBuilder的静态方法获得
		 * IndexDao可以动态获取，这里先写死
		 */
		BeanDefinitionBuilder builder = BeanDefinitionBuilder.genericBeanDefinition(IndexUCC.class);
		//得到标准的BeanDefinition
		GenericBeanDefinition beanDefinition = (GenericBeanDefinition) builder.getBeanDefinition();
		System.out.println("ImportBeanDefinitionRegistrar:"+beanDefinition.getBeanClassName());
		// 设置构造方法,因为MyFactoryBean不是使用的默认构造方法，如果使用的无参构造方法，spring比较容易创建对象实例，
		// 但是如果是我们自己的构造方法，那么spring就没有办法自动帮我们创建对象了，
		// 所以我们要手动设置自己的构造方法，来实例化对象
		beanDefinition.getConstructorArgumentValues().addGenericArgumentValue("com.wk.ucc.IndexUCC");
		//通过factoryBean的特性，拿出代理对象
		beanDefinition.setBeanClass(MyFactoryBean.class);
		//注册到registry中,
		registry.registerBeanDefinition("indexUcc",beanDefinition);
	}
}
