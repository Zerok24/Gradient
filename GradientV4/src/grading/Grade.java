package grading;

/**
 * The requirements of a Grade object.
 * 
 * @author Bunguiu Norales
 */
public interface Grade extends Comparable<Grade>
{
  /**
   * Get the key associated with this Graded object.
   *
   * @return   The key
   */
  public abstract String getKey();
  
  /**
   * Get the value associated with this Graded object.
   *
   * @return   The value
   */
  public abstract Double getValue();
}
