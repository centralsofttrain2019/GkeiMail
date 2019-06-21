package jp.co.central_soft.train2019.wakaba.web;

import java.io.IOException;
import java.util.Collections;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jp.co.central_soft.train2019.wakaba.bean.DisplayMailListBean;
import jp.co.central_soft.train2019.wakaba.domain.LoginInfo;
import jp.co.central_soft.train2019.wakaba.domain.MailFolderEnum;
import jp.co.central_soft.train2019.wakaba.dto.MailDto;
import jp.co.central_soft.train2019.wakaba.service.MailService;

/**
 * Servlet implementation class DisplayMailListServlet
 */
@WebServlet("/DisplayMailListServlet")
public class DisplayMailListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public DisplayMailListServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DisplayMailListBean bean = new DisplayMailListBean();

		MailService service = new MailService();
		String boxName = request.getParameter("folder");
		MailFolderEnum folder = null;
		if(boxName==null) {
			folder = MailFolderEnum.INBOX;
		}else {
			folder = MailFolderEnum.valueOf(boxName);
		}
		// TODO ダミーのログインデータ
		LoginInfo loginInfo = (LoginInfo)request.getSession().getAttribute("LoginInfo");
//		System.out.println(loginInfo.toString());
		List<MailDto> mails = service.getMailListInFolder(loginInfo.getUserID(), folder);
		service.receiveMail(1);

		Collections.reverse(mails);
		for(MailDto mail: mails) {
			bean.putFromDtoToMail(mail);
		}
		bean.setFolder(folder);
		// System.out.println(bean.getMailInformations().get(0).getJoinedString());

		request.setAttribute("bean", bean);
		RequestDispatcher rd = request.getRequestDispatcher("/displayMailList.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
