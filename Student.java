import java.util.ArrayList;
import java.util.List;

public class Student {
	
	int studentId ;
	List<String> preferences = new ArrayList<String>();
	String level=""; 
	int satisfactionRating;
<<<<<<< HEAD
	List<Courses> allocatedList = new ArrayList<Courses>();	
=======
	List<Courses> allocated = new ArrayList<Courses>();	
>>>>>>> 2b366995fb369d41398700276239e2a9732dd0b4
	
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


