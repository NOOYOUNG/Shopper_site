package com.shop.site.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.shop.site.Model.Board;
import com.shop.site.Model.Item;
import com.shop.site.Model.Member;
import com.shop.site.Repository.BoardRepository;
import com.shop.site.Repository.ItemRepository;
import com.shop.site.Repository.MemberRepository;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
public class UserController {
	@Autowired
	private MemberRepository memberRepository;
	
	@Autowired
	private ItemRepository itemRepository;
	
	@Autowired
	private BoardRepository boardRepository;
	
	
	@RequestMapping(value="/searchItem", method=RequestMethod.GET)
	public String searchItem(HttpServletRequest request) {
		String searchText=request.getParameter("searchText");
		
		List<Item> itemList=itemRepository.findByItemNameContains(searchText);
		
		request.setAttribute("itemList", itemList);
		
		return "readItem";
	}
	
	@RequestMapping(value = "/askqna", method = RequestMethod.GET)
	public String askQnA(HttpServletRequest request, HttpSession session) {
		String loggedState = (String) session.getAttribute("loggedstate");
		System.out.println(loggedState);

		Member loggedmember=memberRepository.findByUserId(loggedState);
		request.setAttribute("loggedmember", loggedmember);
		
		if (loggedState != null || !loggedState.isEmpty()) {
			return "askQnA";
		} 
		else {
			Member loggedMember = memberRepository.findByUserId(loggedState);
			request.setAttribute("currentUserId", loggedMember.getUserId());
			request.setAttribute("currentName", loggedMember.getName());
			request.setAttribute("currentAge", loggedMember.getAge());
			request.setAttribute("currentAddress", loggedMember.getAddress());
			request.setAttribute("currenPhone", loggedMember.getPhone());
			return "loginSuccess";
		}
	}
	
	@RequestMapping(value="/writeqna", method=RequestMethod.POST)
	public String writeQnA(HttpServletRequest request, HttpSession session) {
		String loggedState=(String)session.getAttribute("loggedstate");
		Member loggedmember=memberRepository.findByUserId(loggedState);
		System.out.println(loggedState);
		String content=request.getParameter("content");
		
		Board board=Board.builder()
				.userId(loggedmember.getUserId())
				.password(loggedmember.getPassword())
				.content(content)
				.build();
		boardRepository.save(board);
		
		List<Board> boardList=boardRepository.findAll();
		request.setAttribute("boardList", boardList);
		
		return "askQnA";
	}
	
}
