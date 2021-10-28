package fecha;


import static com.sun.org.apache.xalan.internal.lib.ExsltDatetime.date;
import static com.sun.org.apache.xalan.internal.lib.ExsltDatetime.date;
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;


public class Fecha {
public String getDate() {
    Date date = new Date();    
    SimpleDateFormat dateFormat = new SimpleDateFormat("YYYY/MM/dd");
    return (dateFormat.format(date));  
    }





}

