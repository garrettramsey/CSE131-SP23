package module3._3foreach;

public class IncrementLoop
{
   public static void main(String[] args)
   {
     int[ ] values = {6, 2, 1, 7, 12, 5};
     // Can this loop increment the values?
     for (int val : values)
     {
       val++;
       System.out.println("New val: " + val);
     }
     // Print out array to see if they really changed
     System.out.println("Array after the loop: ");
     for (int v : values)
     {
       System.out.print(v + " ");
     }
   }
}

