import java.util.InputMismatchException;
import java.util.Scanner;

public class A {
    static int timeFlag = 1;
    static int distanceFlag = 5;
    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.print("______Frog Game______\nSelect Time(press 1) or Distance(press 2) (other for exit)  :- ");
            int getSlection = scanner.nextInt();
            if (getSlection == 2 || getSlection == 1) {
                if (getSlection == 1) {
                    System.out.print("Enter the time Frog jumps ?");
                    int time =scanner.nextInt();
                    int distance =0 ;
                    while (time > 0) {
                        distance += distanceFlag;
                        distanceFlag = (distanceFlag == 5) ? 3 : (distanceFlag == 3) ? 1 : 5;
                        time -= timeFlag;
                        timeFlag = (timeFlag == 1) ? 2 : (timeFlag == 2) ? 5 : 1;
                    }
                    System.out.println("Distane that take "+distance);
                } else {
                    System.out.println("Enter the distance Frog goes ?");
                    int distance = scanner.nextInt();
                    int time = 0;
                    while (distance > 0) {
                        distance -= distanceFlag;
                        distanceFlag = (distanceFlag == 5) ? 3 : (distanceFlag == 3) ? 1 : 5;
                        time += timeFlag;
                        timeFlag = (timeFlag == 1) ? 2 : (timeFlag == 2) ? 5 : 1;
                    }
                    System.out.println(time);
                }
                scanner.close();
            }
        } catch (InputMismatchException e) {
            System.out.println("Please Enter valid number input only !");
        }catch(java.lang.Exception e){
            System.out.println("something went wrong !");
        }
    }
}
