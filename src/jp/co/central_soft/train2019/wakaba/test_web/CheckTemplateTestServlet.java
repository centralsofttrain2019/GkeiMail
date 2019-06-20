package jp.co.central_soft.train2019.wakaba.test_web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jp.co.central_soft.train2019.wakaba.bean.CheckTemplateBean;
import jp.co.central_soft.train2019.wakaba.dto.TemplateDto;
import jp.co.central_soft.train2019.wakaba.service.TemplateService;

/**
 * Servlet implementation class CheckTemplateTestServlet
 */
@WebServlet("/CheckTemplateTestServlet")
public class CheckTemplateTestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public CheckTemplateTestServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int app = Integer.parseInt(request.getParameter("app"));

		TemplateService service = new TemplateService();
		CheckTemplateBean bean = new CheckTemplateBean();

		TemplateDto dto = service.getTemplateByKey(app);
		bean.setTemplateContent(dto.getTemplateContent());
		System.out.println("テンプレートID:" + request.getParameter("app") + "テンプレート内容：" + dto.getTemplateContent());
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
