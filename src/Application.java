import java.util.*;

public class Application {
    public static void main(String[] args) {
        Student student = new Student();
        student.getStudentsByClass("4A");
        student.sortedStudentsByClass();



    }
}

class Student {
    private String studentId;
    private String name;
    private String lastName;
    private String studentClassNumber;
    private int studentLogNumber;
    private String sex;

    public Student(String studentId, String name, String lastName, String studentClassNumber, int studentLogNumber, String sex) {
        this.studentId = studentId;
        this.name = name;
        this.lastName = lastName;
        this.studentClassNumber = studentClassNumber;
        this.studentLogNumber = studentLogNumber;
        this.sex = sex;
    }

    public Student() {
    }

    public String getStudentId() {
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
        return "\n" + "Student Id: " + studentId + " " + name + " " + lastName + " " + studentClassNumber + " " + studentLogNumber + " " + sex;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return studentId == student.studentId &&
                studentLogNumber == student.studentLogNumber &&
                sex == student.sex &&
                Objects.equals(name, student.name) &&
                Objects.equals(lastName, student.lastName) &&
                Objects.equals(studentClassNumber, student.studentClassNumber);
    }

    @Override
    public int hashCode() {
        return Integer.parseInt(studentId);

    }

    private List<Student> students;

    public List<Student> listOfStudents() {
        students = new ArrayList<>();
        students.add(new Student("1", "jakub", "firlejczyk", "4A", 1, "M"));
        students.add(new Student("2", "Korneli", "Szymkowiak", "4B", 3, "M"));
        students.add(new Student("3", "Joachim", "Piwowarczyk", "4E", 4, "M"));
        students.add(new Student("4", "Laurencjusz", "Koza", "4C", 2, "M"));
        students.add(new Student("5", "Maria", "Sitek", "4B", 5, "F"));
        students.add(new Student("6", "Anastazja", "Zwoliński", "4B", 6, "F"));
        return students;
    }

    public List<Student> sortingStudents(String classNumber) {
        List <Student> sortedStudentsByClass = new ArrayList<>();
        for (Student student : listOfStudents()) {
            if (classNumber.equals(student.getStudentClassNumber())) {
                sortedStudentsByClass.add(student);
            }
        }
        return sortedStudentsByClass;
    }

    public List<Student> getAllMaleStudentsFromClass4B() {
        for (Student student : listOfStudents()) {
            if (student.getStudentClassNumber().equals("4B") && student.getSex().equals("M")) {
                System.out.println(student);
            }
        }
        return students;
    }

    public Map<String, List<Student>> sortedStudentsByClass() {
        double average = 0;
        double sum = 0;
        Map<String, List<Student>> sortedStudents = new HashMap<>();
        for (Student student : listOfStudents()) {
            sortedStudents.put(student.studentClassNumber, sortingStudents(student.getStudentClassNumber()));
            sum++;
        }
        for (Map.Entry<String, List<Student>> entry : sortedStudents.entrySet()) {
            System.out.println("class: " +   entry.getKey() + "\n" + " " + entry.getValue() + " ");

        }
        average = sum/sortedStudents.size();
        System.out.println("Average students per class :" + average);
        return sortedStudents;
    }

    public Map<String, List<Student>> getStudentsByClass(String classNumber) {
        Map<String, List<Student>> studentMap = new HashMap<>();
        for (Student student : listOfStudents()) {
            if (student.getStudentClassNumber().equals(classNumber))
                studentMap.put(student.studentClassNumber, sortingStudents(classNumber));
        }
        for (Map.Entry<String, List<Student>> entry : studentMap.entrySet()) {
            System.out.println(entry.getValue() + " ");

        }
        return studentMap;
    }

    public int studentsInClass(String classNumber) {
        int sum = 0;
        for (Student student : listOfStudents()) {
            if (student.getStudentClassNumber().equals(classNumber)) {
                sum++;
            }
        }
        System.out.println("The number of students in class " + classNumber + " is: " + sum);
        return sum;
    }

}






