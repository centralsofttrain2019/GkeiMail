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
					+	"	WHERE UserName = ?";



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
				userDto.setUserID	(rs.getString("	UserID	"));
				userDto.setFirstName	(rs.getString("	FirstName	"));
				userDto.setLastName	(rs.getString("	LastName	"));
				userDto.setGender	(rs.getString("	Gender	"));
				userDto.setOccupation	(rs.getString("	Occupation	"));
				userDto.setOrganization	(rs.getString("	Organization	"));
				userDto.setDepeartment	(rs.getString("	Depeartment	"));
				userDto.setSignature	(rs.getString("	Signature	"));
				userDto.setUserName	(rs.getString("	UserName	"));
				userDto.setUserPassword	(rs.getString("	UserPassword	"));

				userDto.setMailAddress	(rs.getString("	MailAddress	"));

			}
			return userDto;
		}

	}



}
