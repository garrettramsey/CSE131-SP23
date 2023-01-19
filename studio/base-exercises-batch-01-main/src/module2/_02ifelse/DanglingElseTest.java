package module2._02ifelse;

public class DanglingElseTest
{
   public static void main(String[] args)
   {
      boolean sunny = true;
      boolean hot = false;
      if (sunny)
         if (hot)
             System.out.println("Head for the beach!");
       else // Which if is else attached to??
        System.out.println("Bring your umbrella!");
   }
}
