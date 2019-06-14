package jp.co.central_soft.train2019.wakaba.web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jp.co.central_soft.train2019.wakaba.bean.CheckTemplateBean;

/**
 * Servlet implementation class DispTemplateServlet
 */
@WebServlet("/CheckTemplateServlet")
public class CheckTemplateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public CheckTemplateServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//int app = Integer.parseInt(request.getParameter("app"));

		//TemplateService service = new TemplateService();
		CheckTemplateBean bean = new CheckTemplateBean();
		bean.setTemplateContent(request.getParameter("app"));


		//TemplateDto dto = service.getTemplateByKey(app);
		//bean.setTemplateContent(dto.getTemplateContent());

		request.setAttribute("bean", bean);
		RequestDispatcher disp = request.getRequestDispatcher("/checkTemplate.jsp");
		disp.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
