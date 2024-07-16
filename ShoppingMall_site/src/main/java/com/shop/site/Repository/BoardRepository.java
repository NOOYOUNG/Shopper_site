package com.shop.site.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.shop.site.Model.Board;

@Repository
public interface BoardRepository extends JpaRepository<Board, Long> {

}
