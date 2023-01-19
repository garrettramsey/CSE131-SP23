package module2._07strings;

public class ReverseString
{
   public static void main(String[] args)
   {
     String s = "Hello";
     String sReversed = "";
     String ithLetter;

     for(int i=0; i < s.length(); i++) {
         ithLetter = s.substring(i,i+1);
         // add the letter at index i to what's already reversed.
         sReversed = ithLetter + sReversed;
     }
     System.out.println(s + " reversed is " + sReversed);
   }
 }
 
