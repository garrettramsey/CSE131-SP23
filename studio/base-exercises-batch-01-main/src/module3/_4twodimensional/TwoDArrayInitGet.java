package module3._4twodimensional;

public class TwoDArrayInitGet
{
   public static void main(String[] args)
   {
      String[][] seatingInfo = { {"Jamal", "Maria"},
                                 {"Jake", "Suzy"},
                                 {"Emma", "Luke"} };
      String name = seatingInfo[0][0];
      System.out.println(name + " is at [0,0]");

   }
}

