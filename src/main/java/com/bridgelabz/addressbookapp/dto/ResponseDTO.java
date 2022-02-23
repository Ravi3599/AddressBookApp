package com.bridgelabz.addressbookapp.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

//Created ResponseDTO class so we can get output in format of message with data
@Data
public class ResponseDTO {
	private String message;
	private Object data;
	public ResponseDTO(String message, Object data) {
		super();
		this.message = message;
		this.data = data;
	}
}