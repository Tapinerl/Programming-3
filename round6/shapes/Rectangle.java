
import java.text.DecimalFormat;
import java.text.NumberFormat;


/**
 *
 * @author ellio
 */
public class Rectangle implements IShapeMetrics{
    
    NumberFormat formatter = new DecimalFormat("#0.00"); 
    private double height;
    private double width;

    public Rectangle(double height, double width){
        this.height=height;
        this.width=width;
    }
    public String toString(){
        return ("Rectangle with height " + formatter.format(height) 
                + " and width " + formatter.format(width));
    } 
    public String name() {
        return "rectangle";
    }
    public double area() {

        return height*width;
    }
    public double circumference() {
        return 2*height+2*width;
    }
}