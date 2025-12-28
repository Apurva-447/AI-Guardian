package util;

import java.util.Properties;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class EmailService {

    // 🔐 CHANGE THESE
    private static final String FROM_EMAIL = "Apurvap447@gmail.com";
    private static final String APP_PASSWORD = "bbkzfdfagiyhtakd";

    public static void sendGuardianEmail(String toEmail, String messageText) {

        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");

        Session session = Session.getInstance(props,
            new Authenticator() {
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication(FROM_EMAIL, APP_PASSWORD);
                }
            }
        );

        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(FROM_EMAIL));
            message.setRecipients(
                    Message.RecipientType.TO,
                    InternetAddress.parse(toEmail)
            );
            message.setSubject("AI Guardian Emergency Alert");
            message.setText(messageText);

            Transport.send(message);

            System.out.println("📧 Guardian email sent successfully");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
