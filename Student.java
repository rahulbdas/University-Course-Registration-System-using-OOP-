import java.util.ArrayList;
import java.util.Random;

public class Student extends User implements Student_Interface  {
	
	//courses list
	
	Random rand = new Random();
	
	
	
	private ArrayList<String> Courses = new ArrayList<String>();

	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Student (String firstName, String lastName, String username, String password) {
		
		
				
		super( username,  password,  firstName,  lastName);
		
	}
	
	




	public void getCourses() {
		
		System.out.println(this.getFirstName() + " " + this.getLastName() + " is enrolled in these courses:");

		
		
		for (String x: this.Courses) {
			System.out.println(x);
			
			
		}
		
		
	}

	
	
	
	// view courses that are not full
	
	public void View_NotFull_Courses(ArrayList<Course> d) {
		System.out.println("The availbale courses are: ");

		
		for (int i = 0; i < d.size(); i++) {
			
			Course c = d.get(i);
		
			
			if (c.getCurrent_Students() < c.getMaximum_Students()) {
				

				System.out.println(c.getCourse_Name());
			}
			
			
		}
		
		
		
		
		
		
	}
	
	//withdraw
	
	public  void WithDraw_Courses(ArrayList <Course> x, Student x2, String course, String section) {
		
		
		
		
		for (int i = 0; i < x.size(); i++) {
			
			Course d = x.get(i);
			
			
			if ( d.getCourse_Name().equals(course) && d.getCourse_Section().equals(section)) {
				
				d.delete_Student(x2);
				
				Courses.remove(course);
			}
		}
		System.out.println("You have succesfully withdrawn from the course.");
		
	
	}
		

		
		
		
	
	
//register a student for a course
	
	public  void Register(Student name,  ArrayList <Course> x, String course, String section ) {
		
		
		for (int i = 0; i < x.size(); i++) {
			 
			Course d = x.get(i);
			
			
			
			if ( d.getCourse_Name().toLowerCase().equals(course.toLowerCase()) && d.getCourse_Section().equals(section)) {
				
				
				Courses.add(course);
				
				d.add_Student(name);
				
				

				
				
			
		}
		
		
		}
		
	}

	
	public void View_Student_Choices() {
		
		
		System.out.println("1. View all courses.");
		
		System.out.println("2. View all courses that are not FULL.");
		
		System.out.println("3. Register for a course.");
		
		System.out.println("4. Withdraw from a course.");
		
		System.out.println("5.View all current courses.");
		
		System.out.println("6. Exit.");

		
	}
	
	public void withdraw(String o) {
		
		Courses.remove(o);
		
	}
	
	
	

}

