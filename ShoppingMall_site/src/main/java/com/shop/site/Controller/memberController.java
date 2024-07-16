package com.shop.site.Controller;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.shop.site.Model.Item;
import com.shop.site.Model.Member;
import com.shop.site.Repository.ItemRepository;
import com.shop.site.Repository.MemberRepository;
import com.shop.site.Service.LoginClass;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
public class memberController {
	@Autowired
	private MemberRepository memberRepository;
	
	@Autowired
	private ItemRepository itemRepository;
	
	LoginClass LC=new LoginClass();
	
	@RequestMapping(value="/updatePage", method=RequestMethod.GET)
	public String updatePage(HttpServletRequest request, HttpSession session) {
		String loggedState=(String)session.getAttribute("loggedstate");
		if(loggedState==null || loggedState.isEmpty()) {
			return "redirect:/";
		}
		
		String userId=request.getParameter("userId");
		
		Member loggedMember=memberRepository.findByUserId(userId);
		
		request.setAttribute("currentUserId", loggedMember.getUserId());
		request.setAttribute("currentName", loggedMember.getName());
		request.setAttribute("currentAge", loggedMember.getAge());
		request.setAttribute("currentAddress", loggedMember.getAddress());
		request.setAttribute("currentPhone", loggedMember.getPhone());
		
		return "updatePage";
	}
	
	@RequestMapping(value="/updateMember", method=RequestMethod.GET)
	public String updateMember(HttpServletRequest request) {
		String userId=request.getParameter("userId");
		String modname=request.getParameter("modname");
		String modAge=request.getParameter("modage");
		int modage=0;
		if(modAge!=null) {
			modage=Integer.parseInt(modAge);
		}
		String modaddress=request.getParameter("modaddress");
		String modphone=request.getParameter("modphone");
		
		Member loggedMember=memberRepository.findByUserId(userId);
		
		Member member=Member.builder()
				.listNumber(loggedMember.getListNumber())
				.userId(loggedMember.getUserId())
				.password(loggedMember.getPassword())
				.name(modname)
				.age(modage)
				.address(modaddress)
				.phone(modphone)
				.build();
		memberRepository.save(member);
		
		request.setAttribute("currentUserId", loggedMember.getUserId());
		request.setAttribute("currentName", loggedMember.getName());
		request.setAttribute("currentAge", loggedMember.getAge());
		request.setAttribute("currentAddress", loggedMember.getAddress());
		request.setAttribute("currentPhone", loggedMember.getPhone());
		
		return "loginSuccess";
	}
	
	@RequestMapping(value="/findPage", method=RequestMethod.GET)
	public String findPage(HttpServletRequest request) {
		return "findPassword";
	}
	
	@RequestMapping(value="/findPassword", method=RequestMethod.POST)
	public String findPassword(HttpServletRequest request) {
		String name=request.getParameter("name");
		String phone=request.getParameter("phone");
		
		Member loggedMember=memberRepository.findByNameAndPhone(name, phone);
		
		if(loggedMember!=null) {
			request.setAttribute("currentUserId", loggedMember.getUserId());
			return "resetPassword";
		}
		else {
			System.out.println("존재하지 않는 회원입니다.");
			return "redirtect:/";
		}
	}
	
	@RequestMapping(value="/resetPassword", method=RequestMethod.POST)
	public String resetPassword(HttpServletRequest request) {
		String userId=request.getParameter("userId");
		String repwd=request.getParameter("repassword");
		
		Member loggedMember=memberRepository.findByUserId(userId);
		
		loggedMember.setPassword(repwd);
		memberRepository.save(loggedMember);
		
		return "redirect:/";
	}	
	
	@RequestMapping(value="/deleteMember", method=RequestMethod.GET)
	public String deletePersonalInfo(HttpServletRequest request, HttpSession session) {
		String loggedState=(String)session.getAttribute("loggedstate");
		if(loggedState==null || loggedState.isEmpty()) {
			return "redirect:/";
		}
		
		String userId=request.getParameter("userId");
		
		Member loggedMember=memberRepository.findByUserId(userId);
		
		if(LC.login(memberRepository, loggedMember.getUserId(), loggedMember.getPassword())==true) {
			memberRepository.deleteByUserId(loggedMember.getUserId());
			return "deleteMember";
		}
		else {
			return "loginSuccess";
		}
	}

}
