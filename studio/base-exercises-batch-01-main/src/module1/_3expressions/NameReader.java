package module1._3expressions;

import java.util.Scanner;
public class NameReader {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);  

        System.out.println("Please Enter your name: ");
        String name = scan.nextLine();
        System.out.println("Hello " + name);

    }

}
