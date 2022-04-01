
package Classes;
import java.sql.*;
import javax.swing.JOptionPane;

public class databaseConnections {
     //below are default database credentials
    //change below if you need to use a different database.
    public static final String username = "root";
    public static final String password = "t00rbada!";
    public static final String connectString = "jdbc:mysql://localhost:3306/hotelmanagementsystem";
    
    
    
    // make a con checker method to insert to main method
    
    
  
    
    public void databaseConnection(String query,String successMessage,String messageBoxTitle) {
            Connection con = null;
        try {
            
            
            
            //starts the database connection
            con = DriverManager.getConnection(connectString, username, password);
            
            System.out.println("connected!");

            // creates a statement object  
            Statement statement;
            statement = con.createStatement();
            
            
            statement.executeUpdate(query);
            
            
            /*
            ResultSet rs = statement.executeQuery("select * from electronic_table");
            while (rs.next()) {
                System.out.println(rs.getString(1) + "  " + rs.getString(2) + "  " + rs.getInt(3));
            }
            */
            
             con.close();
            
           JOptionPane.showMessageDialog(null, successMessage,messageBoxTitle,JOptionPane.INFORMATION_MESSAGE);


        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Exception occured : "+ e,"SQL exception",JOptionPane.INFORMATION_MESSAGE); //Display dialogue box

          
        } 
    
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
