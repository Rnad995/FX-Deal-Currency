package com.bloomberg.fxdeal.repo;

import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.bloomberg.fxdeal.model.Currency;


public interface CurrencyRepo extends JpaRepository<Currency, Long>{
	
	@Query("SELECT c FROM Currency c WHERE c.name = :currency")
    Optional<Currency> findById(@Param("currency") String currency);

    @Query("select id from Currency")
    List<Currency> getCurrencies();
    
  

    

	
}
