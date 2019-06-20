package jp.co.central_soft.train2019.wakaba.domain;

public enum MailFolderEnum
{
	INBOX("受信箱"),
	SENT("送信済み"),
	DRAFTS("下書き");
	// TRASH("ごみ箱"),

	private final String NAME;

	private MailFolderEnum(String name) {
		this.NAME = name;
	}

	@Override
	public String toString() {
		return this.NAME;
	}
}
