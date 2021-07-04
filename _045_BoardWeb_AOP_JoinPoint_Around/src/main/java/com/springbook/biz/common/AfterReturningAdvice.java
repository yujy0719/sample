package com.springbook.biz.common;

import org.aspectj.lang.JoinPoint;

import com.springbook.biz.user.UserVO;

public class AfterReturningAdvice {
	public void afterLog(JoinPoint jp, Object returnObj) {
		String method = jp.getSignature().getName();
		
		/* BoardVO 객체는 처리하지 않고
		 * UserVO 객체일 때는 아래처럼 처리한다
		 * */
		if(returnObj instanceof UserVO) {
			UserVO user = (UserVO)returnObj;
			if(user.getRole().equals("Admin")) {
				System.out.println(user.getName() + " 로그인(Admin)");
			}
		}
		
		// 연결된 모든 메서드의 정보를 출력해준다
		System.out.println("[사후 처리] " + method + 
				"() 메서드 리턴값 : " + returnObj.toString());
		
		//System.out.println("[사후 처리] 비즈니스 로직 수행 후 동작");
	}
}
