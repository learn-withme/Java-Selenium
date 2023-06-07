package Email;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.apache.log4j.FileAppender;
import org.apache.log4j.Layout;
import org.apache.log4j.Logger;
import org.apache.log4j.PatternLayout;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class mailSetup {

	final static readConfigFile config = new readConfigFile();

	public static Session getSession() {

		Properties properties = System.getProperties();

		// Setup mail server
		properties.put("mail.smtp.host", "smtp.dreamhost.com");
		properties.put("mail.smtp.port", "465");
		properties.put("mail.smtp.ssl.enable", "true");
		properties.put("mail.smtp.auth", "true");

		// Get the Session object.// and pass username and password
		Session session = Session.getInstance(properties, new javax.mail.Authenticator() {

			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(config.getUser_Id(),config.getPwd());
			}

		});
		
		// Used to debug SMTP issues
        //session.setDebug(true);

		return session;
	}

	public static int sendmail() {
		int mail_count = 0;

		Logger logger = Logger.getLogger(mailSetup.class);

		Layout layout = new PatternLayout("%p       %d{yyyy-MM-dd hh-mm-ss} %m %n");
		String fileName = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss'.logs'").format(new Date()); 

		String log_path = config.getLogPath();
		FileAppender appender;
		try {
			appender = new FileAppender(layout,log_path+fileName);
			logger.addAppender(appender); 

		} catch (IOException e) {
			e.printStackTrace();
		}

		Session session = getSession();

		FileInputStream fileinput;
		try {
			fileinput = new FileInputStream(config.getExcelPath());

			XSSFWorkbook workbook = new XSSFWorkbook(fileinput);

			XSSFSheet mail_sheet = workbook.getSheet(config.getMailSheet());

			int rowcount = mail_sheet.getLastRowNum();
			
			for (int i = 1; i <= rowcount; i++) {

				// Create a default MimeMessage object.
				MimeMessage message = new MimeMessage(session);

				// Set From: header field of the header.
				message.setFrom(new InternetAddress(config.getFrom()));

				// Set Subject
				message.setSubject(config.getSubject());

				//Get the mail id from the excel sheet
				XSSFRow maildata = mail_sheet.getRow(i);
				String to = maildata.getCell(1).getStringCellValue();
				
				if (!to.isBlank())
				{
					// Set To Mail id
					message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));

					//Get the names from the excel sheet
					String names = maildata.getCell(0).getStringCellValue();
					String prefix = "Dear ";
					String name = prefix + names;

					if (!names.isBlank())
					{
						// Read the data from the text file
						BufferedReader reader = 
								new BufferedReader(new FileReader(config.getContentPath()));

						StringBuilder content = new StringBuilder();  
						content.append(name).append("\n").append("\n");    

						String line;
						while (( line = reader.readLine()) != null) {
							content.append(line).append("\n");
						}
						reader.close();

						message.setText(content.toString());

						workbook.close();

						// Send message
						Transport.send(message);
						logger.info ("EMail sent to " + to);
						mail_count ++;
					}
					else
						logger.error("Name Field Empty in the Alumini Excel Sheet for " +to);
				}
				else
					logger.error("EMail Field Empty in the Alumini Excel Sheet");
			}
		} catch (FileNotFoundException e) {
			logger.error("Excel File is Not Found in the Path ");
		} catch (AddressException e) {
			logger.error("Mail Address is Wrong.. Please Check From and To Address");
		}  catch (IOException e) {
			e.printStackTrace();
		} catch (MessagingException e) {
			logger.error("Message Not Sent Properly");
		}
	return mail_count;
	}

}


