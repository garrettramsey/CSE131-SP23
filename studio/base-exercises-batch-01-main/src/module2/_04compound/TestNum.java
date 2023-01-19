package module2._04compound;

public class TestNum
{
   public static void main(String[] args)
   {
     int score = 10; // Try -10 and 110
     if (score < 0 || score > 100)
     {
         System.out.println("Score has an illegal value.");
     }
     if (score >= 0 && score <= 100)
     {
         System.out.println("Score is in the range 0-100");
     }

   }
}
