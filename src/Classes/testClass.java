
package Classes;






public class testClass {

    
    public static void main(String[] args) {
        /*
        System.out.println(Country.getcountryIndex("Sri Lanka"));
        IDGenerators news = new IDGenerators();
        System.out.println(news.newResID());
         */
         CustomerIdComboGenerator.loadCustomerName(UI.mainInterface.sampleTxtField,"C1");
      /*  Connection con;
        try {
            con = DriverManager.getConnection(connectString, username, password);
            
            Statement statement;
            statement = con.createStatement();
            
            
            ResultSet rs = statement.executeQuery("SELECT  First_Name,Last_Name FROM hotelmanagementsystem.customer WHERE Customer_ID = 'C1';");
          //First_Name,Last_Name   WHERE Customer_ID = 'C1'    SELECT  * FROM hotelmanagementsystem.customer ;                
            while(rs.next()){
        String custName = rs.getString(1) + " " + rs.getString(2);
         System.out.println(custName);
                System.out.println("asdasd");
                
}       
            
         //  System.out.println(rs.wasNull());
        } catch (SQLException ex) {
            Logger.getLogger(testClass.class.getName()).log(Level.SEVERE, null, ex);
        }
            
            */
        
        
            }
}
