package jp.co.central_soft.train2019.wakaba.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import jp.co.central_soft.train2019.wakaba.domain.BuiltInTypeEnum;
import jp.co.central_soft.train2019.wakaba.domain.MashiMashiTypeEnum;
import jp.co.central_soft.train2019.wakaba.dto.PurposeTypeDto;

public class PurposeTypeDao
{
	private Connection con;

	private static final String FIND_ALL =
			"SELECT * FROM PurposeType";

	private static final String FIND_BY_KEY =
			"SELECT * "
			+ "FROM PurposeType "
			+ "WHERE PurposeTypeID = ?";

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
				pur.setMashiMashiType( MashiMashiTypeEnum.valueOf( rs.getString("MashiMashiType") ));
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

	public PurposeTypeDto findByKey(int id) throws SQLException
	{
		PurposeTypeDto purposeDto = new PurposeTypeDto();

		try(PreparedStatement pstmt = this.con.prepareStatement(FIND_BY_KEY) )
		{
			pstmt.setInt(1, id);

			ResultSet rs = pstmt.executeQuery();
			if( rs.next() )
			{
				purposeDto.setPurposeTypeName(rs.getString("PurposeTypeName"));
			}
		}
		return purposeDto;
	}
}
