package com.love2code.springboot.crudDemo.service;

import java.util.Date;
import java.util.List;


import com.love2code.springboot.crudDemo.entity.FgArrivedFile;


public interface ArrivedFileResultsService {
public List<FgArrivedFile> findAll();
public FgArrivedFile findByStatus(Date date);
public List<FgArrivedFile> findByStatusBetween(Date startDate,Date endDate);
}
