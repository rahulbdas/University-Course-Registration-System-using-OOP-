import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

public interface Admin_Interface {
	
	//create a new course with 
	
	public abstract Course New_Course(String course_Name, String course_Id, String maximum_Students,
			 String instructor, String course_Section, String course_Location, ArrayList<Course> d);
	
	
	//write a file to full courses
	
	public abstract void Write_File(ArrayList<Course> d) throws FileNotFoundException, UnsupportedEncodingException;
	
	//arraylist of students 

	//public ArrayList <Student> All_Students;
	
	
	//delete a course
	public abstract void Delete_Course(ArrayList <Course> c, String d);
	//edit a course
	public abstract void Edit_Course(String courseName, String instructor, ArrayList <Course> c);
	//display info in course by id
	
	public abstract void Display_Course(String CourseName, ArrayList <Course> c);
	//register a student abd create a password and username
	
	
	public void  View_Full_Courses(ArrayList<Course> d);
	
	
	
	public static  void Register_Student(ArrayList<Student> stu, String firstname, String lastname) {
		
		
	}
		
	
	//view all student's names in specific course
	 
	
	public abstract void View_Studnets_InCourse(ArrayList <Course> d, String course) ;
		
		
		
	}
	
	

