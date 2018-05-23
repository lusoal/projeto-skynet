package utils;
import java.util.Properties;
import javax.mail.Address;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import model.Publico;

public class SendMail {
	
	private String texto;
	private String assunto;
	
	
	public SendMail(String texto, String assunto) {
		this.texto = texto;
		this.assunto = assunto;
	}
	
	public boolean sendEmailPublico(Publico publico) {
		 Properties props = new Properties();
		 boolean retorno = false;
         /** Parâmetros de conexão com servidor Gmail */
         props.put("mail.smtp.host", "smtp.gmail.com");
         props.put("mail.smtp.socketFactory.port", "465");
         props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
         props.put("mail.smtp.auth", "true");
         props.put("mail.smtp.port", "465");

         Session session = Session.getDefaultInstance(props,
                     new javax.mail.Authenticator() {
                          protected PasswordAuthentication getPasswordAuthentication() 
                          {		
                        	  	//Preencher com email e senha para disparar avisos
                                return new PasswordAuthentication("", "");
                          }
                     });

         /** Ativa Debug para sessão */
         session.setDebug(true);

         try {

               Message message = new MimeMessage(session);
               message.setFrom(new InternetAddress("seuemail@gmail.com")); //Remetente
               String email = publico.getEmail();
               
               Address[] toUser = InternetAddress //Destinatário(s)
                          .parse(email);  

               message.setRecipients(Message.RecipientType.TO, toUser);
               message.setSubject(assunto);//Assunto
               message.setText(texto);
               /**Método para enviar a mensagem criada*/
               Transport.send(message);
               retorno = true;
          } catch (MessagingException e) {
               throw new RuntimeException(e);
         }
         return retorno;
	}
	
	public boolean sendEmailCadastros() {
		return true;
	}
	
	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	public String getAssunto() {
		return assunto;
	}

	public void setAssunto(String assunto) {
		this.assunto = assunto;
	}

	
}
