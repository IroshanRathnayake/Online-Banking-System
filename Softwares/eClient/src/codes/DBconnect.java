
package codes;

import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;


public class DBconnect {
    
    public static Connection connect(){
        
        Connection conn = null;
        
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = (Connection) DriverManager.getConnection("jdbc:mysql://sql12.freemysqlhosting.net:3306/sql12343595","sql12343595","JJphbhNgQv");
        } catch (Exception e) {
          
            JOptionPane.showMessageDialog(null, e);
        }
        
        
        return conn;
    }
    
}
