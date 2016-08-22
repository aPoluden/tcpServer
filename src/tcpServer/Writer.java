package tcpServer;

import java.io.File;

public abstract class Writer {
    
    protected static String LOG_DIR = "";
    protected static String LOG_PATH = "";
    
    protected static String CSV_DIR = "";
    protected static String CSV_PATH = "";
    
    // Absolute windows logging path
    protected static String WIN_LOG_DIR = "C:/Temp";
    protected static String WIN_LOG_PATH = "C:/Temp/motion_log.log";
    // Absolute unix logging path
    protected static String UNIX_LOG_DIR = "/home/artiom";
    protected static String UNIX_LOG_PATH = "/home/artiom/motion_log.log";
    
    protected static String WIN_CSV_DIR = "C:/Temp";
    protected static String WIN_CSV_PATH = "C:/Temp/motion_log.txt";
    
    protected static String UNIX_CSV_DIR = "/home/artiom";
    protected static String UNIX_CSV_PATH = "/home/artiom/motion_log.txt";
    
//    protected static String UNIX_CSV_DIR = "/var/log";
//    protected static String UNIX_CSV_PATH = "/var/log/motion_log.txt";
    
//  private String UNIX_LOG_DIR = "/var/log";
//  private String UNIX_LOG_PATH = "/var/log/motion_log.log";
    protected static boolean is_win = false;
    
    // Prepare data writing
    protected abstract void init();
    
    // Writes data to file
    protected abstract void write(String msg);
    
    protected void check_dir() {
        (new File(LOG_DIR)).mkdir();
        (new File(CSV_DIR)).mkdir();
    }
    
    protected void check_distro() {
        String distro_name = System.getProperty("os.name");
        if (distro_name == "Windows") {
            // Log
            LOG_DIR = WIN_LOG_DIR;
            LOG_PATH = WIN_LOG_PATH;
            // Csv
            CSV_DIR = WIN_CSV_DIR;
            CSV_PATH = "WIN_CSV_PATH";
            is_win = true;
        } else {
            // Log
            LOG_DIR = UNIX_LOG_DIR;
            LOG_PATH = UNIX_LOG_PATH;
            // Csv
            CSV_DIR = UNIX_CSV_DIR;
            CSV_PATH = UNIX_CSV_PATH;
            is_win = false;
        }
    }
    
}
