package com.demo.async.AsyncDemo;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.demo.async.model.EmployeeAddresses;
import com.demo.async.model.EmployeeData;
import com.demo.async.model.EmployeeNames;
import com.demo.async.model.EmployeePhone;

@SpringBootApplication
public class AsyncDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(AsyncDemoApplication.class, args);
	}

}

@RestController
class AsyncController {

	private static Logger log = LoggerFactory.getLogger(AsyncController.class);

	@Autowired
	private AsyncService service;

	@RequestMapping(value = "/asyncCalls", method = RequestMethod.GET)
	public EmployeeData testAsynch() throws InterruptedException, ExecutionException 
	{
		double randomNumber = Math.round((Math.random() * 49 + 1)); 
		log.info("Asynch Test Start :" + randomNumber);
		CompletableFuture<EmployeeAddresses> employeeAddress = service.getEmployeeAddress( randomNumber);
		CompletableFuture<EmployeeNames> employeeName = service.getEmployeeName( randomNumber);
		CompletableFuture<EmployeePhone> employeePhone = service.getEmployeePhone( randomNumber);

		// Wait until they are all done
		CompletableFuture.allOf(employeeAddress, employeeName, employeePhone).join();
		
		log.info("EmployeeAddress--> " + employeeAddress.get());
		log.info("EmployeeName--> " + employeeName.get());
		log.info("EmployeePhone--> " + employeePhone.get());
		
		log.info("Asynch Test End :" + randomNumber);
		return new EmployeeData(employeeAddress.get(), employeeName.get(), employeePhone.get());
				
	}
}


