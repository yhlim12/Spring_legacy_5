package com.iu.s5.member;

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.iu.s5.AbstractTestCase;

public class memberListTest extends AbstractTestCase {

	@Autowired
	private MemberDAO memberDAO;

	@Test
	public void memberListTest() throws Exception{
		String id="";
		String password ="";
		String name="";
		String phone="";
		String email="";
		int age =0;
		
		for(int i=0;i<150; i++) {
			MemberVO memberVO = new MemberVO();
			if(i%3==0) {
				id="iu"+i;
				password="123";
				name="iiuu"+i;
				phone="12345";
				email="123@naver.com";
				age=10;
			}else if(i%3==1) {
				id="choa"+i;
				password="44";
				name="cchhooaa"+i;
				phone="456";
				email="456@naver.com";
				age=20;
			}else {
				id="suzy"+i;
				password="789";
				name="ssuuzzyy"+i;
				phone="7890";
				email="789@naver.com";
				age=30;
			}
			memberVO.setId(id);
			memberVO.setPassword(password);
			memberVO.setName(name);
			memberVO.setPhone(phone);
			memberVO.setEmail(email);
			memberVO.setAge(age);
			memberDAO.memberJoin(memberVO);
			if(i==50||i==100) {
				Thread.sleep(1000);
			}
			
		}
		
	}
	
}
