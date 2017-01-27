/**
 * 
 */
package com.message.model;

/**
 * @author Steff
 *
 */
public class MessageModel{
	private long timestamp;
	private String message;

	/**
	 * @return the timestamp
	 */
	public long getTimestamp() {
		return timestamp;
	}

	/**
	 * @param timestamp
	 *            the timestamp to set
	 */
	public void setTimestamp(long timestamp) {
		this.timestamp = timestamp;
	}

	/**
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * @param message
	 *            the message to set
	 */
	public void setMessage(String message) {
		this.message = message;
	}

	/**
	 * @param timestamp
	 * @param message
	 */
	public MessageModel(long timestamp, String message) {
		this.timestamp = timestamp;
		this.message = message;
	}

	public MessageModel() {

	}
}
