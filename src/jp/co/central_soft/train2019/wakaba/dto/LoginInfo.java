package jp.co.central_soft.train2019.wakaba.dto;

public class LoginInfo {
	private String	userID	;
	private String	firstName	;
	private String	lastName	;
	private String	gender	;
	private String	occupation	;
	private String	organization	;
	private String	depeartment	;
	private String	signature	;
	private String	password	;
	private String	mailAddress	;
	private String	usercol	;
	private String	user	;

	private String	userName;		// VARCHAR(45) ,
	private String	userPassword;	// VARCHAR(45) ,

	public String getUserID() {
		return userID;
	}
	public void setUserID(String userID) {
		this.userID = userID;
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
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getMailAddress() {
		return mailAddress;
	}
	public void setMailAddress(String mailAddress) {
		this.mailAddress = mailAddress;
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

	public void setFromDto( UserDto dto )
	{
		this.userID			=dto.getUserID();
		this.firstName		=dto.getFirstName();
		this.lastName		=dto.getLastName();
		this.gender			=dto.getGender();
		this.occupation		=dto.getOccupation();
		this.organization	=dto.getOrganization();
		this.depeartment	=dto.getDepeartment();
		this.signature		=dto.getSignature();
		this.password		=dto.getPassword();
		this.mailAddress	=dto.getMailAddress();
		this.usercol		=dto.getUsercol();
		this.user			=dto.getUser();

		this.userName 		=dto.getUserName();
		this.userPassword 	=dto.getUserPassword();

	}


}
