package com.shop.site.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.shop.site.Model.Member;

import jakarta.transaction.Transactional;

@Repository
public interface MemberRepository  extends JpaRepository<Member, Long> {
	
	Long countByUserIdAndPassword(String userId, String password);

	Member findByUserId(String userId);
	Member findByUserIdAndPassword(String userId, String password);
	Member findByNameAndPhone(String name, String phone);
	
	@Transactional
	void deleteByUserId(String userId);

}
