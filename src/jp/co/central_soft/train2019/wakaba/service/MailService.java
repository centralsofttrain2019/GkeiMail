package jp.co.central_soft.train2019.wakaba.service;

import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.ServletException;

import org.simplejavamail.email.Email;
import org.simplejavamail.email.EmailBuilder;
import org.simplejavamail.mailer.Mailer;
import org.simplejavamail.mailer.MailerBuilder;
import org.simplejavamail.mailer.config.TransportStrategy;

import jp.co.central_soft.train2019.wakaba.dao.Dao;
import jp.co.central_soft.train2019.wakaba.dao.MailServerDao;
import jp.co.central_soft.train2019.wakaba.dto.MailServerDto;

public class MailService
{
	public void sendMail(String atesaki, String kenmei, String honbun, int id) throws ServletException
	{
		MailServerDto serverDto = this.getServerInformation(id);
		String mailAddress;
		sendBySimpleJavaMail(atesaki, kenmei, honbun, serverDto);

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
		System.out.println(serverDto.getPOPServer() + serverDto.getPOPPort());
		return serverDto;
	}

	 private static void sendBySimpleJavaMail(String atesaki, String kenmei, String honbun,MailServerDto serverDto)
	 {
	        Email email = EmailBuilder.startingBlank()
	                .from("kikutaro_from", "kunita.test@gmail.com")
	                .to("kikutaro_to", atesaki)
	                .withSubject(kenmei)
	                .withPlainText(honbun)
	                .buildEmail();
	        Mailer mailer = MailerBuilder
	                .withSMTPServer(serverDto.getSMTPServer(), serverDto.getSMTPPort(),	"kunita.test@gmail.com","aa11aa11")
	                .withTransportStrategy(TransportStrategy.SMTP_TLS)
	                .withProxy("socksproxy.host.com", 1080, "proxy user", "proxy password")
	                .withSessionTimeout(10 * 1000)
	                .clearEmailAddressCriteria() // turns off email validation
//	                .withProperty("mail.smtp.sendpartial", true)
	                .withDebugLogging(true)
	                .buildMailer();
	        mailer.sendMail(email);
	  }
}
