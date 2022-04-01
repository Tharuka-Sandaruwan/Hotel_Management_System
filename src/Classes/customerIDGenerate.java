
package Classes;

import static Classes.DBCredentials.connectString;
import static Classes.DBCredentials.password;
import static Classes.DBCredentials.username;

import java.sql.*;
import javax.swing.JOptionPane;


public class customerIDGenerate {
    ///
     public String newCustID() {
            Connection con = null;
            String newID = null;
            
        try {
  
            String lastID = null;
            con = DriverManager.getConnection(connectString, username, password);
            
            Statement statement;
            statement = con.createStatement();
            
            
            ResultSet rs = statement.executeQuery("SELECT Customer_ID FROM hotelmanagementsystem.customer ORDER BY Customer_ID DESC LIMIT 1;");
  
            while (rs.next()) {
                lastID = rs.getString(1);
            }
             
           con.close();
           
            if (lastID == null) {
                newID = "C1";
            }
            else{
            Integer lastCustNo = Integer.parseInt(lastID.substring(1));
            lastCustNo++;
            return "C"+lastCustNo;
            
            }
           
          

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Exception occured : "+ e,"SQL exception",JOptionPane.ERROR_MESSAGE); 

          
        } 
         return newID;

        
     }
  
}
     
     

