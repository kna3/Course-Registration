package coursesRegistration.util;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class Results implements FileDisplayInterface, StdoutDisplayInterface {
	/**
	 * Takes updated studentList as input and prints courses allocated as per the preferences by the student
	 * with their satisfaction rating and the combined AverageRating
	 */
	public void displayResult(List<Student> studentList) {

		int i = 0;
		float average = 0;
		float total = 0;

		for(i = 0;i<studentList.size();i++){
			System.out.print(studentList.get(i).getStudentId()+ ":");
			for(int j = 0; j<studentList.get(i).getAllocatedList().size(); j++) {
				System.out.print(studentList.get(i).getAllocatedList().get(j).getCourseName() + ",");
			}

			System.out.println("::SatisfactionRating="+studentList.get(i).satisfactionRating);
			total = total + studentList.get(i).satisfactionRating;
		}

		average = total/i;
		System.out.println("\n" + "AverageSatisfactionRating="+ average);

	}
	/**
	 * Takes updated studentList as input and prints courses allocated to students in an outputfile 
	 * with their satisfaction rating and the combined AverageRating
	 */
	public void displayFile(List<Student> studentList, String outputFile) throws IOException{

		FileWriter output = null;
		try
		{
			output = new FileWriter(outputFile);
			int i;
			int average = 0;
			int total = 0;

			for(i = 0;i<studentList.size();i++){
				output.write(studentList.get(i).getStudentId()+ ":");

				for(int j = 0; j<studentList.get(i).getAllocatedList().size(); j++){
					output.write(studentList.get(i).getAllocatedList().get(j).getCourseName());
					output.write(",");
				}

				output.write("::SatisfactionRating="+ studentList.get(i).satisfactionRating +"\n");
				total = total+ studentList.get(i).satisfactionRating;
			}	

			average = total/i;
			output.write("\n" + "AverageSatisfactionRating="+ average);

		}

		catch(IOException e){
			System.out.println("File not found exception");
			System.out.println(e.getMessage());
		}
		finally{
			output.close();
		}

	}



}

