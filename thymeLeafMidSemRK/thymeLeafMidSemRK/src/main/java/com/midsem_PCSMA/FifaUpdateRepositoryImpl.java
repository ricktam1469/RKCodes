package com.midsem_PCSMA;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.domain.Sort.Order;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

public class FifaUpdateRepositoryImpl implements FifaUpdateRepositoryCustom{

	@Autowired private MongoTemplate mongotemp;
	@Autowired FifaUpdateRepository mongofifa;
	
	public List<FifaUpdate> limitEntry( int val) {
		// TODO Auto-generated method stub
		return mongotemp.find(new Query().with(new Sort(new Order(Direction.DESC,"date"))).limit(val), FifaUpdate.class); 
		
	}
	public void deleteEntry(String date){
		System.out.println(mongofifa.findOne(date));
		mongotemp.remove(mongofifa.findBydate(date));
	}

}
