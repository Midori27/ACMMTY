/* HOLA */
/*
 * To change this template, choose Tools | Templates
 * and open the templato in the editor.
 */
//codigo tomado de http://www.mkyong.com/java/javamail-api-sending-email-via-gmail-smtp-example/
package Controlador;



import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;


/**
 *
 * @author juanjo
 */
public class ControladorEmail {
    private static final String USERNAME = "acm.monterrey@gmail.com";
    private static final String PASSWORD = "acmgmail2013";
    private static ControladorEmail instance;
    private Session session;
    
    public ControladorEmail(){
        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host","smtp.gmail.com");
        props.put("mail.smtp.port", "587");
        
        session = Session.getInstance(props,
                new javax.mail.Authenticator(){
                    protected PasswordAuthentication getPasswordAuthentication(){
                        return new PasswordAuthentication(USERNAME,PASSWORD);
                    }
                });
    }
    
    public static ControladorEmail getInstanceControladorEmail(){
        ControladorEmail i = instance;
        
        if(i == null){
            i = new ControladorEmail();
        }
        
        return i;
    }
    
    public void enviaMail(String de, String para, String asunto, String contenido){
        try{
            Message mensaje = new MimeMessage(session);
            mensaje.setFrom(new InternetAddress(de));
            mensaje.setRecipients(Message.RecipientType.TO, InternetAddress.parse(para));
            mensaje.setSubject(asunto);
            mensaje.setText(contenido);
            Transport.send(mensaje);
        }catch(MessagingException e){
            throw new RuntimeException(e);
        }
    }
}
