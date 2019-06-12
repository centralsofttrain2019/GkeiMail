package jp.co.central_soft.train2019.wakaba.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import jp.co.central_soft.train2019.wakaba.dto.AddressTypeDto;

public class AddressTypeDao
{
	private Connection con;

	private static final String FIND_ALL =
			"SELECT * FROM AddressType";

	public AddressTypeDao(Connection con)
	{
		this.con = con;
	}

	public List<AddressTypeDto> findAll() throws SQLException
	{
		List<AddressTypeDto> adrList = new ArrayList<AddressTypeDto>();
		PreparedStatement ps = this.con.prepareStatement(FIND_ALL);

		try (ResultSet rs = ps.executeQuery())
		{
			while(rs.next())
			{
				AddressTypeDto adr = new AddressTypeDto();
				adr.setAddressTypeID(rs.getInt("AddressTypeID"));
				adr.setAddressTypeName(rs.getString("AddressTypeName"));
//				adr.setBuiltInType( BuiltInTypeEnum.valueOf( rs.getString("BuiltInType") ));
				adr.setCreateDate( LocalDateTime.of(
						rs.getDate("createDate").toLocalDate(),
						rs.getTime("createDate").toLocalTime()
						));
				adr.setSuperTypeID(rs.getInt("SuperTypeID"));
				adrList.add(adr);
			}
		}
		catch (SQLException e)
		{
			throw e;
		}
		return adrList;
	}
}
