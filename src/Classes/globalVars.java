
package Classes;

// this clss is used to store global variables like the currently selected customer id

import java.util.ArrayList;

public class globalVars {
    
    public static String selectedCustID ; // store selected customer id
    
    //used when updating the phone table
    public static String previousPhoneNum1 ;
    public static String previousPhoneNum2 ;
  
    public static String lastlyAddedNIC = "NIC"; // stores nic as string because the matches method gives error when it is null
    public static String selectedNIC = "Selected NIC"; // dumb value to avoid getting crashed
    
   
    // used to remove the added rooms from the available rooms temporarily
    public static ArrayList<String>  premiumSelected = new ArrayList<String>();
    public static ArrayList<String>  royalSelected = new ArrayList<String>();
    public static ArrayList<String>  exeSelected = new ArrayList<String>();
    
    
    public static boolean isStaffLoaded = false;
    //variable to store the total amount
    
    
    public static String CustIdBill ;
    public static String liableChargesBill;
    public static double totalChargesBill = 0.0;

    
    
    public static double totalRoomCharges = 0.0;
    public static double totalPackagecharge = 0.0;

    

    
    
   

}


