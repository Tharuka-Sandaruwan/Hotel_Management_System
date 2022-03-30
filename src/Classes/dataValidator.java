package Classes;

//used to validate data when entering
public class dataValidator {

    public static boolean NICvalidator(String nicNumber) {
        if (nicNumber.length() == 12 && nicNumber.matches("[0-9]+")
                && Integer.parseInt(nicNumber.substring(4, 7)) < 867) {
            return true;
        } else if (nicNumber.length() == 10 && nicNumber.indexOf("V") == 9
                && nicNumber.matches("[0-9]+(.*)V")
                && Integer.parseInt(nicNumber.substring(2, 5)) < 867) {
            return true;
        } else {
            return false;

        }
      
    }
    
    public static boolean PhoneNumberValidator(String phoneNum){
    if (phoneNum.length() >= 10 && phoneNum.matches("[0-9]+")){
        return true;
    }else{
    
        return false;

    }
    
    }
    
    
    

}
