package jp.co.central_soft.train2019.wakaba.web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/CreateMailServlet")
public class CreateMailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String button = request.getParameter("button");
		if(button.equals("send")) {
			String atesaki = request.getParameter("atesaki");
			String kenmei = request.getParameter("kenmei");
			String honbun = request.getParameter("honbun");

			//MailService service = new MailService();
			//service.sendMail(atesaki,kenmei,honbun,1);

			RequestDispatcher rd = request.getRequestDispatcher("/DisplayTemplateListServlet");
			rd.forward(request, response);
		}



		RequestDispatcher rd = request.getRequestDispatcher("/createMail.jsp");
		rd.forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
