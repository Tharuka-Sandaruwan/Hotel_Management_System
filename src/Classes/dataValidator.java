package Classes;

import UI.mainInterface;
import com.toedter.calendar.JDateChooser;
import com.toedter.calendar.JTextFieldDateEditor;
import java.awt.Color;
import java.util.regex.*;
import javax.swing.JCheckBox;
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

        
        String phoneNumPatterns 
      = "^(\\+\\d{1,3}( )?)?((\\(\\d{3}\\))|\\d{3})[- .]?\\d{3}[- .]?\\d{4}$" 
      + "|^(\\+\\d{1,3}( )?)?(\\d{3}[ ]?){2}\\d{3}$" 
      + "|^(\\+\\d{1,3}( )?)?(\\d{3}[ ]?)(\\d{2}[ ]?){2}\\d{2}$";


        Pattern pattern = Pattern.compile(phoneNumPatterns);
    
        Matcher matcher = pattern.matcher(phoneNum);
  
            
        
        if (phoneNum.length() >= 10 &&  matcher.matches()) 
        {
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
    
    //method to validate only one from kids or adults
    public static boolean oneValidator(JTextField KidOrAdult){
        if((KidOrAdult.getText().matches("[0-9]+") && Integer.parseInt(KidOrAdult.getText()) < 255) || KidOrAdult.getText().matches(""))
        {
            KidOrAdult.setBorder(mainInterface.Bordergood());
            return true; 
        }else {
            KidOrAdult.setBorder(mainInterface.BorderError());
            return false;
        }
        
        }
    
    //method which checks both kids or adults valid.USE THIS WHEN NEED TO VALIDATE BOTH AT THE SAME TIME
    public static boolean adultKidsValidate(JTextField adults,JTextField kids){
       
        
        
        if (adults.getText().matches("") && kids.getText().matches("")) {
           adults.setBorder(mainInterface.BorderError());
            return false;
        }else{
            return (oneValidator(kids) && oneValidator(adults));

        }
       
    }
    
    
    
    public static boolean DateValidator(JDateChooser dateSelectorName){
    JTextFieldDateEditor textPart = (JTextFieldDateEditor) dateSelectorName.getDateEditor();
    
        if (textPart.getDate() == null) {
            textPart.setBorder(mainInterface.BorderError());
            return false;
        }else{
            textPart.setBorder(mainInterface.Bordergood());
            return true;
        }
    
    
    }
    
    
    //IMPLEMENT FUNCTIONALITY TO CHECK IF TICKED,TEXTBOX IS NOT EMPTY
    //used to check whether the user selected the rooms from the table to the relevent category he/she ticked
    public static boolean isRoomAssigned(JCheckBox premiumTik,JTextField premiumTxt,JCheckBox royalTik,JTextField royalTxt,JCheckBox executTik,JTextField executTxt){
    // ^(?!\s*$).+
        
        
        if (premiumTik.isSelected() && premiumTxt.getText().matches("^(?!\\s*$).+")) {
            
            if (true) {
                
            }
            premiumTxt.setBorder(mainInterface.Bordergood());
            premiumTik.setForeground(Color.BLACK);
            royalTxt.setBorder(mainInterface.Bordergood());
            royalTik.setForeground(Color.BLACK);
            executTxt.setBorder(mainInterface.Bordergood());
            executTik.setForeground(Color.BLACK);
            return true;
        }else if (royalTik.isSelected() && royalTxt.getText().matches("^(?!\\s*$).+")) {
            premiumTxt.setBorder(mainInterface.Bordergood());
            premiumTik.setForeground(Color.BLACK);
            royalTxt.setBorder(mainInterface.Bordergood());
            royalTik.setForeground(Color.BLACK);
            executTxt.setBorder(mainInterface.Bordergood());
            executTik.setForeground(Color.BLACK);
            return true;
        }else if (executTik.isSelected() && executTxt.getText().matches("^(?!\\s*$).+")) {
            premiumTxt.setBorder(mainInterface.Bordergood());
            premiumTik.setForeground(Color.BLACK);
            royalTxt.setBorder(mainInterface.Bordergood());
            royalTik.setForeground(Color.BLACK);
            executTxt.setBorder(mainInterface.Bordergood());
            executTik.setForeground(Color.BLACK);
            return true;
        }
        else{
            executTxt.setBorder(mainInterface.BorderError());
            executTik.setForeground(Color.red);
            royalTxt.setBorder(mainInterface.BorderError());
            royalTik.setForeground(Color.red);
            premiumTxt.setBorder(mainInterface.BorderError());
            premiumTik.setForeground(Color.red);
            return false;
        }
        
    }
    
    
    
    

}
