package project2;

import java.util.ArrayList;

/**
 * Class to represent a student
 * Contains name and all grade data
 */

public class Student {
	String[] name = new String[2];
	double[] quiz = new double[5];
	double[] assignment = new double[5];
	double[] exam = new double[2];
	double project, attendance;
	
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
            	ArrayList<Double> quizList = new ArrayList<Double>();
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
            	ArrayList<Double> assignmentList = new ArrayList<Double>();
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
}
