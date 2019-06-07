package jp.co.central_soft.train2019.wakaba.dto;

import java.time.LocalDateTime;

import jp.co.central_soft.train2019.wakaba.domain.BuiltInTypeEnum;

public class PurposeTypeDto
{
	private int purposeTypeID;
	private String purposeTypeName;
	private BuiltInTypeEnum builtInType;
	// TODO マシマシタイプ
	private LocalDateTime createDate;
	private AddressTypeDto superType;
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
	public LocalDateTime getCreateDate() {
		return this.createDate;
	}
	public void setCreateDate(LocalDateTime createDate) {
		this.createDate = createDate;
	}
	public AddressTypeDto getSuperType() {
		return this.superType;
	}
	public void setSuperType(AddressTypeDto superType) {
		this.superType = superType;
	}
}

