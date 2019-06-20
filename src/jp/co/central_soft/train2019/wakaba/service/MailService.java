package jp.co.central_soft.train2019.wakaba.service;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.NoSuchProviderException;
import javax.mail.Session;
import javax.mail.Store;
import javax.mail.URLName;
import javax.servlet.ServletException;

import org.simplejavamail.converter.EmailConverter;
import org.simplejavamail.email.Email;
import org.simplejavamail.email.EmailBuilder;
import org.simplejavamail.mailer.Mailer;
import org.simplejavamail.mailer.MailerBuilder;

import com.sun.mail.pop3.POP3SSLStore;

import jp.co.central_soft.train2019.wakaba.dao.Dao;
import jp.co.central_soft.train2019.wakaba.dao.MailDao;
import jp.co.central_soft.train2019.wakaba.dao.MailServerDao;
import jp.co.central_soft.train2019.wakaba.dto.MailDto;
import jp.co.central_soft.train2019.wakaba.dto.MailServerDto;

public class MailService
{
	public void sendMail(String atesaki, String kenmei, String honbun, int id) throws ServletException
	{
		MailServerDto serverDto = this.getServerInformation(id);
		List<String> toList = new ArrayList<String>();
		toList.add(atesaki);
		String mailAddress;
		sendBySimpleJavaMail(toList, kenmei, honbun, serverDto);

	}

	public List<MailDto> receiveMail(int id) throws ServletException
	{
		System.out.println("start");
		MailServerDto serverDto = this.getServerInformation(id);
		List<MailDto> dtolist = new ArrayList<MailDto>();
		dtolist = receiveJavaMail(serverDto);
		System.out.println("end");
		return dtolist;
	}

	public MailServerDto getServerInformation(int id) throws ServletException
	{
		MailServerDto serverDto = null;
		try( Connection con = Dao.getConnection() ){
			MailServerDao dao = new MailServerDao(con);
			serverDto = dao.getServerInformation(id);
		} catch ( ClassNotFoundException|SQLException e) {
			e.printStackTrace();
			throw new ServletException(e);
		}
		return serverDto;
	}

	 private static void sendBySimpleJavaMail(List<String> toList, String kenmei, String honbun,MailServerDto serverDto)
	 {
		 	Email email = EmailBuilder.startingBlank()
	                .from("kikutaro_from", "kunita.test@gmail.com")
	                .to("kikutaro_to",toList )
	                .withSubject(kenmei)
	                .withPlainText(honbun)
	                .buildEmail();
		 	try {
				EmailConverter.emailToMimeMessage(email)
						.writeTo(System.out);
			} catch (IOException | MessagingException e) {
				// TODO 自動生成された catch ブロック
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

	 private static List<MailDto> receiveJavaMail(MailServerDto serverDto)
	 {
		String username = "kunita.test@gmail.com";
		String password = "aa11aa11";
		//boolean debug = true;
		List<MailDto> dtolist = new ArrayList<MailDto>();



		try {
			Properties pop3Props = new Properties();
			pop3Props.setProperty("mail.pop3.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
			pop3Props.setProperty("mail.pop3.socketFactory.fallback", "false");
			pop3Props.setProperty("mail.pop3.port", "995");
			pop3Props.setProperty("mail.pop3.socketFactory.port", "995");
			URLName url = new URLName("pop3", "pop.gmail.com", 995, "", username, password);
			Session session = Session.getInstance(pop3Props, null);
			Store store = new POP3SSLStore(session, url);
			store.connect();

			Folder folder = store.getFolder("INBOX");
			folder.open(Folder.READ_ONLY);
			Message[] msgs = folder.getMessages();
			for (Message msg : msgs)
			{
				MailDto dto = new MailDto();
//				System.out.println("---------------------------------");
//				System.out.println("Email Number " + msg.getMessageNumber());
//				System.out.println("Subject: " + msg.getSubject());
//				System.out.println("From: " + msg.getFrom()[0]);
//				System.out.println("Text: " + msg.getContent().toString());
//				System.out.println("Date: " + msg.getSentDate());
				Instant instant = msg.getSentDate().toInstant();
//				dto.setMessageID(msg.getMessageNumber());
//				dto.setSubject(EmailConverter.mimeMessageToEmail((MimeMessage) msg).getPlainText()); //本文
				dto.setSubject(msg.getSubject().toString());
				dto.setFrom( msg.getFrom()[0].toString()); //送信元
				dto.setDate(LocalDateTime.ofInstant(instant, ZoneId.systemDefault()));
				dtolist.add(dto);
			}
			folder.close();
			store.close();
		} catch (NoSuchProviderException e) {
			e.printStackTrace();
		} catch (MessagingException e) {
			e.printStackTrace();
		}
		return dtolist;


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
