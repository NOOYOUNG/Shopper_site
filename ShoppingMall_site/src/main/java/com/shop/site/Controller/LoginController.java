package com.shop.site.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.shop.site.Model.Member;
import com.shop.site.Repository.ItemRepository;
import com.shop.site.Repository.MemberRepository;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
public class LoginController {
	@Autowired
	private MemberRepository memberRepository;
	
	@Autowired
	private ItemRepository itemRepository;
	
	LoginClass LC=new LoginClass();
	
	@RequestMapping(value="/signUpPage", method=RequestMethod.GET)
	public String signUpPage(HttpServletRequest request) {
		return "signUp";
	}
	
	@RequestMapping(value="/signUp", method=RequestMethod.POST)
	public String signUp(HttpServletRequest request) {
		String userId=request.getParameter("userId");
		String pwd=request.getParameter("password");
		String name=request.getParameter("name");
		String Age=request.getParameter("age");
		int age=Integer.parseInt(Age);
		String address=request.getParameter("address");
		String phone=request.getParameter("phone");
		
		Member member=Member.builder()
				.userId(userId)
				.password(pwd)
				.name(name)
				.age(age)
				.address(address)
				.phone(phone)
				.build();
		memberRepository.save(member);
		
		return "completeSignUp";
	}
	
	@RequestMapping(value="/logIn", method=RequestMethod.POST)
	public String logIn(HttpServletRequest request, HttpSession session) {
		String userId=request.getParameter("userId");
		String pwd=request.getParameter("password");
		
		if(LC.login(memberRepository, userId, pwd)==true) {
			Member loggedMember=memberRepository.findByUserIdAndPassword(userId, pwd);
			
			//관리자 기능 추가-
			if(loggedMember.getUserId().contains("admin")) {
				session.setAttribute("loggedstate", loggedMember.getUserId());
				
				request.setAttribute("currentUserId", loggedMember.getUserId());
				request.setAttribute("currentName", loggedMember.getName());
				request.setAttribute("currentAge", loggedMember.getAge());
				request.setAttribute("currentAddress", loggedMember.getAddress());
				request.setAttribute("currentPhone", loggedMember.getPhone());
				
				return "adminPage";
			}
			
			session.setAttribute("loggedstate", loggedMember.getUserId());
			
			request.setAttribute("currentUserId", loggedMember.getUserId());
			request.setAttribute("currentName", loggedMember.getName());
			request.setAttribute("currentAge", loggedMember.getAge());
			request.setAttribute("currentAddress", loggedMember.getAddress());
			request.setAttribute("currentPhone", loggedMember.getPhone());
			
			return "loginSuccess";		
		}
		else {
			return "loginFail";
		}
	}
	
	@RequestMapping(value="/loginState", method=RequestMethod.GET)
	public String logInState(HttpServletRequest request, HttpSession session) {
		String loggedState=(String)session.getAttribute("loggedstate");
		if(loggedState!=null) {
			Member loggedResult=memberRepository.findByUserId(loggedState);
			
			request.setAttribute("currentUserId", loggedState);
			request.setAttribute("currentName", loggedResult.getName());
			request.setAttribute("currentAge", loggedResult.getAge());
			request.setAttribute("currentAddress", loggedResult.getAddress());
			request.setAttribute("currentPhone", loggedResult.getPhone());
			
			return "loginSuccess";
		}
		else {
			return "redirect:/";
		}	
	}
	
	@RequestMapping(value="/logout", method=RequestMethod.GET)
	public String logout(HttpServletRequest request, HttpSession session) {
		session.invalidate();
		LC.logout();
		return "logout";
	}
}
