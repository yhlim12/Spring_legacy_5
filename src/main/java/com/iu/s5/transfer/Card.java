package com.iu.s5.transfer;

import org.aspectj.lang.ProceedingJoinPoint;

public class Card {
	
	public void cardAfter() {
		System.out.println("-----------------------------");
		System.out.println("카드 결제");
	}

	public Object cardCheck(ProceedingJoinPoint join)throws Throwable{
		System.out.println("----------------------------------");
		System.out.println("카드 Check in");
		Object [] ar = join.getArgs();
		for(Object o : ar) {
			System.out.println(o.toString());
		}
		
		Object obj = join.proceed();
	
		System.out.println("카드 Check out");
		
		
		return obj;
	}
	
	
}
