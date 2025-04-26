package com.media.service_impl;

import java.util.List;
import com.media.dao.*;
import com.media.dao_impl.*;
import com.media.entity.Messages;
import com.media.service.MessagesService;

public class MessagesService_impl implements MessagesService {
    MessagesDao messagesDao = new MessagesDao_impl();

    @Override
    public Messages createMessage(Messages message) {
        return messagesDao.createMessages(message);
    }

    @Override
    public List<Messages> getAllMessages() {
        return messagesDao.getAllMessages();
    }

    @Override
    public Messages getMessage(String Msg_Id) {
        return messagesDao.getMessages(Msg_Id);
    }

    @Override
    public Messages updateMessage(String Msg_Id, Messages updatedMessage) {
        return messagesDao.updateMessages(Msg_Id, updatedMessage);
    }

    @Override
    public String deleteMessage(String Msg_Id) {
        return messagesDao.deleteMessages(Msg_Id);
    }
    
    @Override
    public Messages getMessagesById(String Msg_Id) {
        return messagesDao.getMessageById(Msg_Id);
    }

    @Override
    public String sendMessages(String Sender_Id, String Receiver_Id, String Msg_txt, String Send_at, String Msg_Id) {
        messagesDao.saveMessage(Sender_Id, Receiver_Id, Msg_txt, Send_at, Msg_Id);
        return "Message sent successfully.";
    }

	
}
