/*
 * This class determines the letter grade.
 * There are three grading schemas.
 */
package project2;

public class LetterGrade {
            
/////////////////////////////////////////////////////////////Methods///////////////////////////////////////////////////////////
    /**
     * Sets the grading to schema 1
     * @param score 
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
