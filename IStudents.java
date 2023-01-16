package interfaces;
import classes.*;
public interface IStudents
{
	void insertStudent(Student s);
	void removeStudent(Student s);
	Student getStudent(String id);
	void showAllStudents();
}