/*
 * Copyright 2002-2014 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.springframework.context;

import org.springframework.beans.factory.HierarchicalBeanFactory;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.core.env.EnvironmentCapable;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.springframework.lang.Nullable;

/**
 * Central interface to provide configuration for an application.
 * This is read-only while the application is running, but may be
 * reloaded if the implementation supports this.
 * 为应用程序提供配置的中央接口
 * 在应用程序运行时,这是只读的,但是如果实现支持这个接口,则可以重新加载.
 *
 * <p>An ApplicationContext provides:
 * 一个ApplicationContext提供以下的功能:
 * <ul>
 * <li>Bean factory methods for accessing application components.
 * 用于访问应用程序组件的Bean工厂方法.
 * Inherited from {@link org.springframework.beans.factory.ListableBeanFactory}.
 * <li>The ability to load file resources in a generic fashion.
 * 以通用方式加载资源文件的能力
 * Inherited from the {@link org.springframework.core.io.ResourceLoader} interface.
 * <li>The ability to publish events to registered listeners.
 * 将事件发布到注册侦听器的能力
 * Inherited from the {@link ApplicationEventPublisher} interface.
 * <li>The ability to resolve messages, supporting internationalization.
 *  解析消息的能力,支持国际化.
 * Inherited from the {@link MessageSource} interface.
 * <li>Inheritance from a parent context. Definitions in a descendant context
 * will always take priority. This means, for example, that a single parent
 * context can be used by an entire web application, while each servlet has
 * its own child context that is independent of that of any other servlet.
 * 从父上下文继承,在后代上下文中的定义将始终处于优先级.例如,这意味着单个父上下文可以被整个web应用程序使用,
 * 而每个servlet都有自己独立于任何其他servlet的子上下文.
 * </ul>
 *
 * <p>In addition to standard {@link org.springframework.beans.factory.BeanFactory}
 * lifecycle capabilities, ApplicationContext implementations detect and invoke
 * {@link ApplicationContextAware} beans as well as {@link ResourceLoaderAware},
 * {@link ApplicationEventPublisherAware} and {@link MessageSourceAware} beans.
 * 除了标准的BeanFactory生命周期功能,ApplicationContext实现检测和调用{ApplicationContextAware}bean以及
 *
 * @author Rod Johnson
 * @author Juergen Hoeller
 * @see ConfigurableApplicationContext
 * @see org.springframework.beans.factory.BeanFactory
 * @see org.springframework.core.io.ResourceLoader
 */
public interface ApplicationContext extends EnvironmentCapable, ListableBeanFactory, HierarchicalBeanFactory,
		MessageSource, ApplicationEventPublisher, ResourcePatternResolver {

	/**
	 * Return the unique id of this application context.
	 * @return the unique id of the context, or {@code null} if none
	 * 返回此应用程序上下文的唯一id.
	 */
	@Nullable
	String getId();

	/**
	 * Return a name for the deployed application that this context belongs to.
	 * @return a name for the deployed application, or the empty String by default
	 * 返回此上下文所属的已部署的应用程序的名称
	 */
	String getApplicationName();

	/**
	 * Return a friendly name for this context.
	 * @return a display name for this context (never {@code null})
	 * 为这个上下文返回一个友好的名称
	 */
	String getDisplayName();

	/**
	 * Return the timestamp when this context was first loaded.
	 * @return the timestamp (ms) when this context was first loaded
	 * 返回第一次加载改上下文时的时间戳
	 */
	long getStartupDate();

	/**
	 * Return the parent context, or {@code null} if there is no parent
	 * and this is the root of the context hierarchy.
	 * @return the parent context, or {@code null} if there is no parent
	 * 返回父上下文,如果没有父上下文,并且这是上下文层次结构的根,则返回{null}
	 */
	@Nullable
	ApplicationContext getParent();

	/**
	 * Expose AutowireCapableBeanFactory functionality for this context.
	 * 为此上下文公开AutowireCapableBeanFactory的功能
	 *
	 * <p>This is not typically used by application code, except for the purpose of
	 * initializing bean instances that live outside of the application context,
	 * applying the Spring bean lifecycle (fully or partly) to them.
	 * 这通常不被应用程序代码使用,除非是为了初始化位于应用程序上下文之外的bean实例.
	 * 对它们应用Spring bean生命周期(全部或部分).
	 *
	 * <p>Alternatively, the internal BeanFactory exposed by the
	 * {@link ConfigurableApplicationContext} interface offers access to the
	 * {@link AutowireCapableBeanFactory} interface too. The present method mainly
	 * serves as a convenient, specific facility on the ApplicationContext interface.
	 * 另外,由{ConfigurableApplicationContext}接口公开的内部BeanFactory也提供对
	 * {AutowireCapableBeanFactory}接口的访问.本方法主要用于作为ApplicationContext接口上的一种方便的,特定的工具.
	 *
	 * <p><b>NOTE: As of 4.2, this method will consistently throw IllegalStateException
	 * after the application context has been closed.</b> In current Spring Framework
	 * versions, only refreshable application contexts behave that way; as of 4.2,
	 * all application context implementations will be required to comply.
	 * @return the AutowireCapableBeanFactory for this context
	 * @throws IllegalStateException if the context does not support the
	 * {@link AutowireCapableBeanFactory} interface, or does not hold an
	 * autowire-capable bean factory yet (e.g. if {@code refresh()} has
	 * never been called), or if the context has been closed already
	 * @see ConfigurableApplicationContext#refresh()
	 * @see ConfigurableApplicationContext#getBeanFactory()
	 * 注意:从4.2版本开始,该方法将在应用程序上下文关闭后始终抛出IllegalStateException
	 * 在当前的Spring框架版本中,只有可刷新的应用程序上下文才会有这种行为,从4.2开始,
	 * 所有应用程序上下文都必须遵守.
	 */
	AutowireCapableBeanFactory getAutowireCapableBeanFactory() throws IllegalStateException;

}
