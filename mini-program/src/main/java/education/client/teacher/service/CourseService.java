package education.client.teacher.service;

import education.entity.Course;

import java.util.List;

public interface CourseService {
  /**
   *
   * @param courseID 课程ID
   * @return 课程对象
   */
  Course findCourseByName(int courseID);

  /**
   *
   * @param name 教师名
   * @return 课程ID链表
   */
  List<Integer> findCourseIDByName(String name);

 /**
   *
   * @param teacherID 教师ID
   * @param courseName 课程名
   * @param description 描述
   * @return 是否成功
   */
  boolean addCourse(int teacherID, String courseName, String description);

  /**
   *
   * @param courseID 课程ID
   * @param courseName 修改后的课程名
   * @param description 修改后的描述
   * @return
   */
  boolean updateCourse(int courseID, String courseName, String description);

}
