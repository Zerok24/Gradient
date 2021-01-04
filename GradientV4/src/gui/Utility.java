package gui;

public class Utility
{
  public static int calculate(int x, int y)
  {
    int       a, b;

    do
    {
      a = 1;                 // S1
       
      if (x > y)             // S2
      {
        a = 2;               // S3
      }

      x++;                   // S4
      b = x * a;             // S5
    }
    while (b <= 0);          // S6
       
    return b;                // S7
  }
}
