package develop.api.jwt.mail;

import javax.mail.MessagingException;

import develop.api.jwt.domain.User;

import java.util.Map;

public interface MailBox {

  void sendInvitationMail(User user) ;

}
