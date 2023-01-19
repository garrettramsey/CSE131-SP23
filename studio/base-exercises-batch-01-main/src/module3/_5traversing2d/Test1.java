package module3._5traversing2d;

public class Test1
{

   public static void main(String[] args)
   {
      int[][] a = { {1,2,3},{4,5,6}};
      double total = 0;
      int value = 0;
      for (int row = 0; row < a.length; row++)
      {
         for (int col = 0; col < a[0].length; col++)
         {
            value = a[row][col];
            total = total + value;
         }
      }
      System.out.println(total / (a.length * a[0].length));
   }
}

