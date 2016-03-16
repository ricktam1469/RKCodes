package com.midsem_PCSMA;


import org.springframework.data.mongodb.repository.MongoRepository;

public interface CricUpdateRepository extends MongoRepository<CricUpdate, String> {
		

		public CricUpdate findBydate(String date);
		
		
}
