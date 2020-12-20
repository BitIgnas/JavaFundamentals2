package WarmUp;

public class StudentMain {
    public static void main(String[] args) {

        Student student = new Student("Ignotas", "Java");
        student.sayHello();

        Student[] students = constructSudentList();

        for (Student singleStudent : students) {
            processStudentCourse(singleStudent);
        }
    }


    private static Student[] constructSudentList() {
        Student mario = new Student("Mario", "Java");
        Student marc = new Student("Marc", "Javascript");
        Student maria = new Student("Maria", "PHP");
        Student [] students = {mario, marc, maria};
        return students;
    }

    private static void processStudentCourse(Student singleStudent) {
        boolean isJavaSudent = singleStudent.course.equalsIgnoreCase("java");

        if(isJavaSudent){
            System.out.println(singleStudent.name + " is a Java student");
        } else {
            System.out.println(singleStudent.name + " programuoja kitomis kalbomis");
        }
    }
}
