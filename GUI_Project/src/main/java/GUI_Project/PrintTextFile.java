
package GUI_Project;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Formatter;
import java.util.Scanner;


public class PrintTextFile  {
    
    private Scanner input = new Scanner (System.in);
    private boolean bool=true;
    
  
    
    public void openFile(){
              try
              {
              input =new Scanner(new File("bmi.txt"));
              }
              catch(FileNotFoundException ex)
              {
                  setBool(false);
                  System.out.println("file not found please give inputs to the file (weight in KG and Height in M and press) Result so will be written to the file");           
              }
              catch (IOException ex)
              {
                  setBool(false);
                  System.out.println("cant create or open the file please try again"); 
              }
              catch(SecurityException ex)
              {
                  setBool(false);
                  System.out.println("you dont have the permisions of this file");
              }
              catch(Exception ex)
              {
                  setBool(false);
                  System.out.println("something went wrong");
              }
    
    }

    
    
    public void readFile()
    {
        WriteTextFile tf= new WriteTextFile();
        
        
        while(input.hasNext())
        {
            tf.setWeight(input.nextDouble());
            tf.setHeight(input.nextDouble());
            
            System.out.println(tf);
        }
        
      
        
        
        
    }
    
    public void closeFile()
    {
          if(input!=null)
          {
              input.close();   
          }   
    }

    public void setBool(boolean x)
    {
        bool=x;
    }
    

    public boolean getBool()
    {
        return bool;
    }
    
    

}
    
    
    
    
    
    
    
    
    
    
    
    
    
    

