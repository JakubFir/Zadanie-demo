import java.util.*;

public class Application {
    public static void main(String[] args) {
         List<Student> students = new ArrayList<>();
        students.add(new Student("1", "jakub", "firlejczyk", "4A", 1, "M"));
        students.add(new Student("2", "Korneli", "Szymkowiak", "4B", 3, "M"));
        students.add(new Student("3", "Joachim", "Piwowarczyk", "4E", 4, "M"));
        students.add(new Student("4", "Laurencjusz", "Koza", "4C", 2, "M"));
        students.add(new Student("5", "Maria", "Sitek", "4B", 5, "F"));
        students.add(new Student("6", "Anastazja", "Zwoliński", "4B", 6, "F"));

        Map<String, Student> studentMap = new HashMap<>();
        for(Student student : students) {
            studentMap.put(student.getStudentId(), student);
        }
        StudentUtils studentUtils = new StudentUtils();
        studentMap.put("7",new Student("3", "Korneli", "Szymkowiak", "4F", 3, "M"));

        if(!studentUtils.getStudentsByClass(studentMap,"4F").isEmpty()) {
            System.out.println("Students in class " + studentUtils.getStudentsByClass(studentMap,"4F"));
        }else {
            System.out.println("class does not exists");
        }
       studentUtils.studentsSortedByClass(studentMap);


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
        return studentId == student.studentId && studentLogNumber == student.studentLogNumber && sex == student.sex && Objects.equals(name, student.name) && Objects.equals(lastName, student.lastName) && Objects.equals(studentClassNumber, student.studentClassNumber);
    }


}
class StudentUtils{
    Student student = new Student();

    public int studentsInClass(List<Student> students, String classNumber) {
        int sum = 0;
        for (Student student : students) {
            if (student.getStudentClassNumber().equals(classNumber)) {
                sum++;
            }
        }
        System.out.println("The number of students in class " + classNumber + " is: " + sum);
        return sum;
    }
    public List<Student> searchStudentsBySexAndClass(List<Student> students, String classNumber, String sex) {
        List<Student> searchedStudents = new ArrayList<>();
        for (Student student : students) {
            if (student.getStudentClassNumber().equals(classNumber) && student.getSex().equals(sex)) {
                searchedStudents.add(student);
                System.out.println(student);
            }
        }
        return searchedStudents;
    }

    public List<Student> sortingStudentsByClass(Map<String, Student> students, String classNumber) {
        List<Student> sortedStudentsByClass = new ArrayList<>();
       for(Map.Entry<String,Student> entry : students.entrySet()) {
            if (classNumber.equals(entry.getValue().getStudentClassNumber())) {
                sortedStudentsByClass.add(entry.getValue());
            }
        }
        return sortedStudentsByClass;
    }

    public Map<String, List<Student>> studentsSortedByClass(Map<String, Student> students) {
        Map<String, List<Student>> sortedStudents = new HashMap<>();
        for(Map.Entry<String,Student> entry : students.entrySet()) {
            if(!sortedStudents.containsKey(entry.getValue().getStudentClassNumber())) {
                sortedStudents.put(entry.getValue().getStudentClassNumber(), sortingStudentsByClass(students, entry.getValue().getStudentClassNumber()));
            }
        }
        for (Map.Entry<String, List<Student>> entry : sortedStudents.entrySet()) {
            System.out.println("class: " + entry.getKey() + "\n" + " " + entry.getValue() + " ");
        }
        return sortedStudents;
    }

    public List<Student> getStudentsByClass(Map<String, Student> students, String classNumber) {
        List<Student> studentsInClass = new ArrayList<>();
        for (Map.Entry<String, Student> entry : students.entrySet()) {
            if (entry.getValue().getStudentClassNumber().equals(classNumber))
                studentsInClass.add(entry.getValue());
        }
        return studentsInClass;
    }
    public double averageStudentsPerClass(Map<String,List<Student>> studentMap){
        double students =0;
        double numbersOfClass =0;
        double average;
        for (Map.Entry<String, List<Student>> entry : studentMap.entrySet()) {
            for(Student value : entry.getValue()){
                students++;
            }
            numbersOfClass++;
        }
        average = students/numbersOfClass;
        System.out.println(average);
        return average;
    }
}






