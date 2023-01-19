package module3._6exercises;

public class Test16
{
    public static void main(String[] args)
    {
        String[][] arr = { {"red","orange", "purple"}, {"green","blue", "indigo"} };

        // ADD CODE HERE //

        for (int row = 0; row < arr.length; row++)
        {
            for (int col = 0; col < arr[1].length; col++)
            {
                System.out.println(arr[row][col]);
            }
        }
    }
}

