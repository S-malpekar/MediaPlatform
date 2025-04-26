package com.media.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity

public class Messages {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Msg_Id", length = 10)
	private String Msg_Id;

	@Column(name = "Sender_Id", length = 50)
	private String Sender_Id;

	@Column(name = "Receiver_Id", length = 50)
	private String Receiver_Id;

	@Column(name = "Send_at", length = 10)
	private String send_at;

	@Column(name = "Msg_txt", length = 300)
	private String msg_txt;

	@ManyToOne
	@JoinColumn(name = "sender_id")
	private User email;

	@ManyToOne
	@JoinColumn(name = "receiver_id")
	private User email1;



	public String getMsg_Id() {
		return Msg_Id;
	}

	public void setMsg_Id(String msg_Id) {
		Msg_Id = msg_Id;
	}

	public String getSender_Id() {
		return Sender_Id;
	}

	public void setSender_Id(String sender_Id) {
		Sender_Id = sender_Id;
	}

	public String getReceiver_Id() {
		return Receiver_Id;
	}

	public void setReceiver_Id(String receiver_Id) {
		Receiver_Id = receiver_Id;
	}

	public String getSend_at() {
		return send_at;
	}

	public void setSend_at(String send_at) {
		this.send_at = send_at;
	}

	public String getMsg_txt() {
		return msg_txt;
	}

	public void setMsg_txt(String msg_txt) {
		this.msg_txt = msg_txt;
	}

	public User getSender() {
		return email;
	}

	public void setSender(User sender) {
		this.email = sender;
	}

	public User getReceiver() {
		return email1;
	}

	public void setReceiver(User receiver) {
		this.email1 = receiver;
	}

	
	
	public Messages(String msg_Id, String sender_Id, String receiver_Id, String msg_txt, String send_at) {
		super();
		Msg_Id = msg_Id;
		Sender_Id = sender_Id;
		Receiver_Id = receiver_Id;
		this.msg_txt = msg_txt;
		this.send_at = send_at;
	}




	public Messages() {
		super();
		// TODO Auto-generated constructor stub
	}




	@Override
	public String toString() {
		return "Messages [Msg_Id=" + Msg_Id + ", Sender_Id=" + Sender_Id + ", Receiver_Id=" + Receiver_Id + ", msg_txt=" + msg_txt + ", send_at="
				+ send_at+" ]";
	}
}
