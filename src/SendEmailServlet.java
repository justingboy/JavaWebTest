import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Properties;


/**
 * Created by wanglin on 2018/8/29.
 */
public class SendEmailServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 收件人的电子邮件 ID
        String to = "justingboy1851@gmail.com";

        // 发件人的电子邮件 ID
        String from = "justingboy@163.com";

        // 假设您是从本地主机发送电子邮件
        String host = "smtp.163.com";

        // 获取系统的属性
        Properties properties = System.getProperties();

        // 设置邮件服务器
        properties.setProperty("mail.smtp.host", host);


//        MailSSLSocketFactory sf = null;
//        try {
//            sf = new MailSSLSocketFactory();
//            // 设置信任所有的主机
//            sf.setTrustAllHosts(true);
//            properties.put("mail.smtp.ssl.enable", "true");
//            properties.put("mail.smtp.ssl.socketFactory", sf);
//        } catch (GeneralSecurityException e) {
//            e.printStackTrace();
//        }
        Session session = null;
        try {

            System.out.println("AAAAAASSAAS-6");
            properties.setProperty("mail.transport.protocol", "smtp");// 设置传输协议
            properties.put("mail.smtp.auth", "true");
            Authentication authentication = new Authentication("justingboy@163.com", "**************");
//         获取默认的 Session 对象
            session = Session.getInstance(properties, authentication);
//        Session session = Session.getDefaultInstance(properties);
        } catch (Exception e) {
            e.printStackTrace();
        }


        // 设置响应内容类型
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        try {
            // 创建一个默认的 MimeMessage 对象
            MimeMessage message = new MimeMessage(session);
            // 设置 From: header field of the header.
            message.setFrom(new InternetAddress(from));
            // 设置 To: header field of the header.
            message.addRecipient(Message.RecipientType.TO,
                    new InternetAddress(to));
            // 设置 Subject: header field
            message.setSubject("王林你好！ ");
            // 现在设置实际消息
            message.setText("This is actual message");
            // 发送消息
            Transport.send(message);
            String title = "发送电子邮件";
            String res = "成功发送消息...";
            String docType = "<!DOCTYPE html> \n";
            out.println(docType +
                    "<html>\n" +
                    "<head><title>" + title + "</title></head>\n" +
                    "<body bgcolor=\"#f0f0f0\">\n" +
                    "<h1 align=\"center\">" + title + "</h1>\n" +
                    "<p align=\"center\">" + res + "</p>\n" +
                    "</body></html>");
        } catch (MessagingException mex) {
            mex.printStackTrace();
        }
    }

    private class Authentication extends Authenticator {
        String username = null;
        String password = null;

        public Authentication() {
        }

        public Authentication(String username, String password) {
            this.username = username;
            this.password = password;
        }

        protected PasswordAuthentication getPasswordAuthentication() {
            PasswordAuthentication pa = new PasswordAuthentication(username, password);
            return pa;
        }
    }
}
