import java.util.Comparator;


public class Attainment implements Comparable<Attainment> 
{
    
    private String courseCode;
    private String studentNumber;
    private int grade;

    public Attainment(String cCode, String sNumber, int grade) 
    {
        this.courseCode = cCode;
        this.studentNumber = sNumber;
        this.grade = grade;
    }

    public String getCourseCode() 
    {
        return courseCode;
    }

    public String getStudentNumber() 
    {
        return studentNumber;
    }

    public int getGrade() 
    {
        return grade;
    }
    public static final Comparator<Attainment> CODE_STUDENT_CMP = new Comparator<>() 
    {
        @Override
        public int compare(Attainment x1, Attainment x2) 
        {
            if (x1.courseCode.compareTo(x2.courseCode) == 0) 
            {
                return x1.studentNumber.compareTo(x2.studentNumber);
            } 
            else 
            {
                return x1.courseCode.compareTo(x2.courseCode);
            }
        }
    };
    public static final Comparator<Attainment> CODE_GRADE_CMP = new Comparator<>() 
    {
        @Override
        public int compare(Attainment x1, Attainment x2) 
        {
            if (x1.courseCode.compareTo(x2.courseCode) == 0) 
            {
                if (x1.grade == x2.grade) 
                {
                    return 0;
                } 
                else if (x1.grade > x2.grade) 
                {
                    return -1;
                } 
                else 
                {
                    return 1;
                }
            }
            else 
            {
                return x1.courseCode.compareTo(x2.courseCode);
            }
        }
    };
    @Override
    public String toString() 
    {
        return String.format("%s %s %d", courseCode, studentNumber, grade);
    }
    @Override
    public int compareTo(Attainment o) 
    {
        if (this.studentNumber.compareTo(o.studentNumber) == 0) 
        {
            return this.courseCode.compareTo(o.courseCode);
        } 
        else 
        {
            return this.studentNumber.compareTo(o.studentNumber);
        } 
    }   
}