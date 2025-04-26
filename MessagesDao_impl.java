package com.media.dao_impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import com.media.HibernateUtil.HibernateUtil;
import com.media.dao.MessagesDao;
import com.media.entity.Messages;
import com.media.entity.User;

public class MessagesDao_impl implements MessagesDao {

	@Override
	public Messages createMessages(Messages message) {
		try (Session session = HibernateUtil.getSession()) {
			session.beginTransaction();
			session.save(message);
			session.getTransaction().commit();
			return message;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return message;
	}

	@Override
	public List<Messages> getAllMessages() {
	    List<Messages> messagesList = new ArrayList<>();
	    
	    try (Session session = HibernateUtil.getSession()) {
	        Query<Messages> query = session.createQuery("FROM Messages", Messages.class);
	        messagesList = query.list();
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    
	    return messagesList; // Return the retrieved messages (empty if none found)
	}

	@Override
	public Messages getMessages(String Msg_Id) {
		try (Session session = HibernateUtil.getSession()) {
			return session.get(Messages.class, Msg_Id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Messages updateMessages(String Msg_Id, Messages updatedMessage) {
		try (Session session = HibernateUtil.getSession()) {
			Messages message = session.get(Messages.class, Msg_Id);
			if (message != null) {
				session.beginTransaction();
				message.setSender_Id(updatedMessage.getSender_Id());
				message.setReceiver_Id(updatedMessage.getReceiver_Id());
				message.setSend_at(updatedMessage.getSend_at());
				message.setMsg_txt(updatedMessage.getMsg_txt());
				session.saveOrUpdate(message);
				session.getTransaction().commit();
			}
			return message;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return updatedMessage;
	}

	@Override
	public String deleteMessages(String Msg_Id) {
		try (Session session = HibernateUtil.getSession()) {
			Messages message = session.get(Messages.class, Msg_Id);
			if (message != null) {
				session.beginTransaction();
				session.delete(message);
				session.getTransaction().commit();
				return "Message deleted successfully";
			}
			return "Message not found";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "Error deleting message";
	}
	
	@Override
	public void saveMessage(String Sender_Id, String receiver_Id, String msg_txt, String send_at, String msg_Id) {
	    try (Session session = HibernateUtil.getSession()) {
	        session.beginTransaction();
	        session.save(Sender_Id);
	        session.getTransaction().commit();
	        System.out.println("Message saved: " + Sender_Id + receiver_Id + msg_txt + send_at + msg_Id);
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	}

	@Override
	public Messages getMessageById(String Msg_Id) { 
	    try (Session session = HibernateUtil.getSession()) {
	        Query<Messages> query = session.createQuery("FROM Messages m WHERE m.Msg_Id = :Msg_Id", Messages.class);
	        query.setParameter("msgId", Msg_Id);
	        return query.uniqueResult(); // Return a single message
	    } catch (Exception e) {
	        e.printStackTrace();
	        return null;
	    }
	}

	@Override
	public String sendMessages(String Sender_Id, String Receiver_Id, String Msg_txt, String Send_at) {
	    Transaction tx = null;

	    try (Session session = HibernateUtil.getSession()) {
	        tx = session.beginTransaction();

	        // Fetch sender and receiver Users from the database
	        User sender = session.get(User.class, Sender_Id);
	        User receiver = session.get(User.class, Receiver_Id);

	        if (sender == null || receiver == null) {
	            return "Sender or Receiver email not found!";
	        }

	        Messages msg = new Messages();
	        msg.setSender(sender);
	        msg.setReceiver(receiver);
	        msg.setMsg_txt(Msg_txt);
	        msg.setSend_at(Send_at);

	        session.save(msg);
	        tx.commit();
	        return "Message sent successfully!";
	    } catch (Exception e) {
	        if (tx != null) tx.rollback();
	        return "Failed to send message: " + e.getMessage();
	    }
	}


}


