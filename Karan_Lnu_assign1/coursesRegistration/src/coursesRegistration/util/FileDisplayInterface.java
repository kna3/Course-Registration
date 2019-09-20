package coursesRegistration.util;

import java.io.IOException;
import java.util.List;

public interface FileDisplayInterface {
	
	void displayFile(List<Student> studentList, String outputFile) throws IOException;
}
