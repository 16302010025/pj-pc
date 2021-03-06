package education.client.teacher.service;

import education.entity.Exercise;
import education.entity.ExerciseWithBLOBs;
import education.entity.Paper;

import java.util.List;

public interface TeacherExamService {
  /**
   *
   * @param teacherID 教师ID
   * @param courseID 课程ID
   * @return paperID
   */
  int addPaper(int teacherID,int courseID);

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
  int addExercise(int paperID,String description,char correct,String a,String b,String c,String d);

  /**
   *
   * @param exerciseID 试题ID
   * @param description 题干
   * @param correct 正确选项
   * @param a
   * @param b
   * @param c
   * @param d
   * @return 是否成功
   */
  boolean updateExercise(int exerciseID,String description,char correct,String a,String b,String c,String d);

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
  List<Paper> findPaperByTeacherID(int teacherID);

  /**
   *
   * @param exercriseID 试题Id
   * @return 试题对象
   */
  ExerciseWithBLOBs findExerciseByID(int exercriseID);

  /**
   *
   * @param paperID 试卷ID
   * @return 所有题目的ID
   */
  List<ExerciseWithBLOBs> findExerciseIDByID(int paperID);


}
