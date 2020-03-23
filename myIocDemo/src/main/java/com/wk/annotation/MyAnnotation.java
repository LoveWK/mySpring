package com.wk.annotation;

import com.wk.importBeanDefinitionRegister.MyImportBeanDefinitionRegister;
import com.wk.scanner.MyScanner;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration//java配置类注解
@ComponentScan("com.wk")//设置扫描包的路径
@MyScanner//引入自己的扫描注解
public class MyAnnotation {
}
