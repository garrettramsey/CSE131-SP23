package module2._06for;

public class SongTest
{
   public static void main(String[] args)
   {
	  String line1 = " bottles of pop on the wall";
      String line2 = " bottles of pop";
      String line3 = "Take one down and pass it around";

      // loop 5 times (5, 4, 3, 2, 1)
      for (int i = 5; i > 0; i--)
      {
         System.out.println(i + line1);
         System.out.println(i + line2);
         System.out.println(line3);
         System.out.println((i - 1) + line1);
         System.out.println();
      }
   }
}
