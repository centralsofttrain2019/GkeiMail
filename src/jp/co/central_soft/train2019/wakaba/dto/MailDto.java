package jp.co.central_soft.train2019.wakaba.dto;

import java.time.LocalDateTime;
import java.util.List;

import jp.co.central_soft.train2019.wakaba.domain.MailFolderEnum;

public class MailDto
{
	private int mailID;
	private String from;
	private String to;
	private String cc;
	private String bcc;
	private String messageID;
	private String subject;
	private String keywords;
	private String comments;
	private LocalDateTime date;
	private String mimeVersion;
	private int userID;
	private MailFolderEnum folder;
	private List<MailContentDto> contents;
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
	public String getMimeVersion() {
		return this.mimeVersion;
	}
	public void setMimeVersion(String mimeVersion) {
		this.mimeVersion = mimeVersion;
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
	public int getUserID() {
		return this.userID;
	}
	public void setUserID(int userID) {
		this.userID = userID;
	}
	public MailFolderEnum getFolder() {
		return this.folder;
	}
	public void setFolder(MailFolderEnum folder) {
		this.folder = folder;
	}
}

