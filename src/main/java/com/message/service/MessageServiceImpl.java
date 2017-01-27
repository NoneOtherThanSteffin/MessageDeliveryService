/**
 * 
 */
package com.message.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.message.model.MessageModel;
import com.message.repository.MessageRepository;

/**
 * @author Steff
 *
 */
@Service
public class MessageServiceImpl implements MessageService {

	@Autowired
	MessageRepository mMessageRepository;

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.message.service.MessageService#saveProfile(java.lang.String)
	 */
	@Override
	public int saveProfile(String profileName) {
		return mMessageRepository.saveProfile(profileName);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.message.service.MessageService#saveMessage(java.lang.String,
	 * java.lang.String)
	 */
	@Override
	public int saveMessage(String profileName, String message) {
		return mMessageRepository.sendMessage(profileName, message);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.message.service.MessageService#getMessage(java.lang.String)
	 */
	@Override
	public ArrayList<MessageModel> getMessage(String profileName) {
		return mMessageRepository.getMessage(profileName);
	}

	/* (non-Javadoc)
	 * @see com.message.service.MessageService#getProfile(java.lang.String)
	 */
	@Override
	public String getProfile(String profileName) {
		return mMessageRepository.getProfile(profileName);
	}
}
