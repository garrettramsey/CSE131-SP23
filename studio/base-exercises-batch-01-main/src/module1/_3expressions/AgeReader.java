package module1._3expressions;

import java.util.Scanner;
public class AgeReader {
    public static void main(String[] args) {
        int age;
        Scanner scan = new Scanner(System.in);
        
        System.out.println("How old are you?");
        age = scan.nextInt();
        System.out.println(age + " is a great age!");
        
    }
}

