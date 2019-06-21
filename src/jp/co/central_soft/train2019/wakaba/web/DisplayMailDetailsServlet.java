package jp.co.central_soft.train2019.wakaba.web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jp.co.central_soft.train2019.wakaba.bean.DisplayMailDetailsBean;
import jp.co.central_soft.train2019.wakaba.dto.MailDto;
import jp.co.central_soft.train2019.wakaba.service.MailService;

//テンプレート宛先とか選択する画面のやつ
@WebServlet("/DisplayMailDetailsServlet")
public class DisplayMailDetailsServlet extends HttpServlet
{
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(
			HttpServletRequest request,
			HttpServletResponse response)
					throws ServletException, IOException
	{

		String strmailID = request.getParameter("mail-list");
		int mailID = Integer.parseInt(strmailID);

		//Service sev = new Service();
		//TemplateDto dto = sev.findTemplateByKey(1);
		DisplayMailDetailsBean bean = new DisplayMailDetailsBean();
		MailService service = new MailService();

		MailDto dto = service.getMail(mailID);

		bean.setSubject( dto.getSubject() );
		bean.setDate( dto.getDate() );
		bean.setFrom( dto.getFrom() );
		bean.setComment( dto.getComments() );

		request.setAttribute("bean", bean);
		RequestDispatcher rd = request.getRequestDispatcher("/displayMailDetails.jsp");
		rd.forward(request, response);
	}

	@Override
	protected void doPost(
			HttpServletRequest request,
			HttpServletResponse response)
					throws ServletException, IOException
	{
		doGet(request, response);
	}

}
