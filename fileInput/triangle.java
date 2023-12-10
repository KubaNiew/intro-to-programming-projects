import java.util.Scanner;
import javax.swing.JOptionPane;
import java.io.*;
import javax.swing.JFileChooser;
import java.util.*;

public class triangle {
    public static int sideA = 0;
    public static int sideB = 0;
    public static int sideC = 0;

    public static void main(String[] args) {
        String fileName;
        while (true) {
            fileName = JOptionPane.showInputDialog("Enter the filename: ");

            try {
                File file = new File(fileName);
                Scanner inputFile = new Scanner(file);
                PrintWriter outputFile = new PrintWriter("output.txt");
                processFile(file, inputFile, outputFile);
                break;
            } catch (FileNotFoundException e) {
                System.out.println("File does not exist");
                JOptionPane.showMessageDialog(null, "Enter a valid file");
            

            }
        }
    }
    

    public static void processFile(File file, Scanner inputFile, PrintWriter outputFile){
        while (inputFile.hasNext()) {
            String str = inputFile.nextLine();
            if(str.startsWith("#")){
                str = str.substring(1).trim();
            }
            total++;
            Scanner scanner = new Scanner(str);

            try {

                sideA = scanner.nextInt();
                sideB = scanner.nextInt();
                sideC = scanner.nextInt();

                classifyTriangle(outputFile,sideA,sideB,sideC);

                while(scanner.hasNext()){
                    String discard = scanner.next();
                    outputFile.println("Item Discarded: " + discard);
                    wrong++;

                }
                
            } catch (InputMismatchException e){
                outputFile.println("Error - At least one of your sides is not an integer");
                wrong++;
            }  catch(NoSuchElementException e){
                outputFile.println("");
            }

        }

        summeryReport(file,outputFile);

        inputFile.close();
        outputFile.close();
        System.out.println("Output written to output.txt");

        
    }            

    
    
    //Remeber to fix assending order
    public static int numOfLines = 1;
    public static void classifyTriangle(PrintWriter outputFile, int sideA, int sideB,int sideC) {

        String typeOfTriangle;

        if (sideA == sideB && sideB == sideC) {
            typeOfTriangle = "Equalateral";

        } else if (sideA == sideB || sideB == sideC || sideA == sideC) {
            typeOfTriangle = "Iscoles";

        } else if (sideA * sideA + sideB * sideB == sideC * sideC) {
            typeOfTriangle = "right Traingle";

        } else {
            typeOfTriangle = "scalene";

        } 

        if (sideA <= 0 || sideB  <=0 || sideC <= 0) {
            outputFile.println("Error - At least one of your sides is an invalid integer value");

        } else if (sideA > sideB || sideB > sideC){
            outputFile.println("Error - Sides not in ascending order");

        }else if(sideA + sideB < sideC || sideB + sideC < sideA){
            outputFile.println("Error - Sides cannot form a valid triangle");

        } else {
            outputFile.println(numOfLines++ + ": The triangle " + sideA + ", " + sideB + ", " + sideC + " is a " + typeOfTriangle);
            area(sideA, sideB, sideC, outputFile);
        }

    }
    public static void area(double sideA, double sideB, double sideC, PrintWriter outputFile){
        double s = (sideA + sideB + sideC) / 2;
        double a = Math.sqrt(s * (s - sideA) * (s - sideB) * (s - sideC));
        outputFile.printf("The area of this triangle is   %.2f%n", a);
        right++;
    }

    public static int total = 0;
    public static int right = 0;
    public static int wrong = 0;
    public static void summeryReport(File file, PrintWriter outputFile){
        outputFile.println("EOF found\n");
        outputFile.println("File Path: " + file.getAbsolutePath());
        outputFile.println("--------------- Summary Report ---------------");

        outputFile.println("Total entries processed     = " + total);
        outputFile.println("Number of valid entries     = " + right);
        outputFile.println("Number of invalid entries   = " + wrong);

        double percentage = ((double) right / total) * 100;
        outputFile.printf("Percentage of valid entries  = %.2f%%\n", percentage);

    }
}