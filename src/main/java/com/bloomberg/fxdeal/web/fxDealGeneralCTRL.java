package com.bloomberg.fxdeal.web;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import com.bloomberg.fxdeal.model.Currency;
import com.bloomberg.fxdeal.model.Request;
import com.bloomberg.fxdeal.service.CurrencyService;
import com.bloomberg.fxdeal.service.RequestService;
import com.google.gson.Gson;
import java.util.logging.Logger;
import jakarta.transaction.Transactional;


@Transactional

@Controller
public class fxDealGeneralCTRL {	
	
	private static final Logger logger = Logger.getLogger(fxDealGeneralCTRL.class.getName());

	@Autowired
	private  CurrencyService currencyService;
	@Autowired
	private  RequestService requestService;
	Gson gson = new Gson();
	
	@GetMapping("/getAllCurrencies")
	public ResponseEntity<List<Currency>> getAllCurrencies() throws Exception {
		 return new ResponseEntity<>(currencyService.getCurrencies(), HttpStatus.OK) ;
	}
	
	@GetMapping("/home")
	public String Home() throws Exception {
		logger.info("Starting Home Page, Welcome Home :)");
		return "deal";
	}
	
	@PostMapping("/saveRequest")
	@ResponseBody
	public ResponseEntity<String> saveRequest(@RequestBody Map<String, String> requestData) {
		logger.info("Starting saveRequest Controller");
		logger.info("Get the request details from Front-end Side");

	    String amountValue = requestData.get("valueInput");
	    String selectCurrencyDealName = requestData.get("selectCurrencyDealName");
	    String selectOriginDealName = requestData.get("selectOriginDealName");
	    String RegisterDate = requestData.get("RegisterDate");
	    
	    Request newRequest = new Request();
	    newRequest.setfromIso(selectOriginDealName);
	    newRequest.settoIso(selectCurrencyDealName);
	    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
	    LocalDate date = LocalDate.parse(RegisterDate, formatter);
	    LocalDateTime dateTime = date.atStartOfDay();
	    newRequest.setDeal_timestamp(dateTime);
	    BigDecimal amount = new BigDecimal(amountValue);
	    newRequest.setAmount(amount);
	    
	    // Perform further processing or save the data to the database
	    
	    ResponseEntity<String> requestIfExist = requestService.checkIfRequestExist(newRequest) ;
	    if(requestIfExist != null) {
			logger.severe(RegisterDate);

	    	return requestIfExist;
	    }
		requestService.insertRequest(newRequest) ;
		logger.info("Save Request Successfuly In Database :) ");

	    return new ResponseEntity<String>(HttpStatus.OK);
	}

	
	
}