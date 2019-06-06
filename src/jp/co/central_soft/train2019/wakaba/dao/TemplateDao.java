package jp.co.central_soft.train2019.wakaba.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

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
			if( true ) {
				tmpl.setTemplateID(42);
				tmpl.setTemplateName("hello");
			}
		//TODO catch
		} finally {
			if(rs!=null)
				rs.close();
		}
		return tmpl;
	}

	public TemplateDto findByAddressAndPurpose(int addressID, int purposeID)
	{
		TemplateDto tmpl = null;
		return tmpl;
	}

	public TemplateDto findFinelyByKeyword(String keyword)
	{
		TemplateDto tmpl = null;
		return tmpl;
	}

	public boolean insertTemplate()
	{
		boolean isSucceed = true;
		return isSucceed;
	}
}
