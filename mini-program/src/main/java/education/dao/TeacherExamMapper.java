package education.dao;

import education.entity.ExerciseWithBLOBs;
import education.entity.Paper;

import java.util.List;

public interface TeacherExamMapper {
  /**
   *
   * @param paper
   * @return paperID
   */
  int addPaper(Paper paper);

  /**
   *
   * @param exercise
   * @return 试题ID
   */
  int addExercise(ExerciseWithBLOBs exercise);

  /**
   *
   * @param exercise
   * @return 是否成功
   */
  boolean updateExercise(ExerciseWithBLOBs exercise);

  /**
   *
   * @param paperID 试卷ID
   * @return 试卷对象
   */
  Paper findPaperByID(int paperID);

  /**
   *
   * @param courseID 课程ID
   * @return 所有该course的所有paper
   */
  List<Paper> findPaperByCourseID(int courseID);

  /**
   *
   * @param teacherID 教师ID
   * @return 该老师所有试卷
   */
  List<Paper> findPaperByTeacherID(int teacherID);

  /**
   *
   * @param exercriseID 试题Id
   * @return 试题对象
   */
  ExerciseWithBLOBs findExerciseByExerciseID(int exercriseID);

  /**
   *
   * @param paperID 试卷ID
   * @return 所有题目
   */
  List<ExerciseWithBLOBs> findExerciseByPaperID(int paperID);
}
