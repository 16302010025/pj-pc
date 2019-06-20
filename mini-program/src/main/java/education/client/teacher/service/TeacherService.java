package education.client.teacher.service;

import education.entity.Teacher;

public interface TeacherService {
  Teacher findTeacherByName(String name);

  boolean isPasswordMatch(String name,String password);

  boolean addTeacher(String name,String password,boolean gender,String description);

  boolean updatePassword(String name,String newPassword);

  Teacher findTeacherByID(int teacherID);
}
