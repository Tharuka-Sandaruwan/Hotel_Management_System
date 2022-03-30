package Classes;

import java.sql.*;
import javax.swing.JOptionPane;
import static Classes.databaseConnections.connectString;
import static Classes.databaseConnections.username;
import static Classes.databaseConnections.password;
import UI.*;

public class main {

    public static void main(String[] args) {
        
            

                Connection con = null;
                try {
                    con = DriverManager.getConnection(connectString, username, password);

                    System.out.println("connected!");

                    con.close();

                    java.awt.EventQueue.invokeLater(new Runnable() { public void run() { new mainInterface().setVisible(true); }});

                } catch (SQLException e) {
                    JOptionPane.showMessageDialog(null, "Cannot Connect to the database! Please check the connection to the database. " + e, "SQL exception", JOptionPane.ERROR_MESSAGE); //Display dialogue box

                }

            
        

    }

}
