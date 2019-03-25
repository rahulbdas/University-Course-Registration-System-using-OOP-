import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Scanner;

public class MainMethod {
	
	public static void main(String[] args) throws IOException {
		//User us = new User();
		
		
		Scanner sc = new Scanner(System.in);

		System.out.println("Is this your first time using this Course Registration System. Please answer yes 'y' or no 'n'.");
		
		String ans = sc.nextLine().toLowerCase();
		
		while( !ans.equals("y") && !ans.equals("n")) {
			
			System.out.println("Please enter a valid input. Yes 'y' or No 'n'. ");
			String ans2 = sc.nextLine().toLowerCase();

			
			ans = ans2;
			
			
		}
		ArrayList <Course> CourseArray = new ArrayList<Course>();
		
		ArrayList<Student> students = new ArrayList<Student>();
		
		
		
		if (ans.equals("y")) {
		
			Data d = new Data();
		
			String x = d.CourseString();
		
		
		
		//System.out.println(d.MakeCourse(d.array(x)));
		
		
			//Course c2 = CourseArray.get(10);
		
		//System.out.println(c2.getCourse_Section());
		//how to create names specified in an arraylist
		
		//us.View_Courses(CourseArray);
			
			ArrayList <Course> CourseArray2 = d.MakeCourse(d.array(x));

			ArrayList<Student> students2 = new ArrayList<Student>();
			
			CourseArray = CourseArray2;
			
			students = students2;
			
		
		}
		
		//deserialization here 
		else {
			
			try{
				  //FileInputSystem recieves bytes from a file
			      FileInputStream fis = new FileInputStream("CourseArray.ser");
			      
			      FileInputStream fis2 = new FileInputStream("Student.ser");

			      
			      
			      //ObjectInputStream does the deserialization-- it reconstructs the data into an object
			      ObjectInputStream ois = new ObjectInputStream(fis);
			      
			      
			      ObjectInputStream ois2 = new ObjectInputStream(fis2);

			      //Cast as Employee. readObject will take the object from ObjectInputStream
			      CourseArray = (ArrayList<Course>)ois.readObject();
			      
			      students = (ArrayList<Student>)ois2.readObject();
			      

			      ois.close();
			      fis.close();
			      
			      ois2.close();
			      fis2.close();
			    }
			    catch(IOException ioe) {
			       ioe.printStackTrace();
			       return;
			    }
			 catch(ClassNotFoundException cnfe) {
			       cnfe.printStackTrace();
			       return;
			     }
			
			
			
		}
		//flag to keep program running 
		
		
		boolean w = true;
		
		while (w) {
		
		
		
		System.out.println("Welcome to the Course Registration System. Please enter if you are a student (s) or Admin (a).");
		
		String s = sc.nextLine().toLowerCase();
		
		while (!s.equals("s") && !s.equals("a") ) {
			
			System.out.println("Please enter an 'a' for admin or a 's' for student .");
			
			String 
			s1 = sc.nextLine();

			s = s1;
			
		}
				
		//another flag for a while loop
		boolean h = true;
		
		
			
			
		
		
		if (s.equals("a")) {
			
			System.out.println("Please Enter a Username");
			String username = sc.nextLine();
			
			while (!username.equals("Admin")) {
				
				System.out.println("That was an incorrect username");
				System.out.println("Please Enter a Username");

				String username1 = sc.nextLine();
				username = username1;
				

			}
			
			System.out.println("Please Enter a Password");
			
			String password = sc.nextLine();

			while (!password.equals("Admin001")) {
				
				System.out.println("That was an incorrect password");
				System.out.println("Please Enter a Password");

				String password1 = sc.nextLine();
				
				password = password1;
				
				

			}
			
			Admin admin = new Admin();
			
			
			while (h) {
				
				
			System.out.println("Welcome Admin. Here are your options:");
			
			System.out.println("For Course Management enter 'c'");
			
			System.out.println("For Reports enter 'r'");
			
			String l = sc.nextLine();

			
			
			while (!l.equals("c") && !l.equals("r")) {
				
				System.out.println("For Course Management enter 'c'");
				
				System.out.println("For Reports enter 'r'");
				
				
				String l1 = sc.nextLine();
				
				l = l1;
				

				
			}
			
			
			if (l.equals("c")) {
				admin.View_CourseManagement();
				
				System.out.println("Please enter the number of the selection you would like to do.");
				String choice = sc.nextLine();
				
				while (!choice.equals("1") && !choice.equals("2") &&!choice.equals("3") &&!choice.equals("4") && !choice.equals("5") && !choice.equals("6")) {
					System.out.println("Please enter A VALID number of the selection you would like to do.");
					String choice1 = sc.nextLine();
					
					choice = choice1;
					
				}
				if (choice.equals("1")) {
					
					System.out.println("Please give a course name.");
					
					String course_Name = sc.nextLine();
					
					
					System.out.println("Please give a course ID.");
					
					String course_Id = sc.nextLine();
					
					System.out.println("Please specify the maximum amount of students.");
					
					String maximum_Students = sc.nextLine();
					

					System.out.println("Please specify the instructor.");
					
					String instructor = sc.nextLine();
					
					
					System.out.println("Please give the course section.");
					
					
					
					String course_Section = sc.nextLine();
					
					System.out.println("Please give the course location.");
					
					String course_Location = sc.nextLine();


					
					admin.New_Course(course_Name, course_Id, maximum_Students, instructor, course_Section, course_Location, CourseArray);
					
					System.out.println("The course was successfully created.");
					
					
				}
				
				if (choice.equals("2")){
					
					System.out.println("What course would you like to delete? Please give the course name.");
					String name = sc.nextLine();
					
					
					
					
			
					admin.Delete_Course(CourseArray, name);
					
					System.out.println("The course was successfully deleted.");
					
				}
				if (choice.equals("3")){
					
					
					System.out.println("What course what you like to edit?");
					
					String c = sc.nextLine();
					
					System.out.println("What would you like to change the instructor's name to?");
					
					String instructor = sc.nextLine();
					


					admin.Edit_Course(c , instructor, CourseArray);
					
				}
				if (choice.equals("4")){
					
					
					System.out.println("What course what you like to view? Please give the course ID.");
					String c = sc.nextLine();
					
					

					admin.Display_Course(c,CourseArray );
					
					
				}
				if (choice.equals("5")) {
					
					System.out.println("Please enter the first name of the student");
					
					String fname = sc.nextLine();
					System.out.println("Please enter the last name of the student");
					String lname = sc.nextLine();
					
					admin.Register_Student(students, fname, lname );

					
					
				}
				
				
				if (choice.equals("6")) {
					w = false;
					h = false;
					
					
					
				}
			}
			
			else {
				admin.View_Reports();
				
				System.out.println("Please enter the number of the selection you would like to do.");
				
				String choice = sc.nextLine();

				while (!choice.equals("1") && !choice.equals("2") &&!choice.equals("3") &&!choice.equals("4") && !choice.equals("5") && !choice.equals("6") && !choice.equals("7")) {
					System.out.println("Please enter A VALID number of the selection you would like to do.");
					String choice1 = sc.nextLine();
					
					choice = choice1;
					
				}
				
				if (choice.equals("1")) {
					admin.View_Courses(CourseArray);
					
					
				}
			
		
				
				if (choice.equals("2")) {
					
					admin.View_Full_Courses(CourseArray);
				}
		
			
			
		
				
				if (choice.equals("3")) {
					
					admin.Write_File(CourseArray);
					System.out.println("The file was succesfully created of full courses.");
					
					
					
				}
					
				
				
				if (choice.equals("4")) {
					
					System.out.println("Please enter the Course Name you would like to see the student's of.");
					
					String course = sc.nextLine();
					
					boolean g = true;
					
					
					admin.View_Studnets_InCourse(CourseArray, course);
				}

				if (choice.equals("5")) {
					
					System.out.println("Please enter the Student's first name");
					
					String fname = sc.nextLine();
					
					
					System.out.println("Please enter the Student's last name");
					
					String lname = sc.nextLine();

					
					admin.View_Student_Course(fname, lname, students);
					

}
				
				if (choice.equals("6")) {
					
					admin.Sort(CourseArray);
					
					
					
					
				}

				
				if (choice.equals("7")) {
					
					w = false;
					h = false;
					
					
					
					
					
				}
				
			}
}
			
		}
		
		boolean f = true;
		
		
		
		if (s.equals("s")) {
			
			//System.out.println("Please Enter a Username");
			//String username1 = sc.nextLine();
			
			//flag for validation
			
			boolean c = true;
			
			
			while (c) {
				System.out.println("Please Enter a username.");
				String username1 = sc.nextLine();
				for (Student stu: students  ) {
					
					String uname = stu.getUsername();
					
					
					if (username1.equals(uname)) {
						
						c = false;
						
						
					}
				}
				
				if (c == true) {
				System.out.println("That was an incorrect username.");
						//System.out.println("Please Enter a Username");

				//String username11 = sc.nextLine();
				//username1 = username11;
					}
			
					
			}
				Student Current_Student = new Student();
				
			
			
				
				
				
			while (!c) {
				System.out.println("Please Enter a password");
				String password1 = sc.nextLine();
				for (Student stu: students  ) {
					
					String pass = stu.getPassword();
					
					
					if (password1.equals(pass)) {
						Current_Student = stu;
						c = true;
						
				
						
					}
				}
				
				if (c == false) {
				
				System.out.println("That was an incorrect password.");
						//System.out.println("Please Enter a Username");

				//String username11 = sc.nextLine();
				//password1 = username11;
					}
			
			}
			
			while (f) {
			
		
			
			Current_Student.View_Student_Choices();
			
			//System.out.println(Current_Student.getFirstName());
			
			
			String choice = sc.nextLine();
			
			
			

			while (!choice.equals("1") && !choice.equals("2") &&!choice.equals("3") &&!choice.equals("4") && !choice.equals("5") && !choice.equals("6")) {
				System.out.println("Please enter A VALID number of the selection you would like to do.");
				String choice1 = sc.nextLine();
				
				choice = choice1;
				
			}
			
			
			
			if (choice.equals("1")) {
				Current_Student.View_Courses(CourseArray);
				
				
				
			}
		
			
			if (choice.equals("2")) {
				Current_Student.View_NotFull_Courses(CourseArray);
				
				
			}
		
			
			if (choice.equals("3")) {
				
				System.out.println("Please enter the course name.");
				
				String course = sc.nextLine();
				
				System.out.println("Please enter the course section.");
				
				String section = sc.nextLine();


				System.out.println("Please enter your first name.");
				
				String fname = sc.nextLine();

				System.out.println("Please enter your last name.");

				
				String lname = sc.nextLine();
				
				

				Current_Student.Register(Current_Student, CourseArray, course, section);
				
				
				
			}
			
			if (choice.equals("4")) {
				
				System.out.println("Please enter the course name.");
				
				String course = sc.nextLine();
				
				System.out.println("Please enter the course section.");
				
				String section = sc.nextLine();
				
				System.out.println("Please enter your first name.");
				
				String fname = sc.nextLine();

				System.out.println("Please enter your last name.");

				
				String lname = sc.nextLine();
				
				

				Current_Student.WithDraw_Courses(CourseArray, Current_Student, course, section);
				
				
				
			}
			
			if (choice.equals("5")) {
				
				Current_Student.getCourses();
				
				
				
			}
			
			
			if (choice.equals("6")) {
				
				
				w = false;
				
				f = false;
				
				
			}
				
				

			
			
			
			
		}
		
		
		
	}
		
}
		
		//serialization here 
		
		try {
			//FileOutput Stream writes data to a file
			FileOutputStream CourseArray_Data = new FileOutputStream("CourseArray.ser");
			
			
			FileOutputStream student_Data = new FileOutputStream("Student.ser");

			//ObjectOutputStream writes objects to a stream (A sequence of data)
			ObjectOutputStream oos = new ObjectOutputStream(CourseArray_Data);
			
			ObjectOutputStream oos2 = new ObjectOutputStream(student_Data);

			
			//Writes the specific object to the OOS
			
			oos2.writeObject(students);

			oos.writeObject(CourseArray);
			

			
			//Close both streams
			oos.close();
			oos2.close();

			CourseArray_Data.close();
			
			student_Data.close();

			System.out.println("All your information has been updated.");
		} 
		catch (IOException ioe) {
			ioe.printStackTrace();
		}
		
	
	}
}
