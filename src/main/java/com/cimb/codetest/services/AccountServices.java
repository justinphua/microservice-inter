package com.cimb.codetest.services;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.web.client.RestTemplate;
import com.cimb.codetest.common.Constants;
import com.cimb.codetest.common.WSResponseBean;
import com.cimb.codetest.common.WebServiceUtils;
import com.cimb.codetest.domain.BankAccount;
import com.cimb.codetest.domain.Payload;
import com.cimb.codetest.domain.ServiceResponse;

public class AccountServices {

	private final String url = "http://localhost:9080/customer";
	
	public WSResponseBean getAllAccountBalance(){
		ServiceResponse serviceResponse;
		WSResponseBean res = null;
		List<Payload> newPayload;
		
		try {
			serviceResponse = getServiceRequest();
			
			if(serviceResponse.getResCode() != Constants.RES_CODE_SUCCESS ||
					serviceResponse.getPayload()== null) {
				throw new Exception(Constants.SERVICE_REQUEST_ERR_MSG);
			}
			
			newPayload = serviceResponse.getPayload().stream().map(customer -> {
				double total = 0.00;
				total = calculateTotal(customer.getBankAccount());
				customer.setTotalBalance(total);
				return customer;
			}).collect(Collectors.toList());
			
			res = WebServiceUtils.getInstance().commonSuccess(newPayload);
			
		} catch(Exception e) {
			System.out.println("AccountServices.getAllAccountBalance: Error -> " + e.getMessage());
			res = WebServiceUtils.getInstance().commonError(null, e.getMessage());
		}
		return res;
	}
	
	private double calculateTotal(List<BankAccount> accountList) {
		double totalBalance = 0.0;
		
		try {
			totalBalance = accountList.stream().map(account -> account.getAccountBalance()).reduce(0.00, Double::sum);
		} catch(Exception e) {
			System.out.println("AccountServices.calculateTotal: Error -> " + e.getMessage());
		}
		return totalBalance;
	}
	
	private ServiceResponse getServiceRequest() {
		ServiceResponse serviceResponse = null;
		RestTemplate restTemplate;
		
		try {
			restTemplate = new RestTemplate();
			serviceResponse = restTemplate.getForObject(url, ServiceResponse.class);
		} catch(Exception e) {
			System.out.println("AccountServices.getServiceRequest: Error -> " + e.getMessage());
		}
		
		return serviceResponse;
	}
 }
