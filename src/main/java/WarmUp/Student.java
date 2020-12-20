package WarmUp;

public class Student {

    public String name;
    //private pasiekiamas tik klases vidue
    private int grade;
    public String course;

    public Student(String newName, String newCourse) {
        this.name = newName;
        this.course = newCourse;
    }

    public void sayHello() {
        System.out.println("Laba.....");
        whisper();
    }

    private void whisper() {
        System.out.println("Good student");
    }
}
