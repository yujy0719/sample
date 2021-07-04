package com.springbook.biz.common;

import org.aspectj.lang.JoinPoint;

/*
AOP로 연결된 메서드의 매개변수로
JoinPoint 변수를 넣어주면
이 변수에 연결된 메서드의 정보가 담겨온다
*/
public class LogAdvice {
	public void printLog(JoinPoint jp) {
		System.out.println("[공통 로그] 비즈니스 로직 수행 전 동작");
	}
}
