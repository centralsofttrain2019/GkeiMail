package jp.co.central_soft.train2019.wakaba.bean;

import jp.co.central_soft.train2019.wakaba.dto.TemplateDto;

public class SelectTemplateBean {

	private int atesaki;
	private int naiyou;
	private int mashimashi;

	public int getAtesaki() {
		return atesaki;
	}
	public void setAtesaki(int ate) {
		this.atesaki = ate;
	}
	public int getNaiyou() {
		return naiyou;
	}
	public void setNaiyou(int nai) {
		this.naiyou = nai;
	}
	public int getMashimashi() {
		return mashimashi;
	}
	public void setMashimashi(int mashimashi) {
		this.mashimashi = mashimashi;
	}

	public void setFromTemplateDto(TemplateDto dto) {
		// TODO 書いて
	}
}
