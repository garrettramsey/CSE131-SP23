package module2._09analysis;

public class NestedLoops
{

   public static void main(String[] args)
   {
       for (int row = 0; row < 5; row++)
       {
           for (int col = 0; col < 10; col++)
           {
               System.out.print("*");
           }
           System.out.println();
       }
   }
}

