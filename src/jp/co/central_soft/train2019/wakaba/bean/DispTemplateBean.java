package jp.co.central_soft.train2019.wakaba.bean;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import jp.co.central_soft.train2019.wakaba.dto.AddressTypeDto;
import jp.co.central_soft.train2019.wakaba.dto.PurposeTypeDto;
import jp.co.central_soft.train2019.wakaba.dto.TemplateDto;

public class DispTemplateBean {

	public class TemplateData {
		private int templateID;
		private String templateName;
		private int addressTypeID;
		private String addressTypeName;
		private int purposeTypeID;
		private String purposeTypeName;
		private int mashiMashiValue;
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
		public int getMashiMashiValue() {
			return this.mashiMashiValue;
		}
		public void setMashiMashiValue(int mashiMashiValue) {
			this.mashiMashiValue = mashiMashiValue;
		}
	}
	private Map<Integer, String> addressTypes;
	private Map<Integer, String> purposeTypes;
	private List<TemplateData> templates;

	public DispTemplateBean() {
		this.addressTypes = new HashMap<>();
		this.purposeTypes = new HashMap<>();
		this.templates = new ArrayList<>();
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

	public List<TemplateData> getTemplates() {
		return this.templates;
	}
	public void setTemplates(List<TemplateData> templates) {
		this.templates = templates;
	}
	public void putFromDtoToTemplates(TemplateDto dto1, List<AddressTypeDto> dto2, List<PurposeTypeDto> dto3) {
		// TODO 作ってない
		TemplateData template = new TemplateData();
		template.setTemplateID(dto1.getTemplateID());
		template.setTemplateName(dto1.getTemplateName());
		template.setAddressTypeID(dto1.getAddressTypeID());
		//template.setAddressTypeName();
		template.setPurposeTypeID(dto1.getPurposeTypeID());
		//template.setPurposeTypeName();
		template.setMashiMashiValue(dto1.getMashiMashiValue());
		templates.add(template);
	}

}
