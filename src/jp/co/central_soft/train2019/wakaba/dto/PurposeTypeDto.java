package jp.co.central_soft.train2019.wakaba.dto;

import java.time.LocalDateTime;

import jp.co.central_soft.train2019.wakaba.domain.BuiltInTypeEnum;
import jp.co.central_soft.train2019.wakaba.domain.MashiMashiTypeEnum;

public class PurposeTypeDto
{
	private int purposeTypeID;
	private String purposeTypeName;
	private BuiltInTypeEnum builtInType;
	private MashiMashiTypeEnum mashiMashiType;
	private LocalDateTime createDate;
	private Integer superTypeID;
	public int getPurposeTypeID() {
		return this.purposeTypeID;
	}
	public void setPurposeTypeID(int purposeTypeID) {
		this.purposeTypeID = purposeTypeID;
	}
	public String getPurposeTypeName() {
		return this.purposeTypeName;
	}
	public void setPurposeTypeName(String purposeTypeName) {
		this.purposeTypeName = purposeTypeName;
	}
	public BuiltInTypeEnum getBuiltInType() {
		return this.builtInType;
	}
	public void setBuiltInType(BuiltInTypeEnum builtInType) {
		this.builtInType = builtInType;
	}
	public MashiMashiTypeEnum getMashiMashiType() {
		return this.mashiMashiType;
	}
	public void setMashiMashiType(MashiMashiTypeEnum mashiMashiType) {
		this.mashiMashiType = mashiMashiType;
	}
	public LocalDateTime getCreateDate() {
		return this.createDate;
	}
	public void setCreateDate(LocalDateTime createDate) {
		this.createDate = createDate;
	}
	public Integer getSuperTypeID() {
		return this.superTypeID;
	}
	public void setSuperTypeID(Integer superTypeID) {
		this.superTypeID = superTypeID;
	}
}

