package com.shop.site.Model;

import lombok.*;

import java.time.LocalDate;

import jakarta.persistence.*;

@ToString
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name="tbl_shopitem")
@Entity
public class Item {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Column(length=100, nullable=false)
	private String itemName;
	
	@Column(length=100, nullable=false)
	private String productType;
	
	@Column(length=100, nullable=false)
	private String shop;
	
	@Column(nullable=false)
	private int price;
	
	@Column(nullable=false)
	private LocalDate saleDate;
	
	
}
