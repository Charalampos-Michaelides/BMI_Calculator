
package GUI_Project;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.SwingConstants;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;


public class RatingSlider extends JFrame {
  
    private JSlider s1;
    private JLabel l1,l2;
    private JPanel p1;
    private JButton b1;
    
    
    RatingSlider()
    {
        super("Rate us");
        
        s1= new JSlider(SwingConstants.HORIZONTAL,100,0); //100 spaces the slider starts from the 0
        l1= new JLabel("Rate us your opinion matters"); //label that is visible
        l2= new JLabel(); // it will appear the text only when the slider moves
        b1= new JButton("Submit");
        
        
        p1= new JPanel();
        
        s1.setPaintTicks(true);   //makes the ticks visible
        s1.setMinorTickSpacing(2); // space between minor ticks is 2 spaces
        
        s1.setPaintTrack(true);
        s1.setMajorTickSpacing(20); // soaces between major ticks is 20 spaces
        
        
        
        s1.setPaintLabels(true); // major ticks einai pollaplasia tou 20
        
        
        
        p1.add(s1);  // add slider
        p1.add(l1);  // add first label
        p1.add(l2); // add second label
        p1.add(b1);
        
        add(p1);  // add panel
        
        
        Rating handler= new Rating();
        s1.addChangeListener(handler);
        b1.addActionListener(handler);
    }
    
    
    private class Rating implements ChangeListener,ActionListener
    {

        
        public void stateChanged(ChangeEvent event) 
        {
            l2.setText("Rating: " + s1.getValue() + "%"); // when the slider moves it will appear the label l2
            
        }

       
        public void actionPerformed(ActionEvent event) {
            JOptionPane.showMessageDialog(null, "Your Rating is: " + s1.getValue()+ "% ,thanks for the ratings will be taken seriously ");
            
            
        }
        
    }
    
    
    
    
    
    
    
}
