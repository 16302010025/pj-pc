package education.client.teacher.service;

import education.entity.Student;

import java.util.List;

public interface TeacherOtherService {
  /**
   *
   * @param courseID 课程
   * @return 选了这门课的学生
   */
  List<Student> findChooseByCourseID(int courseID);

  /**
   *
   * @param paperID 试卷ID
   * @return 做完试卷的学生
   */
  List<Student> findFinishByPaperID(int paperID);

  /**
   *
   * @param paperID 试卷ID
   * @return 没做的学生
   */
  List<Student> findUnFinishByPaperID(int courseID,int paperID);


}
