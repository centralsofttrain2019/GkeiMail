package jp.co.central_soft.train2019.wakaba.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jp.co.central_soft.train2019.wakaba.bean.SelectTemplateBean;
import jp.co.central_soft.train2019.wakaba.dto.AddressTypeDto;
import jp.co.central_soft.train2019.wakaba.dto.PurposeTypeDto;
import jp.co.central_soft.train2019.wakaba.service.TemplateService;

//テンプレート宛先とか選択する画面のやつ
@WebServlet("/SelectTemplateServlet")
public class SelectTemplateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(
			HttpServletRequest request,
			HttpServletResponse response)
					throws ServletException, IOException
	{
		SelectTemplateBean bean = new SelectTemplateBean();
		TemplateService tmpService = new TemplateService();

		List<AddressTypeDto> addList = tmpService.getAddressTypeList();
		List<PurposeTypeDto> purList = tmpService.getPurposeTypeList();

		bean.setAddList(addList);
		bean.setPurList(purList);
		for(AddressTypeDto addDto : addList)
		{
			bean.putFromDtoToAddressTypes(addDto);
		}
		for(PurposeTypeDto purDto : purList)
		{
			bean.putFromDtoToPurposeTypes(purDto);
		}
//		bean.setAddressTypes(addList);
//		// TODO ダミーデータ
//		AddressTypeDto adDto = new AddressTypeDto();
//		adDto.setAddressTypeID(1);
//		adDto.setAddressTypeName("上司");
//		adDto.setBuiltInType(BuiltInTypeEnum.BUILTIN);
//
//		AddressTypeDto adDto1 = new AddressTypeDto();
//		adDto1.setAddressTypeID(2);
//		adDto1.setAddressTypeName("社内");
//		adDto1.setBuiltInType(BuiltInTypeEnum.BUILTIN);
//		PurposeTypeDto puDto = new PurposeTypeDto();
//		puDto.setPurposeTypeID(1);
//		puDto.setPurposeTypeName("感謝");
//		puDto.setBuiltInType(BuiltInTypeEnum.BUILTIN);
//		SelectTemplateBean bean = new SelectTemplateBean();
//		bean.putFromDtoToAddressTypes(adDto);
//		bean.putFromDtoToAddressTypes(adDto1);
//		bean.putFromDtoToPurposeTypes(puDto);

		request.setAttribute("bean", bean);
		RequestDispatcher rd = request.getRequestDispatcher("/selectTemplate.jsp");
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
