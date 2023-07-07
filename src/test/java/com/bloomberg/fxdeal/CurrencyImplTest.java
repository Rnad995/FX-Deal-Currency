package com.bloomberg.fxdeal;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import com.bloomberg.fxdeal.model.Currency;
import com.bloomberg.fxdeal.repo.CurrencyRepo;
import com.bloomberg.fxdeal.service.CurrencyService;

@SpringBootTest
public class CurrencyImplTest {
	
	@Mock
	private CurrencyRepo repository;
	
	@Autowired
	private CurrencyService subject;
	private Currency currencyJOD;
	@BeforeEach
	public void setup() {
		subject= new CurrencyService(repository);
		subject.getCurrencies();
		

		currencyJOD = new Currency();
		currencyJOD.setName("JOD");
		currencyJOD.setValue(0.71);
		
		Currency currencyYEN = new Currency();
		currencyYEN.setName("YEN");
		currencyYEN.setValue(143.06);
		
		Currency currencyQAR = new Currency();
		currencyQAR.setName("QAR");
		currencyQAR.setValue(3.64);
		
		Currency currencyUSD = new Currency();
		currencyUSD.setName("USD");
		currencyUSD.setValue(1);
		
		
	}
	@Test
	public void getAllCurrencies_test() {
		Mockito.when(repository.findAll()).thenReturn(Arrays.asList());
		List<Currency> currencies = subject.getCurrencies();
		assertTrue(currencies.isEmpty());		
	}
	
	
	
	
}
