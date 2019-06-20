package jp.co.central_soft.train2019.wakaba.web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jp.co.central_soft.train2019.wakaba.domain.LoginInfo;
import jp.co.central_soft.train2019.wakaba.dto.UserDto;
import jp.co.central_soft.train2019.wakaba.service.UserService;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String userName = request.getParameter("userName");
		String password = request.getParameter("password");

		UserService service = new UserService();
		UserDto dto = service.getUserByName(userName, password);

		if(dto == null)
		{
			RequestDispatcher rd = request.getRequestDispatcher("/loginError.jsp");
			rd.forward(request, response);
			return;
		}

		LoginInfo loginInfo = new LoginInfo();
		loginInfo.setValuesFromDto(dto);

		HttpSession session = request.getSession();
		session.setAttribute("LoginInfo",loginInfo);

		RequestDispatcher rd = request.getRequestDispatcher("/DisplayMailListServlet");
		rd.forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
