package jp.co.central_soft.train2019.wakaba.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
<<<<<<< HEAD
=======
import java.time.LocalDateTime;
import java.util.ArrayList;
>>>>>>> branch 'master' of https://github.com/centralsofttrain2019/GkeiMail
import java.util.List;

import jp.co.central_soft.train2019.wakaba.domain.BuiltInTypeEnum;
import jp.co.central_soft.train2019.wakaba.dto.TemplateDto;

public class TemplateDao {

	private Connection con;
	private static final String FIND_BY_KEY =
			"SELECT * FROM Template WHERE TemplateID = ?";

	public TemplateDao(Connection con) {
		super();
		this.con = con;
	}

	public TemplateDto findByKey(int id) throws SQLException
	{
		TemplateDto tmpl = new TemplateDto();

		PreparedStatement pstmt = con.prepareStatement(FIND_BY_KEY);
		pstmt.setInt(1, id);

		ResultSet rs = pstmt.executeQuery();

		try {
<<<<<<< HEAD
			if( true ) {
				tmpl.setTemplateID(42);
				tmpl.setTemplateName("hello");
=======
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
>>>>>>> branch 'master' of https://github.com/centralsofttrain2019/GkeiMail
			}
		//TODO catch
		} finally {
			if(rs!=null)
				rs.close();
		}
		return tmpl;
	}

	public List<TemplateDto> findByAddressAndPurposeAndKeywords(int addressID, int purposeID, List<String> keywords)
	{
<<<<<<< HEAD
		// TODO スタブ
		List<TemplateDto> tmpl = null;
		return tmpl;
=======
		List<TemplateDto> tmpList = new ArrayList<TemplateDto>();

		PreparedStatement pstmt = con.prepareStatement(FIND_BY_ADDRESS_PURPOSE);

		pstmt.setInt(1, addressID);
		pstmt.setInt(2, purposeID);

		ResultSet rs = pstmt.executeQuery();
		try
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
		finally
		{
			if(rs!=null)
				rs.close();
		}
		return tmpList;
>>>>>>> branch 'master' of https://github.com/centralsofttrain2019/GkeiMail
	}

	public boolean insert()
	{
<<<<<<< HEAD
		// TODO スタブ
		boolean isSucceed = true;
		return isSucceed;
=======
		List<TemplateDto> tmpList = new ArrayList<TemplateDto>();

		PreparedStatement pstmt = con.prepareStatement(KEYWORDS);
		ResultSet rs = pstmt.executeQuery();
		int keywordID = -1;

		try
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
		finally
		{
			if(rs!=null)
				rs.close();
		}

		PreparedStatement pstmt2 = con.prepareStatement(FIND_BY_ADDRESS_PURPOSE_KEYWORD);
		pstmt2.setInt(1, addressID);
		pstmt2.setInt(2, purposeID);
		pstmt2.setInt(3, keywordID);
		ResultSet rs2 = pstmt.executeQuery();

		try
		{
			while( rs2.next() )
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
		finally
		{
			if(rs2!=null)
				rs2.close();
		}

		return tmpList;
	}

	public boolean insert(TemplateDto tmp) throws SQLException
	{
		PreparedStatement pstmt = con.prepareStatement(INSERT);
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
>>>>>>> branch 'master' of https://github.com/centralsofttrain2019/GkeiMail
	}
}
