import org.testng.annotations.Test;

import java.util.*;
import java.util.stream.Collectors;

public class Application {
    public static void main(String[] args) {
        ListOfStudents listOfStudents = new ListOfStudents();
        for(Map.Entry<Integer,Student> entry : listOfStudents.studentMap.entrySet()){
            if(entry.getValue().getStudentClassNumber().equals("4B")&& entry.getValue().getSex().equals("M")){
                System.out.println(entry);
            }
        }
    }
}
class Student {
    private int studentId;
    private String name;
    private String lastName;
    private String studentClassNumber;
    private int studentLogNumber;
    private String sex;

    public Student(int studentId, String name, String lastName, String studentClassNumber, int studentLogNumber, String sex) {
        this.studentId = studentId;
        this.name = name;
        this.lastName = lastName;
        this.studentClassNumber = studentClassNumber;
        this.studentLogNumber = studentLogNumber;
        this.sex = sex;
    }

    public Student(){
    }
    public int getStudentId() {
        return this.studentId;
    }

    public String getName() {
        return this.name;
    }

    public String getLastName() {
        return this.lastName;
    }

    public String getStudentClassNumber() {
        return this.studentClassNumber;
    }

    public int getStudentLogNumber() {
        return this.studentLogNumber;
    }

    public String getSex() {
        return this.sex;
    }

    @Override
    public String toString() {
        return "Student Id: " + studentId
                + " " + name + " "
                + lastName + " "
                + studentClassNumber + " "
                + studentLogNumber + " " +
                sex ;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return studentId == student.studentId && studentLogNumber == student.studentLogNumber && sex == student.sex && Objects.equals(name, student.name) && Objects.equals(lastName, student.lastName) && Objects.equals(studentClassNumber, student.studentClassNumber);
    }

    @Override
    public int hashCode() {
        return Integer.parseInt(studentClassNumber);

    }
}
class ListOfStudents extends Student{
    private List<Student> students;
    public List<Student> listOfStudents() {
        students = new ArrayList<>();
        students.add(new Student(1,"jakub", "firlejczyk", "4A", 4, "M"));
        students.add(new Student(2,"jakub", "firlejczyk", "4B", 4, "M"));
        students.add(new Student(3,"jakub", "firlejczyk", "4E", 4, "M"));
        students.add(new Student(4,"jakub", "firlejczyeek", "4C", 4, "M"));
        students.add(new Student(5,"jakub", "firlejczyeek", "4B", 4, "M"));
        students.add(new Student(6,"jakub", "firlejczyeek", "4B", 4, "F"));

        return students;
    }
    Map<Integer,Student> studentMap = listOfStudents().stream().collect(Collectors.toMap(Student::getStudentId, student -> student));
}





