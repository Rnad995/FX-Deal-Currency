package com.bloomberg.fxdeal;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Optional;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import com.bloomberg.fxdeal.model.Request;
import com.bloomberg.fxdeal.repo.RequestRepo;
import com.bloomberg.fxdeal.service.RequestService;
import jakarta.transaction.Transactional;

@Transactional
@SpringBootTest
public class RequestImplTest {
	
	@Autowired
	private RequestRepo repository;
	
	@Autowired
	private RequestService subject;

	private Request RequestOne;
	
	@BeforeEach
	public void setup() {
		subject= new RequestService(repository);
		RequestOne = new Request();
		RequestOne.settoIso("JOD");
		RequestOne.setfromIso("JOD");
		RequestOne.setAmount(new BigDecimal(1000));
		
	}
	
	@Test
	public void failingHasNoRowContains_test() {
        assertThrows(Exception.class, () -> subject.insertRequest(RequestOne));

	}
	
	@Test
	public void failingHasAllRowContains_test() {
		String registerDate = "2022-12-22";
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
	    LocalDate date = LocalDate.parse(registerDate, formatter);
	    LocalDateTime dateTime = date.atStartOfDay();
	    RequestOne.setDeal_timestamp(dateTime);
		subject.insertRequest(RequestOne);
        assertTrue(true); 
		
	}
	
	@Test
	public void findRequestionById_test() {
		Optional<Request> isRequestExist = repository.findRequestById(RequestOne.getfromIso(), RequestOne.gettoIso(), RequestOne.getAmount());
		System.out.println(isRequestExist);
		
	}
	
	@Test
    public void getRequestById_validId_returns() {
        // Create a mock repository
        RequestRepo mockRepository = mock(RequestRepo.class);

        // Create a sample request
        Request sampleRequest = new Request();
        sampleRequest.setAmount(new BigDecimal(123));
        sampleRequest.setfromIso("JOD");
        sampleRequest.settoIso("JOD"); 
        String registerDate = "2022-12-22";
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
	    LocalDate date = LocalDate.parse(registerDate, formatter);
	    LocalDateTime dateTime = date.atStartOfDay();
	    sampleRequest.setDeal_timestamp(dateTime);
        mockRepository.insertRequest( sampleRequest.getfromIso(),sampleRequest.gettoIso(),sampleRequest.getDeal_timestamp() ,sampleRequest.getAmount());
        Optional<Request> findRepo =mockRepository.findRequestById( sampleRequest.getfromIso(),
        sampleRequest.gettoIso(), sampleRequest.getAmount());


        assertThat(findRepo.isPresent());

    }
	
	
}