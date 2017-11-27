/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project2;

import java.util.ArrayList;

public class GradesReport {
    
    GradeReader grade = new GradeReader();
    ArrayList<Student> studentList = grade.getGrades();
    
    String[] name;
    private ArrayList<Double> quiz;
    private ArrayList<Double> assignment;
    private ArrayList<Double> exam;
    double project, attendance, quizAverage, assignmentAverage;
    
    //methods
    public void reportGrades(String[] name, Schema s, boolean dropLowest)
    {
        System.out.println ("Student Name // Q1 Q2 Q3 Q4 Q5 // L1 L2 L3 L4 L5 // E1 E2 PROJ ATT ");
        for (int i = 0; i < studentList.size(); i++) 
        {
            name = studentList.get(i).getName();
            System.out.println(name[0] + " " + name[1]);
            quiz = studentList.get(i).getQuiz();
            System.out.print("Quizzes: " + quiz.get(0) + ", " + quiz.get(1) + ", " + quiz.get(2) + ", " + quiz.get(3) + ", " + quiz.get(4));
            assignment = studentList.get(i).getAssignment();
            System.out.print("\nAssignment: " + assignment.get(0) + ", " + assignment.get(1) + ", " + assignment.get(2) + ", " + assignment.get(3) + ", " + assignment.get(4));
            exam = studentList.get(i).getExam();
            System.out.print("\nExams: " + exam.get(0) + ", " + exam.get(1));
            project = studentList.get(i).getProject();
            System.out.println("\nProject: " + project);
            attendance = studentList.get(i).getAttendance();
            System.out.println("\nProject: " + attendance);
            
            
        }
     
    
}
}
    
