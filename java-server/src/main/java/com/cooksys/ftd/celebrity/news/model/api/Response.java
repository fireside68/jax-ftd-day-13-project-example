package com.cooksys.ftd.celebrity.news.model.api;

/**
 * 
 * @author fireside68
 *
 * @param <T>
 */

public class Response<T> {
	
	/**
	 * if true, an error was encountered and no data was returned.  An optional message field is provided.
	 */
	private Boolean error;
	
	/**
	 * an optional message field
	 */
	private String message;
	
	/** 
	 * the data returned by the server; missing in event of an error
	 */
	private T data;
	public Boolean getError() {
		return error;
	}
	public void setError(Boolean error) {
		this.error = error;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public T getData() {
		return data;
	}
	public void setData(T data) {
		this.data = data;
	}

	
	
	

}
