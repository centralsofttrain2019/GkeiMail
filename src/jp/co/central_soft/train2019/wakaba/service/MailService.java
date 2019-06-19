package jp.co.central_soft.train2019.wakaba.service;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.mail.MessagingException;
import javax.servlet.ServletException;

import org.simplejavamail.converter.EmailConverter;
import org.simplejavamail.email.Email;
import org.simplejavamail.email.EmailBuilder;
import org.simplejavamail.mailer.Mailer;
import org.simplejavamail.mailer.MailerBuilder;

import jp.co.central_soft.train2019.wakaba.bean.MailDto;
import jp.co.central_soft.train2019.wakaba.dao.Dao;
import jp.co.central_soft.train2019.wakaba.dao.MailDao;
import jp.co.central_soft.train2019.wakaba.dao.MailServerDao;
import jp.co.central_soft.train2019.wakaba.dto.MailServerDto;

public class MailService
{
	private List<String> to =new  ArrayList<String>();
	public void sendMail(String atesaki, String kenmei, String honbun, int id) throws ServletException
	{
		MailServerDto serverDto = this.getServerInformation(id);
		System.out.println(atesaki);
		this.to.add(atesaki);
		System.out.println(atesaki + to.get(0));
		sendBySimpleJavaMail(to, kenmei, honbun, serverDto);

	}

	public MailServerDto getServerInformation(int id) throws ServletException
	{
		MailServerDto serverDto = null;
		try( Connection con = Dao.getConnection() ){
			MailServerDao dao = new MailServerDao(con);
			serverDto = dao.getSMTPInformation(id);
		} catch ( ClassNotFoundException|SQLException e) {
			e.printStackTrace();
			throw new ServletException(e);
		}
		return serverDto;
	}

	 private static void sendBySimpleJavaMail(List<String> list, String kenmei, String honbun,MailServerDto serverDto)
	 {
		 	Email email = EmailBuilder.startingBlank()
	                .from("kikutaro_from", "kunita.test@gmail.com")
	                .to("kikutaro_to",list)
	                .withSubject(kenmei)
	                .withPlainText(honbun)
	                .buildEmail();
		 	try {
				EmailConverter.emailToMimeMessage(email)
						.writeTo(System.out);
				System.out.println("yuya");
			} catch (IOException | MessagingException e) {
				// TODO 自動生成された catch ブロック
				System.out.println("kunita");
				e.printStackTrace();
			}
	        Mailer mailer = MailerBuilder
	                .withSMTPServer(serverDto.getSMTPServer(), serverDto.getSMTPPort(),"kunita.test@gmail.com","aa11aa11")
//	                .withTransportStrategy(TransportStrategy.SMTP_TLS)
//	                .withProxy("socksproxy.host.com", 1080, "proxy user", "proxy password")
//	                .withSessionTimeout(10 * 1000)
//	                .clearEmailAddressCriteria() // turns off email validation
//	                .withProperty("mail.smtp.sendpartial", true)
//	                .withDebugLogging(true)
	                .buildMailer();
	        mailer.sendMail(email);
	  }

	public List<MailDto> getMailList(int userID) throws ServletException
	{
		List<MailDto> dtos = null;
		try( Connection con = Dao.getConnection() ){
			MailDao dao = new MailDao(con);
			dtos = dao.findByUserID(userID);
		} catch ( ClassNotFoundException | SQLException e ) {
			throw new ServletException(e);
		}
		return dtos;
	}
}
