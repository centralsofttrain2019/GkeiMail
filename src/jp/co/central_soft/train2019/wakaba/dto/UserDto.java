package jp.co.central_soft.train2019.wakaba.dto;

public class UserDto {
	private int	userID	;
	private String	firstName	;
	private String	lastName	;
	private String	gender	;
	private String	occupation	;
	private String	organization	;
	private String	depeartment	;
	private String	signature	;
	private String	mailAddress	;
	private String	mailPassword;
	private String	usercol	;
	private String	user	;

	private String	userName;		// VARCHAR(45) ,
	private String	userPassword;	// VARCHAR(45) ,

	public int getUserID() {
		return userID;
	}
	public void setUserID(int i) {
		this.userID = i;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getOccupation() {
		return occupation;
	}
	public void setOccupation(String occupation) {
		this.occupation = occupation;
	}
	public String getOrganization() {
		return organization;
	}
	public void setOrganization(String organization) {
		this.organization = organization;
	}
	public String getDepeartment() {
		return depeartment;
	}
	public void setDepeartment(String depeartment) {
		this.depeartment = depeartment;
	}
	public String getSignature() {
		return signature;
	}
	public void setSignature(String signature) {
		this.signature = signature;
	}
	public String getMailAddress() {
		return mailAddress;
	}
	public void setMailAddress(String mailAddress) {
		this.mailAddress = mailAddress;
	}
	public String getMailPassword() {
		return this.mailPassword;
	}
	public void setMailPassword(String mailPassword) {
		this.mailPassword = mailPassword;
	}
	public String getUsercol() {
		return usercol;
	}
	public void setUsercol(String usercol) {
		this.usercol = usercol;
	}
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserPassword() {
		return userPassword;
	}
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
	@Override
	public String toString() {
		return "UserDto [userID=" + userID + ", firstName=" + firstName + ", lastName=" + lastName + ", gender="
				+ gender + ", occupation=" + occupation + ", organization=" + organization + ", depeartment="
				+ depeartment + ", signature=" + signature + ", password=" + mailPassword + ", mailAddress=" + mailAddress
				+ ", usercol=" + usercol + ", user=" + user + ", userName=" + userName + ", userPassword="
				+ userPassword + "]";
	}

}
