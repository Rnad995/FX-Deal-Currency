package com.bloomberg.fxdeal.repo;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import com.bloomberg.fxdeal.model.Request;


public interface RequestRepo extends JpaRepository<Request, Long>{
	
		@Query("SELECT r FROM Request r WHERE r.fromIso = :fromIso AND  r.toIso = :toIso AND  r.amount = :amount")
	    Optional<Request> findRequestById(
	    		@Param("fromIso") String fromIso,
	 	        @Param("toIso") String toIso,
		        @Param("amount") BigDecimal amount
	    		);
		
	  	@Modifying
	    @Query("INSERT INTO Request (fromIso, toIso, date, amount) VALUES (:fromIso, :toIso, :date, :amount)")
	    void insertRequest(
	        @Param("fromIso") String fromIso,
	        @Param("toIso") String toIso,
	        @Param("date") LocalDateTime date,
	        @Param("amount") BigDecimal amount
	    );
}
