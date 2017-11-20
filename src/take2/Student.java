package take2;


public class Student {
	String firstName, lastName;
	double[] quiz = new double[5];
	double[] assignment = new double[5];
	double[] exam = new double[2];
	double project, attendance, quizAverage, assignmentAverage;
	
	public void setName(String[] name)
	{
		firstName = name[0];
		lastName = name[1];
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
	
	// List of getters
	
	public double[] getQuiz()
	{
		return quiz;
	}
	
	public double[] getAssignment()
	{
		return assignment;
	}
	
	public double getAssignmentAverage()
	{
		return assignmentAverage;
	}
	
	public double getQuizAverage()
	{
		return quizAverage;
	}
		
	public void print()
	{
		System.out.println(firstName + " " + lastName);
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