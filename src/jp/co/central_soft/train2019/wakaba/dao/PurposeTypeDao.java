package jp.co.central_soft.train2019.wakaba.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import jp.co.central_soft.train2019.wakaba.dto.PurposeTypeDto;

public class PurposeTypeDao
{
	private Connection con;

	public PurposeTypeDao(Connection con)
	{
		// TODO 自動生成されたコンストラクター・スタブ
		this.con = con;
	}

	public List<PurposeTypeDto> findAll() throws SQLException
	{
		// TODO 自動生成されたメソッド・スタブ
		return null;
	}
}
