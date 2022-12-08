package com.william.restvaild.util.rest;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RestfulResponse<T> implements Serializable {

	private static final long serialVersionUID = -6022453015589774883L;
	
	private T data;
	
	public RestfulResponse(T data) {
		this.data = data;
	}
	
}
