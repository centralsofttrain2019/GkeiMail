package jp.co.central_soft.train2019.wakaba.bean;

import java.time.LocalDateTime;

import jp.co.central_soft.train2019.wakaba.dto.MailContentDto;

public class DisplayMailDetailsBean {

	private String from;
	private String to;
	private String subject;
	private String comment;
	private LocalDateTime date;
	private MailContentDto contents;

	public String getFrom() {
		return from;
	}
	public void setFrom(String from) {
		this.from = from;
	}
	public String getTo() {
		return to;
	}
	public void setTo(String to) {
		this.to = to;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public LocalDateTime getDate() {
		return date;
	}
	public void setDate(LocalDateTime date) {
		this.date = date;
	}
	public MailContentDto getContents() {
		return contents;
	}
	public void setContents(MailContentDto contents) {
		this.contents = contents;
	}

}
