
package project2;

import java.util.ArrayList;

/**
 * A grade calculator determines the student grades.
 * It can be changed by the types of grades to be included in the final grade.
 * @author Group 3
 */
public class GradeCalculator {
    private static final double QUIZ_PERCENT = .2;
    private static final double ASSIGN_PERCENT = .2;
    private static final double PROJ_PERCENT = .1;
    private static final double EXAM_PERCENT = .4;
    private static final double ATT_PERCENT = .1;

    /**
     * Calculates the average quiz grades
     * @param s the students whose grade is to be calculated
     * @return avg the average quiz grade
     */
    public static double calculateQuizAverage(Student s)    {
        ArrayList<Double> quizzes = s.getQuiz();
        double avg = 0;
        
        for (int i = 0; i < quizzes.size(); ++i) {
            avg += quizzes.get(i);
            
        }
        
        return avg / quizzes.size();
    }
    /**
     * Calculates the average assignment grades
     * @param s the students whose grade is to be calculated
     * @return avg the average assignment grade
     */
    public static double calculateAssignmentAverage(Student s)  {
        ArrayList<Double> assignments = s.getAssignment();
        double avg = 0;
        
        for (int i = 0; i < assignments.size(); ++i) {
            avg += assignments.get(i);
            
        }
        
        return avg / assignments.size();
    }
    
    /**
      * Calculates the final grades
     * @param s the students whose grade is to be calculated
     * @return _____________ the final grade of the student
     */
    public static double calculateFinalGrade(Student s) {
        
        //TODO doesn't calculator properly
        //Also add drop ability
        double quizPoints = calculateQuizAverage(s) * QUIZ_PERCENT;
        double assignPoints = calculateAssignmentAverage(s) * ASSIGN_PERCENT;
        double projPoints = s.getProject() * PROJ_PERCENT;
        double examPoints = ((s.getExam().get(0) + s.getExam().get(1)) / 2) * EXAM_PERCENT;
        double attPoints = s.getAttendance() * ATT_PERCENT;
        return (quizPoints + assignPoints + projPoints + examPoints + attPoints + attPoints);
    }
    
    /**
     * Determines the letter grade of the student
     * @param grade the number grade of the student
     * @param s the grading schema
     * @return ___________ the letter grade of the student based on the schema
     */
    public static String getLetterGrade(double grade, Schema s)  {
        //TODO Placeholder
        return "B";
        
    }
    
}
