
package GUI_Project;


public class WriteTextFile {
    private double w,h;
    
    WriteTextFile()
    {
        
    setWeight(-1);
    setHeight(-1);
        
        
        
    }

    
    WriteTextFile(double x, double y)
    {
        setWeight(x);
        setHeight(y);
    }
    
    
    
    
    
    
    
    
    
    public void setWeight(double x)
    {
        w=x;
    }
    
    
    public double getWeight()
    {
       return w; 
    }

    public void setHeight(double y)
    {
        h=y;
    }
    
   
    public double getlHeight()
    {
       return h; 
    }
    
    
    public String toString()
    {
        return "Weight: " + getWeight() + " Height: " + getlHeight(); 
    }

    
    
}
