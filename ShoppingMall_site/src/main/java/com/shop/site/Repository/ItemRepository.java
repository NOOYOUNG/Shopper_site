package com.shop.site.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.shop.site.Model.Item;

@Repository
public interface ItemRepository extends JpaRepository<Item, Long>{

	List<Item> findByItemNameContains(String searchText);

}
