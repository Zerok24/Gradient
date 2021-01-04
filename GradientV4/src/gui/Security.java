package gui;

public class Security
{
  private static final char[] STARS = {'*','*','*','*','*','*','*','*'};
  private static final String TOO_LONG = new String(STARS, 0, STARS.length) +
                                            "...";

  public static String obfuscate(String s, String defaultString)
  {
    if ((s == null) || (s.length() == 0))          // 1
            return defaultString;                  // 2
    else if (s.length() > STARS.length)            // 3
            return TOO_LONG;					   // 4
    else			
            return new String(STARS, 0, s.length());     // 5
  }
}


