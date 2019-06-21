package education.client.teacher.service;

import education.entity.Course;

import java.util.List;

public interface TeacherCourseService {
  /**
   *
   * @param courseID 课程ID
   * @return 课程对象
   */
  Course findCourseByID(int courseID);

  /**
   *
   * @param teacherID 教师ID
   * @return 课程ID链表
   */
  List<Integer> findCourseIDByID(int teacherID);

 /**
   *
   * @param teacherID 教师ID
   * @param courseName 课程名
   * @param description 描述
   * @return 所添加课程的ID
   */
  int addCourse(int teacherID, String courseName, String description);

  /**
   *
   * @param courseID 课程ID
   * @param courseName 修改后的课程名
   * @param description 修改后的描述
   * @return
   */
  boolean updateCourse(int courseID, String courseName, String description);

}
