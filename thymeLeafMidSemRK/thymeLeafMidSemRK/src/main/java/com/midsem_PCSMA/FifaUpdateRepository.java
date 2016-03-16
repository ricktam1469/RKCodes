package com.midsem_PCSMA;



import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;



public interface FifaUpdateRepository extends MongoRepository<FifaUpdate, String>,FifaUpdateRepositoryCustom {
	

		public FifaUpdate findBydate(String date);
		
		Page<FifaUpdate> findTop2Bydate(String date, Pageable pageable);
}
