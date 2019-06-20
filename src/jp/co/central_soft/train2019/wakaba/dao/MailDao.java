	package jp.co.central_soft.train2019.wakaba.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import jp.co.central_soft.train2019.wakaba.domain.ContentDispositionEnum;
import jp.co.central_soft.train2019.wakaba.domain.MailFolderEnum;
import jp.co.central_soft.train2019.wakaba.dto.MailContentDto;
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
	private static final String INSERT_CONTENT =
		  "INSERT "
		+ "INTO mailcontent ("
		+ "Name, ContentType, ContentDisposition, ContentBinary, ContentID, MailID"
		+ ")"
		+ "VALUES ("
		+ "?, ?, ?, ?, ?, ?"
		+ ")";
	private static final String FIND_BY_MAILID =
			  "SELECT * "
			+ "FROM mail "
			+ "WHERE MailID = ?";
	private static final String FIND_BY_USERID_WITH_FOLDER =
		  "SELECT * "
		+ "FROM mail "
		+ "WHERE UserID = ? AND Folder = ?";
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

	public MailDto findByMailID(int mailID) throws SQLException
	{
		MailDto dto = new MailDto();;

		try(PreparedStatement pstmt = this.con.prepareStatement(FIND_BY_MAILID)) {
			pstmt.setInt(1, mailID);
			try(ResultSet rs = pstmt.executeQuery()) {
				if(rs.next()) {
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
				}
			}
		}

		List<MailContentDto> contents = new ArrayList<>();
		try(PreparedStatement pstmt = this.con.prepareStatement(FIND_CONTENT_BY_MAILID)) {
			pstmt.setInt(1, mailID);
			try(ResultSet rs = pstmt.executeQuery()) {
				while(rs.next()) {
					MailContentDto content = new MailContentDto();
					content.setMailContentID(rs.getInt("MailContentID"));
					content.setName(rs.getString("Name"));
					content.setContentType(rs.getString("ContentType"));
					content.setContentDisposition(
						ContentDispositionEnum.valueOf(rs.getString("ContentDisposition"))
					);
					content.setContentBinary(rs.getBytes("ContentBinary"));
					content.setContentID(rs.getString("ContentID"));
					content.setMailID(rs.getInt("MailID"));
					contents.add(content);
				}
			}
		}
		dto.setContents(contents);

		return dto;
	}

	public List<MailDto> findByUserID(int userID) throws SQLException
	{
		throw new UnsupportedOperationException("未実装だよ～～～ん");
		// TODO WithoutContent
		// return this.findByUserIDWithoutContent(userID);
	}

	public List<MailDto> findByUserIDInFolder(int userID, MailFolderEnum folder) throws SQLException
	{
		throw new UnsupportedOperationException("未実装だよ～～～ん");
		// TODO WithoutContent
		// return this.findByUserIDWithoutContent(userID);
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

	public List<MailDto> findByUserIDInFolderWithoutContent(int userID, MailFolderEnum folder) throws SQLException
	{
		List<MailDto> dtos = new ArrayList<>();

		try(PreparedStatement pstmt = this.con.prepareStatement(FIND_BY_USERID_WITH_FOLDER)) {
			pstmt.setInt(1, userID);
			pstmt.setString(2, folder.name());
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

	public boolean insert(MailDto dto) throws SQLException
	{
		boolean isSuccess = true;

		try(PreparedStatement pstmt = this.con.prepareStatement(INSERT)) {
			pstmt.setString(1, dto.getFrom());
			pstmt.setString(2, dto.getTo());
			pstmt.setString(3, dto.getCc());
			pstmt.setString(4, dto.getBcc());
			pstmt.setString(5, dto.getMessageID());
			pstmt.setString(6, dto.getSubject());
			pstmt.setString(7, dto.getKeywords());
			pstmt.setString(8, dto.getComments());
			pstmt.setDate(9, java.sql.Date.valueOf(dto.getDate().toLocalDate()));
			pstmt.setTime(9, java.sql.Time.valueOf(dto.getDate().toLocalTime()));
			pstmt.setString(10, dto.getMimeVersion());
			pstmt.setInt(11, dto.getUserID());
			isSuccess = isSuccess && (pstmt.executeUpdate() == 1);
		}
		for(MailContentDto content: dto.getContents()) {
			try(PreparedStatement pstmt = this.con.prepareStatement(INSERT_CONTENT)) {
				pstmt.setString(1, content.getName());
				pstmt.setString(2, content.getContentType());
				pstmt.setString(3, content.getContentDisposition().name());
				pstmt.setBytes(4, content.getContentBinary());
				pstmt.setString(5, content.getContentID());
				pstmt.setInt(6, content.getMailID());
				isSuccess = isSuccess && (pstmt.executeUpdate() == 1);
			}
		}

		return isSuccess;
	}
}

