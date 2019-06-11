package jp.co.central_soft.train2019.wakaba.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import jp.co.central_soft.train2019.wakaba.dto.AddressTypeDto;

public class AddressTypeDao
{
	private Connection con;

	public AddressTypeDao(Connection con)
	{
		// TODO 自動生成されたコンストラクター・スタブ
		this.con = con;
	}

	public List<AddressTypeDto> findAll() throws SQLException
	{
		// TODO 自動生成されたメソッド・スタブ
		return null;
	}
}
