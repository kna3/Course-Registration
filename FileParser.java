
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

//import Student.Level;

public class FileParser {
	static Validate obj = new Validate();

	public void ParseCourseFile(String file) {
		
		try {
				
		List<String> list = new ArrayList<String>();
		FileProcessor fileobj = new FileProcessor();
		list = fileobj.readLine(file);
		
		Iterator<String> itr =list.iterator();
		String line = null;
		while(itr.hasNext()) {
		     line = itr.next().toString();
			 int capacityIndex = line.indexOf("CAPACITY:")+ 9;
	    	 int timingIndex = line.indexOf("CLASS_TIMING:")+ 13;
	    	 char c = line.charAt(0);
	    	 int cap = Integer.parseInt(line.substring(capacityIndex,capacityIndex+2));
	    	 int time = Integer.parseInt(line.substring(timingIndex,timingIndex+1));
	    	 
	    	 Courses courses=new Courses();
	    	 courses.setCapacity(cap);
	    	 courses.setClassTimings(time);
	    	 courses.setCourseName(c);
	    	 obj.getCourseList().add(courses);
	      
	
		}
	}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public void ParseStudentFile(String file) {
		try {
			
		List<String> preferences = new ArrayList<String>();
		List<String> list = new ArrayList<String>();
		FileProcessor fileobj = new FileProcessor();
		list = fileobj.readLine(file);
		
		Iterator<String> itr =list.iterator();
		String line = null;
		int studentId;
		while(itr.hasNext()) {
		     line = itr.next();
		    // System.out.println("line :" + itr.next());
		     //System.out.println("line :" + line);
		     String id = line.substring(0, 3);
	         System.out.println("id :" + id);
	         studentId = (Integer.parseInt(id));
			 System.out.println("id1 :" + studentId);
		     String prefer = (line.substring(4,21));
		     String[] pref = prefer.split(",");
			 for (String a : pref) {
	        
	   	     preferences = Arrays.asList(a);
			 }
	   	     String level="";
	   	     level = (line.substring(23, line.length()));
	   	    // System.out.println("id 2 :" + id);  
	   	     Student student=new Student();
	   	     student.setStudentId(studentId);
	   	     student.setPreferences(preferences);
	         student.setLevel(level);
	    	 obj.getStudentList().add(student);
	    	 
		}
	}		 
		
		catch(Exception e){
			
			System.exit(1);	
		}
		obj.test();
	}
		
}


