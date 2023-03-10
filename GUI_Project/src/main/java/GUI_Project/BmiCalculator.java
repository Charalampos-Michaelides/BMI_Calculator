
package GUI_Project;


import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Handler;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;
import java.lang.Math;
import java.util.Formatter;
import java.util.FormatterClosedException;
import java.util.NoSuchElementException;
import javax.swing.ButtonGroup;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTabbedPane;
import javax.swing.SwingConstants;

public class BmiCalculator extends JFrame {
  
    
    
    private  PrintTextFile ptf;
    
    private static double bmi=0;
    //step 1 kathorismos GUI components
    
    private static boolean femaleRButton=false,maleRButton=false,file=false;
    
    private boolean bool;
    
    private JLabel l1,l2,l3,l4,l5;
    
    private JTextField f1,f2;  // f1 for the weight and f2 for the height
    private JTextField f3,f4;  // instructions to fill the text fields of weight and height
    
    private JButton b1,b2;
    
    private JRadioButton maleJRadioButton, femaleJRadioButton;
    
    private ButtonGroup groupOfRadioButtons;
    
    private Formatter print; 
    
    //step 2 dimiourgia kenou kataskeuasth
    
    public BmiCalculator()
    {
        //step 2a - stisimo tou parathirou
        super("BMI_Calculator");
        setLayout(new FlowLayout());
        
        l1= new JLabel();
        l2= new JLabel();
        l3= new JLabel();
        l4= new JLabel();
        l5= new JLabel();
        
       
        
        b1= new JButton("Result");
        b2= new JButton("Print Text File");
        f1= new JTextField(4);
        f2= new JTextField(4);
        f3= new JTextField("Enter your weight in KG");           // creates a field with the message "Enter your weight in KG"
        f3.setEditable(false);                                   //the user cant modified the message
        f4= new JTextField("Enter your height in meters (M)");
        f4.setEditable(false);
        add(f3);
        add(f1);
        add(f4);
        add(f2);
        add(b1);
        add(b2);
        
        maleJRadioButton= new JRadioButton("Male",false);   // create radiobutton with message "Male", false because we dont want to be checked in the beggining
        femaleJRadioButton= new JRadioButton("Female",false);
        
        add(maleJRadioButton);
        add(femaleJRadioButton);
        add(l1);
        add(l2);
        add(l3);
        add(l4);
        add(l5);
        
        
        
        groupOfRadioButtons=new ButtonGroup();             //group the radioButtons so only the one can be selected (true)
        groupOfRadioButtons.add(maleJRadioButton);
        groupOfRadioButtons.add(femaleJRadioButton);   
        
        //step 2b anathesi diaxiristwn gia simvanta
        
        Calculator handler= new Calculator();
        maleJRadioButton.addItemListener(handler);
        femaleJRadioButton.addItemListener(handler);
        b1.addActionListener(handler);
        b2.addActionListener(handler);
        
        
    }    

    
    
    
    
