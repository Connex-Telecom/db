package com.connex.interviewdb.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.connex.interviewdb.controller.model.Item;


public interface ItemsRepository extends JpaRepository<Item, Long> {
	
}
