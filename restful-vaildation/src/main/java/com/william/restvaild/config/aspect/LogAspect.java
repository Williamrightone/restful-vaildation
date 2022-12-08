package com.william.restvaild.config.aspect;

import javax.servlet.http.HttpServletRequest;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Aspect
@Order(1)
@Component
public class LogAspect {

	@Pointcut("execution(public * com.william.restvaild.controller..*Controller.*(..))")
	public void logReceive() {
	}
	
	@Before("logReceive()")
	public void doBefore(JoinPoint joinPoint) throws Throwable {
		
		ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
		HttpServletRequest request = attributes.getRequest();

		StringBuilder sb = new StringBuilder();
		sb.append("\nRequest URL: ").append(request.getRequestURL().toString());
		sb.append("\nHTTP Method : ").append(request.getMethod());
		sb.append("\nRequest IP : ").append(request.getRemoteAddr());
		sb.append("\nRequest Class : ").append(joinPoint.getSignature().getDeclaringTypeName()).append(".")
				.append(joinPoint.getSignature().getName());
		sb.append("\nRequest Header : ").append(request.getHeader("Authorization"));

		log.info(sb.toString());

	}
	
	
}
