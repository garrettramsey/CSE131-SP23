package module2._02ifelse;

import java.util.Scanner;
public class DriversTest
{
   public static void main(String[] args)
   {
     Scanner scan = new Scanner(System.in);
     int age = scan.nextInt();
     if (age >= 18)
     {
         System.out.println("You can get a driver's license in most states!");
     }
     else
     {
         System.out.println("Sorry, you need to be older to get a driver's license.");
     }
   }
}
