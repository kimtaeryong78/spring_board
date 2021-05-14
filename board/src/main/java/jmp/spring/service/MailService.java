package jmp.spring.service;

import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.Properties;
import java.util.UUID;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import jmp.spring.vo.UserVO;
import lombok.Setter;

@Component
public class MailService {
	
	@Setter(onMethod_ = @Autowired)
	private Properties prop;
	
	@Value("#{prop['mail_id']}")
	String mail_id;
	
	@Value("#{prop['mail_pw']}")
	String mail_pw;
	
	BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
	
	public String pwdMailSend(UserVO user) {
		String tempStr = UUID.randomUUID().toString().substring(0,7);
		
		// 구글 계정 인증용 ID/PW 세팅
		Authenticator auth = new MailAuth(mail_id, mail_pw);
		// 세션 및 메세지 생성 (프로퍼티, 인증)
		Session session = Session.getDefaultInstance(prop, auth);
		MimeMessage email = new MimeMessage(session);

		try {
			// 보내는 날짜 지정
			email.setSentDate(new Date());
			// 발송자 설정 (발송자의 메일, 발송자명)
			email.setFrom(new InternetAddress("kimtaeryong78@gmail.com", "김태룡"));
             // 수신자 설정 
			// Message.RecipientType.TO : 받는 사람 
			InternetAddress to = new InternetAddress(user.getEmail());
			email.setRecipient(Message.RecipientType.TO, to);	//참조
			
            // 메일 제목
			email.setSubject("임시 비밀번호 인증 메일", "UTF-8");
			// 메일 내용
			email.setText("이 메일은 " +user.getName()+"님의 비밀번호 확인을 위한 메일입니다. 임시 비밀 번호는 "+ tempStr +" 입니다.", "UTF-8");
			
            // 메일 발송
			Transport.send(email);
			
			//비밀번호 암호화
			tempStr = encoder.encode(tempStr);

		} catch (AddressException ae) {// 주소를 입력하지 않았을 경우
			System.out.println("AddressException : " + ae.getMessage());
		} catch (MessagingException me) {// 메세지에 이상이 있을 경우
			System.out.println("MessagingException : " + me.getMessage());
		} catch (UnsupportedEncodingException e) {
			System.out.println("UnsupportedEncodingException : " + e.getMessage());
		}
		return tempStr;
	}
	public void idMailSend(UserVO user) {
		// 구글 계정 인증용 ID/PW 세팅
		Authenticator auth = new MailAuth(mail_id, mail_pw);
		// 세션 및 메세지 생성 (프로퍼티, 인증)
		Session session = Session.getDefaultInstance(prop, auth);
		MimeMessage email = new MimeMessage(session);
		
		try {
			// 보내는 날짜 지정
			email.setSentDate(new Date());
			// 발송자 설정 (발송자의 메일, 발송자명)
			email.setFrom(new InternetAddress("kimtaeryong78@gmail.com", "김태룡"));
			// 수신자 설정 
			// Message.RecipientType.TO : 받는 사람 
			InternetAddress to = new InternetAddress(user.getEmail());
			email.setRecipient(Message.RecipientType.TO, to);	//참조
			
			// 메일 제목
			email.setSubject("아이디 인증 메일", "UTF-8");
			// 메일 내용
			email.setText("이 메일은 " +user.getName()+"님의 아이디 확인을 위한 메일입니다. 아이디는 "+ user.getId() +" 입니다.", "UTF-8");
			
			// 메일 발송
			Transport.send(email);
			
		} catch (AddressException ae) {// 주소를 입력하지 않았을 경우
			System.out.println("AddressException : " + ae.getMessage());
		} catch (MessagingException me) {// 메세지에 이상이 있을 경우
			System.out.println("MessagingException : " + me.getMessage());
		} catch (UnsupportedEncodingException e) {
			System.out.println("UnsupportedEncodingException : " + e.getMessage());
		}
	}
}

class MailAuth extends Authenticator{
	
	PasswordAuthentication pa;
	
	public MailAuth(String mail_id, String mail_pw) {
		// 사용자 인증 정보를 담아서 반환
		pa = new PasswordAuthentication(mail_id, mail_pw);
	}
	
	public PasswordAuthentication getPasswordAuthentication() {
		return pa;
	}

}
