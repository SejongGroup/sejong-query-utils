package com.kakao.datavisualization.interceptor;

import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import com.kakao.datavisualization.interceptor.Auth.Role;

@Retention(RUNTIME)
@Target({ TYPE, METHOD })
public @interface Auth {
	public enum Role {ADMIN, USER}
	
	// 이와 같이 작성하면 메서드 위에 @Auth(role=Role.ADMIN)과 같이 작성 가능
	public Role role() default Role.USER;
}