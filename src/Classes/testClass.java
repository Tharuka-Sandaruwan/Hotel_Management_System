
package Classes;

import java.text.DecimalFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;






public class testClass {

    
    public static void main(String[] args) {
        
//         ArrayList<String>  allRoomsSelected = new ArrayList<String>();
//            allRoomsSelected.addAll(globalVars.premiumSelected);
//            allRoomsSelected.addAll(globalVars.royalSelected);
//            allRoomsSelected.addAll(globalVars.exeSelected);
//
//            System.out.println(globalVars.premiumSelected);

//databaseConnections testing = new databaseConnections();
//testing.assignStaffAutomatic("C1");
//
//        String number = "1000500000";
//double amount = Double.parseDouble(number);
//DecimalFormat formatter = new DecimalFormat("#,###.00");
//
//System.out.println(formatter.format(amount));


//        System.out.println(dataValidator.monetaryValue(2000514.12));
        
DateTimeFormatter dtf = DateTimeFormatter.ofPattern("uuuu/MM/dd HH:mm:ss");
LocalDateTime now = LocalDateTime.now();
        System.out.println(dtf.format(now));
            }
}
