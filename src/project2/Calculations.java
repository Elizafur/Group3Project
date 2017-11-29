
package project2;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Calculations makes various calculations with student grades.
 * @author Group3
 */
public class Calculations {
	
	ArrayList<Double> q, a;
	double avg;
	double sum;
        
        /**
         * Gets the average grade of the students assignments and quizzes
         * @return studentList and array list of students 
         */
	public ArrayList<Student> getAverage()
	{
		Scanner dropIn = new Scanner(System.in);
		GradeReader grade = new GradeReader();
		ArrayList<Student> studentList = grade.getGrades();
		
		System.out.println("Do you want to drop the lowest grades?\n" + "1: Yes\n" + "No\n");
		int answer = dropIn.nextInt();
			
		for(int i = 0; i < studentList.size(); i++) // Loop to calculate the quiz average and assign it to the student
		{
			q = studentList.get(i).getQuiz();
			
			if(answer == 1)
				studentList.get(i).dropLowestQuiz();
				
			sum = 0;
				for(int j = 0; j < q.size(); j++)
				{
					avg = 0;
					sum = sum + q.get(j);
					avg = sum / (j + 1);
				}
			studentList.get(i).setQuizAverage(avg);
		}
		
		for(int i = 0; i < studentList.size(); i++) // Loop to calculate the assignment average and assign it to the student
		{
			a = studentList.get(i).getAssignment();
			
			if(answer == 1)
				studentList.get(i).dropLowestAssignment();
			
			sum = 0;
				for(int j = 0; j < a.size(); j++)
				{
					avg = 0;
					sum = sum + a.get(j);
					avg = sum / (j + 1);
				}
			studentList.get(i).setAssignmentAverage(avg);
		}
		
		return studentList;
	}
}
