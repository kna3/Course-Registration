import java.io.IOException;
import java.util.List;

public class Main {

	public static void main(String[] args) throws IOException {

		if (args.length != 0) {
			String CourseInformationFile = args[0];
			String studentCoursePrefFile = args[1];

			FileProcessor fileobj = new FileProcessor();

			List<String> cList = fileobj.readLine(CourseInformationFile);
			List<String> sList = fileobj.readLine(studentCoursePrefFile);
			
			FileParser courseObj = new FileParser();
			List<Courses> courseList = courseObj.ParseCourseFile(cList);
			List<Student> studentList= courseObj.ParseStudentFile(sList);
			
			Validate obj = new Validate();
			obj.test(studentList, courseList);
		
			FileDisplayInterface fileDisplay = new Results();
			fileDisplay.DisplayFile(studentList, "registration_results.txt");
			
			StdoutDisplayInterface outDisplay = new Results();
			outDisplay.DisplayResult(studentList);
		}
		else {
			 System.err.println("Invalid number of arguments");
	         System.err.println("Program exited");
	         System.exit(1);
		}
		
	}
}

