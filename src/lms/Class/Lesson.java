package lms.Class;

public class Lesson {
    private int id;
    private String lessonName;
    private String description;
   // private static int counter=1;

    public Lesson(int id, String lessonName, String description) {
        this.id = id;
        this.lessonName = lessonName;
        this.description = description;
    }

    public Lesson(String lessonName, String description) {
        this.lessonName = lessonName;
        this.description = description;
    }

    public Lesson() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLessonName() {
        return lessonName;
    }

    public void setLessonName(String lessonName) {
        this.lessonName = lessonName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return " " +
                "\nid=" + id +
                "\n lessonName='" + lessonName + '\'' +
                "\n description='" + description + '\'' +
                ' ';
    }
}
