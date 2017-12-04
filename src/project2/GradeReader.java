
package project2;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.FileNotFoundException;

/**
 * A Grade Reader creates students and assign grades to each individual student based on text file.
 * @author Group 3
 */

public class GradeReader {
	// Method that creates and returns an arraylist of students
    /**
     * Creates an array list of student objects by reading from a text file
     * @return studentAL an array list of student objects
     */
	public ArrayList<Student> getGrades()
	{	
		ArrayList<Student> studentAL = new ArrayList<Student>(); //Array list to hold your student objects.
		
		try {
			File inputFile = new File(System.getProperty("user.dir") + "\\StudentRoster2.txt");
	
			Scanner in = new Scanner(inputFile); 
	
			int count = 0; // Loop counter to control which student you are reading in for.
			while(in.hasNext()) {
			    if(count%2==0) {//on even loops get name
			    	String[] name = new String[2];
		
			    	name[0] = in.next();
			    	name[1] = in.next();
			    	
			    	studentAL.add(new Student()); //Create a new student on every even loop just before assigning a name.
			    	studentAL.get(studentAL.size()-1).setName(name);
			    	
			    } else { // on odd loops get the grades
			    	double[] quizGrade = new double[5];
			    	double[] assignGrade = new double[5];
			    	double[] examGrade = new double[2];
			    	double projectGrade, attendanceGrade;
			    	
			    	for(int i = 0; i <= 4; i++) //Loops to read in each of the grades into their respective variables
			    		quizGrade[i] = in.nextDouble();
			    	
			    	for(int i = 0; i <= 4; i++)
			    		assignGrade[i] = in.nextDouble();
			    	
			    	for(int i = 0; i <= 1; i++)
			    		examGrade[i] = in.nextDouble();
			    	
			    	attendanceGrade = in.nextDouble();
			    	projectGrade = in.nextDouble();
			    	
			    	//Assigning all of the grades back to the student
			    	studentAL.get(studentAL.size()-1).setQuiz(quizGrade);
			    	studentAL.get(studentAL.size()-1).setAssignment(assignGrade);
			    	studentAL.get(studentAL.size()-1).setExam(examGrade);
			    	studentAL.get(studentAL.size()-1).setAttendance(attendanceGrade);
			    	studentAL.get(studentAL.size()-1).setProject(projectGrade);
			    }
			    count++;
			}
		
			in.close();
			
				}catch(FileNotFoundException e)
					{
						System.out.print(e.getMessage());
					}
		return studentAL;
		
	}
}

