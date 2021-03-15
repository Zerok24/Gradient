package grading;
import java.util.List;

/**
 * The requirements of a strategy (in the sense of the Strategy Pattern) for
 * calculating a numeric grade from a collection of grades.
 *
 * @author Bunguiu Norales
 * @version 1.0
 */
public interface GradingStrategy
{
  /**
   * Use this GradingStrategy to calculate a numeric grade.
   *
   * @param key     The key to use for the resulting Grade
   * @param grades  The collections of grades
   * @return        The numeric grade
   * @throws SizeException if the List contains the wrong number of elements
   */
  public abstract Grade calculate(String key, List<Grade> grades) throws SizeException;

}

