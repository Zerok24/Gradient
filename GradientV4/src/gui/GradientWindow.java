package gui;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import grading.CompositeGrade;
import grading.SizeException;

/**
 * Creates a window for the course.
 * @author Bunguiu Norales
 *
 */
public class GradientWindow extends JFrame implements ActionListener
{
	/**
	 * Is a unique series identifier.
	 */
	public static final long serialVersionUID = 1L;
	private List<CategoryField> categoryField;
	private CompositeGrade template;
	
	
	private JMenuBar menuBar;
	private JMenu fileMenu, editMenu;
	private JMenuItem item1, item2, item3;
	
	/**
	 * Construct a window object for the course.
	 * @param template information about the course.
	 * @throws SizeException if the size of the course if not valid.
	 */
	public GradientWindow(CompositeGrade template) throws SizeException
	{
			
		
		super("Gradient by noralebr");
		
		this.template = template;

		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(300,400);
		setLocationRelativeTo(null);
		categoryField = new ArrayList<CategoryField>();

		getContentPane().setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
		setJMenuBar(menuBar());
		
		
		for (int i = 0; i < template.getComponents().size(); i++) 
		{
			
			categoryField.add(new CategoryField((CompositeGrade)
		    		this.template.getComponents().get(i)));
			add(categoryField.get(i));
		
		}
		
		
		
	}
	
	/**
	 * Creates a new menu bar for the window.
	 * @return a menu bar.
	 */
	public JMenuBar menuBar()
	{
		
		
		
		menuBar = new JMenuBar();
		
		//file Menu
		fileMenu = new JMenu("File");
		item1 = new JMenuItem("Exit");
		item1.addActionListener(this);
		
		fileMenu.add(item1);
		menuBar.add(fileMenu);
		
		//Edit Menu
		editMenu = new JMenu("Edit");
		item2 = new JMenuItem("Calculate");
		item2.addActionListener(this);
		editMenu.add(item2);
		
		item3 = new JMenuItem("Reset");
		item3.addActionListener(this);
		editMenu.add(item3);
		menuBar.add(editMenu);
		return menuBar;
		
	}

	/**
	 * Reacts to the user actions.
	 */
	@Override
	public void actionPerformed(ActionEvent e) 
	{
		// TODO Auto-generated method stub
		
		if (e.getSource() == item1 )  
		{
			System.exit(0);
		}
		
		if (e.getSource() == item2)
		{
			JOptionPane.showMessageDialog(null, template.getValue(), "Course Grade", 
					JOptionPane.INFORMATION_MESSAGE);
		}
		
		if (e.getSource() == item3) 
		{
			for (int i = 0; i < categoryField.size(); i++) 
			{
				categoryField.get(i).reset();
			}
		}
		
	}
	
	
	
}
