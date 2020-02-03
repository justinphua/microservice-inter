package com.cimb.codetest.domain;

import lombok.Getter;
import lombok.Setter;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Setter @Getter
@JsonIgnoreProperties(ignoreUnknown = true)
public class BankAccount {
	private String accountNumber;
    private double accountBalance;
}
