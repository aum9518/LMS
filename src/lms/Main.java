package lms;

import lms.Class.FunctionableImpl;
import lms.Class.Group;
import lms.Class.Lesson;
import lms.Class.Person;
import lms.Enum.Gender;
import lms.Exception.MyException;
import lms.Interface.Functionable;
import org.w3c.dom.ls.LSOutput;

import java.time.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        List<Group> groups = new ArrayList<>();

        Person person = new Person(1, "Manas", "Abdugani uulu", "admin@gmail.com", "admin1234", Gender.MALE);
        time();
        while (true) {
            try {

                System.out.println("Катталган болсонуз 1, сыр созду унутуп калып озгортуу учун 2 басыныз: ");
                int num = new Scanner(System.in).nextInt();
                switch (num) {
                    case 1:
                        System.out.println("Email адрести жазыныз: ");
                        String email = new Scanner(System.in).nextLine();
                        System.out.println("Сыр созду жазыныз: ");
                        String password = new Scanner(System.in).nextLine();
                        try {
                            if (email.contains("@")) {
                                if (password.length() > 7) {
                                    if (person.getEmail().equals(email) && person.getPassword().equals(password)) {
                                        service();
                                    } else {
                                        throw new MyException("Email же сыр соз туура эмес");
                                    }
                                } else {
                                    throw new MyException("Сыр соз 7 символдон коп болуусу зарыл");
                                }
                            } else {
                                throw new MyException("Email дин форматты туура эмес");
                            }
                        } catch (MyException e) {
                            System.out.println(e.getMessage());
                        }
                        break;
                    case 2:
                        System.out.println("Почтанызыды жазыныз");
                        String email1 = new Scanner(System.in).nextLine();
                        if (email1.equals(person.getEmail())) {
                            System.out.println("Жаны сыр созду жазыныз: ");
                            String newPassword = new Scanner(System.in).nextLine();
                            if (newPassword.length() > 7) {
                                person.setPassword(newPassword);
                            } else {
                                throw new MyException("Татаалыраак сыр соз жазыныз!");
                            }
                        }
                        break;
                    default:
                        throw new MyException("Error");
                }
            } catch (MyException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public static void time() {
        if (LocalTime.now().isAfter(LocalTime.of(12, 00))) {
            System.out.println("Кутман кун! Саат-> " + LocalTime.now().getHour() + ":" + LocalTime.now().getMinute());
        } else if (LocalTime.now().isAfter(LocalTime.of(18, 00))) {
            System.out.println("Кутман кеч! Саат-> " + LocalTime.now().getHour() + ":" + LocalTime.now().getMinute());
        } else if (LocalTime.now().isBefore(LocalTime.of(12, 00))) {
            System.out.println("Кутман тан! Саат-> " + LocalTime.now().getHour() + ":" + LocalTime.now().getMinute());
        }
    }

    public static void service() {

        List<Group> groups = new ArrayList<>();


        FunctionableImpl function = new FunctionableImpl();
        System.out.println(">>>>>Кош келиниз<<<<<");
        while (true) {
            System.out.println("     Бир команда танданыз:" +
                    "\n1.Add new group" +
                    "\n2.Get group by name" +
                    "\n3.Update group name" +
                    "\n4.Get all groups" +
                    "\n5.Add new student to group" +
                    "\n6.Update student" +
                    "\n7.Find student by first name" +
                    "\n8.Get all students by group name" +
                    "\n9.Get all student's lesson" +
                    "\n10.Delete student" +
                    "\n11.Add new lesson to group" +
                    "\n12.Get lesson by name" +
                    "\n13.Get all lesson by group name" +
                    "\n14.Delete lesson" +
                    "\n15.Delete group");
            int num = new Scanner(System.in).nextInt();
            switch (num) {
                case 1:
                    function.addNewGroup(groups);
                    break;
                case 2:
                    function.getGroupByNames(groups);
                    break;
                case 3:
                    function.updateGroupName(groups);
                    break;
                case 4:
                    System.out.println(function.getAllGroups(groups));
                    break;
                case 5:
                    function.addNewStudentToGroup(groups);
                    break;
                case 6:
                    function.updateStudents(groups);
                    break;
                case 7:
                    function.findStudentByFirstName(groups);
                    break;
                case 8:
                    function.getAllStudentsByGroupName(groups);
                    break;
                case 9:
                    function.getAllStudentsLesson(groups);
                    break;
                case 10:
                    function.deleteStudent(groups);
                    break;
                case 11:
                    function.addNewLessonToGroup(groups);
                    break;
                case 12:
                    function.getLessonByName(groups);
                    break;
                case 13:
                    function.getAllLessonByGroupName(groups);
                    break;
                case 14:
                    function.deleteLesson(groups);
                case 15:
                    function.deleteGroup(groups);
                    break;
                default:
                    System.out.println("Error");
                    break;

            }
        }
    }
}
