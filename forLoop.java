
import java.util.Scanner;
public class forLoop
{
    public static void man(String[] args){
        Scanner object = new Scanner(System.in);
        System.out.println("Welcome to the Fibonacci Adder");
        System.out.println("To quit, end a non-integer number or string\n");
        int num;
        
        while(true) {
            System.out.print("How many Fibonacci numbers should be summed? >> ");
                if (object.hasNextInt()){
                num = object.nextInt();
                int sum = 0;
                long prev = 0;
                long count = 1;
                for(int k = 2; k<= num; k++) {
                    sum += count;
                    long add = prev + count;
                    prev = count;
                    count = add;
            
                }
                System.out.println("The sum of the first "+ num +" Fibonacci numbers is: " + sum + "\n");
                
            } else {
                System.out.print("\nThank You for Using the Fibonacci Adder");
                break;
            }
        }
    } 
} 