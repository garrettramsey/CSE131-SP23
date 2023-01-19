package module3._3foreach;

public class EvenLoop
{
   public static void main(String[] args)
   {
     int[ ] values = {6, 2, 1, 7, 12, 5};
     // Rewrite this loop as a for each loop and run
     for (int i=0; i < values.length; i++)
     {
       if (values[i] % 2 == 0)
           System.out.println(values[i] + " is even!");
     }
   }
}

