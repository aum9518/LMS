package lms.Class;

import java.util.List;

public class Group {
    private int id;
    private String name;
    private String description;
    private List<Lesson> lesson;
    private List<Person> student;
    private static int counter = 1;

    public Group() {
    }



    public Group(int id, String name, String description) {
        this.id = counter++;
        this.name = name;
        this.description = description;
    }

    public Group(int id, String name, String description, List<Lesson> lesson, List<Person> student) {
        this.id = counter++;
        this.name = name;
        this.description = description;
        this.lesson = lesson;
        this.student = student;
    }

    public Group(String name, String description, List<Lesson> lesson, List<Person> student) {
        this.name = name;
        this.description = description;
        this.lesson = lesson;
        this.student = student;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Lesson> getLesson() {
        return lesson;
    }

    public void setLesson(List<Lesson> lesson) {
        this.lesson = lesson;
    }

    public List<Person> getStudent() {
        return student;
    }

    public void setStudent(List<Person> student) {
        this.student = student;
    }

    @Override
    public String toString() {
        return " " +
                "\nid=" + id +
                "\n name='" + name + '\'' +
                "\n description='" + description + '\'' +
                "\n lesson=" + lesson +
                "\n student=" + student +
                ' ';
    }
}
