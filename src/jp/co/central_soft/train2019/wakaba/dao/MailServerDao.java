package jp.co.central_soft.train2019.wakaba.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import jp.co.central_soft.train2019.wakaba.dto.MailServerDto;

public class MailServerDao
{
	private Connection con;

	private static final String FIND_BY_KEY =
			"SELECT SMTPServer,SMTPPort "
			+ "FROM  mailserver "
			+ "WHERE ServerID = ?";

	public MailServerDao(Connection con)
	{
		this.con = con;
	}

	public MailServerDto getSMTPInformation(int id) throws SQLException
	{
		MailServerDto serverDto = new MailServerDto();

		try(PreparedStatement pstmt = this.con.prepareStatement(FIND_BY_KEY) )
		{
			pstmt.setInt(1, id);

			ResultSet rs = pstmt.executeQuery();
			if( rs.next() )
			{
				serverDto.setSMTPServer(rs.getString("SMTPServer"));
				System.out.println(serverDto.getPOPServer());
				serverDto.setSMTPPort(rs.getInt("SMTPPort"));
			}
		}
		return serverDto;
	}
}

