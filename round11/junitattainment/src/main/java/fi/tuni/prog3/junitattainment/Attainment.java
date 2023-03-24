package fi.tuni.prog3.junitattainment;
import java.util.Comparator;

public class Attainment implements Comparable<Attainment>
{
    private final String course;
    private final String student;
    private final int grade;
    
    public static final Comparator<Attainment> CODE_STUDENT_CMP =
            Comparator.comparing(Attainment::getCourseCode).thenComparing(Attainment::getStudentNumber);
    public static final Comparator<Attainment> CODE_GRADE_CMP =
            Comparator.comparing(Attainment::getCourseCode).thenComparing(Attainment::getGrade, Comparator.reverseOrder());

    public Attainment(String course, String student, int grade) 
    {
        if(course == null || student == null || grade < 0|| grade > 5 )
        {
            throw new IllegalArgumentException("Illegal argumet");
        }
        this.course = course;
        this.student = student;
        this.grade = grade;
    }

    public String getCourseCode() 
    {
        return course;
    }

    public String getStudentNumber() 
    {
        return student;
    }

    public int getGrade() 
    {
        return grade;
    }
    
    @Override
    public String toString()
    {
        return String.format("%s %s %d", course, student, grade);
    }
    
    @Override
    public int compareTo(Attainment other)
    {
        int cmp = student.compareTo(other.student);
        if(cmp == 0){
            cmp = course.compareTo(other.course);
        }
        return cmp;
    }  
    
}