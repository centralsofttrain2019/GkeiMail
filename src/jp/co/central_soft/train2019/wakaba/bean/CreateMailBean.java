package jp.co.central_soft.train2019.wakaba.bean;

public class CreateMailBean {

	private String content;
	private String templateBottonLabel = "テンプレート選択";
	private boolean flag = false;

	public boolean isFlag() {
		return flag;
	}

	public void setFlag(boolean flag) {
		this.flag = flag;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getTemplateBottonLabel() {
		return templateBottonLabel;
	}

	public void setTemplateBottonLabel(String templateBottonLabel) {
		this.templateBottonLabel = templateBottonLabel;
	}



}
