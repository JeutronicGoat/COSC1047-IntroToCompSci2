
public class TestCourse {

	
	public static void main(String[] args) {
		
		Course course = new Course("CompScience");//course info
		course.addStudent("Jacob");
		course.addStudent("Bobby");
		
		//print course info
		System.out.println(course.getCourseName());
		System.out.println(course.getNumberOfStudents());
		
		printStudents(course);
		
		System.out.println("\n");
		
		Course course2 = (Course)course.clone();//clone
		
		//print course2 info
		System.out.println(course2.getCourseName());
		System.out.println(course2.getNumberOfStudents());
		
		printStudents(course2);
		
		//add to course one
		course.addStudent("Hunter");
		
		System.out.println("\n");
		
		//test if array refs the same
		System.out.println("course1:");
		printStudents(course);
		
		System.out.println("\n");
		
		System.out.println("course2:");
		printStudents(course2);
		
		System.out.println();

		//address test
		System.out.println();
		if(course == course2) {
			System.out.println("They have the same address!!");
		}
		else {
			System.out.println("They have different addresses!!");
		}
		
	}
	
	//print Students nicely formated, excludes nulls
	public static void printStudents(Course course) {
		String[] students = course.getStudents();
		for (int i = 0; i < students.length; i++) {
			if(students[i + 1] == null) {
				System.out.print("{" + students[i] + "}");
				break;
			}
			else {
				System.out.print("{");
				System.out.print(students[i] + "}" + (i == (students.length - 1) ? "\n" : ", "));
			}
		}
	}
	
}
