package com.william.restvaild.config.aspect;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
@Component
@Order(2)
public class ProjectAspect {

	@Pointcut("execution(public * com.william.restvaild.controller..*Controller.*(..))")
	public void logDB() {
	}

}
