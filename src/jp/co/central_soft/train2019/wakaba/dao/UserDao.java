package jp.co.central_soft.train2019.wakaba.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import jp.co.central_soft.train2019.wakaba.dto.UserDto;

public class UserDao {
	private Connection con;

	private static final String FIND_USER =
						"	SELECT 	user	.	UserID		,	"
					+	"	    	user	.	FirstName	,	"
					+	"	    	user	.	LastName	,	"
					+	"	    	user	.	Gender		,	"
					+	"	    	user	.	Occupation	,	"
					+	"	    	user	.	Organization,	"
					+	"	    	user	.	Depeartment	,	"
					+	"	    	user	.	Signature	,	"
					+	"	    	user	.	UserName	,	"
					+	"	    	user	.	UserPassword,	"
					+	"	    	user	.	MailPassword,	"
					+	"	    	user	.	MailAddress		"
					+	"	FROM 	gkei_mail	.	user		"
					+	"	WHERE UserName = ? ";

	private static final String FIND_USER_BY_KEY =
			"	SELECT 	user	.	UserID		,	"
		+	"	    	user	.	FirstName	,	"
		+	"	    	user	.	LastName	,	"
		+	"	    	user	.	Gender		,	"
		+	"	    	user	.	Occupation	,	"
		+	"	    	user	.	Organization,	"
		+	"	    	user	.	Depeartment	,	"
		+	"	    	user	.	Signature	,	"
		+	"	    	user	.	UserName	,	"
		+	"	    	user	.	UserPassword,	"
		+	"	    	user	.	MailPassword,	"
		+	"	    	user	.	MailAddress		"
		+	"	FROM 	gkei_mail	.	user		"
		+	"	WHERE UserID = ? ";


	public UserDao(Connection con) {
		super();
		this.con = con;
	}

	public UserDto getUser(String userName) throws SQLException {
		try(PreparedStatement stm = con.prepareStatement(FIND_USER))
		{
			stm.setString(1,userName);
			ResultSet rs = stm.executeQuery();

			UserDto userDto = new UserDto();
			while(rs.next())
			{
				//System.out.println("start");
				userDto.setUserID		(rs.getInt(1));
				userDto.setFirstName	(rs.getString(2));
				userDto.setLastName		(rs.getString(3));
				userDto.setGender		(rs.getString(4));
				userDto.setOccupation	(rs.getString(5));
				userDto.setOrganization	(rs.getString(6));
				userDto.setDepeartment	(rs.getString(7));
				userDto.setSignature	(rs.getString(8));
				userDto.setUserName		(rs.getString(9));
				userDto.setUserPassword	(rs.getString(10));
				userDto.setMailPassword(rs.getString(11));
				userDto.setMailAddress	(rs.getString(12));

			}
			return userDto;
		}

	}

	public UserDto getUser(int userID) throws SQLException {
		try(PreparedStatement stm = con.prepareStatement(FIND_USER_BY_KEY))
		{
			stm.setInt(1,userID);
			ResultSet rs = stm.executeQuery();

			UserDto userDto = new UserDto();
			while(rs.next())
			{
				//System.out.println("start");
				userDto.setUserID		(rs.getInt(1));
				userDto.setFirstName	(rs.getString(2));
				userDto.setLastName		(rs.getString(3));
				userDto.setGender		(rs.getString(4));
				userDto.setOccupation	(rs.getString(5));
				userDto.setOrganization	(rs.getString(6));
				userDto.setDepeartment	(rs.getString(7));
				userDto.setSignature	(rs.getString(8));
				userDto.setUserName		(rs.getString(9));
				userDto.setUserPassword	(rs.getString(10));
				userDto.setMailPassword(rs.getString(11));
				userDto.setMailAddress	(rs.getString(12));

			}
			return userDto;
		}
	}



}
