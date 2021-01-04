package grading;


import java.util.*;

/**
 * A GradingStrategy that calculates the weighted average of a collection
 * of grades.
 * 
 * @author Bunguiu Norales 
 * @author  Ann E. Coda, Sagacious Media
 */
public class WeightedAverageStrategy implements GradingStrategy
{
  private static final Double     ZERO = 0.0;

  private boolean                 shouldIgnoreMissing;
  private Map<String, Double>     weights;

   
  /**
   * Default Constructor.
   */
  public WeightedAverageStrategy()
  {
    this(null, false);        
  }

  /**
   * Explicit Value Constructor.
   *
   * @param weights  The Map of weights to use (or null for equal weights)
   */
  public WeightedAverageStrategy(Map<String, Double> weights)
  {
    //super();
    this.weights = weights;
  }

  /**
   * Explicit Value Constructor.
   *
   * @param weights        The Map of weights to use (or null for equal weights)
   * @param shouldIgnoreMissing  true to ignore missing values; false to treat as 0
   */
  public WeightedAverageStrategy(Map<String, Double> weights, boolean shouldIgnoreMissing)
  {
	  
	  this.shouldIgnoreMissing = shouldIgnoreMissing;
    this.weights = weights;
  }

  /**
   * Use this GradingStrategy to calculate a numeric grade.
   *
   * Note: If there are no weights (i.e., the weights Map is null) then
   * each grade is assumed to have a weight of 1. If there are weights but
   * an individual Grade does not have a corresponding weight its
   * weight is assumed to be 0.0.
   *
   * @param key     The key for the Grade to return
   * @param grades  The collection of grades
   * @return        The numeric grade
   */
  public Grade calculate(String key, List<Grade> grades)
  {
    double                denominator, numerator;        
    Double                grade = 0.0, weight = 0.0;        


    // Early return
    if ( (grades == null)||(grades.size() == 0) ) return new LeafGrade(key, ZERO);

    numerator   = 0.0;
    denominator = 0.0;

    for (Grade g: grades)
    {
      grade = g.getValue();


      if (weights == null || weights.size() == 0) // All weights are unspecified
      {
    	  
        weight = 1.0;
      }

      else                 // Some weights are specified
      {
        weight = weights.get(g.getKey());
      }

      if (grade == null)
      {
        // Handle a missing Grade
        
        if (!shouldIgnoreMissing) 
        {
        
        	denominator +=weight;
		    }
      }

      else
      {
        // Handle an existing Grade
        numerator   += weight * grade;
        denominator += weight;
      }
    }
    if (denominator == 0.0) 
    {
    	
    	return new LeafGrade(key, 0.0);
    }else 
    {
    	return new LeafGrade(key, (numerator/denominator) );
    }

   
  }
}
