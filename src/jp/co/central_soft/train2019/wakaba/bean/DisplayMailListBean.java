package jp.co.central_soft.train2019.wakaba.bean;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import jp.co.central_soft.train2019.wakaba.dto.MailDto;

public class DisplayMailListBean
{
	public class MailInformation {
		int id;
		String subject;
		String from;
		private LocalDateTime date;

		public int getId() {
			return this.id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public String getSubject() {
			return this.subject;
		}
		public void setSubject(String subject) {
			this.subject = subject;
		}
		public String getFrom() {
			return this.from;
		}
		public void setFrom(String from) {
			this.from = from;
		}
		public LocalDateTime getDate() {
			return this.date;
		}
		public void setDate(LocalDateTime date) {
			this.date = date;
		}
		public String getJoinedString() {
			return this.getSubject() + " / " + this.getFrom() + " / " + this.getDate();
		}
	}
	private List<MailInformation> mailInformations = new ArrayList<>();
	public void putFromDtoToMail(MailDto dto) {
		MailInformation entry = new MailInformation();
		//
		entry.setId(dto.getId());
		entry.setSubject(dto.getSubject());
		entry.setFrom(dto.getFrom());
		entry.setDate(dto.getDate());
		this.mailInformations.add(entry);
	}
	public List<MailInformation> getMailInformations() {
		return this.mailInformations;
	}
}

