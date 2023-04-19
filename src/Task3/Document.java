package Task3;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

public class Document extends JPanel {
    private JTextArea textArea1;
    private JTextArea textArea2;
    private JLabel label1;
    private JLabel label2;
   

    public Document() {
        //construct components
        textArea1 = new JTextArea (5, 5);
        textArea2 = new JTextArea (5, 5);
        
        textArea1.setDisabledTextColor(Color.DARK_GRAY);
        textArea1.setBackground(Color.LIGHT_GRAY);
        
        textArea2.setDisabledTextColor(Color.DARK_GRAY);
        textArea2.setBackground(Color.LIGHT_GRAY);
     
        
        textArea1.setEnabled(false);
        textArea2.setEnabled(false);
        textArea2.setLineWrap(true);
        textArea2.setWrapStyleWord(true);
        
        
        
        label1 = new JLabel ("Zone de Texte 2");
        label2 = new JLabel ("Zone de Texte 1");

        //adjust size and set layout
        setPreferredSize (new Dimension (752, 430));
        setLayout (null);

        //add components
        add (textArea1);
        add (textArea2);
        add (label1);
        add (label2);

        //set component bounds (only needed by Absolute Positioning)
        textArea1.setBounds (150, 50, 450, 150);
        textArea2.setBounds (150, 250, 450, 150);
        label1.setBounds (105, 215, 100, 25);
        label2.setBounds (105, 15, 100, 25);
        
       
    }
    
    void setTextArea1Text(String newText){
    	textArea1.setText(newText);
    }
    
    void setTextArea2Text(String newText){
    	textArea2.setText(newText);
    }

}
