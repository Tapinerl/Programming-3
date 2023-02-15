
import java.text.DecimalFormat;
import java.text.NumberFormat;

public class Circle implements IShapeMetrics{

    private double radius;
    NumberFormat formatter = new DecimalFormat("#0.00"); 
    public Circle(double radius){
        this.radius=radius;
    }
    public String name(){
        return "circle";
    }
    public double circumference(){
        return radius*2*pi;
    }
    public String toString(){
        return ("Circle with radius: " + formatter.format(radius));
    }
    public double area(){
        return pi*(radius*radius);
    }
}