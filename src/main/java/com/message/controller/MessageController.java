/**
 * 
 */
package com.message.controller;

import java.util.ArrayList;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.message.model.MessageModel;
import com.message.model.MessageResponse;
import com.message.service.MessageService;

/**
 * @author Steff
 *
 */
@RestController
@RequestMapping("/api/msg")
public class MessageController {

	@Autowired
	MessageService mMessageServiceImpl;

	@RequestMapping(value = "/saveprofile/{profileName}", method = RequestMethod.POST)
	public MessageResponse saveProfile(@PathParam(value = "profileName") String mName) {
		int response = mMessageServiceImpl.saveProfile(mName);
		if (response == 0) {
			return (new MessageResponse("Profile Not Saved"));
		}
		return (new MessageResponse("Profile Saved"));
	}

	@RequestMapping(value = "/savemessage/{profileName}/{message}", method = RequestMethod.POST)
	public MessageResponse saveMessage(@PathParam(value = "profileName") String profileName,@PathParam(value = "message")  String message) {
		int response = mMessageServiceImpl.saveMessage(profileName, message);
		if (response == 0) {
			return (new MessageResponse("Message not send"));
		}
		return (new MessageResponse("Message send successfully"));
	}

	@RequestMapping(value = "/getmessage/{profileName}", method = RequestMethod.GET)
	public MessageModel[] getMessage(String profileName) {
		ArrayList<MessageModel> response = mMessageServiceImpl.getMessage(profileName);
		
		MessageModel [] messageArray = (MessageModel[]) response.toArray();
		if (response.isEmpty()) {
			System.out.println("No Messages Present");
			return null;
		}
		System.out.println("Messages Present");
		return messageArray;
	}

	@RequestMapping(value = "/getprofile/{profileName}", method = RequestMethod.GET)
	public String getProfile(@PathParam (value = "profileName") String profileName){
		return mMessageServiceImpl.getProfile(profileName);
	}
}
