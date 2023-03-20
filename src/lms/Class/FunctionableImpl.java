package lms.Class;

import lms.Enum.Gender;
import lms.Exception.MyException;
import lms.Interface.Functionable;
import org.w3c.dom.ls.LSOutput;

import java.util.*;

public class FunctionableImpl implements Functionable {


    @Override
    public void addNewGroup(List<Group> groups) {
        List<Person>student = new ArrayList<>();
        List<Lesson>lessons = new ArrayList<>();
        Scanner in = new Scanner(System.in);
        System.out.println("Группанын атын жазыныз: ");
        String groupName = in.nextLine();
      try {
          if (!groups.isEmpty()) {
              for (int i = 0; i < groups.size(); i++) {
                  if (groups.get(i).getName().equalsIgnoreCase(groupName)) {
                      throw new MyException("Mynday at bar");
                  }
              }
          }
      } catch (MyException e) {
          System.out.println(e.getMessage());
      }
        System.out.println("Группанын суроттомосун жазыныз: ");
        String description = in.nextLine();
        Group group = new Group(1,groupName,description ,lessons,student);
        System.out.println(group);
        groups.add(group);
    }
    @Override
    public void getGroupByNames(List<Group> groups) {
        try {
            System.out.println("Группанын атын жазыныз");
            String name = new Scanner(System.in).nextLine();
            List<Group>additional = new ArrayList<>();
            int id = 0;
            for (Group group:groups){
                if (group.getName().equalsIgnoreCase(name)){
                    id=group.getId();
                }
            }
            for (Group a:groups) {
                if (a.getId()==id){
                    additional.add(a);
                }
            }
            if (additional.isEmpty()){
                throw new MyException("Мындай группа табылган жок");
            }else {
                System.out.println(additional);
            }
        } catch (MyException e) {
            System.out.println(e.getMessage());
        }

    }

    @Override
    public void updateGroupName(List<Group> groups) {
        System.out.println("Группанын атын жазыныз: ");
        String groupName = new Scanner(System.in).nextLine();
        for (Group a:groups) {
            if (a.getName().equalsIgnoreCase(groupName)){
                System.out.println("Жаны ат жазыныз:");
                String name = new  Scanner(System.in).nextLine();
                a.setName(name);
            }
        }

    }

    @Override
    public List<Group> getAllGroups(List<Group> groups) {
        return groups;
    }

    @Override
    public void addNewStudentToGroup(List<Group> groups) {
            try {
                int id = 0;
                List<Group>list=new ArrayList<>();
                Person person = new Person();
                System.out.println("Кайсыл группага кошсонуз ошол группанын атын жазыныз: ");
                String name = new Scanner(System.in).nextLine();

                System.out.println("Атын жазыныз: ");
                String firstName = new Scanner(System.in).nextLine();
                System.out.println("Фамилиясын жазыныз: ");
                String lastName = new Scanner(System.in).nextLine();
                System.out.println("Email адресин жазыныз: ");
                String email = new Scanner(System.in).nextLine();
                boolean isTrue = true;
                try {
                    for (Group s : groups) {
                        for (Person v : s.getStudent()) {
                            if (!s.getStudent().isEmpty()) {
                                if (v.getEmail().equals(email)) {
                                    isTrue = false;
                                    break;
                                } else {
                                    isTrue = true;

                                }
                            }
                        }
                    }
                    if (!isTrue){
                        throw new MyException("Myndai email bar");
                    }
                    System.out.println("Сыр созду жазыныз: ");
                    String password = new Scanner(System.in).nextLine();
                    person.setFirstName(firstName);
                    person.setLastName(lastName);
                    if (email.contains("@")){
                        person.setEmail(email);
                    }else {
                        throw new MyException("Почтаныздын адресинде '@' камтуусу керек" );
                    }
                    if (password.length()>7){
                        person.setPassword(password);
                    }else {
                        throw new MyException("Сыр созунуз 7 символдон ашуусу керек.");
                    }
                    System.out.println("Жынысын жазыныз(Male/Female): ");
                    String gender = new Scanner(System.in).nextLine().toUpperCase();
                    person.setGender(Gender.valueOf(gender));
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }

                boolean istrue1 = true;
                for (Group a :groups) {
                    if (a.getName().equalsIgnoreCase(name)){
                        istrue1 = true;
                        id = a.getId();
                    }else {
                        istrue1 = false;
                    }
                }
                if (!istrue1){
                    throw new MyException("Мындай группа табылган жок");
                }
                for (Group b:groups) {
                    if (b.getId()==id){
                        person.setId(b.getStudent().size()+1);
                        b.getStudent().add(person);
                    }
                }
                System.out.println(person);
            } catch (MyException e) {
                System.out.println(e.getMessage());
            }
    }

