package com.wk.invocationHandler;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 *
 */
public class MyInvocationHandler implements InvocationHandler {
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) {
		System.out.println("myInvocationHandler....");
		//可以在这里通过method进行自己的逻辑处理
		return null;
	}
}
