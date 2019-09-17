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
		Iterator<Courses> it = courseList.iterator();
		Iterator<Student> itr = studentList.iterator();
		
		while(itr.hasNext()) {
			if((itr.next().level)== (Level.THIRD_YEAR).toString()) {
				pref = itr.next().getPreferences();
				int id = itr.next().studentId;
				for(int i = 0; i < 3 ; i++) {
					char currentPref[] = pref.get(i).toCharArray();
					if(pref.get(i).matches("[A-I]")) {
					for(int j = 0; j < courseList.size();) {
						if((courseList.get(j).getCourseName()) == (currentPref[i])) {
							currentCap = courseList.get(j).getCapacity();
							time = courseList.get(j).getClassTimings();
							if(currentCap>0) {
								
								courseList.get(j).setCapacity(currentCap-1);
								AllocateCourse(pref,id);
							}
						}
						else j++;
					}
						
					}
				}
			  }	
		}
	}
	
	public void AllocateCourse(List<String> pref, int id) {
			}
		}
	

	}

}	
