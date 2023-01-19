package module2._04compound;

public class Test1
{
   public static void main(String[] args)
   {
     boolean cleanedRoom = true;
     boolean didHomework = false;
     if (cleanedRoom && didHomework)
     {
         System.out.println("You can go out");
     }
     else
     {
         System.out.println("No, you can't go out");
     }
   }
}
