package com.love2code.springboot.crudDemo.dao;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;


import com.love2code.springboot.crudDemo.entity.FgArrivedFile;



public interface ArrivedFileResultsRepository extends JpaRepository<FgArrivedFile, Integer> {

	Optional<FgArrivedFile> findByStatus(Date status);
	List<FgArrivedFile> findByStatusBetween(Date startstatus,Date endstatus);
	

}
