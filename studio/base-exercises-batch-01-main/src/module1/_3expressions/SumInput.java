package module1._3expressions;

import java.util.Scanner;
public class SumInput {
    public static void main(String[] args) {
        int num1, num2;
        Scanner scan = new Scanner(System.in);
        
        
        System.out.println("Enter first number");
        num1= scan.nextInt();
        System.out.println("Enter second number");
        num2= scan.nextInt();
        System.out.println("Sum is " + num1 + num2);

    }
}
