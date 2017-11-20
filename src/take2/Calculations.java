package take2;

import java.util.ArrayList;

public class Calculations {
	
	double[] q,a;
	double avg;
	double sum;
	public ArrayList<Student> getAverage()
	{
		GradeReader grade = new GradeReader();
		ArrayList<Student> studentList = grade.getGrades();
		
		for(int i = 0; i < studentList.size(); i++) // Loop to calculate the quiz average and assign it to the student
		{
			q = studentList.get(i).getQuiz();
			sum = 0;
				for(int j = 0; j < q.length; j++)
				{
					avg = 0;
					sum = sum + q[j];
					avg = sum / (j + 1);
				}
			studentList.get(i).setQuizAverage(avg);
		}
		
		for(int i = 0; i < studentList.size(); i++) // Loop to calculate the assignment average and assign it to the student
		{
			a = studentList.get(i).getAssignment();
			sum = 0;
				for(int j = 0; j < a.length; j++)
				{
					avg = 0;
					sum = sum + a[j];
					avg = sum / (j + 1);
				}
			studentList.get(i).setAssignmentAverage(avg);
		}
		
		return studentList;
	}
	
	
}
