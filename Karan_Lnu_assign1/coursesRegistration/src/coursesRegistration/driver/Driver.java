package coursesRegistration.driver;

import java.io.IOException;
import java.util.List;

import coursesRegistration.scheduler.Validate;
import coursesRegistration.util.Courses;
import coursesRegistration.util.FileDisplayInterface;
import coursesRegistration.util.FileParser;
import coursesRegistration.util.FileProcessor;
import coursesRegistration.util.Results;
import coursesRegistration.util.StdoutDisplayInterface;
import coursesRegistration.util.Student;

/**
 * @author Karan Lnu
 *
 */
public class Driver {
	/*
	 * The Driver function takes three arguments, studentinfo and courseinfo
	 * and an outputFile where result will be stored. It checks for number of
	 * Arguments and exits giving an error message if inputs are incorrect.
	 */
	public static void main(String[] args) throws IOException {

		/*
		 * As the build.xml specifies the arguments as argX, in case the
		 * argument value is not given java takes the default value specified in
		 * build.xml. To avoid that, below condition is used
		 */
		if (args.length != 5 || args[0].equals("${arg0}") || args[1].equals("${arg1}") || args[2].equals("${arg2}")
				) {

			System.err.println("Error: Incorrect number of arguments. Program accepts 3 argumnets.");
			System.exit(0);
		}

		System.out.println("Hello World! Lets get started with the assignment");

		if (args.length == 5) {
			String CourseInformationFile = args[1];
			String studentCoursePrefFile = args[0];

			FileProcessor fileobj = new FileProcessor();

			List<String> cList = fileobj.readLine(CourseInformationFile);
			List<String> sList = fileobj.readLine(studentCoursePrefFile);

			FileParser courseObj = new FileParser();
			List<Courses> courseList = courseObj.parseCourseFile(cList);
			List<Student> studentList= courseObj.parseStudentFile(sList);

			Validate validate = new Validate();
			validate.test(studentList, courseList);

			FileDisplayInterface fileDisplay = new Results();
			fileDisplay.displayFile(studentList,args[2]);

			StdoutDisplayInterface outDisplay = new Results();
			outDisplay.displayResult(studentList);
		}
		else {
			System.err.println("Invalid number of arguments");
			System.err.println("Program exited");
			System.exit(1);
		}

	}
}

