/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project2;

import java.io.FileNotFoundException;
import java.util.ArrayList;

public class Test {

	public static void main(String args[]) throws FileNotFoundException
	{
		//Calculations test = new Calculations();
		//ArrayList<Student> s = test.getAverage();
		//System.out.println(s.get(0).getQuizAverage());
		//System.out.println(s.get(0).getAssignmentAverage());
                
                //GradeReader m = new GradeReader();
                //m.getGrades();
            
                GradesReport g = new GradesReport();
                g.PrintDetails();
            
//                Student s = new Student();
//                s.print();
                
                //GradesReport gradesR = new GradesReport();
                //gradesR.reportGradesNoDrop();
		
	}
}

    

