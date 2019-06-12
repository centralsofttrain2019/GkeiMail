package jp.co.central_soft.train2019.wakaba.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import javax.servlet.ServletException;

import jp.co.central_soft.train2019.wakaba.dao.AddressTypeDao;
import jp.co.central_soft.train2019.wakaba.dao.Dao;
import jp.co.central_soft.train2019.wakaba.dao.PurposeTypeDao;
import jp.co.central_soft.train2019.wakaba.dao.TemplateDao;
import jp.co.central_soft.train2019.wakaba.dto.AddressTypeDto;
import jp.co.central_soft.train2019.wakaba.dto.PurposeTypeDto;
import jp.co.central_soft.train2019.wakaba.dto.TemplateDto;

public class TemplateService
{
	public TemplateService()
	{
	}

	private class TemplateComparator implements Comparator<TemplateDto>
	{
		private int mashiMashiValue;

		public TemplateComparator(int mashiMashiValue)
		{
			this.mashiMashiValue = mashiMashiValue;
		}

		@Override
		public int compare(TemplateDto x, TemplateDto y)
		{
			int dx = Math.abs(x.getMashiMashiValue() - this.mashiMashiValue);
			int dy = Math.abs(y.getMashiMashiValue() - this.mashiMashiValue);
			return -(dx - dy);
		}
	}

	public List<TemplateDto> getTemplateList(
			int addressTypeID, int purposeTypeID, String keyword, int mashiMashiValue)
					throws ServletException
	{
		List<TemplateDto> list = null;

		try(Connection con = Dao.getConnection()) {
			TemplateDao dao = new TemplateDao(con);
//			list = dao.findByAddressAndPurposeAndKeywords(addressTypeID, purposeTypeID, keyword);
			//TODO ダミーデータ
			list = new ArrayList<TemplateDto>();

			TemplateDto teDto1 = new TemplateDto();
			teDto1.setTemplateID(1);
			teDto1.setTemplateName("上司に圧倒的感謝");
			teDto1.setTemplateContent("上司に圧倒的感謝コンテンツ");
			teDto1.setMashiMashiValue(1);

			TemplateDto teDto2 = new TemplateDto();
			teDto2.setTemplateID(2);
			teDto2.setTemplateName("部下と圧倒的成長");
			teDto2.setTemplateContent("部下と圧倒的成長コンテンツ");
			teDto2.setMashiMashiValue(1);

			list.add(teDto1);
			list.add(teDto2);

		} catch(SQLException | ClassNotFoundException e) {
			throw new ServletException(e);
		}

		Collections.sort(list, new TemplateComparator(mashiMashiValue));

		return list;
	}

	public List<AddressTypeDto> getAddressTypeList() throws ServletException
	{
		List<AddressTypeDto> atd = null;
		try( Connection con = Dao.getConnection() ){
			AddressTypeDao dao = new AddressTypeDao(con);
			atd = dao.findAll();
		} catch ( ClassNotFoundException|SQLException e) {
			e.printStackTrace();
			throw new ServletException(e);
		}
		return atd;
	}

	public List<PurposeTypeDto> getPurposeTypeList() throws ServletException
	{
		List<PurposeTypeDto> ptd = null;
		try( Connection con = Dao.getConnection() ){
			PurposeTypeDao dao = new PurposeTypeDao(con);
			ptd = dao.findAll();
		} catch ( ClassNotFoundException|SQLException e) {
			e.printStackTrace();
			throw new ServletException(e);
		}
		return ptd;
	}

	public TemplateDto getTemplateByKey(int id) throws ServletException
	{
		TemplateDto td = null;
		try( Connection con = Dao.getConnection() ){
			TemplateDao dao = new TemplateDao(con);
			td = dao.findByKey(id);
		} catch ( ClassNotFoundException|SQLException e) {
			e.printStackTrace();
			throw new ServletException(e);
		}
		return td;
	}
}
