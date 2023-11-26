import java.util.Scanner;

public class TriangleClassifier
{
    public static void main(String[] args) 
    {
        Scanner object = new Scanner(System.in);
        
        double sideA = 0;
        double sideB = 0;
        double sideC = 0;
        System.out.println("Welcome to the Triangle Classifier program");
        System.out.print("Enter the lengths of the three (3) triangle sides in ascending order >> ");
        
        
        
        if (object.hasNextInt()){
            sideA = object.nextInt();
        } else {
            System.out.print("Error - At least one of your sides is not an integer");
            return;
        } 
        
        if (object.hasNextInt()){
            sideB = object.nextInt();
        } else {
            System.out.print("Error - At least one of your sides is not an integer");
            return;
        }
        
        if (object.hasNextInt()){
            sideC = object.nextInt();
        } else {
            System.out.print("Error - At least one of your sides is not an integer");
            return;
        }
        
        
        
        
        if (sideA <= 0 || sideB <= 0 || sideC <= 0){
                System.out.print("Error - At least one of your sides is an invalid value");
                return;
        }  
        
        if (sideA > sideB || sideB > sideC){
                System.out.print("Error - Sides not in ascending order");
                return;
        } 
        
        if(sideA + sideB < sideC || sideB + sideC < sideA){
            System.out.print("Error - Sides cannot form a valid triangle");
            return;
        }
        
        String typeOfTriangle;
        
        
        if (sideA == sideB || sideB == sideC) {
            typeOfTriangle = "Equalateral";
        } else if (sideA == sideB || sideB == sideC || sideA == sideC) {
            typeOfTriangle = "Iscoles";
        } else if (sideA * sideA + sideB * sideB == sideC * sideC) {
            typeOfTriangle = "right Traingle";
        } else {
            typeOfTriangle = "scalene";
        }
        
        System.out.println("The triangle is a " + typeOfTriangle);
        
        double s = (sideA + sideB + sideC) / 2;
        double a = Math.sqrt(s * (s - sideA) * (s - sideB) * (s - sideC));
        
        System.out.printf("The area of this triangle is %.2f", + a);    
        
        
        
        
        
    
    
            
        
    
        
        
        
        

        
    }
}
