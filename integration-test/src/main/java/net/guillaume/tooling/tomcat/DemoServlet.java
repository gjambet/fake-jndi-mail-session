package net.guillaume.tooling.tomcat;

import java.io.IOException;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class DemoServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.getWriter().println("DemoServlet : doGet");

        InitialContext ic = null;
        Session session = null;
        try {
            ic = new InitialContext();
            session = (Session) ic.lookup("java:comp/env/mail/Session");
        } catch (NamingException e) {
            e.printStackTrace(resp.getWriter());
        }

        resp.getWriter().println("DemoServlet, Session : " + session);

        try {

            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress("pipo@yopmail.com"));
            message.addRecipient(Message.RecipientType.TO, new InternetAddress("bimbo@yopmail.com"));
            message.setSubject("This is the Subject Line!");
            message.setText("This is actual message");
            Transport.send(message);
            System.out.println("Sent message successfully....");
        } catch (MessagingException e) {
            e.printStackTrace(resp.getWriter());
        }

        resp.getWriter().flush();

    }
}
