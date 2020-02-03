package com.cimb.codetest.domain;

import java.util.List;
import lombok.Getter;
import lombok.Setter;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Setter @Getter
@JsonIgnoreProperties(ignoreUnknown = true)
public class Payload {

	private String firstName;
	private String lastName;
	private String email;
	private String phoneNumber;
	private String mailingAddress1;
	private String mailingAddress2;
	private double totalBalance;
	private List<BankAccount> bankAccount;
	
}
