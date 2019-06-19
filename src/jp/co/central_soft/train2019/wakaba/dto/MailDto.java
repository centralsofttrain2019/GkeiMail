package jp.co.central_soft.train2019.wakaba.dto;

import java.time.LocalDateTime;
import java.util.List;

public class MailDto
{
	int mailID;
	String from;
	String to;
	String cc;
	String bcc;
	String messageID;
	String subject;
	String keywords;
	String comments;
	LocalDateTime date;
	String mimeVension;
	List<MailContentDto> contents;
	public int getMailID() {
		return this.mailID;
	}
	public void setMailID(int mailID) {
		this.mailID = mailID;
	}
	public String getFrom() {
		return this.from;
	}
	public void setFrom(String from) {
		this.from = from;
	}
	public String getTo() {
		return this.to;
	}
	public void setTo(String to) {
		this.to = to;
	}
	public String getCc() {
		return this.cc;
	}
	public void setCc(String cc) {
		this.cc = cc;
	}
	public String getBcc() {
		return this.bcc;
	}
	public void setBcc(String bcc) {
		this.bcc = bcc;
	}
	public String getMessageID() {
		return this.messageID;
	}
	public void setMessageID(String messageID) {
		this.messageID = messageID;
	}
	public String getSubject() {
		return this.subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getKeywords() {
		return this.keywords;
	}
	public void setKeywords(String keywords) {
		this.keywords = keywords;
	}
	public String getComments() {
		return this.comments;
	}
	public void setComments(String comments) {
		this.comments = comments;
	}
	public LocalDateTime getDate() {
		return this.date;
	}
	public void setDate(LocalDateTime date) {
		this.date = date;
	}
	public String getMimeVension() {
		return this.mimeVension;
	}
	public void setMimeVension(String mimeVension) {
		this.mimeVension = mimeVension;
	}
	public List<MailContentDto> getContents() {
		return this.contents;
	}
	public void setContents(List<MailContentDto> contents) {
		this.contents = contents;
	}
	public MailContentDto takeContent(int n) {
		return this.contents.get(n);
	}
	public void putContent(MailContentDto dto) {
		this.contents.add(dto);
	}
}

