
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.lang.Exception;

public class ExceptionExample {
    public static void main(String[] args) {
        //syntax of try catch
        try {
        } catch (Exception e) {
        }

        try {
        } finally {
            System.out.println("ishan");
        }

        try {
        } catch (ArithmeticException e) {
        } catch (NullPointerException e) {
        } catch (Exception e) {
        }

        try {
        } catch (ArithmeticException e) {
        } catch (NullPointerException e) {
        } catch (Exception e) {
        } finally {
        }

        //difference between checked and unchecked exception(Examples only not best practises)
        //unchecked- runtime check
        try {
            int i = 10 / 0;
        } catch (ArithmeticException e) {
        }
        //checked- compile time check
        try {
            FileReader fileReader = new FileReader("abc");
        } catch (FileNotFoundException e) {
        }

//Custome Exception
        try {
            canIBuyLiquor(14);
        } catch (BuyLiquorException e) {
            System.out.println(e);
        }

//cant catch a Parent Exception  from child Exception
        try {
            throw new RuntimeException();
        } catch (IndexOutOfBoundsException ex) {
            System.out.println("IndexOutOfBoundsException");
        }
     //rethrow exceptions
        createFile();

    }

    public static void createFile() {
        try {
            FileReader fileReader = new FileReader("");
        } catch (FileNotFoundException e) {
            throw new RuntimeException("Access is denied to C drive try another drive!");
        }

    }

    public static void canIBuyLiquor(int age) throws BuyLiquorException {
        if (age > 18) {
            System.out.println("You can buy !");
        } else {
            throw new BuyLiquorException("Go to School not to Bar !");
        }
    }
}

class BuyLiquorException extends Exception {
    BuyLiquorException(String error) {
        super(error);
    }
}
