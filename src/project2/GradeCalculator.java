/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project2;

import java.util.ArrayList;

/**
 *
 * @author EliF
 */
public class GradeCalculator {
    private static final double QUIZ_PERCENT = .2;
    private static final double ASSIGN_PERCENT = .2;
    private static final double PROJ_PERCENT = .1;
    private static final double EXAM_PERCENT = .4;
    private static final double ATT_PERCENT = .1;

    
    public static double calculateQuizAverage(Student s)    {
        ArrayList<Double> quizzes = s.getQuiz();
        double avg = 0;
        
        for (int i = 0; i < quizzes.size(); ++i) {
            avg += quizzes.get(i);
            
        }
        
        return avg / quizzes.size();
    }
    public static double calculateAssignmentAverage(Student s)  {
        ArrayList<Double> assignments = s.getAssignment();
        double avg = 0;
        
        for (int i = 0; i < assignments.size(); ++i) {
            avg += assignments.get(i);
            
        }
        
        return avg / assignments.size();
    }
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
    public static String getLetterGrade(double grade, Schema s)  {
        //TODO Placeholder
        return "B";
        
    }
    
}
