/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project2;

import java.util.ArrayList;

public class Student {
	String[] name = new String[2];
	double[] quiz = new double[5];
	double[] assignment = new double[5];
	double[] exam = new double[2];
	double project, attendance;
	ArrayList<Double> assignmentList = new ArrayList<Double>();
	ArrayList<Double> quizList = new ArrayList<Double>();
	
        ///////////////////////////////////////////////Setters///////////////////////////////////////////////////////////
        
        /**
         * Sets the name of the student
         * @param sName 
         */
	public void setName(String[] sName)
	{
		name = sName;
	}
	
        /**
         * Sets the quiz grades (5)
         * @param qGrade 
         */
	public void setQuiz(double[] qGrade)
	{
		quiz = qGrade;
	}
        
	/**
         * Sets the projects grade
         * @param proj 
         */
	public void setProject(double proj)
	{
		project = proj;
	}
	
        /**
         * Sets the attendance grade
         * @param attend 
         */
	public void setAttendance(double attend)
	{
		attendance = attend;
	}
	
        /**
         * Sets the assignment grades (5)
         * @param aGrade 
         */
	public void setAssignment(double[] aGrade)
	{
		assignment = aGrade;
	}
	
        /**
         * Sets the exam grades (2)
         * @param eGrade 
         */
	public void setExam(double[] eGrade)
	{
		exam = eGrade;
	}
	
	
	/////////////////////////////////////////////Getters////////////////////////////////////////////////////////////
	
        /**
         * Gets the quiz grades
         * @return quizList
         */
	public ArrayList<Double> getQuiz()
	{
		for(int i = 0; i < quiz.length; i++)
		{
			quizList.add(quiz[i]);
		}
		return quizList;
	}
	
        
        /**
         * Gets the assignments grades
         * @return assignmentList
         */
	public ArrayList<Double> getAssignment()
	{
		for(int i = 0; i < assignment.length; i++)
		{
			assignmentList.add(assignment[i]);
		}
		return assignmentList;
	}
        
        /**
         * Gets the exam grades
         * @return examList
         */
        public ArrayList<Double> getExam()  {
            ArrayList<Double> examList = new ArrayList<Double>();
            for (int i = 0; i < exam.length; ++i)   {
                examList.add(exam[i]);
            }
            
            return examList;
        }
	
        /**
         * Gets the student name
         * @return name
         */
	public String[] getName()
	{
                return name;
	}
        
        /**
         * Gets the project grade
         * @return project
         */
        public double getProject()  {
            return project;
        }
        
        /**
         * Gets the attendance grade
         * @return attendance
         */
        public double getAttendance()   {
            return attendance;
        }
	
        /**
         * Removes the lowest quiz grade
         */
	public void dropLowestQuiz() 
	{
		double lowest = quizList.get(0);
		int lowestPosition = 0;
		for(int i = 0; i < quizList.size(); i++)
		{
			if(quizList.get(i) < lowest)
			{
				lowest = quizList.get(i);
				lowestPosition = i;
			}
		}
		quizList.remove(lowestPosition);
	}
	
        /**
         * Removes the lowest assignment grade
         */
	public void dropLowestAssignment()
	{
		double lowest = assignmentList.get(0);
		int lowestPosition = 0;
		
		for(int i = 0; i < quizList.size(); i++)
		{
			if(assignmentList.get(i) < lowest)
			{
				lowest = assignmentList.get(i);
				lowestPosition = i;
			}
		}
		assignmentList.remove(lowestPosition);
	}	
		
        /**
         * Prints the student info for testing
         */
	public void print()
	{
		System.out.println(name[0] + " " + name[1]);
		for(int i = 0; i <= 4; i++)
		{
			System.out.print(quiz[i] + " ");
		}
		System.out.println(" ");
		for(int i = 0; i <= 4; i++)
		{
			System.out.print(assignment[i] + " ");
		}
		System.out.println(" ");
		for(int i = 0; i <= 1; i++)
		{
			System.out.print(exam[i] + " ");
		}
		System.out.println(" ");
		System.out.println(attendance);
		System.out.println(project);
	}
}
