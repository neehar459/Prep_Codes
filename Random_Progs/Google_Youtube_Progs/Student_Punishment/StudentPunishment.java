import java.util.List;
import java.util.ArrayList;
import java.util.Date;
public class StudentPunishment{
	public static void main(String[] args){
		
		Student s1 = new Student("Andy", 1, 1);
		Student s2 = new Student("Adam", 2, 1);
		Student s3 = new Student("Ben", 3, 1);
		Student s4 = new Student("Page", 4, 1);
		Student s5 = new Student("Chris", 5, 1);
		Student s6 = new Student("Campbell", 6, 1);
		Student s7 = new Student("Harry", 7, 1);
		Student s8 = new Student("Tom", 8, 1);
		Student s9 = new Student("Zhang", 9, 1);
		Student s10 = new Student("Mohan", 10, 1);
		List<Student> studentList = new ArrayList<Student>();
		Date d1 = new Date(2014,7,1);Date d2 = new Date(2014,7,2);Date d3 = new Date(2014,7,3);Date d4 = new Date(2014,7,4);Date d5 = new Date(2014,7,5);
		Date d6 = new Date(2014,7,16);Date d7 = new Date(2014,7,7);Date d8 = new Date(2014,7,8);Date d9 = new Date(2014,7,9);Date d10 = new Date(2014,7,10);
		List<Date> dateList = new ArrayList<Date>();
		dateList.add(d1);dateList.add(d2);dateList.add(d3);dateList.add(d4);dateList.add(d5);dateList.add(d6);dateList.add(d7);dateList.add(d8);
		dateList.add(d9);dateList.add(d10);
		studentList.add(s1);studentList.add(s2);studentList.add(s3);studentList.add(s4);studentList.add(s5);studentList.add(s6);studentList.add(s7);
		studentList.add(s8);studentList.add(s9);studentList.add(s10);
		Attendance attendance = new Attendance(dateList,studentList);
		
	}
	public static void punishStudents(List<Student> studentsList){
	
	}
}
class Attendance{
	List<Date> totalDates; 
	List<Student> studentsList;
	public Attendance(){
		System.out.println("Attendance class");
	}
	public Attendance(List<Date> totalDates, List<Student> studentsList){
		this.totalDates = totalDates;
		this.studentsList = studentsList;
	}
}
class Student{
	String name;
	int rollNumber;
	int classId;
	Date attendedDate;
	String punishment;
	public Student(){
		System.out.println("Default Constructor");
	}
	public Student(String name, int rollNumber, int classId){
		this.name = name;
		this.rollNumber = rollNumber;
		this.classId = classId;
	}
	public Student(String name, int rollNumber, int classId, Date attendedDate){
		this.name = name;
		this.rollNumber = rollNumber;
		this.classId = classId;
		this.attendedDate = attendedDate;
	}
}