package com.damai.datasource;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 
 * 在方法上使用，用于指定使用哪个数据源
 * 
 * @author felix.chen
 * @date 2018年2月12日 上午15:26:57
 *
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface RoutingDataSource {
	RoutingStrategy value();
}