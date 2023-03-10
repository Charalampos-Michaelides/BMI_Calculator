
package GUI_Project;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.SwingConstants;


public class NavigationPanel extends JFrame {
  
       private static boolean boolb1=true,boolb2=true,boolb3=true;
        
        private JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9,l10,l11,l12;
        private JButton b1,b2,b3;
        private JPanel p1,p2;
                
      
        
        public NavigationPanel()
        {
            super("navigation window");
            JTabbedPane tabpane= new JTabbedPane();
            
            //set up first tab for Instructions
            l3= new JLabel("       WELCOME TO INSTRCTION TAB, MAIN INSTRUCTIONS:");
            l4= new JLabel(" read all the instructions and after that click in the tab2, when you click in the tab2 "
                          + "press the button BMI Calculator put your weight in the first textbox in (KG) and your height in second textbox in meters (m) also select your gender and click Result"
                          ,SwingConstants.CENTER);
            l5=new JLabel( "after that press the button Creation of a Gym Program and click start. Then click Calculation of Your Gym Program and ",SwingConstants.CENTER);
            l6=new JLabel("after that will appear in your screen your gym-program customized for your weight");
            l7=new JLabel("                                                                                                                               if you want to find another program for another person repeat the same proccess");
            l8= new JLabel("                                                                                                                                     ");
            l9= new JLabel("-------------------------------------------------------------------------------------------------------------------------------------------------------SECONDARY INSTRUCTIONS");
            l10= new JLabel("---------------------------------------------------------------------------------------------------------------------------------------------------- ");
            l11= new JLabel("go to tab2 press the BMI Calculator button and press Print Text File to see the content of the file, go again to tab2 and press the Rating button");
            l12= new JLabel("move the slider where you want and press the Submit button");
            
            p2= new JPanel();
            p2.setLayout(new FlowLayout());
            p2.add(l3);
            p2.add(l4);
            p2.add(l5);
            p2.add(l6);
            p2.add(l7);
            p2.add(l8);
            p2.add(l9);
            p2.add(l10);
            p2.add(l11);
            p2.add(l12);
            tabpane.addTab("Tab1", null,p2,"first panel");
            
            //set up second tab for navigation
            b1= new JButton("BMI Calculator");
            b2= new JButton("Creation of a Gym Program");
            b3= new JButton("Rating");
            l1= new JLabel("Main panel",SwingConstants.CENTER);
            l2= new JLabel("in order to have access to Gym Program you must first calculate your BMI by clicking the button BMI Caclulator",SwingConstants.CENTER);
            p1= new JPanel();
            p1.setLayout(new BorderLayout());
            p1.add(l1);
            p1.add(l2);
            p1.add(b1,BorderLayout.EAST);
            p1.add(b2,BorderLayout.WEST);
            p1.add(b3,BorderLayout.NORTH);
            tabpane.addTab("Tab2",null, p1, "Second Panel");
            
            
            
            
            
              MainPanel handler= new MainPanel();
              b1.addActionListener(handler);
              b2.addActionListener(handler);
              b3.addActionListener(handler);
              add(tabpane);
          }
        
        
          public class MainPanel implements ActionListener
        {

            
            public void actionPerformed(ActionEvent event) 
            {
                
               
                if(event.getSource()==b1 && boolb1)
                {
                    boolb1=false;
                    BmiCalculator frame=new BmiCalculator();
                    frame.setSize(500,300); // (x,y) dimensions
                    frame.setVisible(true);
                    frame.setResizable(false);
                    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    
       
                }
                else if(event.getSource()==b1 && !boolb1)
                {
                    System.out.println("you cant press this button (BMI Calculator) more than 1 time");    
                }
                
                      else  if(event.getSource()==b2 && boolb2)
                            {
                            boolb2=false;
                            GymPrograms frame=new GymPrograms();
                            frame.setSize(1550,775); // (x,y) dimensions
                            frame.setVisible(true);
                            frame.setResizable(false);
                            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                        
                            }
                             else if(event.getSource()==b2 && !boolb2)
                                {
                                System.out.println("you cant press this button (Creation of a Gym Program) more than 1 time");
                                }
                        
                        
                        
                        
                                  else if(event.getSource()==b3 && boolb3)
                                  {
                                     boolb3=false;
                                     RatingSlider frame=new RatingSlider();
                                     frame.setSize(500,550); // (x,y) dimensions
                                     frame.setVisible(true);
                                     frame.setResizable(false);
                                     frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                            
                                  }
                                        else if(event.getSource()==b3 && !boolb3)
                                        {
                                            System.out.println("you cant press this button (Rating) more than 1 time"); 
                                        }
            
            }
            
            
            
            
        }
        

        
    }
    
    
    
    
    
    
    

