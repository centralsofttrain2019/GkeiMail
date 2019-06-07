package jp.co.central_soft.train2019.wakaba.web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jp.co.central_soft.train2019.wakaba.bean.DispTemplateBean;
import jp.co.central_soft.train2019.wakaba.domain.BuiltInTypeEnum;
import jp.co.central_soft.train2019.wakaba.dto.AddressTypeDto;
import jp.co.central_soft.train2019.wakaba.dto.PurposeTypeDto;

//テンプレート宛先とか選択する画面のやつ
@WebServlet("/DispTemplateServlet")
public class DispTemplateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(
			HttpServletRequest request,
			HttpServletResponse response)
					throws ServletException, IOException
	{
		DispTemplateBean bean = new DispTemplateBean();

		// TODO ダミーデータ
		AddressTypeDto adDto = new AddressTypeDto();
		adDto.setAddressTypeID(1);
		adDto.setAddressTypeName("上司");
		adDto.setBuiltInType(BuiltInTypeEnum.BUILTIN);
		PurposeTypeDto puDto = new PurposeTypeDto();
		puDto.setPurposeTypeID(1);
		puDto.setPurposeTypeName("感謝");
		puDto.setBuiltInType(BuiltInTypeEnum.BUILTIN);

		bean.putFromDtoToAddressTypes(adDto);
		bean.putFromDtoToPurposeTypes(puDto);

		request.setAttribute("bean", bean);
		RequestDispatcher rd = request.getRequestDispatcher("/dispTemplate.jsp");
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
