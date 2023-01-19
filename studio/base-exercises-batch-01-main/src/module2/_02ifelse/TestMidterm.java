package module2._02ifelse;

import java.util.Scanner;
public class TestMidterm
{
   public static void main(String[] args)
   {
     Scanner scan = new Scanner(System.in);

     System.out.println("Did you pass the midterm exam?");

     boolean passedExam = scan.nextBoolean();
     if (passedExam)
     {
        System.out.println("Good job studying!");
     }
     if (!passedExam)
     {
        System.out.println("Study harder next time.");
     }
   }
}
