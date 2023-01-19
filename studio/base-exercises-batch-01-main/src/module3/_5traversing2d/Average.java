package module3._5traversing2d;

public class Average
{

   public static double getAvg(int[][] a)
   {
      double total = 0;
      for (int[] innerArray : a)
      {
         for (int val : innerArray)
         {
            total = total + val;
         }
      }
      return total / (a.length * a[0].length);
   }

   public static void main(String[] args)
   {
      int[][] a = {  {80, 90, 70}, {20, 80, 75}};
      double total = 0;
      for (int[] innerArray : a)
      {
         for (int val : innerArray)
         {
            total = total + val;
         }
      }
      System.out.println(total / (a.length * a[0].length));
   }
}

