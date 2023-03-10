
package GUI_Project;
import java.lang.Math;

public class MaleSecureCode {
    
    private double weight;
    private double height;
    private String bmiType;
    private double lowerBound;
    private double upperBound;
    private double bmi;
    
    
    MaleSecureCode(double w,double h,double lower,double upper,double b)
    {
   
        setWeight(w);
        setHeight(h);       
        setLowerBound(lower);
        setUpperBound(upper);
        setBmiSecure(b);
        setBmiType();
    }
    
    public void setWeight(double w)
    {
        weight=w;
        
    }
    
    public double getWeight()
    {
        return weight;
    }
    
    
    public void setHeight(double h)
    {
        height=h;
    }
    
    
    public double getHeight()
    {
        return height;
    }
    
    
    public void setBmiType()
    {
        
        if(getBmiSecure()>0 && getBmiSecure()<18.5)
        bmiType="underweight";
        else
            if(getBmiSecure()>=18.5 && getBmiSecure()<=24.99)
            {
                bmiType="normal weight";
            }
            else
                if(getBmiSecure()>=25 && getBmiSecure()<=29.99)
                {
                    bmiType="overweight";
                }
                else
                    if(getBmiSecure()>=30 && getBmiSecure()<=34.99)
                    {
                        bmiType="obese";
                    }
                    else
                        if(getBmiSecure()>=35)
                        {
                            bmiType="extremly obese";
                        }
    }
    
    public String getBmiType()
    {
        return bmiType;
    }
    
    
    public void setBmiSecure(double b)
    {
        bmi=b;
        
    }
    
    public double getBmiSecure()
    {
        return bmi;
    }
    
    public void setLowerBound(double lb)
    {
        lowerBound=lb;
    }
    
    public double getLowerBound()
    {
        return lowerBound;
    }
    
    public void setUpperBound(double ub)
    {
        upperBound=ub;
    }
    
    public double getUpperBound()
    {
        return upperBound;
    }
    
    
    public String toString()
    {
        return "Your BMI for weight: "+ getWeight() + " and height: " + getHeight() + " is: "
                + getBmiSecure() + " and you are " + getBmiType() + " ,you need to gain weight from "
                + Math.abs(getLowerBound()-getWeight()) + " - " + Math.abs(getUpperBound()-getWeight()) + " KG to be normal weight";
        
    }
    
    public String toString2()
    {
         return "Your BMI for weight: "+ getWeight() + " and height: " + getHeight() + " is: "
                + getBmiSecure() + " and you are " + getBmiType() + " ,you need to lose weight from "
                + Math.abs(getLowerBound()-getWeight()) + " - " + Math.abs(getUpperBound()-getWeight()) + " KG to be normal weight";
    }
    
    public String toString3()
    {
         return "Your BMI for weight: "+ getWeight() + " and height: " + getHeight() + " is: "
                + getBmiSecure() + " and you are normal weight " +" ,you are in the perfect weight ";
              
    }
    
    
}

    
    

