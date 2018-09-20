package com.damai.aspect;

import java.lang.reflect.Method;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.damai.datasource.DynamicRoutingContextHolder;
import com.damai.datasource.RoutingDataSource;

public class DBReadWriteSeparateAspect {
	
	private final Logger logger = LoggerFactory.getLogger(getClass());

    public void before(JoinPoint point) {
        Object target = point.getTarget();
        String methodName = point.getSignature().getName();
        Class<?> clazz = target.getClass();

        logger.info("before class:{} method:{} execute", clazz.getName(), methodName);

        Class<?>[] parameterTypes = ((MethodSignature) point.getSignature()).getMethod().getParameterTypes();
        try {
            Method method = clazz.getMethod(methodName, parameterTypes);
            if (method != null && method.isAnnotationPresent(RoutingDataSource.class)) {
                RoutingDataSource data = method.getAnnotation(RoutingDataSource.class);
                DynamicRoutingContextHolder.setRouteStrategy(data.value());
                logger.info("class:{} method:{} 切换数据源:{} 成功", clazz.getName(), methodName, data.value());
            }
        } catch (Exception e) {
            logger.error("数据源切换切面异常", e);
        }
    }
}
