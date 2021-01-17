package org.jakartaeerecipes.chapter01.recipe01_06;

import jakarta.mail.Message;
import jakarta.mail.MessagingException;
import jakarta.mail.Session;
import jakarta.mail.Transport;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;
import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;

import java.util.Properties;

@WebListener
public class StartupShutdownListener implements ServletContextListener {

    public void contextInitialized(ServletContextEvent event) {
        System.out.println("Servlet startup...");
        System.out.println(event.getServletContext().getServerInfo());
        System.out.println(System.currentTimeMillis());
        // See error in server.log if mail is unsuccessful
        sendEmail("Servlet context has initialized");
    }

    public void contextDestroyed(ServletContextEvent event) {
        System.out.println("Servlet shutdown...");
        System.out.println(event.getServletContext().getServerInfo());
        System.out.println(System.currentTimeMillis());
        // See error in server.log if mail is unsuccessful
        sendEmail("Servlet context has been destroyed...");
    }

    /**
     * This implementation uses the GMail smtp server
     *
     * @param message
     * @return
     */
    private boolean sendEmail(String message) {
        boolean result = false;
        String smtpHost = "smtp.gmail.com";
        String smtpUsername = "nirav.pradhan@gmail.com";
        String smtpPassword = "RhtdM786@DdlJ";
        String from = "nirav.pradhan@gmail.com";
        String to = "nirav_pradhan@yahoo.co.in";
        int smtpPort = 587;
        System.out.println("sending email...");
        try {
            // Send email here

            //Set the host smtp address
            Properties props = new Properties();
            props.put("mail.smtp.host", smtpHost);
            props.put("mail.smtp.auth", "true");
            props.put("mail.smtp.starttls.enable", "true");

            // create some properties and get the default Session
            Session session = Session.getInstance(props);

            // create a message
            Message msg = new MimeMessage(session);

            // set the from and to address
            InternetAddress addressFrom = new InternetAddress(from);
            msg.setFrom(addressFrom);
            InternetAddress[] address = new InternetAddress[1];
            address[0] = new InternetAddress(to);
            msg.setRecipients(Message.RecipientType.TO, address);
            msg.setSubject(message);
            // Append Footer
            msg.setContent(message, "text/plain");
            Transport transport = session.getTransport("smtp");
//            transport.connect(smtpHost, smtpPort, smtpUsername, smtpPassword);

            //          Transport.send(msg);

            result = true;
        } catch (MessagingException ex) {
            ex.printStackTrace();
            result = false;
        }
        return result;
    }
}
