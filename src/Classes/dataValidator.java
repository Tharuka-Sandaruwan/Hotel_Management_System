package Classes;

import UI.mainInterface;
import java.util.regex.*;
import javax.swing.JTextField;

//used to validate data when entering
public class dataValidator {

    public static boolean NICvalidator(JTextField textFilds) {
        String nicNumber = textFilds.getText();
        
        if (nicNumber.length() == 12 && nicNumber.matches("[0-9]+")
                && Integer.parseInt(nicNumber.substring(4, 7)) < 867) {
            textFilds.setBorder(mainInterface.Bordergood());
            return true;
        } else if (nicNumber.length() == 10 && nicNumber.indexOf("V") == 9
                && nicNumber.matches("[0-9]+(.*)V")
                && Integer.parseInt(nicNumber.substring(2, 5)) < 867) {
                        textFilds.setBorder(mainInterface.Bordergood());
            return true;
        } else {
                        textFilds.setBorder(mainInterface.BorderError());
            return false;
}

    }

    public static boolean PhoneNumberValidator(JTextField textFields) {
        
        String phoneNum = textFields.getText();
        if (phoneNum.length() >= 10 && phoneNum.matches("[0-9]+")) {
            textFields.setBorder(mainInterface.Bordergood());
            return true;
        } else {
            textFields.setBorder(mainInterface.BorderError());
            return false;

        }
    }

    public static boolean eMailValidator(JTextField textFields) {
        String mail =textFields.getText();
                
        String regex1 = "^[\\w!#$%&'*+/=?`{|}~^-]+(?:\\.[\\w!#$%&'*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}";
        String regex2 = "^[A-Za-z0-9+_.-]+@(.+)$";
        Pattern pattern1 = Pattern.compile(regex1);
        Pattern pattern2 = Pattern.compile(regex2);

      
        Matcher matcher1 = pattern1.matcher(mail);
        Matcher matcher2 = pattern2.matcher(mail);
        if (matcher1.matches() && matcher2.matches()) {
           textFields.setBorder(mainInterface.Bordergood());

           return true ; 
        }
        else{
        textFields.setBorder(mainInterface.BorderError());
        return  false;
        }

    }

}
