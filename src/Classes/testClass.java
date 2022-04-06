
package Classes;

import java.util.ArrayList;






public class testClass {

    
    public static void main(String[] args) {
        
         ArrayList<String>  allRoomsSelected = new ArrayList<String>();
            allRoomsSelected.addAll(globalVars.premiumSelected);
            allRoomsSelected.addAll(globalVars.royalSelected);
            allRoomsSelected.addAll(globalVars.exeSelected);

            System.out.println(globalVars.premiumSelected);
        
            }
}
