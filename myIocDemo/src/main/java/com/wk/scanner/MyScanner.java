package com.wk.scanner;

import com.wk.importBeanDefinitionRegister.MyImportBeanDefinitionRegister;
import org.springframework.context.annotation.Import;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * 模拟spring，实现自己的扫描功能
 */
@Import(MyImportBeanDefinitionRegister.class)
@Retention(RetentionPolicy.RUNTIME)//仿照spring的生命周期
public @interface MyScanner {
}
