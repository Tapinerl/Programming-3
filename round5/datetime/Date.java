package datetime;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Date {

    private final int year;
    private final int month;
    private final int day;
   
    public Date(int year, int month, int day) throws DateException{
        boolean isValid = true;
        try {
          DateTimeFormatter f = DateTimeFormatter.ofPattern ( "dd.MM.uuuu" );
          LocalDate ld = LocalDate.parse ( day + "." + month + "." + year , f );
        } catch (Exception e) 
        {
          isValid=false;
        }    
        if (isValid = false) 
        {
            throw new DateException("Illegal date " + day + "." + month + "." + year);
        }
        this.year = year;
        this.month = month;
        this.day = day;
    }
    public int getYear()
    {
        return this.year;
    }
    public int getMonth()
    {
        return this.month;
    }
    public int getDay()
    {
        return this.day;
    }
    @Override
    public String toString()
    {
        return day + "." + month + "." + year;
    }  
}
