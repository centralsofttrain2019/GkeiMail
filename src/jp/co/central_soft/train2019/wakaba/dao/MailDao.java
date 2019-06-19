package jp.co.central_soft.train2019.wakaba.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import jp.co.central_soft.train2019.wakaba.dto.MailDto;

public class MailDao
{
	private Connection con;

	public MailDao(Connection con)
	{
		this.con = con;
	}

	public List<MailDto> findByUserID(int userID) throws SQLException
	{
		// TODO ダミーデータを返却
		return new ArrayList<MailDto>() { { add(new MailDto()); } };
	}
}
