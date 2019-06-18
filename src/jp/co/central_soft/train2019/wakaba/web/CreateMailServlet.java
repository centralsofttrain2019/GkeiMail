package jp.co.central_soft.train2019.wakaba.web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jp.co.central_soft.train2019.wakaba.bean.CreateMailBean;
import jp.co.central_soft.train2019.wakaba.service.MailService;

@WebServlet("/CreateMailServlet")
public class CreateMailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String fromPage = request.getParameter("fromPage");
		RequestDispatcher rd = null;
		if (fromPage.equals("send")) {
			String atesaki = request.getParameter("atesaki");
			String kenmei = request.getParameter("kenmei");
			String honbun = request.getParameter("honbun");

			MailService service = new MailService();
			service.sendMail(atesaki,kenmei,honbun,1);

			rd = request.getRequestDispatcher("/DisplayMailListServlet");
		}
		else if(fromPage.equals("template")) {
			String content = request.getParameter("content");

			CreateMailBean bean = new CreateMailBean();
			bean.setContent(content);

			request.setAttribute("bean", bean);
			rd = request.getRequestDispatcher("/createMail.jsp");
		}
		rd.forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
