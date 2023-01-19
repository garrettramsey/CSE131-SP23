package module2._04compound;

public class Test2
{
   public static void main(String[] args)
   {
     boolean walking = false;
     boolean carIsAvailable = false;
     if (walking || carIsAvailable)
     {
        System.out.println("You can go out");
     }
     else
     {
       System.out.println("No, you can't go out");
     }
   }
}
