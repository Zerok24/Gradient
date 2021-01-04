package gui;


import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JPanel;

import grading.CompositeGrade;
import grading.Grade;
import grading.LeafGrade;

/**
 * This class adds the the categories of the course.
 *
 * @author Bunguiu Norales
 *
 */
public class CategoryField  extends JPanel
{
	/**
	 * Is a unique identifier.
	 */
	public static final long serialVersionUID = 1L;
	private CompositeGrade template;
	private List<LeafGradeField> fields;
	
	
	/**
	 * Construct a CategoryField object with the categories passed.
	 * @param template course information.
	 */
	public CategoryField(CompositeGrade template)
	{
		
		this.template = template;	
		fields = new ArrayList<LeafGradeField>();
		setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
		setBorder(BorderFactory.createTitledBorder(this.getKey()));
		
		
		for (int i = 0; i < this.template.getComponents().size(); i++) 
		{
			
			fields.add(new LeafGradeField(new LeafGrade(
					template.getComponents().get(i).getKey(),
					template.getComponents().get(i).getValue())));
			
			add(fields.get(i));

		}
	}
	
	
	/**
	 * Gets the grade information of the template and return a new grade.
	 * @return grade object.
	 */
	public Grade getGrade() 
	{
		
		
		CompositeGrade grade = new CompositeGrade(template.getKey());
		
		grade.setFilter(template.getFilter());
		grade.setStrategy(template.getStrategy());
		
		for (int i = 0; i < template.getComponents().size(); i++) 
		{
			
			grade.add(template.getComponents().get(i));
		}
		
		
		
		return grade;
		
		
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
	 * Empties the text fields in the category.
	 */
	public void reset()
	{
		for (int i = 0; i < fields.size(); i++) 
		{
			fields.get(i).reset();
		}
	}
		
		
}
	
	

