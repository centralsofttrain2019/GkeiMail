package jp.co.central_soft.train2019.wakaba.dto;

import java.time.LocalDateTime;

import jp.co.central_soft.train2019.wakaba.domain.BuiltInTypeEnum;

public class AddressTypeDto
{
	private int addressTypeID;
	private String addressTypeName;
	private BuiltInTypeEnum builtInType;
	private LocalDateTime createDate;
	private Integer superTypeID;
	public int getAddressTypeID() {
		return this.addressTypeID;
	}
	public void setAddressTypeID(int addressTypeID) {
		this.addressTypeID = addressTypeID;
	}
	public String getAddressTypeName() {
		return this.addressTypeName;
	}
	public void setAddressTypeName(String addressTypeName) {
		this.addressTypeName = addressTypeName;
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
	public Integer getSuperTypeID() {
		return this.superTypeID;
	}
	public void setSuperTypeID(Integer superTypeID) {
		this.superTypeID = superTypeID;
	}
}

