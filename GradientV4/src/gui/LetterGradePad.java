package gui;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class LetterGradePad extends JFrame implements ActionListener
{
	
  private static final long serialVersionUID = 1L;
  private static final String[] GRADES = {"A","B","C","D","F","P"};
  private boolean obfuscating;
  private JLabel display;
  private String contents;

  public LetterGradePad(boolean obfuscating)
  {
	  

    JPanel jpanel = new JPanel();


    this.obfuscating = obfuscating;

    jpanel.setLayout(new BorderLayout());


        JPanel letterPanel = new JPanel();
        letterPanel.setLayout(new GridLayout(3,2));
        for (int i=0; i<GRADES.length; i++) addButton(letterPanel, GRADES[i]);
        jpanel.add(letterPanel, BorderLayout.CENTER);

        JPanel pmPanel = new JPanel();
        pmPanel.setLayout(new GridLayout(1,2));
        addButton(pmPanel, "+");
        addButton(pmPanel, "-");
        jpanel.add(pmPanel, BorderLayout.SOUTH);


        display = new JLabel(" ");
        jpanel.add(display, BorderLayout.NORTH);

        add(jpanel);
        setSize(300,300);
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

    }

    private void addButton(JPanel panel, String text)
    {
        JButton button = new JButton(text);
        panel.add(button);
        button.addActionListener(this);


    }

    public void actionPerformed(ActionEvent event)
    {

        String ocurrencia = event.getActionCommand();


        if (ocurrencia.equals("A"))
        {
            contents = "A";
            display.setText(contents);

        }

        if(ocurrencia.equals("+") && contents != null && display.getText().length() < 2 &&  !contents.equals("")
           && !contents.equals("P") && !contents.equals("F") )
        {
            contents += "+";
            display.setText(contents);
        }

        if(ocurrencia.equals("-") && contents != null && display.getText().length() < 2 &&  !contents.equals("")
                && !contents.equals("P") && !contents.equals("F") )
        {
            contents += "-";
            display.setText(contents);
        }



        if (ocurrencia.equals("B"))
        {
            contents = "B";
            display.setText(contents);

        }
        if (ocurrencia.equals("C"))
        {
            contents = "C";
            display.setText(contents);

        }

        if (ocurrencia.equals("D"))
        {
            contents = "D";
            display.setText(contents);

        }

        if (ocurrencia.equals("F"))
        {
            contents = "F";
            display.setText(contents);

        }

        if (ocurrencia.equals("P"))
        {
            contents = "P";

            display.setText(contents);

        }


    }

    private void displayContents()
    {
        String toDisplay;
        if (obfuscating) toDisplay = Security.obfuscate(contents, "?");
        else toDisplay = contents;
        display.setText(toDisplay);
    }

    public static void main(String[] args) {
        new LetterGradePad(true);
    }

}