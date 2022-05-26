
package Classes;


import java.sql.*;
import javax.swing.JOptionPane;

import static Classes.DBCredentials.connectString;
import static Classes.DBCredentials.password;
import static Classes.DBCredentials.username;
import java.util.ArrayList;
import java.util.Arrays;

public class databaseConnections {

    
    //con checking
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
    
  
        // method to connect to database with message output
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
            JOptionPane.showMessageDialog(null, "Exception occured : "+ e,"SQL exception",JOptionPane.ERROR_MESSAGE); //Display dialogue box

          
        } 
    
    }
    
    // method to connect to database without any message output
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
            JOptionPane.showMessageDialog(null, "Exception occured : "+ e,"SQL exception",JOptionPane.ERROR_MESSAGE); //Display dialogue box

          
        } 
    
    }
    
    // used to get the customer id from the database customer table
    public  String getCustID(String fullName){
    Connection con = null;
    String custID = null;
        try {
            
            //starts the database connection
            con = DriverManager.getConnection(connectString, username, password);
            
            System.out.println("connected!");

            // creates a statement object  
            Statement statement;
            statement = con.createStatement();

            
            ResultSet rs = statement.executeQuery("SELECT Customer_ID FROM hotelmanagementsystem.customer WHERE CONCAT(First_Name,' ',Last_Name) = '"+fullName+"';");
            while (rs.next()) {
                custID =rs.getString(1);
            }
             con.close();

            
             
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Exception occured : "+ e,"SQL exception",JOptionPane.ERROR_MESSAGE); //Display dialogue box

          
        }
        
    
     return custID;
    
    
    }
    
    // ArrayList<String>  allRoomsSelected = new ArrayList<String>();
    //        allRoomsSelected.addAll(globalVars.premiumSelected);
    
    
    //used to get all the reserved rooms as an arraylist from the reservationroom table
    public  ArrayList<String> getRooms(String resID){
      Connection con = null;
    ArrayList<String>  roomList = new ArrayList<String>();
        try {
            
            //starts the database connection
            con = DriverManager.getConnection(connectString, username, password);
            
            System.out.println("connected!");

            // creates a statement object  
            Statement statement;
            statement = con.createStatement();

            
            ResultSet rs = statement.executeQuery("SELECT Room_Number FROM hotelmanagementsystem.reservationroom WHERE Reservation_ID = '"+resID+"';");
            while (rs.next()) {
                roomList.addAll(Arrays.asList(rs.getString(1)));
            }
             con.close();

            
             
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Exception occured : "+ e,"SQL exception",JOptionPane.ERROR_MESSAGE); //Display dialogue box

          
        }
    
        return roomList;
    }
    
    
    
     public  ArrayList<String> getRoomsByCustId(String custId){
      Connection con = null;
    ArrayList<String>  roomList = new ArrayList<String>();
        try {
            
            //starts the database connection
            con = DriverManager.getConnection(connectString, username, password);
            
            System.out.println("connected!");

            // creates a statement object  
            Statement statement;
            statement = con.createStatement();

            
            ResultSet rs = statement.executeQuery("SELECT Room_Number FROM hotelmanagementsystem.bill_rooms_charges WHERE Customer_ID = '"+custId+"';");
            while (rs.next()) {
                roomList.addAll(Arrays.asList(rs.getString(1)));
            }
             con.close();

            
             
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Exception occured : "+ e,"SQL exception",JOptionPane.ERROR_MESSAGE); //Display dialogue box

          
        }
    
        return roomList;
    }
    
    
    
    
    
    
    
    
    
}
