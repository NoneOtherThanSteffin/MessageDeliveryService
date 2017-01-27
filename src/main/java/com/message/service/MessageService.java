/**
 * 
 */
package com.message.service;

import java.util.ArrayList;

import com.message.model.MessageModel;

/**
 * @author Steff
 *
 */
public interface MessageService {

	public int saveProfile(String profileName);
	public String getProfile(String profileName);
	public int saveMessage(String profileName, String message);
	public ArrayList<MessageModel> getMessage(String profileName);
}
