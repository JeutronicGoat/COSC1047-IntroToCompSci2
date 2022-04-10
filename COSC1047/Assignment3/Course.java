
public class Course implements Cloneable{

	private String courseName;
	private String[] students = new String[100];
	private int numberOfStudents;
	 
	
	public Course(String courseName) {
		this.courseName = courseName;
	}
	
	public void addStudent(String student) {
		students[numberOfStudents] = student;
		numberOfStudents++;
	}
	
	public String[] getStudents() {
		return students;
	}
	
	public int getNumberOfStudents() {
		return numberOfStudents;
	}
	
	public String getCourseName() {
		return courseName;
	}
	
	@Override
	public Object clone() {
		try {
			Course course = (Course)super.clone();
			
			String[] students2 = new String[100];	//deep copy the array of students
			for(int i = 0; i < 100; i++) {
				students2[i] = students[i];
			}
			course.students = students2;
			
			return course;
		} 
		catch (CloneNotSupportedException e) {
			System.out.println("Error: This clone is not supported.");
			return null;
		}
	}
	
}
