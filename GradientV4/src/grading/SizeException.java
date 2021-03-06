package grading;
/**
 * A checked exception that indicates that a size problem has occurred.
 * 
 * @author Bunguiu Norales
 */
public class SizeException extends Exception
{
	public static final long serialVersionUID = 1L;
	
	/**
	 * Default Constructor.
	 */
	public SizeException()
	{
		super();
	}

	/**
	 * Explicit Value Constructor.
	 * 
	 * @param message   The human-readable message
	 */
	public SizeException(String message)
	{
		super(message);
	}
}
