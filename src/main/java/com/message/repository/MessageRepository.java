/**
 * 
 */
package com.message.repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import org.springframework.stereotype.Repository;

import com.message.model.MessageModel;

/**
 * @author Steff
 *
 */
@Repository
public class MessageRepository {
	private static Map<String, Map<Long, MessageModel>> profileMap = new HashMap<String, Map<Long, MessageModel>>();

	public int saveProfile(String profileName) {
		Map<Long, MessageModel> messageMap = new HashMap<Long, MessageModel>();
		if (profileMap.containsKey(profileName)) {
			System.out.println(profileName + " already exists");
			return 0;
		} else {
			MessageModel firstMessage = new MessageModel(System.currentTimeMillis(), profileName);
			messageMap.put(System.currentTimeMillis(), firstMessage);
			profileMap.put(profileName, messageMap);
			System.out.println(profileName + " created");
			return 1;
		}

	}
	
	public String getProfile(String profileName){
		if(profileMap.containsKey(profileName)){
			System.out.println(profileName);
			return (profileName + " Create at "+ System.currentTimeMillis());
		}
		return (profileName + " Does not exist");
	}

	public int sendMessage(String profileName, String message) {

		if (profileMap.containsKey(profileName)) {
			MessageModel newMessage = new MessageModel(System.currentTimeMillis(), message);
			Map<Long, MessageModel> putMessage = profileMap.get(profileName);
			putMessage.put(newMessage.getTimestamp(), newMessage);
			return 1;
		}
		return 0;
	}

	public ArrayList<MessageModel> getMessage(String profileName) {
		if (profileName.contains(profileName)) {
			Map<Long, MessageModel> getMessage = profileMap.get(profileName);
			ArrayList<MessageModel> messageModelArray = new ArrayList<MessageModel>();
			for (Entry<Long, MessageModel> entry : getMessage.entrySet()) {
				messageModelArray.add(entry.getValue());
			}
			return messageModelArray;
		}
		return null;
	}
}
