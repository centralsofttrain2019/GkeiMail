package jp.co.central_soft.train2019.wakaba.bean;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import jp.co.central_soft.train2019.wakaba.dto.AddressTypeDto;
import jp.co.central_soft.train2019.wakaba.dto.PurposeTypeDto;
import jp.co.central_soft.train2019.wakaba.dto.TemplateDto;

public class DisplayTemplateListBean {

	public class TemplateData {
		private int templateID;
		private String templateName;
		private String templateContent;
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
		public String getTemplateContent() {
			return templateContent;
		}
		public void setTemplateContent(String templateContent) {
			this.templateContent = templateContent;
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
		@Override
		public String toString() {
			return "TemplateData [templateID=" + templateID + ", templateName=" + templateName + ", templateContent="
					+ templateContent + "]";
		}

	}
	private Map<Integer, String> addressTypes;
	private Map<Integer, String> purposeTypes;
	private List<AddressTypeDto> addList ;
	private List<PurposeTypeDto> purList ;
	private List<TemplateData> templates;
	private int atesaki;
	private int naiyou;
	private String keyword1;
	private int mashimashi;
	private List<String> mashiList;

	public DisplayTemplateListBean() {
		this.addressTypes = new HashMap<>();
		this.purposeTypes = new HashMap<>();
		this.templates = new ArrayList<>();
	}



	public List<String> getMashiList() {
		return mashiList;
	}



	public void setMashiList(List<String> mashiList) {
		this.mashiList = mashiList;
	}



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

	public void putFromDtoListToTemplates(List<TemplateDto> dtoList) {
		for( TemplateDto dto : dtoList ) {
			putFromDtoToTemplates(dto);
		}
	}

	public void putFromDtoToTemplates(TemplateDto dto1
//			,List<AddressTypeDto> dto2, List<PurposeTypeDto> dto3
		) {
		TemplateData template = new TemplateData();
		template.setTemplateID(dto1.getTemplateID());
		template.setTemplateName(dto1.getTemplateName());
		template.setTemplateContent(dto1.getTemplateContent());
		template.setMashiMashiValue(dto1.getMashiMashiValue());

//		template.setAddressTypeID(dto1.getAddressTypeID());
//		template.setAddressTypeName(null);
//
//		template.setPurposeTypeID(dto1.getPurposeTypeID());
//		template.setPurposeTypeName(null);

		this.templates.add(template);
	}
	@Override
	public String toString() {
		return "DisplayTemplateListBean\n"
				+"addressTypes=" + addressTypes + ", purposeTypes=" + purposeTypes
				+ "\ntemplates=" + templates.toString();
	}

}
