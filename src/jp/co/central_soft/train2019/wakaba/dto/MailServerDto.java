package jp.co.central_soft.train2019.wakaba.dto;

public class MailServerDto
{
    String SMTPServer;
    int SMTPPort;

    String POPServer;
    int POPPort;
	public String getSMTPServer() {
		return SMTPServer;
	}
	public void setSMTPServer(String sMTPServer) {
		SMTPServer = sMTPServer;
	}
	public int getSMTPPort() {
		return SMTPPort;
	}
	public void setSMTPPort(int sMTPPort) {
		SMTPPort = sMTPPort;
	}
	public String getPOPServer() {
		return POPServer;
	}
	public void setPOPServer(String pOPServer) {
		POPServer = pOPServer;
	}
	public int getPOPPort() {
		return POPPort;
	}
	public void setPOPPort(int pOPPort) {
		POPPort = pOPPort;
	}


}
