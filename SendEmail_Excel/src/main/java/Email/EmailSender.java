package Email;

import java.io.*;
import javax.mail.*;
import javax.mail.internet.*;

public class EmailSender {	
    public static void main(String[] args) throws AddressException, IOException, MessagingException  {
     	int mail_count = mailSetup.sendmail();
    	System.out.println("Successfully "+mail_count + " mails sent");
    }
}
