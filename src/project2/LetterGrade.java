
package project2;

/**
 * Letter grade is the grade of the student based on the number grade and schema
 * @author group3
 */
public class LetterGrade {
            
/////////////////////////////////////////////////////////////Methods///////////////////////////////////////////////////////////
    
    /**
     * Determines the letter grade of the student based on the schema
     * @param s the schema (1, 2, or 3)
     * @param score the score of student
     * @return grade the letter grade
     */
    public static String getLetterGradeForSchema (Schema s, double score)
    {
        String grade = "";
        if (s == Schema.ONE)    {
            if (score >= 90) 
            {
                grade = "A";
            }
            else if (score >= 80) 
            {
                grade = "B";
            }
            else if (score >= 70) 
            {
                grade = "C";
            }
            else if (score >= 60) 
            {
                grade = "D";
            }
            else 
            {
                grade = "F";
            }
        }
        else if (s == Schema.TWO)   {
            if (score >= 90) 
            {
                grade = "A";
            }
            else if (score >= 80) 
            {
                grade = "B";
            }
            else if (score >= 70) 
            {
                grade = "C";
            }
            else if (score >= 65) 
            {
                grade = "D";
            }
            else 
            {
                grade = "F";
            }
        }
        else    {
            if (score >= 95) 
            {
                grade = "A+";
            }
            else if (score >= 90) 
            {
                grade = "A";
            }
            else if (score >= 85) 
            {
                grade = "B+";
            }
            else if (score >= 80) 
            {
                grade = "B";
            }
            else if (score >= 70) 
            {
                grade = "C";
            }
            else if (score >= 65) 
            {
                grade = "D";
            }
            else 
            {
                grade = "F";
            }
        }
        
        return grade;
    }
}
