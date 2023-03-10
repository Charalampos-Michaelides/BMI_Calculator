
package GUI_Project;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;


public class GymPrograms extends JFrame 
{
    private JDesktopPane GymProgram;
    private int counter=1; // counter for the open windows in the desktop frame
    private BmiCalculator object;
    
    public GymPrograms()
    {
        super("Gym Program");
        
        
        
        JMenuBar bar = new JMenuBar();
        JMenu addMenu = new JMenu( "start" ); 
        JMenuItem newFrame = new JMenuItem( "Calculation of Your Gym Program" );

        
        
        addMenu.add( newFrame ); 
        bar.add( addMenu ); 
        setJMenuBar( bar ); 

        GymProgram = new JDesktopPane(); 
        add( GymProgram ); 
        
        
        Gym handler= new Gym();
        newFrame.addActionListener(handler);
        
        
        
        
    }
    
    public class Gym implements ActionListener
    {

        
        public void actionPerformed(ActionEvent event)
        {      object = new BmiCalculator();
            
               if(object.getBmi()==0)
               {
               JInternalFrame frame2= new JInternalFrame("reminder" ,false,true,false,true);
               
           
               
               Image p2 = new Image();  
               frame2.add( p2 ); 
               frame2.pack(); 

               GymProgram.add( frame2 ); 
               frame2.setVisible( true );
                   
               }
               else
               { 
               JInternalFrame frame= new JInternalFrame("Gym Program" + getCounter(),false,true,false,true);
               increaseCounter();
            
               
               Image pl = new Image();  
               frame.add( pl ); 
               frame.pack(); 

               GymProgram.add( frame ); 
               frame.setVisible( true );
               }
               
               
                
    
        }
        
        
    }
    
 
    public int getCounter()
    {
        return counter;
    }
    
    public void increaseCounter()
    {
        counter++;
    }
    
    
}

class Image extends JPanel 
{
    private BmiCalculator object;
    private ImageIcon picture;
    private String[] programs={"wrong_instructions.png","Underweight_Workout_Female.png", "Normalweight_Workout_Female.png"
                               , "Overweight_Female.png", "obese_Female.png", "ExtremlyObese_Female.png"
                               , "Underweight_Male.png","Normalweight_Workout_Male.png","Overweight_Male.png","Obese_Male.png","ExtremlyObese_Male.png"};
    
    
    public Image()
    {
        object = new BmiCalculator();
    
        picture=new ImageIcon(programs[0]);
      
        
        if(object.getFemaleJRadioButton()==true)
        {
        if(object.getBmi()<18.5 && object.getBmi()>0)
        {
            picture= new ImageIcon(programs[1]);
        }
        else
            if(object.getBmi()>=18.5 && object.getBmi()<=24.99)
            {
                picture= new ImageIcon(programs[2]);
            }
            else
                if(object.getBmi()>=25 && object.getBmi()<=29.99)
                {
                    picture= new ImageIcon(programs[3]);
                }
                else
                    if(object.getBmi()>=30 && object.getBmi()<=39.99)
                    {
                        picture = new ImageIcon(programs[4]);
                    }
                    else
                        if(object.getBmi()>=40)
                        {
                            picture= new ImageIcon(programs[5]);
                        }
        }
        else
            if(object.getMaleJRadioButton()==true)
            {
                if(object.getBmi()<18.5 && object.getBmi()>0)
                {
                    picture= new ImageIcon(programs[6]);
                }        
                else
                    if(object.getBmi()>=18.5 && object.getBmi()<=24.99)
                    {
                        picture= new ImageIcon(programs[7]);
                    }
                    else
                        if(object.getBmi()>=25 && object.getBmi()<=29.99)
                        {
                            picture=new ImageIcon(programs[8]);
                        }
                        else
                            if(object.getBmi()>=30 && object.getBmi()<=34.99)
                            {
                                picture= new ImageIcon(programs[9]);
                            }
                            else
                                if(object.getBmi()>=35)
                                {
                                    picture= new ImageIcon(programs[10]);
                                }
                            
                                
            }
        
     
    }
    
    
     public void paintComponent( Graphics gr )
   {
      super.paintComponent( gr );
      picture.paintIcon( this, gr, 0, 0 ); 
   } 

   
   public Dimension getPreferredSize()
   {
      return new Dimension( picture.getIconWidth(), 
         picture.getIconHeight() );  
   } 
} 

    
    
    

