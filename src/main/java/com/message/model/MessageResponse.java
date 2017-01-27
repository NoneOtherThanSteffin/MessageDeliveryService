/**
 * 
 */
package com.message.model;

/**
 * @author Steff
 *
 */
public class MessageResponse {

	private String messageResponse;

	public MessageResponse() {

	}

	public MessageResponse(String messageResponse) {
		this.messageResponse = messageResponse;
	}

	/**
	 * @return the response
	 */
	public String getResponse() {
		return messageResponse;
	}

	/**
	 * @param response
	 *            the response to set
	 */
	public void setResponse(String messageResponse) {
		this.messageResponse = messageResponse;
	}

}
