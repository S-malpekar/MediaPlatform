package com.media.service;

import java.util.List;
import com.media.entity.Messages;

public interface MessagesService {
	Messages createMessage(Messages message);
	List<Messages> getAllMessages();
	Messages getMessage(String Msg_Id);
	Messages updateMessage(String Msg_Id, Messages updatedMessage);
	String deleteMessage(String Msg_Id);
	Messages getMessagesById(String Msg_Id);
	String sendMessages(String Sender_Id, String Receiver_Id, String Msg_txt, String Send_at, String Msg_Id);
}
