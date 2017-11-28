/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project2;

import java.util.ArrayList;

public class GradesReport {
    
    //Grading percent constants
    private static final double QUIZ_PERCENT = 0.20;
    private static final double ASSIGN_PERCENT = 0.20;
    private static final double PROJ_PERCENT = 0.10;
    private static final double EXAM_PERCENT = 0.20;
    private static final double ATT_PERCENT = 0.10;
    
    
    GradeReader grade = new GradeReader();
    ArrayList<Student> studentList = grade.getGrades();
    
    private String[] name;
    private ArrayList<Double> quiz;
    private ArrayList<Double> assignment;
    private ArrayList<Double> exam;
    private double project, attendance, quizAverage, assignmentAverage, examAverage;
    
    //currently returns student info from reader ONLY
    public double calculateFinalGrade(String[] name, boolean dropLowest)
    {
        //all grading values
        double quiz1;
        double quiz2;
        double quiz3;
        double quiz4;
        double quiz5;
        double assign1;
        double assign2;
        double assign3;
        double assign4;
        double assign5;
        double project;
        double exam1;
        double exam2;
        double attendance;
        
        double finalGrade;
        
        //for loop to access all variables
        for (int i = 0; i < studentList.size(); i++) 
        {
            quiz = studentList.get(i).getQuiz();
            quiz1 = quiz.get(0);
            quiz2 = quiz.get(1); 
            quiz3 = quiz.get(2); 
            quiz4 = quiz.get(3);
            quiz5 = quiz.get(4);
            assignment = studentList.get(i).getAssignment();
            assign1 = assignment.get(0);
            assign2 = assignment.get(1);
            assign3 = assignment.get(2);
            assign4 = assignment.get(3);
            assign5 = assignment.get(4);
            exam = studentList.get(i).getExam();
            exam1 = exam.get(0);
            exam2 = exam.get(1);
            project = studentList.get(i).getProject();
            attendance = studentList.get(i).getAttendance();  
        }
        
        // drop lowest or not
        if (dropLowest == false) //do not drop lowest grade
        {
            double quizTotal = (quiz1 + quiz2 + quiz3 + quiz4 + quiz5);
            quizAverage = (quizTotal/5.0);
             
            double assignTotal = (assign1 + assign2 + assign3 + assign4 + assign5);
            assignmentAverage = (assignTotal/5.0);
            
            double examTotal = (exam1 + exam2);
            examAverage = (examTotal/2.0);
            
            double quizPoints = quizAverage * QUIZ_PERCENT;
            double labPoints = assignmentAverage * ASSIGN_PERCENT;
            double projPoints = project * PROJ_PERCENT;
            double examPoints = examAverage * EXAM_PERCENT;
            double attPoints = attendance * ATT_PERCENT;
            finalGrade = quizPoints + labPoints + projPoints + examPoints + attPoints + attPoints;  
        }
        else //lowest grades dropped
        {
            double quizTotal = (quiz1 + quiz2 + quiz3 + quiz4);
            quizAverage = (quizTotal/4.0);
             
            double assignTotal = (assign1 + assign2 + assign3 + assign4);
            assignmentAverage = (assignTotal/4.0);
            
            double examTotal = (exam1 + exam2);
            examAverage = (examTotal/2.0);
            
            double quizPoints = quizAverage * QUIZ_PERCENT;
            double labPoints = assignmentAverage * ASSIGN_PERCENT;
            double projPoints = project * PROJ_PERCENT;
            double examPoints = examAverage * EXAM_PERCENT;
            double attPoints = attendance * ATT_PERCENT;
            finalGrade = quizPoints + labPoints + projPoints + examPoints + attPoints + attPoints;
        }
      return finalGrade; 
    }
    
    public void PrintDetails ()
    {
        for (int i = 0; i < studentList.size(); i++) 
        {
            name = studentList.get(i).getName();
            System.out.print("\n" + name[0] + " " + name[1]);
            quiz = studentList.get(i).getQuiz();
            System.out.print("\nQuizzes: " + quiz.get(0) + ", " + quiz.get(1) + ", " + quiz.get(2) + ", " + quiz.get(3) + ", " + quiz.get(4));
            assignment = studentList.get(i).getAssignment();
            System.out.print("\nAssignment: " + assignment.get(0) + ", " + assignment.get(1) + ", " + assignment.get(2) + ", " + assignment.get(3) + ", " + assignment.get(4));
            exam = studentList.get(i).getExam();
            System.out.print("\nExams: " + exam.get(0) + ", " + exam.get(1));
            project = studentList.get(i).getProject();
            System.out.print("\nProject: " + project);
            attendance = studentList.get(i).getAttendance();
            System.out.print("\nAtendance: " + attendance);   
        }
    }
         
        
        public void setQuizAverageNoDrop ()
        {
            double value;
            value = (quiz.get(0) + quiz.get(1) + quiz.get(2) + quiz.get(3) + quiz.get(4));
            quizAverage = (value/5.0);
        }
        
        public double getQuizAverageNoDrop ()
        {
            return quizAverage;
        }
        
        public void setQuizAverageDrop ()
        {
            double value;
            value = (quiz.get(0) + quiz.get(1) + quiz.get(2) + quiz.get(3));
            quizAverage = (value/4.0);
        }
        
        public double getQuizAverageDrop ()
        {
            return quizAverage;
        }
        
        public void setAssignAverageNoDrop ()
        {
            double value;
            value = (assignment.get(0) + assignment.get(1) + assignment.get(2) + assignment.get(3) + assignment.get(4));
            assignmentAverage = (value/5.0);
        }
        
        public double getAssignAverageNoDrop ()
        {
            return assignmentAverage;
        }
        
        public void setAssignAverageDrop ()
        {
            double value;
            value = (assignment.get(0) + assignment.get(1) + assignment.get(2) + assignment.get(3));
            quizAverage = (value/4.0);
        }
        
        public double getAssignAverageDrop ()
        {
            return assignmentAverage;
        }
     
    
}

