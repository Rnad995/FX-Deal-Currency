package com.bloomberg.fxdeal.service;

import java.util.Optional;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.bloomberg.fxdeal.model.Request;
import com.bloomberg.fxdeal.repo.RequestRepo;

@Service
public class RequestService{
	private static final Logger logger = Logger.getLogger(RequestService.class.getName());

	@Autowired
    private RequestRepo requestRepo;
	
	public RequestService(RequestRepo repository) {
		requestRepo = repository;
	}

	public ResponseEntity<String> checkIfRequestExist(Request newRequest) {
		Optional<Request> isRequestExist = requestRepo.findRequestById(newRequest.getfromIso(), newRequest.gettoIso(), newRequest.getAmount());
		if (isRequestExist.isPresent()) {
			logger.info("Request already exists");
			logger.info(isRequestExist + " test");

		    return ResponseEntity.status(HttpStatus.CONFLICT).body("Request already exists"); 
		}
		return null;
		
	}
	public void insertRequest(Request newRequest) {
		logger.info("Starting Insert request to the database");

		requestRepo.insertRequest(newRequest.getfromIso(), newRequest.gettoIso()
				, newRequest.getDeal_timestamp(), newRequest.getAmount());
		
	}
}
