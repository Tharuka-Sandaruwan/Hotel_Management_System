
package Classes;

import static Classes.DBCredentials.connectString;
import static Classes.DBCredentials.password;
import static Classes.DBCredentials.username;

import java.sql.*;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;


public class CustomerIdComboGenerator {

public static void loadUserName(JComboBox comboBox){
    Connection con = null;
    try {
           con = DriverManager.getConnection(connectString, username, password);
            
            Statement statement;
            statement = con.createStatement();
            
            
            ResultSet rs = statement.executeQuery("SELECT Customer_ID  FROM hotelmanagementsystem.customer;");
          
            
            while(rs.next()){
        String cusID = rs.getString(1);
        comboBox.addItem(cusID);
}
        
    } catch (Exception e) {
           JOptionPane.showMessageDialog(null, "Exception occured : "+ e,"SQL exception",JOptionPane.ERROR_MESSAGE); 
    }
  

    
}
    

}
/*
       try {
String sql=”SELECT * FROM userinfo”;
pst=conn.prepareStatement(sql);
rs = pst.executeQuery(sql);
while(rs.next()){
String fname = rs.getString(“FirstName”);
String lname = rs.getString(“LastName”);
String name = fname + ” ” + lname;
jComboBox1.addItem(name);
}
}catch(SQLException e) {
JOptionPane.showMessageDialog(this, e.getMessage());
}
*/