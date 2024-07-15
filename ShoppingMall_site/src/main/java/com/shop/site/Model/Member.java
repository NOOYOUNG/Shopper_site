package com.shop.site.Model;

import lombok.*;
import jakarta.persistence.*;

@ToString
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name="tbl_admin")
@Entity

public class Member {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long listNumber;
	
	@Column(length=50, nullable=false)
	private String userId;
	
	@Column(length=50, nullable=false)
	private String password;
	
	@Column(length=50, nullable=false)
	private String name;
	
	@Column(nullable=false)
	private int age;
	
	@Column(length=200, nullable=false)
	private String address;
	
	@Column(length=50, nullable=false)
	private String phone;

}
