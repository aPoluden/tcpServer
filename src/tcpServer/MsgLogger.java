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
	// Abstract logging path
	private String LOG_DIR = "";
	private String LOG_PATH = "";
	// Absolute windows logging path
	private String WIN_LOG_DIR = "C:/Temp";
	private String WIN_LOG_PATH = "C:/Temp/motion_log.log";
	// Absolute unix logging path
//	private String UNIX_LOG_DIR = "/home/artiom";
//	private String UNIX_LOG_PATH = "/home/artiom/motion_log.log";
	private String UNIX_LOG_DIR = "/var/log";
	private String UNIX_LOG_PATH = "/var/log/motion_log.log";
	private boolean is_win = false;
	
	MsgLogger() {
		// Initilize logger
		logger = Logger.getLogger("MotionLog");
		init_logging();
	}
	
	// Initilize logging 
	private void init_logging() {
		try {
			// Some preparations
		    check_distro();
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
	
	// Check if *_LOG_DIR exists
	private void check_dir() {
	    (new File(WIN_LOG_DIR)).mkdir();
	}
	
	// Check PC distribution
	private void check_distro() { 
	    String distro_name = System.getProperty("os.name");
	    if (distro_name == "Windows") {
	        LOG_DIR = WIN_LOG_DIR;
	        LOG_PATH = WIN_LOG_PATH;
	        is_win = true;
	    } else {
	        LOG_DIR = UNIX_LOG_DIR;
	        LOG_PATH = UNIX_LOG_PATH;
	        is_win = false;
	    }
	}
	
	// Write log to file
	public void write_log(String log) {
		logger.info(log);
	}	
}