    @Override
    public void updateStudents(List<Group> groups) {
            try{
                boolean isTrue = true;
                System.out.println("Email адрести жазыныз: ");
                String name = new Scanner(System.in).nextLine();
                for (Group a:groups) {
                    for (Person b:a.getStudent()) {
                        if (b.getEmail().equalsIgnoreCase(name)){
                            isTrue = true;
                                System.out.println("Жаны ат жазыныз");
                                String firstName = new Scanner(System.in).nextLine();
                                b.setFirstName(firstName);
                                System.out.println("Жаны фамилия жазыныз");
                                String lastName = new Scanner(System.in).nextLine();
                                b.setLastName(lastName);

                        }else {
                            isTrue = false;
                        }
                    }
                }
                if (!isTrue){
                    throw new MyException("Сыр соз же Email адрес туура эмес");
                }
            } catch (MyException e) {
                System.out.println(e.getMessage());
            }
    }

    @Override
    public void findStudentByFirstName(List<Group> groups) {
        try{
            List<Person>list = new ArrayList<>();
            for (Group a:groups) {
                for (Person b:a.getStudent()) {
                    System.out.println("Студенттин атын жазыныз: ");
                    String nameOfStudent = new Scanner(System.in).nextLine();
                    if (b.getFirstName().equalsIgnoreCase(nameOfStudent)){
                        list.add(b);
                        break;
                    }
                }
            }
            if (list.isEmpty()){
                throw new MyException("Мындай студент табылган жок");
            }else {
                System.out.println(list);
            }
        } catch (MyException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void getAllStudentsByGroupName(List<Group> groups) {
        try{
            List<Group>list= new ArrayList<>();
            System.out.println("Группанын атын жазыныз: ");
            String groupName = new Scanner(System.in).nextLine();
            for (int i = 0; i < groups.size(); i++) {
                if (groups.get(i).getName().equalsIgnoreCase(groupName)){
                   // System.out.println(groups.get(i).getStudent());
                    list.add(groups.get(i));
                }
            }
            /*for (Group a:groups) {
               if (a.getName().equals(groupName)){
                   list.add(a);
               }
            }*/
            if (list.isEmpty()){
                    throw new MyException("Мындай группа табылган жок");
            }else {
                System.out.println(""+list.get(0).getStudent());
            }
        } catch (MyException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void getAllStudentsLesson(List<Group> groups) {
        try{
            System.out.println("Email адрести жазыныз: ");
            String email = new Scanner(System.in).nextLine();
            for (Group a :groups) {
                for (Person b:a.getStudent()) {
                    if (b.getEmail().equalsIgnoreCase(email)){
                        System.out.println(a.getLesson());
                    }else {
                        throw new MyException("Мындай Email адрес табылган жок");
                    }
                }
            }
        } catch (MyException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void deleteStudent(List<Group> groups) {
        try{
            boolean isTrue = true;
            System.out.println("Email адрес жазыныз: ");
            String email = new Scanner(System.in).nextLine();
            for (Group a:groups) {
                for (Person b:a.getStudent()) {
                    if (b.getEmail().equalsIgnoreCase(email)){
                        isTrue = true;
                        a.getStudent().remove(b);
                        System.out.println("adresi "+email+" bolgon student ochuruldu");
                    }else {
                        isTrue = false;
                    }
                }
            }
            if (!isTrue){
                throw new MyException("Not found");
            }
        } catch (MyException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void addNewLessonToGroup(List<Group> groups) {
        try{
            System.out.println("Группанын атын жазыныз:");
            String groupName = new Scanner(System.in).nextLine();
            int id1 = 0;
            System.out.println("Сабактын атын жазыныз:");
            String lessonName = new Scanner(System.in).nextLine();
            System.out.println("Сабактын суроттомосун жазыныз:");
            String description = new Scanner(System.in).nextLine();
            Lesson lesson = new Lesson(lessonName,description);

            for (Group a:groups) {
                if (a.getName().equalsIgnoreCase(groupName)){
                    id1=a.getId();
                }
            }
            for (Group b:groups) {
                if (b.getId()==id1){
                    lesson.setId(b.getLesson().size()+1);
                    b.getLesson().add(lesson);
                    System.out.println(b.getLesson());
                    System.out.println("Сабак ийгиликтуу сакталды");
                }/*else {
                    throw new MyException("Мындай группа табылган жок");
                }*/
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void getLessonByName(List<Group> groups) {
            try{
                System.out.println("Сабактын атын жазыныз: ");
                String lessonName = new Scanner(System.in).nextLine();
                for (Group a:groups) {
                    for (Lesson b:a.getLesson()) {
                      if (b.getLessonName().equalsIgnoreCase(lessonName)){
                          System.out.println(b);
                      }else {
                          throw new MyException(lessonName+" аттуу сабак табылган жок");
                      }
                    }
                }
            } catch (MyException e) {
                System.out.println(e.getMessage());
            }
    }

    @Override
    public void getAllLessonByGroupName(List<Group> groups) {
        try{
            List<Lesson>list=new ArrayList<>();
            System.out.println("Группанын атын жазыныз: ");
            String groupName = new Scanner(System.in).nextLine();
            int id = 0;
            for (Group a:groups) {
                if (a.getName().equalsIgnoreCase(groupName)){
                    id=a.getId();
                }/*else {
                    throw new MyException(groupName+" аттуу группа табылган жок");
                }*/
            }
            for (Group b:groups) {
                if (b.getId()==id){
                   list.addAll(b.getLesson());
                    System.out.println(b.getStudent());
                }
            }
            if (list.isEmpty()){
                throw new MyException(groupName+" аттуу группа табылган жок");
            }else {
                for (Lesson c:list) {
                    System.out.println(c);
                }
            }
        } catch (MyException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void deleteLesson(List<Group> groups) {
        try{
            boolean isTrue = true;
            System.out.println("Сабактын атын жазыныз: ");
            String lessonName = new Scanner(System.in).nextLine();
            for (Group a:groups) {
                for (Lesson b:a.getLesson()) {
                    if (b.getLessonName().equalsIgnoreCase(lessonName)){
                        isTrue = true;
                        a.getLesson().remove(b);
                        System.out.println("Aty "+lessonName+" bolgon sabak uchuruldu");
                    }else {
                        isTrue = false;
                    }
                }
            }
            if (!isTrue){
                throw new MyException("Not found");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void deleteGroup(List<Group> groups) {

        try{
            int id = 0;
            boolean isTrue = true;
            System.out.println("Группанын атын жазыныз:");
            String groupName = new Scanner(System.in).nextLine();
            for (int i = 0; i < groups.size(); i++) {
                if (groups.get(i).getName().equalsIgnoreCase(groupName)){
                    isTrue = true;
                    groups.remove(groups.get(i));
                    System.out.println("Aty "+groupName+" bolgon gruppa ochtu.");
                }else {
                    isTrue = false;
                }
            }
            if (!isTrue){
                throw new MyException("Not found");
            }

        } catch (MyException e) {
            System.out.println(e.getMessage());
        }
    }
}
