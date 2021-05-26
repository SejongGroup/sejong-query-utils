package com.kakao.datavisualization.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.kakao.datavisualization.model.MemberVO;

public class MemberInterceptor extends HandlerInterceptorAdapter {
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		// 1. handler 종류 확인
		// 우리가 관심 있는 것은 Controller에 있는 메서드이므로 HandlerMethod 타입인지 체크
		if(handler instanceof HandlerMethod == false ) {
			// return true이면  Controller에 있는 메서드가 아니므로, 그대로 컨트롤러로 진행
			return true;
		}
		
		// 2.형 변환
		HandlerMethod handlerMethod = (HandlerMethod)handler;
		
		// 3. @Auth 받아오기
		Auth auth = handlerMethod.getMethodAnnotation(Auth.class);
		
		// 4. method에 @Auth가 없는 경우, 즉 인증이 필요 없는 요청
		if( auth == null ) {
			return true;
		}
		
		// 5. @Auth가 있는 경우이므로, 세션이 있는지 체크
		HttpSession session = request.getSession();
		if( session == null ) {
			// 로그인 화면으로 이동
			response.sendRedirect(request.getContextPath() + "/main");
			return false;
		}
		
		// 6. 세션이 존재하면 유효한 유저인지 확인
		MemberVO member = (MemberVO)session.getAttribute("member");
		if ( member == null ) {
			response.sendRedirect(request.getContextPath() + "/main");
			return false;
		}
		
		/* 
		// 7. admin일 경우
		String role = auth.role().toString();
		if( "ADMIN".equals(role) ) {
			// admin임을 알 수 있는 조건을 작성한다.
			// ex) 서비스의 id가 root이면 admin이다.
			if( "root".equals(member.getUserId()) == false ){   // admin이 아니므로 return false
				response.sendRedirect(request.getContextPath());
				return false;
			}
		}
		*/
		
		return true;
	}
}