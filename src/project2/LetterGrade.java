/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project2;

/**
 *
 * @author Owner
 */
public class LetterGrade {

    //private GradesCalculator aGrade = new GradesCalculator();
    //double score; 
    private String grade;

    public void setGradesSchema1 (double score)
    {
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
    
    public String getGradeSchema1 ()
    {
        return grade;
    }
    
    public void setGradeSchema2 (double score)
    {
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
    public String getGradeSchema2 ()
    {
        return grade;
    }
    
    
    public void setGradeSchema3 (double score)
    {
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
    
    public String getGradeSchema3 ()
    {
        return grade;
    }
    
    
}
