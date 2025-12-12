import java.util.Date;
import java.sql.*;

public class LaunchDate {
    // util, sql
    // java 8 - JODA API -- Nnew date time API -- time package
   public static void main(String[] args) {
     Date date = new Date(); // Date class of util package will return both date and time
     System.out.println(date);
     System.out.println(date.getDate());

     long bigTime = 242343423;
     Date date1 = new Date(bigTime);
     System.out.println(date1);
     date1.getTime();
     System.out.println(date1.getMonth());
    
     // util and sql 
    
   }
    
    
}
