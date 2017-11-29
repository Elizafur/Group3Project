
package project2;

import java.util.ArrayList;

/**
 * A student can have many grades.
 * @author Group 3
 */

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
         * @param sName the student name
         */
	public void setName(String[] sName)
	{
		name = sName;
	}
	
        /**
         * Sets the quiz grades (5)
         * @param qGrade the quiz grades
         */
	public void setQuiz(double[] qGrade)
	{
		quiz = qGrade;
	}
        
	/**
         * Sets the projects grade
         * @param proj the project grade
         */
	public void setProject(double proj)
	{
		project = proj;
	}
	
        /**
         * Sets the attendance grade
         * @param attend the attendance grade
         */
	public void setAttendance(double attend)
	{
		attendance = attend;
	}
	
        /**
         * Sets the assignment grades (5)
         * @param aGrade the assignment grades
         */
	public void setAssignment(double[] aGrade)
	{
		assignment = aGrade;
	}
	
        /**
         * Sets the exam grades (2)
         * @param eGrade the exam grades
         */
	public void setExam(double[] eGrade)
	{
		exam = eGrade;
	}
	
	
	/////////////////////////////////////////////Getters////////////////////////////////////////////////////////////
	
        /**
         * Gets the quiz grades
         * @return quizList the array list of quiz grades
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
         * @return assignmentList the array list of assignment grades
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
         * @return examList the array list of exam grades
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
         * @return name the name of the student
         */
	public String[] getName()
	{
                return name;
	}
        
        /**
         * Gets the project grade
         * @return project the project grade
         */
        public double getProject()  {
            return project;
        }
        
        /**
         * Gets the attendance grade
         * @return attendance the attendance grade
         */
        public double getAttendance()   {
            return attendance;
        }
	
        ////////////////////////////////OTHER METHODS////////////////////////////////////////////////////////////////////////
        
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
         * Prints the student info for testing purposes
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
