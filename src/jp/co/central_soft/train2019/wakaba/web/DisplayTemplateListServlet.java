package jp.co.central_soft.train2019.wakaba.web;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jp.co.central_soft.train2019.wakaba.bean.DisplayTemplateListBean;
import jp.co.central_soft.train2019.wakaba.dto.AddressTypeDto;
import jp.co.central_soft.train2019.wakaba.dto.PurposeTypeDto;
import jp.co.central_soft.train2019.wakaba.dto.TemplateDto;
import jp.co.central_soft.train2019.wakaba.service.TemplateService;

@WebServlet("/DisplayTemplateListServlet")
public class DisplayTemplateListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(
			HttpServletRequest request,
			HttpServletResponse response)
					throws ServletException, IOException
	{
		//サービスを取得
		TemplateService tmpse = new TemplateService();
		List<TemplateDto> tmpList = null;
		DisplayTemplateListBean bean = new DisplayTemplateListBean();
		int atesaki = Integer.parseInt(request.getParameter("atesaki"));
		int naiyou = Integer.parseInt(request.getParameter("naiyou"));
		String keyword1 = request.getParameter("keyword-1");
		int mashimashi = Integer.parseInt(request.getParameter("mashimashi"));
		tmpList = tmpse.getTemplateList(
				atesaki,
				 naiyou,
				keyword1,
				mashimashi
				 );
		bean.putFromDtoListToTemplates(tmpList);
		List<AddressTypeDto> addList = tmpse.getAddressTypeList();
		List<PurposeTypeDto> purList = tmpse.getPurposeTypeList();



		bean.setAddList(addList);
		bean.setPurList(purList);

		bean.setAtesaki(atesaki);
		bean.setNaiyou(naiyou);
		bean.setKeyword1(keyword1);
		bean.setMashimashi(mashimashi);

		List<String> mashiList = new ArrayList<String>();
		mashiList.add(bean.getPurList().get(bean.getNaiyou() -1 ).getMashiMashiType().getElement1());
		mashiList.add(bean.getPurList().get(bean.getNaiyou() -1 ).getMashiMashiType().getElement2());
		mashiList.add(bean.getPurList().get(bean.getNaiyou() -1 ).getMashiMashiType().getElement3());

		bean.setMashiList(mashiList);
		System.out.print(mashiList.toString());
		request.setAttribute("bean", bean);
		if(bean.getTemplates().size() == 0)
		{
			RequestDispatcher rd = request.getRequestDispatcher("/error.jsp");
			rd.forward(request, response);
		}
		else
		{
			//JSPに遷移する
			RequestDispatcher rd = request.getRequestDispatcher("/displayTemplateList.jsp");
			rd.forward(request, response);
		}

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
