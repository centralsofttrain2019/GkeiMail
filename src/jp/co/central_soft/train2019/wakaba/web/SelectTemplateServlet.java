package jp.co.central_soft.train2019.wakaba.web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jp.co.central_soft.train2019.wakaba.bean.SelectTemplateBean;
import jp.co.central_soft.train2019.wakaba.dto.TemplateDto;
import jp.co.central_soft.train2019.wakaba.service.Service;

//テンプレート宛先とか選択する画面のやつ
@WebServlet("/SelectTemplateServlet")
public class SelectTemplateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(
			HttpServletRequest request,
			HttpServletResponse response)
					throws ServletException, IOException
	{
		String ate = request.getParameter("atesaki");
		String nai = request.getParameter("naiyou");

		Service sev = new Service();
		TemplateDto dto = sev.findTemplateByKey(1);
		SelectTemplateBean bean = new SelectTemplateBean();

		bean.setAtesaki(String.valueOf(dto.getTemplateID()));
		bean.setNaiyou(dto.getTemplateName());

		request.setAttribute("bean", bean);
		RequestDispatcher rd = request.getRequestDispatcher("/adtest.jsp");
		rd.forward(request, response);
	}

	protected void doPost(
			HttpServletRequest request,
			HttpServletResponse response)
					throws ServletException, IOException
	{
		doGet(request, response);
	}

}
