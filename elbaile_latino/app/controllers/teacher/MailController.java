package controllers.teacher;

import play.*;
import java.util.Properties;
import play.mvc.Controller;
import play.mvc.Result;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import static play.data.Form.form;

import play.data.Form;
import play.data.format.Formats;
import play.data.DynamicForm;

public class MailController extends Controller {

    public static Result send() {

        Properties props = new Properties();
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.socketFactory.port", "465");
        props.put("mail.smtp.socketFactory.class",
                "javax.net.ssl.SSLSocketFactory");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.port", "465");

        Session session = Session.getInstance(props,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication("elbailelatino", "elbailelatino26");
                    }
                });

        try {
            DynamicForm requestData = form().bindFromRequest();
            String emailtext = requestData.get("message");
            String namefrom = requestData.get("name");

            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress("elbailelatino@gmail.com"));
            message.setRecipients(Message.RecipientType.TO,
                    InternetAddress.parse("MichaelaEva@gmx.de"));

            message.setSubject("Elbailelatino - You got a message from " + namefrom + " !");
            //message.setText("Dear Mail Crawler," +
            //        "\n\n No spam to my email, please!");
            message.setText(emailtext);
            Transport.send(message);

            System.out.println("Done");

            return ok("Email sent!");

        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }


    public static Result sendcancellation() {

        Properties props = new Properties();
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.socketFactory.port", "465");
        props.put("mail.smtp.socketFactory.class",
                "javax.net.ssl.SSLSocketFactory");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.port", "465");

        Session session = Session.getInstance(props,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication("elbailelatino", "elbailelatino26");
                    }
                });

        try {
            DynamicForm requestData = form().bindFromRequest();
            String messagerequested = requestData.get("message");
            String namefrom = requestData.get("name");
            String date = requestData.get("date");

            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress("elbailelatino@gmail.com"));
            message.setRecipients(Message.RecipientType.TO,
                    InternetAddress.parse("MichaelaEva@gmx.de"));

            message.setSubject("Your dance class on " + date + " got canceled.");
            //message.setText("Dear Mail Crawler," +
            //        "\n\n No spam to my email, please!");
            message.setText(messagerequested);
            Transport.send(message);
            System.out.println("Done");

            return ok("Email sent!");

        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }


/**
    public static Result mailForm() {
        Form<MailController.MailForm> mailForm = form(MailController.MailForm.class);
        MailForm mailform = mailForm.get();
        return ok(views.html.courseSettings.render(mailForm));
    }
**/
/**
    public static Result mailForm() {
        DynamicForm requestData = form().bindFromRequest();
        Form<MailForm> form = form(MailForm.class).bindFromRequest();
        MailForm mailform = form.get();
        send(mailform.message);
        return ok(views.html.course.courseSettings.render(@"Test"));
    }
**/
        /**
         * Mail class used by Mail Form.
         */
    public static class MailForm {
        public String message;
        public String date;
        /**
         * Validate the authentication.
         *
         * @return null if validation ok, string with details otherwise
         */

        public String validate() {
            if (isBlank(message)) {
                return "Message is required";
            }
            return null;
        }

   }

    private static boolean isBlank(String input) {
        return input == null || input.isEmpty() || input.trim().isEmpty();
    }

}