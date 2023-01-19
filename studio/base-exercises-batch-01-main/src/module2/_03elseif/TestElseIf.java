package module2._03elseif;

public class TestElseIf
{
   public static void main(String[] args)
   {
     int x = 2;
     if (x < 0)
     {
       System.out.println("x is negative");
     }
     else if (x == 0)
     {
        System.out.println("x is 0");
     }
     else
     {
       System.out.println("x is positive");
     }
     System.out.println("after conditional");
   }
}
