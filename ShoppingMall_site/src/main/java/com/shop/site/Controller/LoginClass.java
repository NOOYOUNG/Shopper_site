package com.shop.site.Controller;

import com.shop.site.Repository.MemberRepository;

public class LoginClass {
	private MemberRepository adminRepository;
	
	public boolean login(MemberRepository memberRepository, String userId, String password) {
		Long count=memberRepository.countByUserIdAndPassword(userId, password);
		
		if(count<=0) {
			return false;
		}
		else {
			return true;
		}
	}
	
	public boolean logout() {
		return true;
	}
}
