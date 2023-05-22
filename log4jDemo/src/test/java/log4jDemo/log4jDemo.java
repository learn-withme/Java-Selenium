package log4jDemo;

import org.apache.log4j.ConsoleAppender;
import org.apache.log4j.FileAppender;
import org.apache.log4j.Layout;
import org.apache.log4j.Logger;
import org.apache.log4j.PatternLayout;
import org.apache.log4j.SimpleLayout;

import java.io.IOException;

import org.apache.log4j.Appender;

public class log4jDemo {
		   /* Get actual class name to be printed on */
	 private static Logger logger = Logger.getLogger(log4jDemo.class);
	   
	   public static void main(String[] args) throws IOException {
		  // Layout layput = new SimpleLayout();
		   Layout layout = new PatternLayout("%p %d %C %M %m %n");
		   //Appender appender = new ConsoleAppender(layout);
		   //logger.addAppender(appender);
		   
		   Appender appender = new FileAppender(layout,"d:/Testing/logs/logfile.log");
		   logger.addAppender(appender);
		   
		   logger.info("From Info");
		   
	   
}
	}
