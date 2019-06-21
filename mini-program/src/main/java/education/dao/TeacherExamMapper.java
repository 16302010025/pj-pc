package education.dao;

import education.entity.Exercise;
import education.entity.Paper;
import org.apache.ibatis.annotations.Insert;
import org.springframework.web.servlet.tags.Param;

import java.util.List;

public interface TeacherExamMapper {
  /**
   *
   * @param teacherID 教师ID
   * @param courseID 课程ID
   * @return paperID
   */
  int addPaper(Paper paper);

  /**
   *
   * @param paperID 试题ID
   * @param description 题干
   * @param correct 正确选项
   * @param a
   * @param b
   * @param c
   * @param d
   * @return 试题ID
   */
  int addExercise(Exercise exercise);

  /**
   *
   * @param paperID 试题ID
   * @param description 题干
   * @param correct 正确选项
   * @param a
   * @param b
   * @param c
   * @param d
   * @return 是否成功
   */
  boolean updateExercise(Exercise exercise);

  /**
   *
   * @param paperID 试卷ID
   * @return 试卷对象
   */
  Paper findPaperByID(int paperID);

  /**
   *
   * @param courseID 课程ID
   * @return 试卷对象一一对应
   */
  List<Paper> findPaperByCourseID(int courseID);

  /**
   *
   * @param teacherID 教师ID
   * @return 该老师所有试卷
   */
  List<Paper> findPAperByTeacherID(int teacherID);

  /**
   *
   * @param exercriseID 试题Id
   * @return 试题对象
   */
  Exercise findExerciseByExerciseID(int exercriseID);

  /**
   *
   * @param paperID 试卷ID
   * @return 所有题目的ID
   */
  List<Exercise> findExerciseByPaperID(int paperID);
}
