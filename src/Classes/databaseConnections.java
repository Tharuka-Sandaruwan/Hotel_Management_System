
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
    /*
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
    
    */
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
    
    
    
     public  ArrayList<String> getUnassignedRoomsByCustId(String custId){
      Connection con = null;
    ArrayList<String>  roomList = new ArrayList<String>();
        try {
            
            //starts the database connection
            con = DriverManager.getConnection(connectString, username, password);
            
            System.out.println("connected!");

            // creates a statement object  
            Statement statement;
            statement = con.createStatement();

            
            ResultSet rs = statement.executeQuery("SELECT Room_Number FROM hotelmanagementsystem.staffunassignedrooms WHERE Customer_ID = '"+custId+"';");
            while (rs.next()) {
                roomList.addAll(Arrays.asList(rs.getString(1)));
            }
             con.close();

            
             
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Exception occured : "+ e,"SQL exception",JOptionPane.ERROR_MESSAGE); //Display dialogue box

          
        }
    
        return roomList;
    }
     
     
     
     public  ArrayList<String> getAssignedRoomsByCustId(String custId){
      Connection con = null;
    ArrayList<String>  roomList = new ArrayList<String>();
        try {
            
            //starts the database connection
            con = DriverManager.getConnection(connectString, username, password);
            
            System.out.println("connected!");

            // creates a statement object  
            Statement statement;
            statement = con.createStatement();

            
            ResultSet rs = statement.executeQuery("SELECT Room_Number FROM hotelmanagementsystem.staffassignedrooms WHERE Customer_ID = '"+custId+"';");
            while (rs.next()) {
                roomList.addAll(Arrays.asList(rs.getString(1)));
            }
             con.close();

            
             
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Exception occured : "+ e,"SQL exception",JOptionPane.ERROR_MESSAGE); //Display dialogue box

          
        }
    
        return roomList;
    }    
    
    
    
    
    public  String getEmpName(String roomNo,String table){
        String name = null;
        
         Connection con = null;
    ArrayList<String>  roomList = new ArrayList<String>();
        try {
            
            //starts the database connection
            con = DriverManager.getConnection(connectString, username, password);
            
            System.out.println("connected!");

            // creates a statement object  
            Statement statement;
            statement = con.createStatement();

            
            ResultSet rs = statement.executeQuery("SELECT Full_Name FROM hotelmanagementsystem."+table+" WHERE Room_Number = '"+roomNo+"';");
            while (rs.next()) {
                name = rs.getString(1);
            }
             con.close();

            
             
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Exception occured : "+ e,"SQL exception",JOptionPane.ERROR_MESSAGE); //Display dialogue box

          
        }
    
    
        return name;
    }
    
    // used to assign staff to the rooms automatically
    public void assignStaffAutomatic(String custId){
             
            
        String roomType;
         Connection con = null;
   
        try {
            
            //starts the database connection
            con = DriverManager.getConnection(connectString, username, password);
            
          

            // creates a statement object  
            Statement statement;
            statement = con.createStatement();
            
            ResultSet rs = statement.executeQuery("SELECT Room_Number FROM hotelmanagementsystem.staffunassignedrooms WHERE customer_id = '"+custId+"';");
            while (rs.next()) {
           
              
               roomType =  rs.getString(1).substring(0, 1); // gets only the room type part
               String roomNumber = rs.getString(1);
                
                
                if (roomType.equals("P")) { 
                 
                    
                    
                    inserToStaffRoom(roomNumber, "availableroomserv");
                    inserToStaffRoom(roomNumber, "availablemaintainclean");
                    inserToStaffRoom(roomNumber, "availablehousekeep");
         
         
          
                }else if(roomType.equals("E")){
                
                   
                    
                    inserToStaffRoom(roomNumber, "availableroomserv");
                    inserToStaffRoom(roomNumber, "availablemaintainclean");
                    inserToStaffRoom(roomNumber, "availablehousekeep"); 
                    inserToStaffRoom(roomNumber, "availableporter"); 
        
                 }else{
                  
                    
                    
                    
                    inserToStaffRoom(roomNumber, "availableroomserv");
                    inserToStaffRoom(roomNumber, "availablemaintainclean");
                    inserToStaffRoom(roomNumber, "availablehousekeep"); 
                    inserToStaffRoom(roomNumber, "availableporter");   
                    inserToStaffRoom(roomNumber, "availablehotelcon"); 
                    
                    
                    
                    
        }
                 
                
            }
            
            //SELECT * FROM hotelmanagementsystem.staffunassignedrooms where customer_id = 'C5';
         //   statement.executeQuery("SELECT Full_Name FROM hotelmanagementsystem."+table+" WHERE Room_Number = '"+roomNo+"';");
            
             con.close();
            /* 
             int count = 0;
             while (count < roomType.size()) {                
                 System.out.println(roomType.toArray()[count]);
                 System.out.println(roomType.toArray()[count].toString().substring(0, 1).equals("P"));
                 count++;
            }
*/
            
             
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Exception occured : "+ e,"SQL exception",JOptionPane.ERROR_MESSAGE); //Display dialogue box

          
        }
    
    
    }
    
    // used to inser the staff member to the room
    public void inserToStaffRoom(String roomNo,String availableStaffTypeTable){
        Connection con = null;
        Connection con2 = null;
  
        try {
            
            //starts the database connection
            con = DriverManager.getConnection(connectString, username, password);
            con2 = DriverManager.getConnection(connectString, username, password);
            
            

            // creates a statement object  
            Statement statement;
            statement = con.createStatement();

            // SELECT staff_ID FROM hotelmanagementsystem.availablehousekeep order by staff_ID asc limit 1;
            ResultSet rs = statement.executeQuery("SELECT staff_ID FROM hotelmanagementsystem."+availableStaffTypeTable+" order by staff_ID asc limit 1;");
           
            while (rs.next()) {
                
                try{
                
                
                Statement statement2;
            statement2 = con2.createStatement();
            statement2.executeUpdate("INSERT INTO hotelmanagementsystem.roomstaff values ('"+roomNo+"','"+rs.getString(1)+"');");
            con2.close();}
                
                
                catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Exception occured : "+ e,"SQL exception",JOptionPane.ERROR_MESSAGE); //Display dialogue box

          
        }
                
            }
             con.close();

            
             
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Exception occured : "+ e,"SQL exception",JOptionPane.ERROR_MESSAGE); //Display dialogue box

          
        }
        
    
     
    
        
    }
    
}
