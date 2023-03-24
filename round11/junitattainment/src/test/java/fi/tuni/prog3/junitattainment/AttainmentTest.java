package fi.tuni.prog3.junitattainment;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


public class AttainmentTest 
{
    
    public AttainmentTest() 
    {
    }
    @BeforeAll
    public static void setUpClass() throws Exception 
    {
    }
    @AfterAll
    public static void tearDownClass() throws Exception 
    {
    }
    @BeforeEach
    public void setUp() throws Exception 
    {
    }
    @AfterEach
    public void tearDown() throws Exception 
    {
    }
    @Test
    public void whenExceptionThrown() 
    {
        System.out.println("whenExceptionThrown");
        Exception exception;
        exception = assertThrows(IllegalArgumentException.class, () -> 
        {
            Attainment attainment = new Attainment("COMP.CS.140", "12345", -1);
        });

        String expectedMessage = "Invalid course code, student number or grade!";
        String actualMessage = exception.getMessage();
        System.out.println(actualMessage);
        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    public void testGetCourseCode() 
    {
        System.out.println("getCourseCode");
        Attainment instance = new Attainment("COMP.CS.140", "12345", 4);
        String expResult = "COMP.CS.140";
        String result = instance.getCourseCode();
        assertEquals(expResult, result);
    }

    @Test
    public void testGetStudentNumber() 
    {
        System.out.println("getStudentNumber");
        Attainment instance = new Attainment("COMP.CS.140", "12345", 4);
        String expResult = "12345";
        String result = instance.getStudentNumber();
        assertEquals(expResult, result);
    }

    @Test
    public void testGetGrade() 
    {
        System.out.println("getGrade");
        Attainment instance = new Attainment("COMP.CS.140", "12345", 4);
        int expResult = 4;
        int result = instance.getGrade();
        assertEquals(expResult, result);
    }

    @Test
    public void testToString() 
    {
        System.out.println("toString");
        Attainment instance = new Attainment("COMP.CS.140", "12345", 4);
        String expResult = "COMP.CS.140 12345 4";
        String result = instance.toString();
        assertEquals(expResult, result);
    }

    @Test
    public void testCompareTo() 
    {
        System.out.println("compareTo");
        Attainment other = new Attainment("COMP.CS.140", "12345", 4);
        Attainment instance = new Attainment("COMP.CS.300", "12345", 5);
        int expResult = 2;
        int result = instance.compareTo(other);
        assertEquals(expResult, result); 
    }
}