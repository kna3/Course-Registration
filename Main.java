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
		
	
		}
	
	}
