package ironhack.com;
import java.util.Scanner;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Utils {

    public static String generateSerialId () {

        return UUID.randomUUID().toString();
    }

    public static int validate_number_of(Scanner scanner){
        boolean is_finish= false;

        do{
            String number_string=scanner.nextLine();
            try{
                int number= Integer.parseInt(number_string);
                return number;
            } catch (NumberFormatException e){
                System.out.println("Enter a valid number");
            }
            is_finish=true;
        }while(is_finish);
        return 0;
    }

    public static boolean validateName(String name) {
        String regex = "^[A-Za-z\\s]+";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(name);
        return matcher.matches();
    }
}
