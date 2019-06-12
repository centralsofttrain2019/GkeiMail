package jp.co.central_soft.train2019.wakaba.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jp.co.central_soft.train2019.wakaba.bean.DisplayTemplateListBean;
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

		TemplateService tmpse = new TemplateService();
		List<TemplateDto> tmpList = null;
		DisplayTemplateListBean bean = new DisplayTemplateListBean();

		tmpList = tmpse.getTemplateList(
				Integer.parseInt(request.getParameter("atesaki")),
				Integer.parseInt(request.getParameter("naiyou")) ,
				request.getParameter("keyword"),
				Integer.parseInt(request.getParameter("mashimashi")) );

		// TODO ダミーデータ
//		AddressTypeDto adDto = new AddressTypeDto();
//		adDto.setAddressTypeID(1);
//		adDto.setAddressTypeName("上司");
//		adDto.setBuiltInType(BuiltInTypeEnum.BUILTIN);
//
//		PurposeTypeDto puDto = new PurposeTypeDto();
//		puDto.setPurposeTypeID(1);
//		puDto.setPurposeTypeName("感謝");
//		puDto.setBuiltInType(BuiltInTypeEnum.BUILTIN);
//
//		TemplateDto teDto1 = new TemplateDto();
//		teDto1.setTemplateID(1);
//		teDto1.setTemplateName("上司に圧倒的感謝");
//		teDto1.setTemplateContent("上司に圧倒的感謝コンテンツ");
//
//		TemplateDto teDto2 = new TemplateDto();
//		teDto2.setTemplateID(2);
//		teDto2.setTemplateName("部下と圧倒的成長");
//		teDto2.setTemplateContent("部下と圧倒的成長コンテンツ");

		bean.putFromDtoListToTemplates(tmpList);

		request.setAttribute("bean", bean);
		RequestDispatcher rd = request.getRequestDispatcher("/displayTemplateList.jsp");
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
