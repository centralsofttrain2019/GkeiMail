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

		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");

		String fromPage = request.getParameter("fromPage");
		RequestDispatcher rd = null;
		System.out.println(fromPage);
		if (fromPage.equals("send")) {
			String atesaki = request.getParameter("atesaki");
			String kenmei = request.getParameter("kenmei");
			String honbun = request.getParameter("honbun");

			if(kenmei.equals("") || honbun.equals("") || kenmei.equals(null) || honbun.equals(null)) {
				CreateMailBean bean = new CreateMailBean();
				bean.setFlag(true);
				request.setAttribute("bean",bean);
				rd = request.getRequestDispatcher("/createMail.jsp");
			}

			MailService service = new MailService();
			service.sendMail(atesaki,kenmei,honbun,1);

			rd = request.getRequestDispatcher("/DisplayMailListServlet?folder=INBOX");
		}
		else if(fromPage.equals("template")) {
			String content = request.getParameter("content");

			CreateMailBean bean = new CreateMailBean();
			bean.setContent(content);
			bean.setTemplateBottonLabel("テンプレート修正");

			request.setAttribute("bean", bean);
			rd = request.getRequestDispatcher("/createMail.jsp");
		}
		else {
			//3新規作成、返信、その他のときの処理
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
