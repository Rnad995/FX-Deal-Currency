package com.bloomberg.fxdeal.web;

import java.util.Optional;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import com.bloomberg.fxdeal.model.ConversionCurrency;
import com.bloomberg.fxdeal.service.CurrencyService;

@Controller
public class CurrencyConversionCTRL {
	private static final Logger logger = Logger.getLogger(CurrencyConversionCTRL.class.getName());

	@Autowired
	private  CurrencyService currencyService;
	
	@PostMapping("/currency-conversion")
	public ResponseEntity<Double> currencyConversion(@RequestBody
			ConversionCurrency conversionCurrency) throws Exception {
		Optional<Double> convertValue = currencyService.convert(conversionCurrency);
		if(convertValue.isPresent()) {
			logger.info("Convert Currency Convertor");

			return new ResponseEntity<Double>(convertValue.get(), HttpStatus.OK) ;
		}
		logger.info("BAD_REQUEST :(");

		return new ResponseEntity<>( HttpStatus.BAD_REQUEST) ;

	}
}
