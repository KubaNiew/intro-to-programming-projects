import java.util.Scanner;

public class whileLoop
{
    public static void main(String[] args){
        Scanner object = new Scanner(System.in);
        
        System.out.println("Welcome to the Fibonacci Sequence Detector\n\n\n");
        int num;
        
        
        while(true) {
            System.out.print("Please input a number for analysis >> ");
            if (object.hasNextInt()){
                num = object.nextInt();
                if (num < 0) {
                    System.out.println("Input must be positive");
                } else {
                int j = 0;
                int i = 1;
                int k = 2;
                int sum = j + i;
                int count = 1;
                int nextNumber = num + i;
                int beforeCount = i - 1;
                int nextCount = k;
                
                 
                if (num == i){
                    System.out.println(num + " is a Fibonacci number whose order in the sequence is both "+ nextNumber +" and " +  (nextNumber + i) + "\n" );
                } else {
                    
                while (j < num) {
                    sum = j + i;
                    j = i;
                    i = sum;
                    beforeCount = count;
                    count++;
                }
                
                if (j == num) {
                    System.out.println(num + " is a Fibonacci number whose order in the sequence is " + count + "\n");
                } else {
                    System.out.println(num + " is not a Fibonacci number");
                     
                    int previousFibonacci = sum - j;
                    
                    int nextFibonacci = j;
                    nextCount = count;
                    
                    
                    
                    
                    System.out.println("However, it lies between Fibonacci numbers "+ previousFibonacci +" (order: "+ beforeCount +") and "+ nextFibonacci +" (order: "+ nextCount +")\n");
                } 
                
                
            
                
        
            
                }
                
                
                } 
            } else {
                System.out.print("Thank You for Using the Fibonacci Sequence Detector");
                break;
            }
        }
    }
}