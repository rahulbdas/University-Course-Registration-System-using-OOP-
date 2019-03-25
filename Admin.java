import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.io.*;
import java.util.Scanner;


public class Admin extends User implements Admin_Interface {
	
	//create a new course with 
	
	private String Username = "Admin";
	
	private String Password = "Admin001";
	
	
	
	
	
	
		public  Course New_Course(String course_Name, String course_Id, String maximum_Students,
				 String instructor, String course_Section, String course_Location, ArrayList<Course> d) {
			
			
			String current_Students = "0";
			
			Course c = new Course(course_Name, course_Id, maximum_Students, current_Students, instructor, course_Section, course_Location );
			d.add(c);
			return c;
			
			
			
			
			
		}
		
		
		//write a file to full courses
		
		public  void Write_File(ArrayList<Course> d) throws FileNotFoundException, UnsupportedEncodingException {
			
		
			
			
		
			
		
				
			PrintWriter witer = new PrintWriter ("FullCourses.txt", "UTF-8");
			for (int i = 0; i < d.size(); i++) {
				
				
				Course o = d.get(i);
				
				
				if (o.getCurrent_Students() == o.getMaximum_Students()) {
					

					witer.println(o.getCourse_Name());
					
					
					
				}
				
				
			
			
	}
			
				

				
	//Always close writer
				witer.close();
			}
			
			//Always close files

		
			
		

		
		
		
		//arraylist of students 

		public ArrayList <Student> All_Students;
		
		
		//delete a course
		public  void Delete_Course(ArrayList <Course> c, String d) {
			
			//start at 1 since the 1 object is all null
			for (int i = 0; i < c.size(); i++) {
				
				Course o = c.get(i);
				
				//System.out.println(o.getCourse_Name());
				if (o.getCourse_Name().toLowerCase().equals(d.toLowerCase())) {
					
					c.remove(o);
					
				}
			}
			
			
			
			
			
		}
		//edit a course
		public  void Edit_Course(String courseName, String instructor, ArrayList <Course> c) {
			
			for (int i = 0; i < c.size(); i++) {
				
				Course o = c.get(i);

				if (o.getCourse_Name().toLowerCase().equals(courseName.toLowerCase())) {
					o.setInstructor(instructor);

										
				}
				
				
			}
			
			
			
			
		}
		//display info in course by id
		
		public   void Display_Course(String CourseName, ArrayList <Course> c) {
			
			
			for (int i = 0; i < c.size(); i++) {
				
				
				Course o = c.get(i);

				if (o.getCourse_Id().toLowerCase().equals(CourseName.toLowerCase())) {
					
					System.out.println("This is the information for Course: " + o.getCourse_Id());

					System.out.println("Course name: " + o.getCourse_Name());
					System.out.println("Course location: " + o.getCourse_Location());
					System.out.println("Course section: " + o.getCourse_Section());
					
					System.out.println("Course Instructor: " +o.getInstructor());
					System.out.println("Current Number of Students: " +o.getCurrent_Students());
					System.out.println("Maximum Students: " +o.getMaximum_Students());
					
					System.out.println("Student Names: ");
					
					for (Student names: o.viewStudent_Names()) {
						System.out.println(names.getFirstName() + " " + names.getLastName());
						
					}
					
					
				}
			}
			
			
			
			
		}
		//register a student and create a password and username
		
		
		public  void Register_Student(ArrayList<Student> stu, String firstname, String lastname) {
			
			
			Random rand = new Random();
			
		

			
			String username = firstname.toLowerCase() + rand.nextInt(100)  ;
			
			String password =  lastname.toLowerCase() + rand.nextInt(100) ;
			
			Student student = new Student(  firstname,  lastname,username,  password);
			
			
			stu.add(student);
			
			
			System.out.println("The username is " + username);
			System.out.println("The password is " + password);

			//idk if i need ot return this or nah
			
			//return stu;
			
			
			
			
		}
		//view full courses
		
		

		public void  View_Full_Courses(ArrayList<Course> d) {
		//view full courses
			
		boolean t = true;
		
		System.out.print("The full courses are: ");

		
		for (int i = 0; i < d.size(); i++) {
			
			
			Course o = d.get(i);
			
			
			if (o.getCurrent_Students() == o.getMaximum_Students()) {
				

				System.out.println(o.getCourse_Name());
				
				t = false;
				
			}
			
			
		}
		
		if (t == true) {
			
			System.out.println("There are no full courses.");
		}
			
		}
		
			
		
		//view all student's names in specific course
		 
		
		public  void View_Studnets_InCourse(ArrayList <Course> d, String course) {
			boolean g = true;
			System.out.println("These are the students registered in the course.");
			
			for (int i = 0; i < d.size(); i ++) {
				Course c = d.get(i);
				
				if (c.getCourse_Name().toLowerCase().equals(course.toLowerCase())) {
					
					ArrayList<Student> stu = c.getStudent_Names();
					
					for (Student f: stu) {
						
						System.out.println(f.getFirstName() + " " + f.getLastName());
						
						g = false;
					}
					
					
					
			
				
			}
			
			}
			
			if (g == true) {
				
				System.out.println("There are no students in this course.");
			}
			
			
		}
			//ArrayList <Student> list = c.getStudent_Names(d);
		
		


		
		public void View_CourseManagement() {
			System.out.println("1. Create a new Course.");
			System.out.println("2. Delete a  Course.");
			System.out.println("3. Edit a Course.");
			System.out.println("4. Display information for a given course.");
			System.out.println("5. Register a student.");
			
			System.out.println("6. Exit.");


		}
		

		public void View_Reports() {
			System.out.println("1. View all courses.");
			
			System.out.println("2. View all courses that are FULL.");
			
			System.out.println("3. Write to a file the list of course that are fullL.");
			
			System.out.println("4. View the names of the students that are registered in a specific course.");
			
			System.out.println("5.View the list of courses that a given student is registered in.");
			
			
			System.out.println("6. Sort the courses based on the current number of students registered.");
		

			System.out.println("7. Exit.");



			
		}
		
		public void Sort(ArrayList<Course>  d) {
			
			
			ArrayList<Integer>  list = new ArrayList<Integer>();
			
			ArrayList<Course> list2 = new ArrayList<Course>();
			
			//new list for ordered courses 
			ArrayList<String> list3 = new ArrayList<String>();

			
			for (int i = 0 ; i < d.size(); i ++) {
				
				
				
				Course g = d.get(i);
				
				list.add(g.getCurrent_Students());
				list2.add(g);
				
				
				
			
				
				
			}
			
			Collections.sort(list);
			
			
			for (int h: list) {
				
				for (int i = 0;  i < list2.size(); i ++) {
					
					Course f = list2.get(i);
					
					
					if (f.getCurrent_Students() == h) {
						
						list3.add(f.getCourse_Name() + ":  " + f.getCurrent_Students() + " students" );
						list2.remove(f);
						
					}
				}
			}
			
			System.out.println("These are the sorted courses based on the registered students where the course with the most students at the bottom:");
			
			for (String g: list3) {
				
				System.out.println(g  );
			}
		}


		
		


		


		


		

		
}
