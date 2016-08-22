package tcpServer;

import java.io.File;
import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

/*
 * Simple message logger
 * Singelton
 */
public class LogWriter extends Writer {
	
    private static LogWriter instance = null;
    
	private static Logger logger;
	// Simple file logging handler
	private static FileHandler fh;
	
	// class cannot be initiated
	private LogWriter() {}
	
	public static LogWriter getInstance() {
	    if (instance == null) {
	        instance = new LogWriter();
	        logger = Logger.getLogger("MotionLog");
	    }
	    return instance;
	}

    @Override
    public void init() {
        try {
            logger = Logger.getLogger("MotionLog");
            // Some preparations
            instance.check_distro();
            instance.check_dir();
            
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

    @Override
    protected void write(String msg) {
        logger.info(msg);
    }	
}
