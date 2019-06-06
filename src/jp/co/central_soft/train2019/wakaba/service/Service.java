package jp.co.central_soft.train2019.wakaba.service;

import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.ServletException;

import jp.co.central_soft.train2019.wakaba.dao.Dao;
import jp.co.central_soft.train2019.wakaba.dao.TemplateDao;
import jp.co.central_soft.train2019.wakaba.dto.TemplateDto;

public class Service {

	public TemplateDto findTemplateByKey(int tid) throws ServletException {
		TemplateDto edp = null;
		try( Connection con = Dao.getConnection() ){
			TemplateDao dao = new TemplateDao(con);
			edp = dao.findByKey(tid);
		} catch ( ClassNotFoundException|SQLException e) {
			e.printStackTrace();
			throw new ServletException(e);
		}

		return edp;
	}
}
