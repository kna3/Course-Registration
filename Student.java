import java.util.ArrayList;
import java.util.List;

public class Student {
	
	int studentId ;
	List<String> preferences = new ArrayList<String>();
	String level=""; 
	int satisfactionRating;

	List<Courses> allocatedList = new ArrayList<Course>();
	public List<Courses> getAllocatedList() {
		return allocatedList;
	}

	public void setAllocatedList(List<Courses> allocatedList) {
		this.allocatedList = allocatedList;
	}

	public int getStudentId() {
		return studentId;
	}

	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}

	public List<String> getPreferences() {
		return preferences;
	}

	public void setPreferences(List<String> preferences) {
		this.preferences = preferences;
	}

	public String getLevel() {
		return level;
	}

	public void setLevel(String level) {
		this.level = level;
	}

	public int getSatisfactionRating() {
		return satisfactionRating;
	}

	public void setSatisfactionRating(int satisfactionRating) {
		this.satisfactionRating = satisfactionRating;
	}
}


