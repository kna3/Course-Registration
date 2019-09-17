import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class Main {

	public static void main(String[] args) {
	
		String CourseInformationFile = args[0];
		String studentCoursePrefFile = args[1];
		
		FileParser courseObj = new FileParser();
		courseObj.ParseCourseFile(CourseInformationFile);
		courseObj.ParseStudentFile(studentCoursePrefFile);
		
		List<Courses> list = new ArrayList<Courses>();
		List<Student> stList = new ArrayList<Student>();
		list = courseObj.obj.getCourseList();
		stList= courseObj.obj.getStudentList();
		
		
		
		Iterator<Courses> it=list.iterator();
		System.out.println("course");
		while (it.hasNext()) {
			Courses courses=it.next();
			System.out.println(courses.getCapacity());
			System.out.println(courses.getClassTimings());
			System.out.println(courses.getCourseName());
			
		}
		System.out.println("student");
		Iterator<Student> itr = stList.iterator();
	    
		while (itr.hasNext()) {
			Student student=itr.next();
			System.out.println(student.getStudentId());
			System.out.println(student.getPreferences());
			System.out.println(student.getLevel());
		}
			
	
		}
	
	}
