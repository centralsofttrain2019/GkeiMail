package jp.co.central_soft.train2019.wakaba.domain;

import jp.co.central_soft.train2019.wakaba.dto.UserDto;

public class LoginInfo
{
	private String mailAddress;
	private String mailPassword;
	private String userName;
	private int userID;

	public String getMailAddress() {
		return mailAddress;
	}

	public void setMailAddress(String mailAddress) {
		this.mailAddress = mailAddress;
	}

	public String getMailPassword() {
		return mailPassword;
	}

	public void setMailPassword(String mailPassword) {
		this.mailPassword = mailPassword;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public int getUserID() {
		//TODO ダミー
		return 1;
//		return userID;
	}

	public void setUserID(int userID) {
		this.userID = userID;
	}

	public void setValuesFromDto(UserDto dto) {
		//TODO dto作ってから！
	}
}
