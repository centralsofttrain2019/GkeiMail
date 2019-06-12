package jp.co.central_soft.train2019.wakaba.dto;

import java.time.LocalDateTime;

import jp.co.central_soft.train2019.wakaba.domain.BuiltInTypeEnum;

public class TemplateDto {

	private int templateID;
	private String templateName;
	private String templateContent;
	private LocalDateTime createDate;
	private int mashiMashiValue;
	private BuiltInTypeEnum builtInType;
	private int addressTypeID;
	private int purposeTypeID;
	private int userID;

	public int getTemplateID() {
		return this.templateID;
	}
	public void setTemplateID(int templateID) {
		this.templateID = templateID;
	}

	public String getTemplateName() {
		return this.templateName;
	}
	public void setTemplateName(String templateName) {
		this.templateName = templateName;
	}

	public String getTemplateContent() {
		return this.templateContent;
	}
	public void setTemplateContent(String templateContent) {
		this.templateContent = templateContent;
	}

	public LocalDateTime getCreateDate() {
		return this.createDate;
	}
	public void setCreateDate(LocalDateTime createDate) {
		this.createDate = createDate;
	}

	public int getMashiMashiValue() {
		return this.mashiMashiValue;
	}
	public void setMashiMashiValue(int mashiMashiValue) {
		this.mashiMashiValue = mashiMashiValue;
	}

	public BuiltInTypeEnum getBuiltInType() {
		return this.builtInType;
	}
	public void setBuiltInType(BuiltInTypeEnum builtInType) {
		this.builtInType = builtInType;
	}

	public int getAddressTypeID() {
		return this.addressTypeID;
	}
	public void setAddressTypeID(int addressTypeID) {
		this.addressTypeID = addressTypeID;
	}

	public int getPurposeTypeID() {
		return this.purposeTypeID;
	}
	public void setPurposeTypeID(int purposeTypeID) {
		this.purposeTypeID = purposeTypeID;
	}

	public int getUserID() {
		return this.userID;
	}
	public void setUserID(int userID) {
		this.userID = userID;
	}
	@Override
	public String toString() {
		return "TemplateDto [templateID=" + templateID + ", templateName=" + templateName + ", templateContent="
				+ templateContent + ", createDate=" + createDate + ", mashiMashiValue=" + mashiMashiValue
				+ ", builtInType=" + builtInType + ", addressTypeID=" + addressTypeID + ", purposeTypeID="
				+ purposeTypeID + ", userID=" + userID + "]";
	}

}
