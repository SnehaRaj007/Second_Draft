package com.love2code.springboot.crudDemo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.love2code.springboot.crudDemo.entity.Partners;

public interface PartnerRepository extends JpaRepository<Partners, Integer> {

}
