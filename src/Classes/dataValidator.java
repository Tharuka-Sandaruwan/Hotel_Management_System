package Classes;

import java.util.regex.*;

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

    public static boolean PhoneNumberValidator(String phoneNum) {
        if (phoneNum.length() >= 10 && phoneNum.matches("[0-9]+")) {
            return true;
        } else {

            return false;

        }
    }

    public static boolean eMailValidator(String mail) {

        String regex1 = "^[\\w!#$%&'*+/=?`{|}~^-]+(?:\\.[\\w!#$%&'*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}";
        String regex2 = "^[A-Za-z0-9+_.-]+@(.+)$";
        Pattern pattern1 = Pattern.compile(regex1);
        Pattern pattern2 = Pattern.compile(regex2);

      
        Matcher matcher1 = pattern1.matcher(mail);
        Matcher matcher2 = pattern2.matcher(mail);
        return matcher1.matches() && matcher2.matches();

    }

}
