package com.demo.async.AsyncDemo;

import java.util.concurrent.CompletableFuture;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.demo.async.model.EmployeeAddresses;
import com.demo.async.model.EmployeeNames;
import com.demo.async.model.EmployeePhone;

@Service
public class AsyncService {

	private static Logger log = LoggerFactory.getLogger(AsyncService.class);

	@Autowired
	private RestTemplate restTemplate;

	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}

	@Async("asyncExecutor")
	public CompletableFuture<EmployeeNames> getEmployeeName(double randomNumber) throws InterruptedException 
	{
		log.info("getEmployeeName Starts : " + randomNumber);
		EmployeeNames employeeNameData = restTemplate.getForObject("http://localhost:8082/names", EmployeeNames.class);
		/*if (randomNumber >=10 & randomNumber <15 ) {
			throw new RuntimeException("Throwing Runtime Exception in getEmployeeName" );
		}*/
		log.info("employeeNameData, {}", employeeNameData);
		Thread.sleep(1000L);	//Intentional delay
		
		log.info("getEmployeeName completed : " + randomNumber);
		return CompletableFuture.completedFuture(employeeNameData);
	}

	@Async("asyncExecutor")
	public CompletableFuture<EmployeeAddresses> getEmployeeAddress(double randomNumber) throws InterruptedException 
	{
		log.info("getEmployeeAddress Starts : "  + randomNumber);
		EmployeeAddresses employeeAddressData = restTemplate.getForObject("http://localhost:8082/addresses", EmployeeAddresses.class);
		/*if (randomNumber >=15 & randomNumber <20 ) {
			throw new RuntimeException("Throwing Runtime Exception in getEmployeeAddress" );
		}*/
		
		log.info("employeeAddressData, {}", employeeAddressData);
		Thread.sleep(6000L);	//Intentional delay
		log.info("getEmployeeAddress completed : "+ randomNumber);
		return CompletableFuture.completedFuture(employeeAddressData);
	}

	@Async("asyncExecutor")
	public CompletableFuture<EmployeePhone> getEmployeePhone(double randomNumber) throws InterruptedException 
	{
		log.info("getEmployeePhone Starts :"  + randomNumber);
		EmployeePhone employeePhoneData = restTemplate.getForObject("http://localhost:8082/phones", EmployeePhone.class);
		/*if (randomNumber >=20 & randomNumber <30 ) {
			throw new RuntimeException("Throwing Runtime Exception in getEmployeePhone" );
		}*/
		log.info("employeePhoneData, {}", employeePhoneData);
		Thread.sleep(5000L);	//Intentional delay
		log.info("getEmployeePhone completed : "+ randomNumber);
		return CompletableFuture.completedFuture(employeePhoneData);
	}

}
