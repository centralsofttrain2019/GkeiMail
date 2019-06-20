package jp.co.central_soft.train2019.wakaba.service;

import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.ServletException;

import jp.co.central_soft.train2019.wakaba.dao.Dao;
import jp.co.central_soft.train2019.wakaba.dao.UserDao;
import jp.co.central_soft.train2019.wakaba.dto.UserDto;

public class UserService {

	public UserDto getUserByName(String userName, String password) throws ServletException {
		UserDto userDto;
		//UserDto userDto = new UserDto();
		//userDto.setUserID(userID);
		//userDto.setMailAddress("test@a.com");
		//userDto.setPassword("test.password");
		try(Connection con = Dao.getConnection())
		{
			UserDao dao = new UserDao(con);
			userDto = dao.getUser(userName);
		}
		catch(SQLException | ClassNotFoundException e) {
			throw new ServletException(e);
		}
		return userDto;
	}

}
