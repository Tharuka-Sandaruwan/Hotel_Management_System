package Classes;

import java.sql.*;
import javax.swing.JOptionPane;

import UI.*;

public class main {

    public static void main(String[] args) {
        databaseConnections conCheck = new databaseConnections();
       
        if (conCheck.DBconnectionVerify()) {
                java.awt.EventQueue.invokeLater(new Runnable() { public void run() { new mainInterface().setVisible(true); }});

        }

    }

}
