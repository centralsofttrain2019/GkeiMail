	package jp.co.central_soft.train2019.wakaba.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import jp.co.central_soft.train2019.wakaba.dto.MailDto;

public class MailDao
{
	private Connection con;
	private static final String INSERT =
		  "INSERT "
		+ "INTO mail ("
		+ "_From, _To, Cc, Bcc, MessageID, Subject, Keywords, Comments, _Date, MimeVersion, UserID"
		+ ")"
		+ "VALUES ("
		+ "?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?"
		+ ")";
	private static final String FIND_BY_USERID =
		  "SELECT * "
		+ "FROM mail "
		+ "WHERE UserID = ?";
	private static final String FIND_CONTENT_BY_MAILID =
		  "SELECT * "
		+ "FROM mailcontent "
		+ "WHERE MailID = ?";

	public MailDao(Connection con)
	{
		this.con = con;
	}

	public List<MailDto> findByUserID(int userID) throws SQLException
	{
		// TODO ダミーデータを返却
		return this.findByUserIDWithoutContent(userID);
	}

	public List<MailDto> findByUserIDWithoutContent(int userID) throws SQLException
	{
		List<MailDto> dtos = new ArrayList<>();

		try(PreparedStatement pstmt = this.con.prepareStatement(FIND_BY_USERID)) {
			pstmt.setInt(1, userID);
			try(ResultSet rs = pstmt.executeQuery()) {
				while(rs.next()) {
					MailDto dto = new MailDto();
					dto.setFrom(rs.getString("_From"));
					dto.setTo(rs.getString("_To"));
					dto.setCc(rs.getString("Cc"));
					dto.setBcc(rs.getString("Bcc"));
					dto.setMessageID(rs.getString("MessageID"));
					dto.setSubject(rs.getString("Subject"));
					dto.setKeywords(rs.getString("Keywords"));
					dto.setComments(rs.getString("Comments"));
					dto.setDate(LocalDateTime.of(
						rs.getDate("_Date").toLocalDate(),
						rs.getTime("_Date").toLocalTime()
					));
					dto.setMimeVersion(rs.getString("MimeVersion"));
					dto.setUserID(rs.getInt("UserID"));
					dtos.add(dto);
				}
			}
		}

		return dtos;
	}
}
