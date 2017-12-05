package com.cactus.aspect;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

import javax.servlet.http.HttpServletRequest;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.cactus.controller.SampleController;
import com.cactus.exception.CactusException;

@Aspect
@Component
public class TimeLoggingAspect {
	private static final Logger logger = LogManager.getLogger(SampleController.class);

//	@Around("execution(* com.cactus.controller.*.*(..))")
	public Object elaspedTimeAdvice(ProceedingJoinPoint joinPoint) throws CactusException {
		logger.debug("aspect running");	
		Object value = null;
		Object[] args = joinPoint.getArgs();
		MethodSignature methodSignature = (MethodSignature) joinPoint.getStaticPart().getSignature();
		Method method = methodSignature.getMethod();
		Annotation[][] parameterAnnotations = method.getParameterAnnotations();
		assert args.length == parameterAnnotations.length;
		for (int argIndex = 0; argIndex < args.length; argIndex++) {
			for (Annotation annotation : parameterAnnotations[argIndex]) {
				if (!(annotation instanceof RequestParam))
					continue;
				RequestParam requestParam = (RequestParam) annotation;
				if (!"accessToken".equals(requestParam.value()))
					continue;
				logger.debug("  " + requestParam.value() + " = " + args[argIndex]);
			}
			
		}
		try {
			value = joinPoint.proceed();
			return value;
		} catch (Throwable e) {
			throw new CactusException("aop exception", e);
		}

	}

	@Around("execution(* com.cactus.controller.*.*(..))")
	public Object requestInfo(ProceedingJoinPoint joinPoint) throws CactusException {
		logger.debug("aspect running");
		HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes())
				.getRequest();
		String ipaddress = request.getRemoteAddr();
		Object value = null;
		Object[] args = joinPoint.getArgs();
		MethodSignature methodSignature = (MethodSignature) joinPoint.getStaticPart().getSignature();
		Method method = methodSignature.getMethod();
		String name = method.getName();
		String params = "";
		for (Object argument : args) {
			params += argument.toString() + " ";
		}
		long start = System.currentTimeMillis();
		try {
			value = joinPoint.proceed();
			long end = System.currentTimeMillis();
			long elapsedTime = end - start;
			logger.debug("ip address:" + ipaddress + "; method name:" + name + "; params: " + params
					+ "; Total elapsed http request/response time in milliseconds: " + elapsedTime);
			return value;
		} catch (Throwable e) {
			throw new CactusException("aop exception", e);
		}

	}
}
