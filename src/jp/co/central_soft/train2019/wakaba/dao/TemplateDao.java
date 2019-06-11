package jp.co.central_soft.train2019.wakaba.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import jp.co.central_soft.train2019.wakaba.domain.BuiltInTypeEnum;
import jp.co.central_soft.train2019.wakaba.dto.TemplateDto;

public class TemplateDao {

	private Connection con;
	private static final String FIND_BY_KEY =
			"SELECT * FROM Template WHERE TemplateID = ?";

	private static final String INSERT =
			 "INSERT INTO template ("
			+"TemplateID,TemplateName,TemplateContent,CreateDate,MashiMashiValue,"
			+"BuiltInType,AddressTypeID,PurposeTypeID,UserID"
			+") VALUES ("
			+"?,?,?,?, ?,?,?,? )";

	private static final String FIND_BY_ADDRESS_PURPOSE =
			 "SELECT * FROM Template"
			+" WHERE addressID = ?"
			+" AND purposeID = ?";

	private static final String KEYWORDS =
			 "SELECT * FROM keyword";

	private static String FIND_BY_ADDRESS_PURPOSE_KEYWORD =
			 "SELECT * FROM Template"
			+" JOIN templatekeyword ON templateID"
			+" JOIN keyword ON keywordID"
			+" WHERE (addressID = ? AND purposeID = ?)"
			+" AND (keywordID = ?)";

	public TemplateDao(Connection con) {
		super();
		this.con = con;
	}

	public TemplateDto findByKey(int id) throws SQLException
	{
		TemplateDto tmpl = new TemplateDto();

		PreparedStatement pstmt = this.con.prepareStatement(FIND_BY_KEY);
		pstmt.setInt(1, id);

		try(ResultSet rs = pstmt.executeQuery()) {
			if( rs.next() ) {
				tmpl.setTemplateID(rs.getInt("templateID"));
				tmpl.setTemplateName(rs.getString("templateName"));
				tmpl.setTemplateContent(rs.getString("templateContent"));
				tmpl.setCreateDate(LocalDateTime.of
						( rs.getDate("createDate").toLocalDate(), rs.getTime("createDate").toLocalTime()) );
				tmpl.setMashiMashiValue(rs.getInt("mashimashivalue"));
				tmpl.setBuiltInType(BuiltInTypeEnum.valueOf(rs.getString("builtInType")));
				tmpl.setAddressTypeID(rs.getInt("addressTypeID"));
				tmpl.setPurposeTypeID(rs.getInt("purposeTypeID"));
				tmpl.setUserID(rs.getInt("userID"));
			}
		} catch(SQLException e) {
			throw e;
		}
		return tmpl;
	}

	public List<TemplateDto> findByAddressAndPurpose(
			int addressID, int purposeID )
					throws SQLException
	{
		List<TemplateDto> tmpList = new ArrayList<TemplateDto>();

		PreparedStatement pstmt = this.con.prepareStatement(FIND_BY_ADDRESS_PURPOSE);

		pstmt.setInt(1, addressID);
		pstmt.setInt(2, purposeID);

		try(ResultSet rs = pstmt.executeQuery())
		{
			while( rs.next() )
			{
				TemplateDto tmp = new TemplateDto();
				tmp.setTemplateID(rs.getInt("templateID"));
				tmp.setTemplateName(rs.getString("templateName"));
				tmp.setTemplateContent(rs.getString("templateContent"));
				tmp.setCreateDate(LocalDateTime.of
						( rs.getDate("createDate").toLocalDate(), rs.getTime("createDate").toLocalTime()) );
				tmp.setMashiMashiValue(rs.getInt("mashimashivalue"));
				tmp.setBuiltInType(BuiltInTypeEnum.valueOf(rs.getString("builtInType")));
				tmp.setAddressTypeID(rs.getInt("addressTypeID"));
				tmp.setPurposeTypeID(rs.getInt("purposeTypeID"));
				tmp.setUserID(rs.getInt("userID"));
				tmpList.add(tmp);
			}
		}
		catch(SQLException e)
		{
			throw e;
		}
		return tmpList;
	}

	public List<TemplateDto> findByAddressAndPurposeAndKeywords(
			int addressID, int purposeID, String keyword)
					throws SQLException
	{
		List<TemplateDto> tmpList = new ArrayList<TemplateDto>();

		PreparedStatement pstmt = this.con.prepareStatement(KEYWORDS);
		int keywordID = -1;

		try(ResultSet rs = pstmt.executeQuery())
		{
			while( rs.next() )
			{
				if( keyword.equals(rs.getString("keywordContent")) )
				{
					keywordID = rs.getInt("keywordID");
				}
			}
		}
		catch(SQLException e)
		{
			throw e;
		}

		PreparedStatement pstmt2 = this.con.prepareStatement(FIND_BY_ADDRESS_PURPOSE_KEYWORD);
		pstmt2.setInt(1, addressID);
		pstmt2.setInt(2, purposeID);
		pstmt2.setInt(3, keywordID);

		try(ResultSet rs = pstmt.executeQuery())
		{
			while( rs.next() )
			{
				TemplateDto tmp = new TemplateDto();
				tmp.setTemplateID(rs.getInt("templateID"));
				tmp.setTemplateName(rs.getString("templateName"));
				tmp.setTemplateContent(rs.getString("templateContent"));
				tmp.setCreateDate(LocalDateTime.of
						( rs.getDate("createDate").toLocalDate(), rs.getTime("createDate").toLocalTime()) );
				tmp.setMashiMashiValue(rs.getInt("mashimashivalue"));
				tmp.setBuiltInType(BuiltInTypeEnum.valueOf(rs.getString("builtInType")));
				tmp.setAddressTypeID(rs.getInt("addressTypeID"));
				tmp.setPurposeTypeID(rs.getInt("purposeTypeID"));
				tmp.setUserID(rs.getInt("userID"));
				tmpList.add(tmp);
			}
		}
		catch(SQLException e)
		{
			throw e;
		}

		return tmpList;
	}

	public boolean insert(TemplateDto tmp) throws SQLException
	{
		PreparedStatement pstmt = this.con.prepareStatement(INSERT);
		pstmt.setInt(1, tmp.getTemplateID());
		pstmt.setString(2, tmp.getTemplateName());
		pstmt.setString(3, tmp.getTemplateContent());
		pstmt.setString(4, tmp.getCreateDate().toString());
		pstmt.setInt(5, tmp.getMashiMashiValue());


		int rows = pstmt.executeUpdate(INSERT);
		if( rows == 1 ) {
			return true;
		}
		return false;
	}
}
