package app;

import grading.*;
import grading.io.*;
import gui.*;
import java.io.*;
import java.lang.reflect.*;
import javax.swing.*;

/**
 * An application for calculating the numeric grade for
 * a course from the grades on individual assignments.
 * 
 * @version 4.0
 * @author  Sagacious Media
 *
 */
public class Gradient implements Runnable
{
  private CompositeGrade     course;
  
  /**
   * The entry point for the application.
   * 
   * @param args args[0] contains the path (relative or absolute) to the .grd file
   */
  public static void main(String[] args)
  {
    // Early exit
    if ((args == null) || (args.length < 1))
    {
      System.err.println("You must enter a file name.");
      System.exit(1);
    }

    try
    {
      BufferedReader in = new BufferedReader(new FileReader(args[0]));
      String         line = in.readLine();
      int            categories = Integer.parseInt(line);
      CompositeGrade course = CourseReader.readCourse(in, categories);
      in.close();

      Gradient app = new Gradient(course);
      try
      {
        SwingUtilities.invokeAndWait(app);
      }
      catch (InvocationTargetException ite)
      {
        ite.printStackTrace();
        System.exit(1);
      }
      catch (InterruptedException ie)
      {
        ie.printStackTrace();
        System.exit(2);
      }
    }
    catch (IOException ioe)
    {
      ioe.printStackTrace();
      System.exit(3);
    }
  }
  
  /**
   * Explicit Value Constructor.
   * 
   * @param course  The CompositeGrade for the course.
   */
  public Gradient(CompositeGrade course)
  {
    this.course = course;
  }
  
  /** 
   * Run the GUI in the event dispatch thread.
   */
  @Override
  public void run()
  {
    setLookAndFeel();

    try {
		new GradientWindow(course);
	} catch (SizeException e) {
		// TODO Auto-generated catch block
		System.out.println("hey");
		
		e.printStackTrace();
	}
  }
  
  /**
   * Set the look and feel for the application.
   */
  private void setLookAndFeel()
  {
    // Setup the look and feel
    boolean done = false;
    try 
    {
      // Use Metal if it is available
      UIManager.LookAndFeelInfo[] lfs = UIManager.getInstalledLookAndFeels();
      for (int i=0; i<lfs.length && !done; i++)
      {
        if ("Metal".equals(lfs[i].getName())) 
        {
          UIManager.setLookAndFeel(lfs[i].getClassName());
          done = true;
        }
      }

      // If Metal isn't available, use the system look and feel
      if (!done)
      {
        String lookAndFeel = UIManager.getSystemLookAndFeelClassName();
        UIManager.setLookAndFeel(lookAndFeel);
      }
    } 
    catch (ClassNotFoundException cnfe)
    {
      // Use the default look and feel
    }
    catch(IllegalAccessException iae)
    {
      // Use the default look and feel
    }
    catch (InstantiationException ie)
    {
      // Use the default look and feel
    }
    catch (UnsupportedLookAndFeelException ulale)
    {
      // Use the default look and feel
    }
  }
}