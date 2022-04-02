
package Classes;

import java.sql.*;

import javax.swing.*;
import javax.swing.table.*;


public class tableDataLoading {
    
     public static void tableRefresh(TableModel tableName){
            Connection con = null;
        try {
            
            
            
            //starts the database connection
            con = DriverManager.getConnection(DBCredentials.connectString, DBCredentials.username, DBCredentials.password);
            
            System.out.println("connected!");

            // creates a statement object  
            Statement statement;
            statement = con.createStatement();
            
                       

            ResultSet rs = statement.executeQuery("select * from hotelmanagementsystem.customer");
            
            DefaultTableModel tblModel= (DefaultTableModel)tableName;
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
    
}
