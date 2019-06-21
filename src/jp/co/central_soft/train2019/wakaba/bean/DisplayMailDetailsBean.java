package jp.co.central_soft.train2019.wakaba.bean;

import java.io.IOException;
import java.time.LocalDateTime;

import jp.co.central_soft.train2019.wakaba.dto.MailContentDto;

public class DisplayMailDetailsBean {

	private String from;
	private String to;
	private String subject;
	private String comment;
	private LocalDateTime date;
	private String honbun;

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

	public void setHonbun(MailContentDto contents) throws IOException {
		this.honbun = new String( contents.getContentBinary() ,"UTF-8");
	}
	public String getHonbun() {
		return this.honbun;
	}

}
