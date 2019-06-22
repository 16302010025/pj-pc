package education.dao;

import education.entity.Student;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TeacherOtherMapper {
  /**
   *
   * @param courseID 课程
   * @return 选了这门课的学生
   */
  List<Student> findChooseByCourseID(Integer courseID);

  /**
   *
   * @param paperID 试卷ID
   * @return 做完试卷的学生
   */
  List<Student> findFinishByPaperID(Integer paperID);

  /**
   *
   * @param paperID 试卷ID
   * @return 没做的学生
   */
  List<Student> findUnFinishByPaperID(@Param("courseID") Integer courseID, @Param("paperID")Integer paperID);
}
