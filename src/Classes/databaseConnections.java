
package Classes;
import java.sql.*;
import javax.swing.JOptionPane;

public class databaseConnections {
     //below are default database credentials
    //change below if you need to use a different database.
    private static final String username = "root";
    private static final String password = "t00rbada!";
    private static final String connectString = "jdbc:mysql://localhost:3306/hotelmanagementsystem";
    
    
    
    // make a con checker method to insert to main method
    public boolean DBconnectionVerify(){
       Connection con = null;
                try {
                    con = DriverManager.getConnection(connectString, username, password);

                    con.close();
                    return true;


                } catch (SQLException e) {
                    JOptionPane.showMessageDialog(null, "Cannot Connect to the database! Please check the connection to the database. " + e, "SQL exception", JOptionPane.ERROR_MESSAGE); //Display dialogue box
                    return false;
                }
       
    }
    
  
    
    public void databaseConnectionMessage(String query,String successMessage,String messageBoxTitle) {
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
    
    
    public void databaseConnectionNoMessage(String query) {
            Connection con = null;
        try {
  
            //starts the database connection
            con = DriverManager.getConnection(connectString, username, password);
            
            System.out.println("connected!");

            // creates a statement object  
            Statement statement;
            statement = con.createStatement();

            statement.executeUpdate(query);

             con.close();


        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Exception occured : "+ e,"SQL exception",JOptionPane.INFORMATION_MESSAGE); //Display dialogue box

          
        } 
    
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
