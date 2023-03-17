package lms.Interface;

import lms.Class.Group;

import java.util.List;

public interface Functionable {
    void addNewGroup(List<Group>groups);
    void getGroupByNames(List<Group>groups);
    void updateGroupName(List<Group>groups);
    List<Group>getAllGroups(List<Group>groups);
    void addNewStudentToGroup(List<Group>groups);
    void updateStudents(List<Group>groups);
    void findStudentByFirstName(List<Group>groups);
    void getAllStudentsByGroupName(List<Group>groups);
    void getAllStudentsLesson(List<Group>groups);
    void deleteStudent(List<Group>groups);
    void addNewLessonToGroup(List<Group>groups);
    void getLessonByName(List<Group>groups);
    void getAllLessonByGroupName(List<Group>groups);
    void deleteLesson(List<Group>groups);
    void deleteGroup(List<Group>groups);




}
