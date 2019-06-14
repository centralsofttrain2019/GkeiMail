package jp.co.central_soft.train2019.wakaba.bean;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import jp.co.central_soft.train2019.wakaba.dto.AddressTypeDto;
import jp.co.central_soft.train2019.wakaba.dto.PurposeTypeDto;

public class SelectTemplateBean {

	private Map<Integer, String> addressTypes;
	private Map<Integer, String> purposeTypes;
	private List<AddressTypeDto> addList ;
	private List<PurposeTypeDto> purList ;


	public List<AddressTypeDto> getAddList() {
		return addList;
	}
	public void setAddList(List<AddressTypeDto> addList) {
		this.addList = addList;
	}
	public List<PurposeTypeDto> getPurList() {
		return purList;
	}
	public void setPurList(List<PurposeTypeDto> purList) {
		this.purList = purList;
	}


	public SelectTemplateBean() {
		this.addressTypes = new HashMap<>();
		this.purposeTypes = new HashMap<>();
	}
	public Map<Integer, String> getAddressTypes() {
		return this.addressTypes;
	}
	public void setAddressTypes(Map<Integer, String> addressTypes) {
		this.addressTypes = new HashMap<>();
		this.addressTypes.putAll(addressTypes);
	}
	public Map<Integer, String> getPurposeTypes() {
		return this.purposeTypes;
	}
	public void setPurposeTypes(Map<Integer, String> purposeTypes) {
		this.purposeTypes = new HashMap<>();
		this.purposeTypes.putAll(purposeTypes);
	}

	public void putFromDtoToAddressTypes(AddressTypeDto dto) {
		this.addressTypes.put(dto.getAddressTypeID(), dto.getAddressTypeName());
	}
	public void putFromDtoToPurposeTypes(PurposeTypeDto dto) {
		this.purposeTypes.put(dto.getPurposeTypeID(), dto.getPurposeTypeName());
	}

}

