package jp.co.central_soft.train2019.wakaba.service;

import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.ServletException;

import jp.co.central_soft.train2019.wakaba.dao.Dao;
import jp.co.central_soft.train2019.wakaba.dao.MailServerDao;
import jp.co.central_soft.train2019.wakaba.dto.MailServerDto;

public class MailService
{
	public void sendMail(int id) throws ServletException
	{
		MailServerDto serverDto = this.getServerInformation(id);

	}

	public MailServerDto getServerInformation(int id) throws ServletException
	{
		MailServerDto serverDto = null;
		try( Connection con = Dao.getConnection() ){
			MailServerDao dao = new MailServerDao(con);
			serverDto = dao.getSMTPInformation(id);
		} catch ( ClassNotFoundException|SQLException e) {
			e.printStackTrace();
			throw new ServletException(e);
		}
		System.out.println(serverDto.getPOPServer() + serverDto.getPOPPort());
		return serverDto;
	}
}
