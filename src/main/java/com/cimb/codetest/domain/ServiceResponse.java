package com.cimb.codetest.domain;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Setter @Getter
@JsonIgnoreProperties(ignoreUnknown = true)
public class ServiceResponse {
	private int resCode;
	private String resMsg;
	private List<Payload> payload;
}
