import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;


public class Validate {
	
enum Level {
		
		FIRST_YEAR, SECOND_YEAR, THIRD_YEAR;	
	}
	
	List<Courses>courseList = new ArrayList<Courses>();
	List<Student>studentList = new ArrayList<Student>();
	
	
//	for(Student student : studentList) {
//        System.out.println(student.getStudentId());
//        System.out.println(student.getPreferences());
//        System.out.println(student.getLevel());
//    }
	
	public List<Student> getStudentList() {
		return studentList;
	}

	public void setStudentList(List<Student> studentList) {
		this.studentList = studentList;
	}

	public List<Courses> getCourseList() {
		return courseList;
	}

	public void setCourseList(List<Courses> courseList) {
		this.courseList = courseList;
	}
	
	public void test() {
		List<String> pref = new ArrayList<String>();
		int currentCap=0;
		int time = 0;
		Comparator<Student> compareBylevel = (Student o1, Student o2) -> o1.getLevel().compareTo( o2.getLevel());
		Collections.sort(studentList, compareBylevel.reversed());
	}
}	
