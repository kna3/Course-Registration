import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class FileParser {
	/**
     * Parses the courseinfo.txt file and adds information to the CourseList
     */
	public List<Courses> ParseCourseFile(List<String> list) {

		List<Courses> courseList = new ArrayList<>();
		try {
			Iterator<String> itr = list.iterator();
			String line = null;
			while (itr.hasNext()) {
				line = itr.next().toString();
				int capacityIndex = line.indexOf("CAPACITY:") + 9;
				int timingIndex = line.indexOf("CLASS_TIMING:") + 13;
				char c = line.charAt(0);
				int cap = Integer.parseInt(line.substring(capacityIndex, capacityIndex + 2));
				int time = Integer.parseInt(line.substring(timingIndex, timingIndex + 1));

				Courses courses = new Courses();
				courses.setCapacity(cap);
				courses.setClassTimings(time);
				courses.setCourseName(c);

				courseList.add(courses);
			}
		} catch (Exception e) {
			System.out.println("Failed to Parse");
			System.out.println(e.getMessage());
			System.exit(0);
		}

		return courseList;
	}
	/**
     * Parses the student.txt file and adds information to the studentList
     */
	public List<Student> ParseStudentFile(List<String> list) {
		
		List<Student> studentList = new ArrayList<>();
		try {
			Iterator<String> itr = list.iterator();
			String line = null;
			int studentId;
			while (itr.hasNext()) {
				List<String> preferences = new ArrayList<String>();
				line = itr.next();
				String id = line.substring(0, 3);
				studentId = (Integer.parseInt(id));
				String prefer = (line.substring(4, 21));
				String[] pref = prefer.split(",");
				for (String a : pref) {

					preferences.add(a);
				}
				String level = "";
				level = (line.substring(23, line.length()));
				Student student = new Student();
				student.setStudentId(studentId);
				student.setPreferences(preferences);
				student.setLevel(level);
				studentList.add(student);

			}
		}

		catch (Exception e) {
			System.out.println("Failed to Parse");
			System.out.println(e.getMessage());
			System.exit(0);
		}
		return studentList;
		
	}

}

