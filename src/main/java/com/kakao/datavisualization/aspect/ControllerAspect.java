package com.kakao.datavisualization.aspect;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

import com.kakao.datavisualization.common.ApplicationProperty;
import com.kakao.datavisualization.model.MemberVO;

@Aspect
public class ControllerAspect {
	
	@Around(value = "execution(* com.kakao.datavisualization.login.controller.*.*(..)) && args(request, response, responseVo)")
	public Object beforeController(ProceedingJoinPoint joinPoint, HttpServletRequest request, HttpServletResponse response, MemberVO responseVo) throws Throwable {
		System.out.println(ApplicationProperty.authorMail);
		return joinPoint.proceed(new Object[] {request, response, responseVo});
	}
}
