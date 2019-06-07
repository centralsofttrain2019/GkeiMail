package jp.co.central_soft.train2019.wakaba.web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DispTemplateServlet
 */
@WebServlet("/DispTemplateServlet")
public class DispTemplateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public DispTemplateServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String atesakivalue;
		String naiyouvalue;
		String masimasivalue;
		atesakivalue = request.getParameter("atesaki");
		naiyouvalue = request.getParameter("naiyou");
		masimasivalue = request.getParameter("mashimashi");
		System.out.print(atesakivalue + naiyouvalue + masimasivalue);
		//String template = request.getParameter("template");

		//Bean bean = new Bean();
		//bean.setMsg(template);

		//beanをリクエストにセット キー名は「bean」とする
		//request.setAttribute("bean", bean);

		//JSPに遷移する
		RequestDispatcher disp = request.getRequestDispatcher("/dispTemplate.jsp");
		disp.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
