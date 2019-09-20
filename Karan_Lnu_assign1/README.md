# CSX42: Assignment 1
## Name: Karan Lnu

-----------------------------------------------------------------------
-----------------------------------------------------------------------


Following are the commands and the instructions to run ANT on your project.
#### Note: build.xml is present in coursesRegistration/src folder.

-----------------------------------------------------------------------
## Instruction to clean:

####Command: ant -buildfile coursesRegistration/src/build.xml clean

Description: It cleans up all the .class files that were generated when you
compiled your code.

-----------------------------------------------------------------------
## Instruction to compile:

####Command: ant -buildfile coursesRegistration/src/build.xml all

Description: Compiles your code and generates .class files inside the BUILD folder.

-----------------------------------------------------------------------
## Instruction to run:

####Command: ant -buildfile coursesRegistration/src/build.xml run -Darg0="student_file.txt" -Darg1="course.txt" -Darg2="output_file.txt" -Darg3="output2_file.txt" -Darg4="output3_file.txt"

Note: Arguments accept the absolute path of the files.


-----------------------------------------------------------------------
## Description:


Data Structures used: ArrayList: The ArrayList class has many methods to manipulate the stored objects, they are resizable which provides dynamic 				                 flexibility, plus it's easier to access them using indexes which was critical as per the requirement of the project.
		                 

Three Major ArrayLists are used:
1) courseList - to store the courses from the input file
2) allottedList - allocated courses of the student
3) studentList - to add student information from input file

-----------------------------------------------------------------------
Logic of Allocated-List:

The method iterates through the studentList but before that it sorts the studentList in a way that the Third_Level students are at the top of the List. The preferences of the student are extracted from the Student object, and then it iterates over the nine given preferences. One preference is taken at a time and the char value is searched in the CourseList; when found it extracts the capacity of the course and the timing. If the capacity is more than 0, and the coursetimings are different from the already allocated course, we assign the course and further calculate the SatisfactionRating using the order of assigned courses and set it to the Student class. The FileParser class ensures that there are no duplicate entries for one StudentID and are in a correct INTEGER format.
However; 
If the courseCapacity, is less than one, we break the loop and skip to the next preference in the list and present course won't be allocated
If the timings of the courses match with an already allocated course, boolean is set to false and it will skip to the next preference and the present course will not be allocated
If the preference is outside the range of [A-I], it will print "Invalid CourseName" and skip to the next preference.
If all the conditions are met the courses are alloted and the capacity if decremented by one for every allocation and the satisfaction value is set to the Student Class for every student.

---------------------------------------------------------------------------
State Workflow:

1) Driver (start state)
   -Action/Methods
	The Driver function takes three arguments, studentinfo and courseinfo
	and an outputfile where result will be stored. It checks for number of
	arguments and exits giving an error message if inputs are incorrect.

2) FileProcessor
   -Action/Methods
	:readLine
	 Takes the student.txt file and courses.txt one by one as input.
	 Reads the file line by line and returns information as a list to FileParser

3) FileParser
   -Action/Methods
	:parseCourseFile
	 Inputs and Parses the list using split and substrings and adds information to the courseList 
	 Capacity can be in the range (0x - 99)
	 ClassTiming can be in the range (0-9)
 	 CourseName can be a Char

   -Action/Methods
	:parseStudentFile
	 Inputs and Parses the list using split and substrings and adds information to the studentList 
	 Id can be in the range (100 - 999) 
	 Preferences can be a List
 	 Level can be a String
	 It ensures that there is only one instance for one studentID, removes the duplicates and ID is in form of Integer
	 i.e. it will reject any unformatted value of StudentID like (1g4,4r9)

4) Student
   -Action/Methods
	 Data-Members: (int studentId, List preferences , String level, int SatisfactionRating) with getters and setters
	 List<Courses> allocatedList;

5) Courses 
   -Action/Methods
	 Data-Members: (int Capacity, int ClassTiming, char CourseName) with getters and setters
	
6) Validate(Business Logic)
   -Action/Methods
	:test
	 Takes studentlist and courselist as input,sorts the student by level, 
         checks the capacity of the requested course, the course timings, if invalid it skips to the next preference
         finally, calculates the SatisfactionRating

7) Result(Final state)
   -Action/Methods
	:displayResult
	 Takes updated studentList as input and prints courses allocated as per the preferences by the student
	 with their satisfaction rating and the combined AverageRating
   -Action/Methods
	:displayFile
	 Takes updated studentList as input and prints courses allocated to students in an outputfile 
	 with their satisfaction rating and the combined AverageRating







-----------------------------------------------------------------------
### Academic Honesty statement:
-----------------------------------------------------------------------

"I have done this assignment completely on my own. I have not copied
it, nor have I given my solution to anyone else. I understand that if
I am involved in plagiarism or cheating an official form will be
submitted to the Academic Honesty Committee of the Watson School to
determine the action that needs to be taken. "

Date: [9/19/2019]


