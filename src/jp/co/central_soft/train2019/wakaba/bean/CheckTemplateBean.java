package jp.co.central_soft.train2019.wakaba.bean;

import java.time.LocalDateTime;

import jp.co.central_soft.train2019.wakaba.domain.BuiltInTypeEnum;

public class CheckTemplateBean {

	private int templateID;
	private String templateName;
	private String templateContent;
	private LocalDateTime createDate;
	private int mashiMashiValue;
	private BuiltInTypeEnum builtInType;
	private int addressTypeID;
	private int purposeTypeID;
	private int userID;
	private int atesaki;
	private int naiyou;
	private String keyword1;
	private int mashimashi;

	public int getTemplateID() {
		return templateID;
	}
	public void setTemplateID(int templateID) {
		this.templateID = templateID;
	}
	public String getTemplateName() {
		return templateName;
	}
	public void setTemplateName(String templateName) {
		this.templateName = templateName;
	}
	public String getTemplateContent() {
		return templateContent;
	}
	public void setTemplateContent(String templateContent) {
		this.templateContent = templateContent;
	}
	public LocalDateTime getCreateDate() {
		return createDate;
	}
	public void setCreateDate(LocalDateTime createDate) {
		this.createDate = createDate;
	}
	public int getMashiMashiValue() {
		return mashiMashiValue;
	}
	public void setMashiMashiValue(int mashiMashiValue) {
		this.mashiMashiValue = mashiMashiValue;
	}
	public BuiltInTypeEnum getBuiltInType() {
		return builtInType;
	}
	public void setBuiltInType(BuiltInTypeEnum builtInType) {
		this.builtInType = builtInType;
	}
	public int getAddressTypeID() {
		return addressTypeID;
	}
	public void setAddressTypeID(int addressTypeID) {
		this.addressTypeID = addressTypeID;
	}
	public int getPurposeTypeID() {
		return purposeTypeID;
	}
	public void setPurposeTypeID(int purposeTypeID) {
		this.purposeTypeID = purposeTypeID;
	}
	public int getUserID() {
		return userID;
	}
	public void setUserID(int userID) {
		this.userID = userID;
	}
	public int getAtesaki() {
		return atesaki;
	}
	public void setAtesaki(int atesaki) {
		this.atesaki = atesaki;
	}
	public int getNaiyou() {
		return naiyou;
	}
	public void setNaiyou(int naiyou) {
		this.naiyou = naiyou;
	}
	public String getKeyword1() {
		return keyword1;
	}
	public void setKeyword1(String keyword1) {
		this.keyword1 = keyword1;
	}
	public int getMashimashi() {
		return mashimashi;
	}
	public void setMashimashi(int mashimashi) {
		this.mashimashi = mashimashi;
	}

}
