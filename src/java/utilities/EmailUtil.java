/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package utilities;

/**
 *
 * @author Sebastian
 */


 
import EJB.EjbUsuario;
import java.util.Date;
import java.util.Properties;
 
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
 
/**
 * A utility class for sending e-mail messages
 * @author www.codejava.net
 *
 */
public class EmailUtil {
    public static void sendEmail(String host, String port,
            final String userName, final String password, String toAddress,
            String subject, String message) throws AddressException,
            MessagingException {
        
        
        // sets SMTP server properties
       
        Properties properties = new Properties();
       
        properties.put("mail.smtp.host", "smtp.gmail.com");
       
        properties.put("mail.smtp.port", "587");
       
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");
        
        // creates a new session with an authenticator
        Authenticator auth = new Authenticator() {
        
            @Override
            public PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("pruebatesisskynet@gmail.com", "skynet2000");
            }
        };
 
        Session session = Session.getInstance(properties, auth);
        // creates a new e-mail message
        Message msg = new MimeMessage(session);
        msg.setFrom(new InternetAddress(toAddress));
        InternetAddress[] toAddresses = { new InternetAddress(toAddress) };
        msg.setRecipients(Message.RecipientType.TO, toAddresses);
        msg.setSubject("Recuperar contraseña Bosque de Hiria");
        msg.setSentDate(new Date());
        Encriptado encriptado = new Encriptado();
        String encriptado1 = encriptado.Encriptar(message);
        String urlEncriptado = encriptado.encriptar(encriptado1);
        EjbUsuario ejbUsuario = new EjbUsuario();
        ejbUsuario.getUsuario().setKey(urlEncriptado);
        ejbUsuario.getUsuario().setUsername(message);
        String recuperarUser = ejbUsuario.actualizarLlave();
        
        msg.setText("Ingresa en el siguiente enlace http://bosquedehiria.com:8080/ProyectoTesis/auth/passwordreset.jsp?ursEnc="+urlEncriptado+" y podras cambiar tu contraseña, tenga en cuenta que el ultimo enlace que recibio es el que funciona, los otros ya no funcionaran");
        // sends the e-mail
        Transport.send(msg);
 
    }
}