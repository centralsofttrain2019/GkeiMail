package jp.co.central_soft.train2019.wakaba.dto;

public class MailContentDto
{
	private int mailContentID;
	private String name;
	private String contentType;
	private String contentDisposition;
	private byte[] contentBinary;
	private String contentID;
	public int getMailContentID() {
		return this.mailContentID;
	}
	public void setMailContentID(int mailContentID) {
		this.mailContentID = mailContentID;
	}
	public String getName() {
		return this.name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getContentType() {
		return this.contentType;
	}
	public void setContentType(String contentType) {
		this.contentType = contentType;
	}
	public String getContentDisposition() {
		return this.contentDisposition;
	}
	public void setContentDisposition(String contentDisposition) {
		this.contentDisposition = contentDisposition;
	}
	public byte[] getContentBinary() {
		return this.contentBinary;
	}
	public void setContentBinary(byte[] contentBinary) {
		this.contentBinary = contentBinary;
	}
	public String getContentID() {
		return this.contentID;
	}
	public void setContentID(String contentID) {
		this.contentID = contentID;
	}
}

