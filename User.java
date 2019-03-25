import java.io.Serializable;
import java.util.ArrayList;

public class User implements Serializable {
	
	private String username;
	
	private String password;
	
	private String FirstName;
	
	private String LastName;
	
	
	

	public User(String username, String password, String firstName, String lastName) {
		
		this.username = username;
		this.password = password;
		FirstName = firstName;
		LastName = lastName;
	}


	public User() {
		// TODO Auto-generated constructor stub
	}


	//view all courses
	public static void View_Courses (ArrayList <Course> x) {
		
		for (int i = 0; i < x.size(); i++) {
			
			Course f = x.get(i);
			
			
			System.out.println(f.getCourse_Name());
			//getting all the courses name from the arraylist by for loop
		}
		
		
	}
	
	
	//Register a student in a course
	
	public void Register_Student() {
		
		
		
		
	}
	

	
	//view list of courses student is in
	public void View_Student_Course(String Firstname, String Lastname, ArrayList <Student> x) {
		
		for (Student d : x) {
			
			String fname = d.getFirstName();
			String lname = d.getLastName();
			
			if (fname.toLowerCase().equals(Firstname.toLowerCase()) && lname.toLowerCase().equals(Lastname.toLowerCase())) {
				
				d.getCourses();
				
			}
				
				
		}
		
		
		
	}
	
	
	//exit



	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getFirstName() {
		return FirstName;
	}


	public void setFirstName(String firstName) {
		FirstName = firstName;
	}


	public String getLastName() {
		return LastName;
	}


	public void setLastName(String lastName) {
		LastName = lastName;
	}
	
	
	

}
