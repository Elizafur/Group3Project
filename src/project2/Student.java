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
	double project, attendance, quizAverage, assignmentAverage;
	ArrayList<Double> assignmentList = new ArrayList<Double>();
	ArrayList<Double> quizList = new ArrayList<Double>();
	
	public void setName(String[] sName)
	{
		name = sName;
	}
	
	public void setQuiz(double[] qGrade)
	{
		quiz = qGrade;
	}
	
	public void setProject(double proj)
	{
		project = proj;
	}
	
	public void setAttendance(double attend)
	{
		attendance = attend;
	}
	
	public void setAssignment(double[] aGrade)
	{
		assignment = aGrade;
	}
	
	public void setExam(double[] eGrade)
	{
		exam = eGrade;
	}
	
	public void setQuizAverage(double qAvg)
	{
		quizAverage = qAvg;
	}
	
	public void setAssignmentAverage(double aAvg)
	{
		assignmentAverage = aAvg;
	}
	
	// Start of getters
	
	public ArrayList<Double> getQuiz()
	{
		for(int i = 0; i < quiz.length; i++)
		{
			quizList.add(quiz[i]);
		}
		return quizList;
	}
	
	public ArrayList<Double> getAssignment()
	{
		for(int i = 0; i < assignment.length; i++)
		{
			assignmentList.add(assignment[i]);
		}
		return assignmentList;
	}
        
        public ArrayList<Double> getExam()  {
            ArrayList<Double> examList = new ArrayList<Double>();
            for (int i = 0; i < exam.length; ++i)   {
                examList.add(exam[i]);
            }
            
            return examList;
        }
	
	public double getAssignmentAverage()
	{
		return assignmentAverage;
	}
	
	public double getQuizAverage()
	{
		return quizAverage;
	}
	
	public String[] getName()
	{
                return name;
		//return (name[0] + " " + name[1]);
	}
        
        public double getProject()  {
            return project;
        }
        
        public double getAttendance()   {
            return attendance;
        }
	
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
