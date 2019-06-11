package jp.co.central_soft.train2019.wakaba.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import jp.co.central_soft.train2019.wakaba.domain.BuiltInTypeEnum;
import jp.co.central_soft.train2019.wakaba.dto.PurposeTypeDto;

public class PurposeTypeDao
{
	private Connection con;

	private static final String FIND_ALL =
			"SELECT * FROM PurposeType";

	public PurposeTypeDao(Connection con)
	{
		this.con = con;
	}

	public List<PurposeTypeDto> findAll() throws SQLException
	{
		List<PurposeTypeDto> purList = new ArrayList<PurposeTypeDto>();
		PreparedStatement ps = this.con.prepareStatement(FIND_ALL);

		try (ResultSet rs = ps.executeQuery())
		{
			while(rs.next())
			{
				PurposeTypeDto pur = new PurposeTypeDto();
				pur.setPurposeTypeID( rs.getInt("PurposeTypeID") );
				pur.setPurposeTypeName(rs.getString("PurposeTypeName"));
				pur.setBuiltInType( BuiltInTypeEnum.valueOf( rs.getString("BuiltInType") ));
				pur.setCreateDate( LocalDateTime.of(
						rs.getDate("createDate").toLocalDate(),
						rs.getTime("createDate").toLocalTime()
						));
				pur.setSuperTypeID(rs.getInt("SuperTypeID"));
				purList.add(pur);
			}
		}
		catch (SQLException e)
		{
			throw e;
		}
		return purList;
	}
}
