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

		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");

		//TemplateService service = new TemplateService();
		CheckTemplateBean bean = new CheckTemplateBean();
		bean.setAtesaki( Integer.parseInt( request.getParameter("atesaki") ));
		bean.setNaiyou( Integer.parseInt( request.getParameter("naiyou") ));
		bean.setKeyword1( request.getParameter("keyword-1"));
		bean.setMashimashi( Integer.parseInt(request.getParameter("mashimashi")));

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
