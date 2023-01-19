package module2._09analysis;

public class Trace
{
    public static void main(String[] args)
    {
        int var1 = 3;
        int var2 = 2;

        while ((var2 != 0) && ((var1 / var2) >= 0))
        {
            var1 = var1 + 1;
            var2 = var2 - 1;
        }
    }
}

