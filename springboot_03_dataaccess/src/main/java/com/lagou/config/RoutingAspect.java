package com.lagou.config;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class RoutingAspect {


	@Around("@annotation(with)")
	public Object routingWithDataSource(ProceedingJoinPoint joinPoint,RoutingWith with) throws Throwable {
		// master
		String key = with.value();
		RoutingDataSourceContext routingDataSourceContext = new RoutingDataSourceContext(key);
		return  joinPoint.proceed();

	}




}
