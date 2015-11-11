/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Bitacora.acceso;

import java.util.Date;
import java.util.Properties;
import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.swing.*;
public class JavaMail
{
public void email(String para, String asunto,String mensaje,String ci, String correo) {
       try{
            final String username = "recursoshumanos@cajamarca.ec";
            final String password = "CajaR3cluta/2014";
            
            Properties props = new Properties();
            props.setProperty("mail.smtp.host", "smtp.cajamarca.ec");
            props.setProperty("mail.smtp.starttls.enable", "true");
            props.setProperty("mail.smtp.port", "587");
            props.setProperty("mail.smtp.auth", "true");
            Session session = Session.getInstance(props,new javax.mail.Authenticator() {
                protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(username, password);
                }
           });
 
            BodyPart texto = new MimeBodyPart();
            texto.setText(mensaje);
            BodyPart adjunto = new MimeBodyPart();
            String ad= "C:\\Users\\Matheus\\Desktop\\pruebas\\individuales\\"+ci+".pdf";
            String ad2= ci+".pdf";
            adjunto.setDataHandler(new DataHandler(new FileDataSource(ad)));
            adjunto.setFileName(ad2);//ARCHIVO Adjunto
            MimeMultipart multiParte = new MimeMultipart();
            multiParte.addBodyPart(texto);
            
            multiParte.addBodyPart(adjunto);
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress("recursoshumanos@cajamarca.ec"));   
            Date d= new Date();
            message.setSentDate(d);
            String [] correos;
            para=correo;
            correos = para.split("\n");
                for(int i=0;i<correos.length;i++){
                    message.addRecipient(Message.RecipientType.TO, new InternetAddress(correos[i]));
                    message.setSubject(asunto);
                    message.setContent(multiParte);
                    Transport t = session.getTransport("smtp");
                    t.connect(username, "CajaR3cluta/2014");
                    t.sendMessage(message, message.getAllRecipients());
                t.close();
              }
         }
        catch (Exception enc)
        {
       JOptionPane.showMessageDialog(null, " ERROR: No se pudo enviar el email ");
        }
    }
}

