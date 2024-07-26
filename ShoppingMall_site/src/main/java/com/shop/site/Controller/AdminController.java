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

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
public class AdminController {
	@Autowired
	private MemberRepository memberRepository;
	
	@Autowired
	private ItemRepository itemRepository;

	
	@RequestMapping(value="/addItem", method=RequestMethod.GET)
	public String addItem(HttpServletRequest request, HttpSession session) {
		String loggedState=(String)session.getAttribute("loggedstate");	
		if (loggedState == null || loggedState.isEmpty()) {
			return "redirect:/";
		}
		return "addItem";
	}
	
	@RequestMapping(value="/insertItem", method=RequestMethod.GET)
	public String insertItem(HttpServletRequest request, HttpSession session) {
		String loggedState=(String)session.getAttribute("loggedstate");
		if (loggedState == null || loggedState.isEmpty()) {
			return "redirect:/";
		}
		
		String itemName=request.getParameter("itemName");
		String productType=request.getParameter("productType");
		String shop=request.getParameter("shop");
		String Price=request.getParameter("price");
		int price=Integer.parseInt(Price);
		String saledate=request.getParameter("saleDate");
		
		DateTimeFormatter formatter=DateTimeFormatter.ofPattern("yyyy-MM-dd");
		LocalDate saleDate=LocalDate.parse(saledate, formatter);
		
		Item item=Item.builder()
				.itemName(itemName)
				.productType(productType)
				.shop(shop)
				.price(price)
				.saleDate(saleDate)
				.build();
		itemRepository.save(item);
		
		return "adminPage";		
	}
	
	@RequestMapping(value="/readItemList", method=RequestMethod.GET)
	public String readItemList(HttpServletRequest request, HttpSession session) {
		String loggedState=(String)session.getAttribute("loggedstate");	
		if(loggedState==null || loggedState.isEmpty()) {
			return "redirect:/";
		}
		
		List<Item> itemList=itemRepository.findAll(Sort.by(Sort.Direction.DESC, "saleDate"));
		
		request.setAttribute("itemList", itemList);
		
		return "readItem";
	}
	
	@RequestMapping(value="/deleteItem", method=RequestMethod.GET)
	public String deleteItem(HttpServletRequest request, HttpSession session) {		
		String loggedState=(String)session.getAttribute("loggedstate");
		if(loggedState==null || loggedState.isEmpty()) {
			return "redirect:/";
		}
		
		String strId=request.getParameter("id");
		Long id=Long.parseLong(strId);
		itemRepository.deleteById(id);
		
		List<Item> itemList=itemRepository.findAll(Sort.by(Sort.Direction.DESC, "saleDate"));
		
		request.setAttribute("itemList", itemList);
		
		return "readItem";

	}
	
	@RequestMapping(value = "/adminPage", method = RequestMethod.GET)
	public String adminPage(HttpServletRequest request, HttpSession session) {		
		String loggedState = (String) session.getAttribute("loggedstate");
		if (loggedState == null || loggedState.isEmpty()) {
			return "redirect:/";
		}

		Member loggedMember = memberRepository.findByUserId(loggedState);

		request.setAttribute("currentUserId", loggedMember.getUserId());
		request.setAttribute("currentName", loggedMember.getName());
		request.setAttribute("currentAge", loggedMember.getAge());
		request.setAttribute("currentAddress", loggedMember.getAddress());
		request.setAttribute("currenPhone", loggedMember.getPhone());

		return "adminPage";
	}
}
