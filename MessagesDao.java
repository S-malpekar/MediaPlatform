package com.media.dao;

import java.util.List;

import com.media.entity.Messages;


public interface MessagesDao {
	Messages createMessages(Messages Messages);
	List<Messages> getAllMessages();
	Messages getMessages(String Msg_Id);
	Messages updateMessages(String Msg_Id, Messages updatedMessages);
	String deleteMessages(String Msg_Id);
	void saveMessage(String message, String receiver_Id, String msg_txt, String send_at, String msg_Id);
	Messages getMessageById(String Msg_Id);
	String sendMessages(String Sender_Id, String Receiver_Id, String Msg_txt, String Send_at);
}
