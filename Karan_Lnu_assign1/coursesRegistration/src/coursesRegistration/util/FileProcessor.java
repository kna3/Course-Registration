package coursesRegistration.util;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileProcessor {
	    BufferedReader input = null;
	    FileReader fr;
	    /**
	     * Takes the student.txt file and courses.txt one by one as input and returns information as a list to Parser
	     */
	    public List<String> readLine(String inputFile) {
		    List<String> list = new ArrayList<String>();
	    	 try {
		            fr = new FileReader(inputFile);
		            input = new BufferedReader(fr);

		        } catch (FileNotFoundException e) {
		            System.err.println("File Not Found at location : " + inputFile);
		            System.err.println("Program exited");
		            System.exit(1);
		        } finally {
		        }
		    
	        String line = null;
	        try {
	        	while ((line = input.readLine()) != null) {
	            list.add(line);
	        	 }
	        } catch (IOException e) {
	            System.out.println("Error: Input File Cannot Be Read. Please Check the File.");
	            System.exit(1);
	        }
	        return list;

	    }

	    /**
	     * To close the file
	     */
	    public void closeFile() {
	        try {
	            input.close();
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	    }

	}

