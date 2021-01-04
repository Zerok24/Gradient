package gui;

import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.JTextField;
import grading.Grade;
import grading.LeafGrade;

/**
 * Creates the text fields for the grades in the course.
 * @author Bunguiu Norales
 *
 */
public class LeafGradeField extends JTextField
{
	/**
	 * Is a unique identifier.
	 */
	public static final long serialVersionUID = 1L;
	private LeafGrade template;
	
	
	/**
	 * Constructs a text field for the grade passed through the template.
	 * @param template course information.
	 */
	public LeafGradeField (LeafGrade template) 
	{
		this.template = template;
		
		setBorder(BorderFactory.createTitledBorder(template.getKey()));
		
		if (template.getValue() == null) 
		{
			setText("0.0");
		}else 
		{
			setText(String.valueOf(template.getValue()));
		}
		
		setForeground(Color.BLUE);
		
	}
	
	/**
	 * Creates a new grade with info passed through the constructor.
	 * @return a new LeafGrade object.
	 */
	public Grade getGrade()
	{
		
		return new LeafGrade(template.getKey(), template.getValue());
	}
	
	/**
	 * Gets the key from the template.
	 * @return the key.
	 */
	public String getKey()
	{
		
		return template.getKey();
	}
	
	/**
	 * Resets the text fields.
	 */
	public void reset() 
	{
		setText("");
	}
	
	
	
}
