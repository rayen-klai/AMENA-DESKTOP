import java.util.Properties;
import javax.mail.*;
import javax.mail.internet.*;

public class EmailExample {
    public static void main(String[] args) {

        String to = "transamena@gmail.com";
        String from = "klairayen123@gmail.com";
        String host = "smtp.gmail.com"; // or your SMTP server host

        Properties properties = System.getProperties();
        properties.setProperty("mail.smtp.host", host);
        properties.setProperty("mail.smtp.port", "587");
        properties.setProperty("mail.smtp.auth", "true");
        properties.setProperty("mail.smtp.starttls.enable", "true");

        Session session = Session.getInstance(properties,
            new javax.mail.Authenticator() {
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication("klairayen123@gmail.com", "Rnaoyuern123");
                }
            });

        try{
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(from));
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
            message.setSubject("Subject line here");
            message.setText("Hello, this is a test email!");

            Transport.send(message);
            System.out.println("Email sent successfully.");
        }catch (MessagingException mex) {
            mex.printStackTrace();
        }
    }
}
