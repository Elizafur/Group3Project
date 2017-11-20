package take2;


import java.io.FileNotFoundException;
import java.util.ArrayList;


public class test {
	public static void main(String args[]) throws FileNotFoundException
	{
		Calculations test = new Calculations();
		ArrayList<Student> s = test.getAverage();
		System.out.println(s.get(0).getQuizAverage());
		System.out.println(s.get(0).getAssignmentAverage());
		
	}
}
