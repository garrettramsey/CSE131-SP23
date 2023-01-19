package module2._07strings;

public class FindAndReplace
{
   public static void main(String[] args)
   {
     String message = "Have a 1ong and happy 1ife";
     int index = 0;

     // while more 1's in the message
     while (message.indexOf("1") >= 0)
     {
        // Find the next index for 1
        index = message.indexOf("1");
        System.out.println("Found a 1 at index: " + index);
        // Replace the 1 with a l at index by concatenating substring up to index and then the rest of the string.
        String firstpart = message.substring(0,index);
        String lastpart = message.substring(index+1);
        message = firstpart + "l" + lastpart;
        System.out.println("Replaced 1 with l at index " + index);
        System.out.println("The message is currently " + message + " but we aren't done looping yet!");
     }
     System.out.println("Cleaned text: " + message);
   }
}

