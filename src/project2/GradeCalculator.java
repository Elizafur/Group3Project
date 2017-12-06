package project2;

import java.util.ArrayList;

/**
 * @author EliF
 * Class used to contain methods used to calculate grade values based on schemas and whether or not
 * the user chooses to drop the lowest grade.
 */
public class GradeCalculator {
    /**
     * Assignment weight values
     */
    private static final double QUIZ_PERCENT = .2;
    private static final double ASSIGN_PERCENT = .2;
    private static final double PROJ_PERCENT = .1;
    private static final double EXAM_PERCENT = .4;
    private static final double ATT_PERCENT = .1;

    /**
<<<<<<< HEAD
     * 
     * @param s The student who's quiz average will be calculated.
     * @param dropLowest Whether to drop the lowest quiz and assignment from the students grade list.
     * @return Returns a double representation of a student's average quiz grade.
     */
    public static double calculateQuizAverage(Student s, boolean dropLowest)    {
        ArrayList<Double> quizzes = s.getQuiz();
        double pointsRecieved = 0;
        
        int lowest = getLowestValueIndex(quizzes);
        if (dropLowest) {
            quizzes.remove(lowest);
        }
        
        for (int i = 0; i < quizzes.size(); ++i) {
            pointsRecieved += quizzes.get(i);
            
        }
            
             //Points got over points possible
        return pointsRecieved / (quizzes.size() * 100);
    }
    
    /**
     * 
     * @param s The student who's assignment average will be calculated.
     * @param dropLowest Whether to drop the lowest quiz and assignment from the students grade list.
     * @return Returns a double representation of a student's average assignment grade.
     */
    public static double calculateAssignmentAverage(Student s, boolean dropLowest)  {
        ArrayList<Double> assignments = s.getAssignment();
        double pointsRecieved = 0;
        
        int lowest = getLowestValueIndex(assignments);
        if (dropLowest) {
            assignments.remove(lowest);
        }
        
        for (int i = 0; i < assignments.size(); ++i) {
            pointsRecieved += assignments.get(i);
            
        }
        
        return pointsRecieved / (assignments.size() * 100);
    }
    
    /**
     * @param s The Student who's final grade will be calculated.
     * @param dropLowest Whether to drop the lowest quiz and assignment from the students grade list.
     * @return Returns a double representation of a student's final number grade.
     */
    public static double calculateFinalGrade(Student s, boolean dropLowest) { 
        double quizPoints = calculateQuizAverage(s, dropLowest) * QUIZ_PERCENT;
        double assignPoints = calculateAssignmentAverage(s, dropLowest) * ASSIGN_PERCENT;
        
        double projPoints = (s.getProject() / 100)* PROJ_PERCENT;
        double examPoints = ((s.getExam().get(0) + s.getExam().get(1)) / 200) * EXAM_PERCENT;
        double attPoints = (s.getAttendance() / 100) * ATT_PERCENT;
        return (quizPoints + assignPoints + projPoints + examPoints + attPoints) * 100;
    }
    
    /**
     * 
     * @param grade The double representation of a student's final number grade.
     * @param s The grade schema to be used: either ONE, TWO, or THREE.
     * @return Returns a string representation of the student's number grade based on the Schema provided.
     */
    public static String getLetterGrade(double grade, Schema s)  {
        return LetterGrade.getLetterGradeForSchema(s, grade);      
    }
    
    /**
     * 
     * @param a An array with which to return the lowest grade in the array.
     * @return The index of the lowest grade within array a.
     */
    private static int getLowestValueIndex(ArrayList<Double> a)   {
        int lowestIndex = 0;
        
        for (int i = 0; i < a.size() - 1; ++i)  {
            if (a.get(i+1) < a.get(lowestIndex))    {
                lowestIndex = i+1;
            }
        }
        
        return lowestIndex;
    }
    
}
