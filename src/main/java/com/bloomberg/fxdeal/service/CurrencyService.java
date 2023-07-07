package com.bloomberg.fxdeal.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bloomberg.fxdeal.model.ConversionCurrency;
import com.bloomberg.fxdeal.model.Currency;
import com.bloomberg.fxdeal.model.NoConstant;
import com.bloomberg.fxdeal.repo.CurrencyRepo;

@Service
public class CurrencyService {
	
	@Autowired
    private CurrencyRepo currencyRepo;

	public CurrencyService(CurrencyRepo repository) {
		// TODO Auto-generated constructor stub
		currencyRepo = repository;
	}
	
	public List<Currency> getCurrencies() {
		List<Currency> allCurrencies= currencyRepo.findAll();
		return allCurrencies;
	}
	
	public Optional<Double> convert(ConversionCurrency conversionCurrency)  {

		Optional<Currency> toValue = currencyRepo.findById(conversionCurrency.getTo().toUpperCase());
		Optional<Currency> fromValue = currencyRepo.findById(conversionCurrency.getFrom().toUpperCase());
		if(toValue.isPresent() && fromValue.isPresent()) {
			if(conversionCurrency.getValue() < NoConstant.Zero)
			{
				System.out.println("RENAD == ZERO");
				return Optional.empty();

			}
			Currency toObject = toValue.get();
			Currency fromObject = fromValue.get();
			Double toResult = toObject.getValue();
			Double fromResult = fromObject.getValue();
			Double result = (toResult * conversionCurrency.getValue())/fromResult;
			return Optional.of(result); 
		}
		
		return Optional.empty();

	}
}
