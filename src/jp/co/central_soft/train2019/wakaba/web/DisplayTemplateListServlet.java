package jp.co.central_soft.train2019.wakaba.web;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jp.co.central_soft.train2019.wakaba.bean.DisplayTemplateListBean;
import jp.co.central_soft.train2019.wakaba.domain.BuiltInTypeEnum;
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

		TemplateService tmpse = new TemplateService();
		

		// TODO ダミーデータ

		AddressTypeDto adDto = new AddressTypeDto();
		adDto.setAddressTypeID(1);
		adDto.setAddressTypeName("上司");
		adDto.setBuiltInType(BuiltInTypeEnum.BUILTIN);

		PurposeTypeDto puDto = new PurposeTypeDto();
		puDto.setPurposeTypeID(1);
		puDto.setPurposeTypeName("感謝");
		puDto.setBuiltInType(BuiltInTypeEnum.BUILTIN);

		DisplayTemplateListBean bean = new DisplayTemplateListBean();
		bean.putFromDtoToAddressTypes(adDto);
		bean.putFromDtoToPurposeTypes(puDto);

		TemplateDto teDto = new TemplateDto();
		teDto.setTemplateID(1);
		teDto.setTemplateName("上司に圧倒的感謝");

		bean.putFromDtoToTemplates(teDto, new ArrayList<>(), new ArrayList<>());

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