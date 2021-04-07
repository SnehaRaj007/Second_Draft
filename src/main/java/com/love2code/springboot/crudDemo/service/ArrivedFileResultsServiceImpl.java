package com.love2code.springboot.crudDemo.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.love2code.springboot.crudDemo.dao.ArrivedFileResultsRepository;



import com.love2code.springboot.crudDemo.entity.FgArrivedFile;


@Service
public class ArrivedFileResultsServiceImpl implements ArrivedFileResultsService {
	
	private ArrivedFileResultsRepository arrivedFileResultsRepository;
	
	 
	@Autowired
	public ArrivedFileResultsServiceImpl(ArrivedFileResultsRepository arrivedFileResultsRepository) {
		this.arrivedFileResultsRepository = arrivedFileResultsRepository;
	}

	@Override
	public List<FgArrivedFile> findAll() {
		
		return arrivedFileResultsRepository.findAll();
	}

	

	@Override
	public FgArrivedFile findByStatus(Date date) {
		Optional<FgArrivedFile> result = arrivedFileResultsRepository.findByStatus(date);
		FgArrivedFile dbresult=null;
		
		if(result.isPresent())
		{
			dbresult=result.get();
		}
		else
		{
			throw new RuntimeException("Did not find dbresult for date " +date);
		}
		return dbresult;
	}

	@Override
	public List<FgArrivedFile> findByStatusBetween(Date startDate, Date endDate) {
		
		return arrivedFileResultsRepository.findByStatusBetween(startDate, endDate);
	}

	
	
	

}
