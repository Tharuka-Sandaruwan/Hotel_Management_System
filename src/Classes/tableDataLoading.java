
package Classes;

import java.sql.*;

import javax.swing.*;
import javax.swing.table.*;


public class tableDataLoading {
    
    // this method can be used to load any table which contain all the data in the single table directly.NEED TO MODIFY THE RESULT SET ARRAY SIZE!!
     public static void tableRefresh(TableModel tableNameModel){
            Connection con = null;
        try {
            
            
            
            //starts the database connection
            con = DriverManager.getConnection(DBCredentials.connectString, DBCredentials.username, DBCredentials.password);
            
            System.out.println("connected!");

            // creates a statement object  
            Statement statement;
            statement = con.createStatement();
            
                       

            ResultSet rs = statement.executeQuery("select * from hotelmanagementsystem.customer");
            
            DefaultTableModel tblModel= (DefaultTableModel)tableNameModel;
            tblModel.setRowCount(0);
            
            
            
            while (rs.next()) {
                //System.out.println(rs.getString(1) + "  " + rs.getString(2) + "  " + rs.getInt(3));
                // NEED TO ADD OTHER STRINGS TO THIS QUERY
                String tblData[] = {rs.getString(1),rs.getString(2),rs.getString(3)};
                              
                tblModel.addRow(tblData);
                
            }
            
            
            
            con.close();

        } catch (SQLException e) {
            
            JOptionPane.showMessageDialog(null, "Exception occured : "+ e); //Display dialogue box
            
        }
    
    }
    
     //OBSOLETE!!!used to get the resultset output from executing the select command
     private ResultSet getQueryResultSELECT(TableModel tableNameModel){
             Connection con = null;
             ResultSet rs = null;
        try {
     
            con = DriverManager.getConnection(DBCredentials.connectString, DBCredentials.username, DBCredentials.password);
            
            System.out.println("connected!");

            // creates a statement object  
            Statement statement;
            statement = con.createStatement();
            
            rs = statement.executeQuery("SELECT * FROM hotelmanagementsystem.customerpanejava;");
       
            con.close();
            
            

        } catch (SQLException e) {
            
            JOptionPane.showMessageDialog(null, "Exception occured : "+ e); //Display dialogue box
            
        }
            return rs;
     }
     
          
     //method to refresh customer table as it loads data from seperate tables into one
     public static void customerTableRefresh(TableModel custTableModel){
            Connection con = null;
        try {
            
            
            
            
            con = DriverManager.getConnection(DBCredentials.connectString, DBCredentials.username, DBCredentials.password);
            
            System.out.println("connected!");

            // creates a statement object  
            Statement statement;
            statement = con.createStatement();
            
                       

            ResultSet rs = statement.executeQuery("SELECT * FROM hotelmanagementsystem.customerpanejava;");
            
            DefaultTableModel tblModel= (DefaultTableModel)custTableModel;
            tblModel.setRowCount(0);
            
            
            
            while (rs.next()) {
                
                
                String tblData[] = {rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8),rs.getString(9)};
                              
                tblModel.addRow(tblData);
                
            }
            
            
            
            con.close();

        } catch (SQLException e) {
            
            JOptionPane.showMessageDialog(null, "Exception occured : "+ e); //Display dialogue box
            
        }
    
    }
     
     
     public static void roomTypeTblRefresh(TableModel tableNameModel,String tableName){
            Connection con = null;
        try {
            
            
            
            //starts the database connection
            con = DriverManager.getConnection(DBCredentials.connectString, DBCredentials.username, DBCredentials.password);
            
            System.out.println("connected!");

            // creates a statement object  
            Statement statement;
            statement = con.createStatement();
            
                       

            ResultSet rs = statement.executeQuery("select * from "+tableName);
          
            DefaultTableModel tblModel= (DefaultTableModel)tableNameModel;
            tblModel.setRowCount(0);
            
            
            
            while (rs.next()) {
                //System.out.println(rs.getString(1) + "  " + rs.getString(2) + "  " + rs.getInt(3));
                // NEED TO ADD OTHER STRINGS TO THIS QUERY
                String tblData[] = {rs.getString(1),rs.getString(2),rs.getString(3)};
                              
                tblModel.addRow(tblData);
                
            }
            
            
            
            con.close();

        } catch (SQLException e) {
            
            JOptionPane.showMessageDialog(null, "Exception occured : "+ e); //Display dialogue box
            
        }
    
    }
     
    // public static void tableCleaner()
}
