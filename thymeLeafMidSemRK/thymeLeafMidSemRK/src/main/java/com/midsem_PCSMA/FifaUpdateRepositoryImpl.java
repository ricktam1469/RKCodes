package com.midsem_PCSMA;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.domain.Sort.Order;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;

public class FifaUpdateRepositoryImpl implements FifaUpdateRepositoryCustom{

	@Autowired private MongoTemplate mongotemp;
	
	public List<FifaUpdate> limit10() {
		// TODO Auto-generated method stub
		return mongotemp.find(new Query().with(new Sort(new Order(Direction.ASC,"date"))).limit(10), FifaUpdate.class); 
		
	}

}
