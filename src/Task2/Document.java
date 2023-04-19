package Task2;

import java.awt.*;
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

        textArea2.getDocument().addDocumentListener(new DocumentListener() {
			
			@Override
			public void removeUpdate(DocumentEvent e) {
				trt();
				
			}
			
			@Override
			public void insertUpdate(DocumentEvent e) {
				trt();
			}
			
			@Override
			public void changedUpdate(DocumentEvent e) {
				trt();
			}
			
			public void trt() {
				try {
					Task2.sendMessage(textArea2.getText());
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
        
        textArea1.setEnabled(false);
        textArea2.setLineWrap(true);
        textArea2.setWrapStyleWord(true);
        textArea1.setBackground(Color.LIGHT_GRAY);
        textArea1.setText("Not available");
        textArea1.setDisabledTextColor(Color.red);
       
        
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


    public static void main (String[] args) {
        JFrame frame = new JFrame ("Real-Time text Editor");
        frame.setResizable(false);
        frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add (new Document());
        frame.pack();
        frame.setVisible (true);
    }
}
