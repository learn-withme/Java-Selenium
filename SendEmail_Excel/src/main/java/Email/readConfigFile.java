package Email;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import org.apache.log4j.Appender;
import org.apache.log4j.FileAppender;
import org.apache.log4j.Layout;
import org.apache.log4j.Logger;
import org.apache.log4j.PatternLayout;

public class readConfigFile{

	Properties properties;

	File file = new File("config.properties");
	String path = file.getAbsolutePath();

	static Logger logger = Logger.getLogger(readConfigFile.class);

	public readConfigFile()  {
		properties = new Properties();
		Layout layout = new PatternLayout("%p       %d{yyyy-MM-dd hh-mm-ss} %m %n");
		
		String fileName = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss'.logs'").format(new Date());
		String file_path = ".\\Config_logs\\";
		Appender appender;
		try {
			appender = new FileAppender(layout,file_path+fileName);
			logger.addAppender(appender);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	try {
		FileInputStream input = new FileInputStream(path);
		try {
			properties.load(input);
		} catch (IOException e) {
			logger.error("Not able to Read the Config File.. ");
		}
	} catch (FileNotFoundException e) {
		logger.error("Not able to Find the Config File.. ");
	}

}

public String getUser_Id() {

	String user_id = properties.getProperty("user_id");
	if (user_id!=null) 
		return user_id;
	else {
		logger.error("User id is not specified in the Config File");
		throw new RuntimeException("User id is not specified in the Config File");		
	}
}

public String getPwd() {
	String pwd = properties.getProperty("pwd");
	if (pwd!=null) 
		return pwd;
	else {
		logger.error("Password is not specified in the Config File");
		throw new RuntimeException("Password is not specified in the Config File");	
	}
}

public String getFrom() {
	String from = properties.getProperty("from");
	if (from!=null) 
		return from;
	else {
		logger.error("From Address is not specified in the Config File");
		throw new RuntimeException("From Address is not specified in the Config File");		
	}
}

public String getSubject() {
	String subject = properties.getProperty("subject");
	if (subject!=null) 
		return subject;
	else {
		logger.error("Subject is not specified in the Config File");
		throw new RuntimeException("Subject is not specified in the Config File");	
	}
}

public String getExcelPath() {
	String excelpath = properties.getProperty("excelpath");
	if (excelpath!=null) 
		return excelpath;
	else {
		logger.error("Excel path is not specified in the Config File");
		throw new RuntimeException("Excel path is not specified in the Config File");	
	}
			
}

public String getContentPath() {
	String content_path = properties.getProperty("content_path");
	if (content_path!=null) 
		return content_path;
	else {
		logger.error("EMail content path is not specified in the Config File");
		throw new RuntimeException("EMail content path is not specified in the Config File");		
	}
}

public String getMailSheet() {
	String mail_sheet_name = properties.getProperty("mail_sheet_name");
	if (mail_sheet_name!=null) 
		return mail_sheet_name;
	else {
		logger.error("Mail Sheet Name is not specified in the Config File");
		throw new RuntimeException("Mail Sheet Name is not specified in the Config File");	
	}
}

public String getLogPath() {
	String log_path = properties.getProperty("log_path");
	if (log_path!=null) 
		return log_path;
	else {
		logger.error("Log File path is not specified in the Config File");
		throw new RuntimeException("Log File path is not specified in the Config File");	
	}
}

}



















