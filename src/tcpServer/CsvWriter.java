package tcpServer;

import java.io.FileWriter;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.Date;

public class CsvWriter extends Writer {
    
    private static CsvWriter instance = null;
    private FileWriter fw = null;
    
    private final String NEW_LINE_SEPARATOR = "\n";
    private final String COMMA_DELIMITER = ",";
    
    private CsvWriter() {}
    
    public static CsvWriter getInstance() {
        if(instance == null) {
            instance = new CsvWriter();
        }
        return instance;
    }
    
    @Override
    public void init() {
        try {            
            instance.check_distro();
            instance.check_dir();
            // if file doesnt exists, then create it
            fw = new FileWriter(CSV_PATH, true);
            fw.append("TS, MSG");
            fw.append(NEW_LINE_SEPARATOR);
            // TODO do not create header if file exists
            
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } 
            finally {
            try {
                fw.flush();
                //fw.close();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }
    
    @Override
    public void write(String msg) {
        try {
            fw.append(String.valueOf(new Timestamp((new Date()).getTime())));
            fw.append(COMMA_DELIMITER);
            fw.append(msg);
            fw.append(NEW_LINE_SEPARATOR);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            try {
                fw.flush();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }
    
}