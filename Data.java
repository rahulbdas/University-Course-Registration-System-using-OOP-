import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;


/**
 * this clas will begin putting the csv dara of the courses into a course object  
 * @author rahuldas
 *
 */
public class Data {
	
	
	//this will hold the string for all the data
	private String Courses;
	
	
	
	
/**
 * this methid will simply read the data in the csv file and put it in a large string
 * @return
 * @throws FileNotFoundException
 */
	
public static String CourseString() throws FileNotFoundException {
		
	String l1 = "";
	
	//this will hold all the strings that is about to be created
		
	
	Scanner sc = new Scanner (new File("src/MyUniversityCourses.csv"));
		
	while (sc.hasNextLine()) {
		
		String line2 = sc.nextLine();
		l1 += line2 + "/";
		//this will read all the data in the file an add all values of courses in 1 string
			
		}
		
	sc.close();
	return l1;
	
		
	}

public static String[][] array (String CourseString){
	
	String [] array = CourseString.split("/");
	//splits data based in then the / i added b4 each line break
	
	
	
	
	String [][] array2 = new String[array.length +1][8];
	//creates a new array i will copy array into
	//there are 4 spots in the second array for the name, rank, year, unit, or date
	int count = 0;
	
	//this is for the index for the array
	for (String z : array) {
		
		String [] cat = z.split(",");
		//temporary string seperate by the commas
		int count2 = 0;
		//this is for the index of cat
			count ++;
			//to keep track of each index per line
		for (int i = 0; i < cat.length; i ++) {
			String x = cat[i];
			
			//System.out.println(x); //used to test my code to see of this works
			array2[count][count2] = cat[i];
			count2++;
			//to keep track of each thing in the line
		}
		
		count2 = 0;
		//reset the count for each line
		
	}
	return array2;
}

/**
 * this method will create a new array list full of course objects
 * 
 * @param array2
 */
public static ArrayList<Course> MakeCourse(String [][] array2) {
	ArrayList <Course> CourseList = new ArrayList();
	
	
	
	//Course c1 = new Course();
	
	for (int i = 2; i < array2.length; i ++) {
		
		
		
			
			//String name = array2[i][0];
			
			Course name = new Course();
			
			name.setCourse_Name(array2[i][0]);
			name.setCourse_Id(array2[i][1]);
			
			//System.out.println(array2[i][2]);

			
			name.setMaximum_Students(array2[i][2]);
			
			//name.getCurrent_Students(array2[i][3]);
			
			name.setInstructor(array2[i][5]);
			
			name.setCourse_Section(array2[i][6]);
			name.setCourse_Location(array2[i][7]);
			CourseList.add(name);
			
			//System.out.println(i); checking to see if there were right number of courses
			
		
		
		
	}

	
	return CourseList;
	
	
	
	
	
	
}
}
