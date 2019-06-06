package jp.co.central_soft.train2019.wakaba.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;

import jp.co.central_soft.train2019.wakaba.dao.TemplateDao;
import jp.co.central_soft.train2019.wakaba.dto.TemplateDto;

public class TemplateService
{
	public TemplateService()
	{
		// TODO 自動生成されたコンストラクター・スタブ
	}

	public List<TemplateDto> getSortedTemplateList(
			int addressTypeID, int purposeTypeID, List<String> keywords, int mashiMashiValue)
					throws ServletException
	{
		// TODO ソート済みのテンプレートリストを返すメソッドを実装する
		List<TemplateDto> list = null;

		try(Connection con = null) { // TODO nullはプレースホルダ
			TemplateDao dao = new TemplateDao(con);
			list = dao.findByAddressAndPurposeAndKeywords(addressTypeID, purposeTypeID, keywords);
		} catch(SQLException e) {
			throw new ServletException(e);
		}

		list.stream().sorted((x, y) ->
			Math.abs(x.getMashiMashiValue() - mashiMashiValue) - Math.abs(y.getMashiMashiValue() - mashiMashiValue));
		return list;
	}
}
