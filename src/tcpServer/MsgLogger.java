package tcpServer;

import java.io.File;
import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

/*
 * Simple message logger
 * TODO singelton and static class
 */
public class MsgLogger {
	
	private Logger logger;
	// Simple file logging handler
	private FileHandler fh;
	// absolute logging file path
	private String LOG_DIR = "C:/Temp";
	private String LOG_PATH = "C:/Temp/motion_log.log";
	
	MsgLogger() {
		// Initilize logger
		logger = Logger.getLogger("MotionLog");
		init_logging();
	}
	
	// Initilize logging 
	private void init_logging() {
		try {
			// Check if directory exists
			check_dir();
			fh = new FileHandler(LOG_PATH, true);
			logger.addHandler(fh);
	        SimpleFormatter formatter = new SimpleFormatter();  
	        fh.setFormatter(formatter);
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	// Check if LOG_DIR exists
	private void check_dir() {
		(new File(LOG_DIR)).mkdir();
	}
	
	// Write log to file
	public void write_log(String log) {
		logger.info(log);
	}
	
	/*
	 * Chto dolzhen delatj MsgLogger
	 * Proveritj sozdana li papka Temp?
	 * Zapisovatj/Popolniatj informaciju done
	 */
	
	
	
}
