package coursesRegistration.scheduler;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

import coursesRegistration.util.Courses;
import coursesRegistration.util.Student;

public class Validate {

	enum Level {

		FIRST_YEAR, SECOND_YEAR, THIRD_YEAR;
	}
	/**
     * Takes studentlist and courselist as input,sorts the student by level, 
     * checks the capacity of the requested course, the course timings, if invalid it skips to the next preference
     *  finally, calculates the SatisfactionRating 
     */
	public void test(List<Student> studentList, List<Courses> courseList) {
		
	try {
		List<String> pref = new ArrayList<String>();
		int currentCap = 0;
		int time = 0;
		int rating = 0;
		int total = 0;
		boolean flagCheck = true;

		Comparator<Student> compareBylevel = (Student o1, Student o2) -> o1.getLevel().compareTo(o2.getLevel());
		Collections.sort(studentList, compareBylevel.reversed());

		Iterator<Student> itr = studentList.iterator();

		while (itr.hasNext()) {
			Student obj = itr.next();
			pref = obj.getPreferences();
						
			for (int i = 0; i < pref.size(); i++) {
				if (obj.getAllocatedList().size() > 2)
					break;
				char currentPref = pref.get(i).charAt(0);
							
				if (pref.get(i).matches("[A-I]")) {
					for (int j = 0; j < courseList.size();) {
						if(flagCheck!= true) {
							flagCheck = true;
							break;
						}
						flagCheck = true;
						if ((courseList.get(j).getCourseName()) == (currentPref)) {
							currentCap = courseList.get(j).getCapacity();
							time = courseList.get(j).getClassTimings();
							if (currentCap > 0) {
								if (obj.getAllocatedList().size() > 0) {
									for(int z=0; z< obj.getAllocatedList().size();z++) {
										if (time == obj.getAllocatedList().get(z).getClassTimings()) {
											flagCheck = false;
											break;
										}
									}	
								}
								if (flagCheck) {
									rating = 9 - i;
									total = total + rating; 
									obj.getAllocatedList().add(courseList.get(j));
									courseList.get(j).setCapacity(currentCap - 1);
									
									break;
								}
							}else break;
						} else j++;
					}
				}
				else {
					System.out.println("Invalid CourseName for ID:" + obj.getStudentId() + ' ' + pref.get(i));
				}
			}
			obj.setSatisfactionRating(total);
			total = 0;
		}
	}
		catch(Exception e) {
			e.printStackTrace();	
		}
	}
	
}