    private class Calculator implements ActionListener, ItemListener
    {         
        
        
         
       
        public void actionPerformed(ActionEvent event) {
            bool=true;
            if(femaleJRadioButton.isSelected())
            {
                setFemaleJRadioButton(true);
            } 
            else
            {
                setFemaleJRadioButton(false);
            }
            
            if(maleJRadioButton.isSelected())
            {
                setMaleJRadioButton(true);
            }
            else
            {
                 setMaleJRadioButton(false);
            }
            
            if(event.getSource()==b1)
            {
              //  file=true;
            double weight=0.0;
            double height=0.0;
            String weightString="";
            String heightString="";
            try
            {
                weightString=f1.getText(); //weightString has the value of the String we typed in the first TextField
                heightString=f2.getText();
                
                
                
                weight=Double.parseDouble(weightString); // converts String to Double
                height=Double.parseDouble(heightString);
                
               

                
            }
            
             catch(NumberFormatException ex)
            {
                bool=false;
                System.out.println("you must fill the boxes with your weight and height with numbers");
            }
          
            
              catch(Exception ex)   //catch all the other exceptions
            {
                System.out.println("something went wrong\n");        
            }
            
         
             
            double bmi2=0,lowerbound,upperbound;
  
            
            bmi=Math.round(weight/Math.pow(height, 2)*100.0)/100.0;  // tha mas dosei apotelesma double arithmou me 2 dekadika psifia
           
            bmi2=weight/Math.pow(height, 2); // xriazomaste ola ta dekadika gia na vgaloume akrivos posa kila xriazete kapios gia na einai sta lower kai upper bound tou normal weight
            
            //ta bmi den xriazontai try kai catch epidi h diairesh tou double arithmou me miden den mas dinei exception alla infinity
            
            
            lowerbound=Math.round(((18.5*weight)/bmi2)*100.0)/100.0;  // if you are under 18.5 bmi calculates the lower bound of KG you must be (so you will be exactly 18.5 BMI)
            
            upperbound=Math.round(((24.99*weight)/bmi2)*100.0)/100.0; //calculates the upperbound of normal weight (BMI=24.99)
            
   
            
            if(bool) //if the user gives text instead of numbers this if will be false 
            {
            
            if(femaleJRadioButton.isSelected())
            {
                FemaleSecureCode fsc= new FemaleSecureCode(weight,height,lowerbound,upperbound,bmi);

                
                
            if(event.getSource()==b1 && fsc.getBmiSecure()<18.5 && fsc.getBmiSecure()>0 )
            {
                JOptionPane.showMessageDialog(null, fsc,"FEMALE",JOptionPane.INFORMATION_MESSAGE);
 
            }
            else
                if(event.getSource()==b1 && fsc.getBmiSecure()>=18.5 && fsc.getBmiSecure()<=24.99)
                {
                     JOptionPane.showMessageDialog(null, fsc.toString3(),"FEMALE",JOptionPane.INFORMATION_MESSAGE);

                }
                else
                    if(event.getSource()==b1 && fsc.getBmiSecure()>=25 && fsc.getBmiSecure()<=29.99)
                    {
                        JOptionPane.showMessageDialog(null, fsc.toString2(),"FEMALE",JOptionPane.INFORMATION_MESSAGE);
                    }
                    else
                        if(event.getSource()==b1 && fsc.getBmiSecure()>=30 && fsc.getBmiSecure()<=39.99)
                        {
                            JOptionPane.showMessageDialog(null, fsc.toString2(),"FEMALEW",JOptionPane.INFORMATION_MESSAGE);
                        }
                        else
                            if(event.getSource()==b1 && fsc.getBmiSecure()>=40)
                            {
                                JOptionPane.showMessageDialog(null, fsc.toString2(),"FEMALE",JOptionPane.INFORMATION_MESSAGE); 
                            }
                            else
                                 if(bmi<=0)
                                    {
                                       System.out.println("your bmi is under zero please give right inputs, reminder input weight in KG and height in Meters (M)");
                                        
                                    }

            }      
            else
                if(maleJRadioButton.isSelected())
                {
                MaleSecureCode msc= new MaleSecureCode(weight,height,lowerbound,upperbound,bmi);
                    
                if(event.getSource()==b1 && msc.getBmiSecure()<18.5 && msc.getBmiSecure()>0  )
                {
                    JOptionPane.showMessageDialog(null, msc,"MALE",JOptionPane.INFORMATION_MESSAGE);
                 
                }
                else
                    if(event.getSource()==b1 && bmi>=18.5 && bmi<=24.99)
                    {
                         JOptionPane.showMessageDialog(null, msc.toString3(),"MALE",JOptionPane.INFORMATION_MESSAGE);
                    
                    }
                    else
                        if(event.getSource()==b1 && bmi>=25 && bmi<=29.99)
                        {
                             JOptionPane.showMessageDialog(null, msc.toString2(),"MALE",JOptionPane.INFORMATION_MESSAGE);
                        
                        }
                        else
                            if(event.getSource()==b1 && bmi>=30 && bmi<=34.99)
                            {
                                 JOptionPane.showMessageDialog(null, msc.toString2(),"MALE",JOptionPane.INFORMATION_MESSAGE);
                          
                            }
                            else
                                if(event.getSource()==b1 && bmi>=35 )
                                     JOptionPane.showMessageDialog(null, msc.toString2(),"MALE",JOptionPane.INFORMATION_MESSAGE);
                           
                                else
                                    if(bmi<=0)
                                    {
                                         System.out.println("your bmi is under zero please give right inputs, reminder input weight in KG and height in Meters (M)");
                                    }
                }                  
                
        
                    } 
        
        if(!maleJRadioButton.isSelected() && !femaleJRadioButton.isSelected())  //elexos an kanena apota dio radioButton einai epilegmeno
        {
            System.out.println("please select gender by clicking one of the circle checkers " );
        }
                

        try{
              FileWriter textFile = new FileWriter("bmi.txt",true); // create file (append)
              print = new Formatter(textFile);
           }
              catch(FileNotFoundException ex)
              {
                  System.out.println("file not found ");
              }
              
              catch (IOException ex)
              {
                  System.out.println("cant create or open the file plzz try again"); 
              }
              catch(SecurityException ex)
              {
                  System.out.println("you dont have the permisions of this file");
              }
              catch(Exception ex)
              {
                  System.out.println("something went wrong");
              }
       
        
            
          
        
                
              
                  
                  WriteTextFile tf= new WriteTextFile(weight,height);
                  
                  try
              {
                  
                  print.format( tf.getWeight() + " " + tf.getlHeight()+  "\n");
                  
                  
              }
              catch(FormatterClosedException ex)
              {
                  System.out.println("error in file writing");
              }
              catch(NoSuchElementException ex)
              {
                  System.out.println("cant find the file");
              }
              catch(Exception ex)
              {
                  System.out.println("something went wrong ");
              }
                
                  
                 
               closeFile();
        }
        
        
        
        if(event.getSource()==b2 )
        {
            ptf= new PrintTextFile(); 
            ptf.openFile();
            if(ptf.getBool()) // an vrei exception h if tha ginei false kai den tha diavasei to file kai tha to klisei
            ptf.readFile();
            ptf.closeFile();
            System.out.println("-----------------");
        }
        
            
        
        }               

        
        public void itemStateChanged(ItemEvent event) {
            
            if(femaleJRadioButton.isSelected())
            {
                l1.setText("You have selected Female BMI Range which is: " + "0<BMI<18.5 you are UnderWeight, ");
                l2.setText("18.5<=BMI<=24.99 you are normal weight, ");
                l3.setText("25<=BMI<=29.99 you are overweight ");
                l4.setText("30<=BMI<=39.99 you are obese, ");
                l5.setText("BMI>=40 you are Extremly obese " );
                
                 
                            
            }
            else if(maleJRadioButton.isSelected())
            {
                l1.setText("You have selected Male BMI Range: " + "0<BMI<18.5 you are UnderWeight, " );
                l2.setText("18.5<=BMI<=24.99 you are normal weight, ");
                l3.setText("25<=BMI<=29.99 you are overweight ");
                l4.setText("30<=BMI<=34.99 you are obese, ");
                l5.setText("BMI>=35 you are Extremly obese ");
            }
   
        }
        
          
               
   
        
    }

   
          public double getBmi()
         {
             return bmi;
         }
        
          
          public boolean getMaleJRadioButton()
          {
              return maleRButton;
          }
          
          public boolean getFemaleJRadioButton()
          {
              return femaleRButton;
          }
    
   
          
          public void setFemaleJRadioButton(boolean x)
          {
              femaleRButton=x;
          }
    
          public void setMaleJRadioButton(boolean x)
          {
              maleRButton=x;
          }
         
       
          
          public void closeFile()
          {
              if(print!=null)
              {
                  print.close();
              }
          }
      
          
          
          
          
          
}
    
    
    
    

